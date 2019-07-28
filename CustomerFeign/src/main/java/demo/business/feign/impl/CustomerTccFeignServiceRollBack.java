package demo.business.feign.impl;

import demo.business.feign.CustomerTccFeignService;
import org.springframework.stereotype.Service;

@Service
public class CustomerTccFeignServiceRollBack implements CustomerTccFeignService{
    @Override
    public void updateEmail(String customerId) {

    }
}
