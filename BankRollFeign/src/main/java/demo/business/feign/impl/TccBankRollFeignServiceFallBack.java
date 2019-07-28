package demo.business.feign.impl;

import demo.business.feign.TccBankRollFeignService;
import org.springframework.stereotype.Component;
import utils.LoggerUtil;

import java.math.BigDecimal;

@Component
public class TccBankRollFeignServiceFallBack implements TccBankRollFeignService {
    @Override
    public void add(Integer bankRollId, BigDecimal amount) {

        LoggerUtil.error(TccBankRollFeignServiceFallBack.class," add is error");
    }
}
