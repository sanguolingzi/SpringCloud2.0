package demo.business.tcc.impl;

import demo.business.service.busi.CustomerBusiService;
import demo.business.tcc.CustomerTccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.customer.CustomerPojo;

@Service
public class CustomerTccCancleServiceImpl implements CustomerTccService {

    @Autowired
    private CustomerBusiService customerBusiServiceImpl;

    @Override
    @Transactional
    public void updateEmail(String customerId) {
        CustomerPojo customerPojo = new CustomerPojo();
        customerPojo.setId(Integer.parseInt(customerId));
        customerPojo.setEmail("cancle");
        customerBusiServiceImpl.updateByPrimaryKeySelective(customerPojo);
    }
}
