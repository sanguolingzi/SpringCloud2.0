package demo.business.tcc.impl;

import demo.business.mapper.busi.OrderBusiMapper;
import demo.business.tcc.OrderTccService;
import model.order.AddOrderModel;
import org.bytesoft.bytetcc.supports.spring.aware.CompensableContextAware;
import org.bytesoft.compensable.CompensableContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.order.OrderPojo;
import utils.LoggerUtil;

@Service
public class OrderTccCancleServiceImpl implements OrderTccService,CompensableContextAware {
    private CompensableContext aware;
    @Override
    public void setCompensableContext(CompensableContext aware) {
        this.aware = aware;
    }
    @Autowired
    private OrderBusiMapper orderBusiMapper;

    @Override
    @Transactional
    public void add(AddOrderModel addOrderModel) {
        LoggerUtil.info(OrderTccCancleServiceImpl.class,"-------OrderTccCancleServiceImpl cancle start ---------------");
        String orderId = this.aware.getVariable("orderId").toString();
        OrderPojo orderPojo = new OrderPojo();
        orderPojo.setId(Integer.parseInt(orderId));
        orderBusiMapper.deleteByPrimaryKey(orderPojo);
    }
}
