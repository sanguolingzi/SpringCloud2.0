package demo.business.service.busi.impl;

import demo.business.service.busi.CustomerBusiService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import demo.business.mapper.busi.CustomerBusiMapper;
import pojo.customer.CustomerPojo;

@Service
public class CustomerBusiServiceImpl implements CustomerBusiService
{
    @Autowired
    private CustomerBusiMapper mapper;

    @Override
    public int updateByPrimaryKeySelective(CustomerPojo customerPojo) {
        mapper.updateByPrimaryKeySelective(customerPojo);
        return 0;
    }
}