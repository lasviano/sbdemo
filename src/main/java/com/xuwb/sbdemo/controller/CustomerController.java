package com.xuwb.sbdemo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuwb.sbdemo.domain.Customer;
import com.xuwb.sbdemo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    //跳转到input.html页面
    @RequestMapping("/input")
    public String input(Model model){
        Customer cust = new Customer();
        model.addAttribute("cust",cust);
        return "input";
    }

    /**
     * 保存方法
     */
    @RequestMapping("/save")
    public String save(Customer customer){
        customerService.save(customer);
        return "succ";
    }

    /**
     * 列表展示
     */
    @RequestMapping("/list")
    public String list(Model model,@RequestParam(required=true,defaultValue="1")Integer page){
        PageHelper.startPage (page,5);
        List<Customer> list = customerService.findAll();
        PageInfo<Customer> p=new PageInfo<Customer>(list);

        model.addAttribute("list", list);
        model.addAttribute ("page",p);
        return "list";
    }

    /**
     * 根据id查询
     */
    @RequestMapping("/findById")
    public String findById(Integer id,Model model){
        Customer cust = customerService.findById(id);
        model.addAttribute("cust", cust);
        return "input";
    }

    /**
     * 删除客户
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        customerService.delete(id);
        return "redirect:/customer/list";
    }
}
