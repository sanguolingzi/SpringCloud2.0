package demo.business.service.busi;

import pojo.customer.CustomerPojo;

public interface CustomerBusiService
{
    int updateByPrimaryKeySelective(CustomerPojo customerPojo);
}