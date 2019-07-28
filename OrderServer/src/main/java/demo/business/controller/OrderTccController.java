package demo.business.controller;


import demo.business.feign.BankrollFeignService;
import demo.business.feign.CustomerTccFeignService;
import demo.business.feign.TccBankRollFeignService;
import demo.business.httpresponse.ResponseData;
import demo.business.service.busi.OrderBusiService;
import demo.business.tcc.OrderTccService;
import model.bankroll.BankRollModel;
import model.order.AddOrderModel;
import org.bytesoft.bytetcc.supports.spring.aware.CompensableContextAware;
import org.bytesoft.compensable.Compensable;
import org.bytesoft.compensable.CompensableContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.order.OrderPojo;

@Compensable(interfaceClass = OrderTccService.class, cancellableKey = "orderTccCancleServiceImpl")
@RestController
@RequestMapping("order")
public class OrderTccController implements OrderTccService,CompensableContextAware {
    private CompensableContext aware;
    @Override
    public void setCompensableContext(CompensableContext aware) {
        this.aware = aware;
    }
    @Autowired
    private OrderBusiService orderBusiServiceImpl;

    @Autowired
    private BankrollFeignService bankrollFeignService;

    @Autowired
    private TccBankRollFeignService tccBankrollFeignService;

    @Autowired
    private CustomerTccFeignService customerTccFeignService;


    @PostMapping(value="/addOrderInfoTcc")
    @Transactional
    public void add(@RequestBody AddOrderModel addOrderModel){

        ResponseData<BankRollModel> bankRollModelResponseData
                =  bankrollFeignService.getBankRollInfo(String.valueOf(addOrderModel.getCustomerId()));

        BankRollModel bankRollModel = null;
        if(bankRollModelResponseData.success())
            bankRollModel = bankRollModelResponseData.getData();

        //新增一个订单
        OrderPojo orderPojo = new OrderPojo();
        orderPojo.setCustomerId(addOrderModel.getCustomerId());
        orderPojo.setOrderSourse(addOrderModel.getOrderSourse().shortValue());
        orderBusiServiceImpl.insertSelective(orderPojo);
        this.aware.setVariable("orderId",orderPojo.getId());
        tccBankrollFeignService.add(bankRollModel.getId(),addOrderModel.getPayAmount());
        customerTccFeignService.updateEmail(String.valueOf(addOrderModel.getCustomerId()));
        System.out.println(1/0);
    }


}
