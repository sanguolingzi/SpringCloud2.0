package demo.business.feign;


import demo.business.feign.impl.CustomerTccFeignServiceRollBack;
import demo.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="CustomerServer",fallback = CustomerTccFeignServiceRollBack.class
        ,path="customer",configuration = {FeignClientConfig.class})
public interface CustomerTccFeignService {

    @RequestMapping(value="/updateEmail")
    public void updateEmail(@RequestParam("customerId") String customerId);
}
