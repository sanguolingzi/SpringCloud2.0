package demo.business.service.info;

import model.custoemr.CustomerModel;

public interface CustomerInfoService
{
    CustomerModel getCustomerInfo(String customerId);

    void forElExpressMethod(String key);

    void testSleuth();

}