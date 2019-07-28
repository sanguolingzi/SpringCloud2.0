package demo.business.tcc.impl;

import demo.business.controller.TccBankRollController;
import demo.business.service.busi.BankRollBusiService;
import demo.business.service.busi.BankRollFlowBusiService;
import demo.business.tcc.TccTestService;
import model.bankroll.BankRollBusiModel;
import org.bytesoft.bytetcc.supports.spring.aware.CompensableContextAware;
import org.bytesoft.compensable.CompensableContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.bankroll.BankRollFlowPojo;
import utils.LoggerUtil;

import java.math.BigDecimal;

@Service
public class TccTestCancleServiceImpl implements TccTestService,CompensableContextAware {

    private CompensableContext aware;
    @Override
    public void setCompensableContext(CompensableContext aware) {
        this.aware = aware;
    }

    @Autowired
    private BankRollBusiService bankRollBusiServiceImpl;

    @Autowired
    private BankRollFlowBusiService bankRollFlowBusiServiceImpl;

    @Override
    @Transactional
    public void add(Integer bankRollId, BigDecimal amount) {
        LoggerUtil.info(TccTestCancleServiceImpl.class,"-------------start cancle add --------------------");
        BankRollBusiModel bankRollBusiModel = new BankRollBusiModel();
        bankRollBusiModel.setBankRollId(bankRollId);
        bankRollBusiModel.setNewAmount(amount);
        bankRollBusiServiceImpl.minusBankrollAmount(bankRollBusiModel);

        String flowId = this.aware.getVariable("flowId").toString();
        BankRollFlowPojo bankRollFlowPojo = new BankRollFlowPojo();
        bankRollFlowPojo.setId(Integer.parseInt(flowId));
        bankRollFlowBusiServiceImpl.deleteByPrimaryKey(bankRollFlowPojo);
        LoggerUtil.info(TccTestCancleServiceImpl.class,"-------------end cancle add --------------------");

    }

    @Override
    @Transactional
    public void minus(Integer bankRollId, BigDecimal amount) {

    }
}
