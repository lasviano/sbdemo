package com.xuwb.sbdemo.service.impl;

import com.xuwb.sbdemo.dao.CustomerMapper;
import com.xuwb.sbdemo.domain.Customer;
import com.xuwb.sbdemo.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    //注入mapper接口的对象
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public void save(Customer customer) {
        //判断是否添加还是修改
        if(customer.getId()!=null){
            //修改
            customerMapper.update(customer);
        }else{
            //添加
            customerMapper.save(customer);
        }
    }

    @Override
    public List<Customer> findAll() {
        return customerMapper.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerMapper.findById(id);
    }

    @Override
    public void delete(Integer id) {
        customerMapper.delete(id);
    }

}
