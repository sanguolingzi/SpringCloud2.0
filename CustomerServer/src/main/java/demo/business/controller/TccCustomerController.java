package demo.business.controller;

import demo.business.service.busi.CustomerBusiService;
import demo.business.tcc.CustomerTccService;
import org.apache.http.client.utils.DateUtils;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.customer.CustomerPojo;

import java.util.Date;


@Compensable(interfaceClass = CustomerTccService.class, cancellableKey = "customerTccCancleServiceImpl")
@RestController
@RequestMapping("customer")
public class TccCustomerController implements CustomerTccService{

    @Autowired
    private CustomerBusiService customerBusiServiceImpl;

    @Override
    @RequestMapping(value="/updateEmail")
    @Transactional
    public void updateEmail(@RequestParam("customerId") String customerId) {
        CustomerPojo customerPojo = new CustomerPojo();
        customerPojo.setId(Integer.parseInt(customerId));
        customerPojo.setEmail(DateUtils.formatDate(new Date()));
        customerBusiServiceImpl.updateByPrimaryKeySelective(customerPojo);
    }
}
