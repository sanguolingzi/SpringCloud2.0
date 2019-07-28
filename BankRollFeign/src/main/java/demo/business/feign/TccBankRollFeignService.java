package demo.business.feign;


import demo.business.feign.impl.TccBankRollFeignServiceFallBack;
import demo.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value="BankRollServer",fallback = TccBankRollFeignServiceFallBack.class
        ,path="bankroll",configuration = {FeignClientConfig.class})
public interface TccBankRollFeignService {
    @PostMapping(value = "/add")
    public void add(@RequestParam("bankRollId") Integer bankRollId, @RequestParam("amount") BigDecimal amount);
}