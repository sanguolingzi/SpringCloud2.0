package demo.business.controller;


import demo.business.service.busi.BankRollBusiService;
import demo.business.service.busi.BankRollFlowBusiService;
import demo.business.tcc.TccTestService;
import model.bankroll.BankRollBusiModel;
import org.bytesoft.bytetcc.supports.spring.aware.CompensableContextAware;
import org.bytesoft.compensable.Compensable;
import org.bytesoft.compensable.CompensableContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.bankroll.BankRollFlowPojo;
import util.BankrollInfoEnum;
import utils.LoggerUtil;

import java.math.BigDecimal;

@Compensable(interfaceClass = TccTestService.class, cancellableKey = "tccTestCancleServiceImpl")
@RestController
@RequestMapping("bankroll")
public class TccBankRollController implements TccTestService,CompensableContextAware {
    private CompensableContext aware;
    @Override
    public void setCompensableContext(CompensableContext aware) {
        this.aware = aware;
    }

    @Autowired
    private BankRollBusiService bankRollBusiServiceImpl;

    @Autowired
    private BankRollFlowBusiService bankRollFlowBusiServiceImpl;

    @PostMapping(value="/add")
    @Transactional
    public void add(@RequestParam Integer bankRollId,@RequestParam BigDecimal amount){
        LoggerUtil.info(TccBankRollController.class,"-------------start try add --------------------");
        BankRollBusiModel bankRollBusiModel = new BankRollBusiModel();
        bankRollBusiModel.setBankRollId(bankRollId);
        bankRollBusiModel.setNewAmount(amount);
        bankRollBusiServiceImpl.addBankrollAmount(bankRollBusiModel);


        BankRollFlowPojo bankRollFlowPojo = new BankRollFlowPojo();
        bankRollFlowPojo.setBankrollId(bankRollBusiModel.getBankRollId());
        bankRollFlowPojo.setAmount(bankRollBusiModel.getNewAmount().movePointRight(2));
        bankRollFlowPojo.setFlowType(bankRollBusiModel.getFlowType());
        bankRollFlowPojo.setFlowDescription(BankrollInfoEnum.AMOUNTPAY.getValue());
        bankRollFlowPojo.setFlowCategory(BankrollInfoEnum.AMOUNT.getValue());
        bankRollFlowBusiServiceImpl.insertSelective(bankRollFlowPojo);
        this.aware.setVariable("flowId",bankRollFlowPojo.getId());
        LoggerUtil.info(TccBankRollController.class,"-------------end try add --------------------");
    }

    @Override
    @Transactional
    public void minus(Integer bankRollId, BigDecimal amount) {

    }
}
