package com.xuwb.sbdemo.controller;

import com.xuwb.sbdemo.property.BoyDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContextListener;

@RestController
public class HelloController {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private Integer age;

    @Value("${context}")
    private String context;

    @Autowired
    private BoyDomain boy;

//    @GetMapping("/hello")
    @RequestMapping(value = "/sayhello", method = RequestMethod.GET)
    public String hello(){
        return "hello world! ";
    }

    @GetMapping("/helloName")
    public String helloName(){
        return "hello "+name+",age "+age+" context: "+context;
    }

    //获取配置文件的对象
    @RequestMapping(value="/getboy",method = RequestMethod.GET)
    public String boy(){
        return "男孩的年龄"+boy.getAge()+"。";
    }

    //两个url访问同一个方法
    @RequestMapping(value={"/one","/two"},method = RequestMethod.GET)
    public String twoUrl(){
        return "两个url访问同一个方法";
    }

    //url中带参数(http://localhost:8080/param/小王)(http://localhost:8080/小王/param)
    @RequestMapping(value="/param/{name}",method = RequestMethod.GET)
    //@RequestMapping(value="/{name}/param",method = RequestMethod.GET)
    public String twoUrl(@PathVariable("name") String name){
        return "从url获取到的参数是=="+name;
    }

    //url传参数（http://localhost:8080/param?name=张三）
    @RequestMapping(value="/param",method = RequestMethod.GET)
    public String requestParam(@RequestParam("name") String name){
        return "request传的参数为=="+name;
    }

    //url传参数设置默认值（http://localhost:8080/setValue）
    //设置默认值，不是必须传的参数，不传也不会报错
    //@RequestMapping(value="/setValue",method = RequestMethod.GET)
    @GetMapping(value="/setValue")
    public String setValue(@RequestParam(value="name",required = false,defaultValue = "无名氏") String name,
                           @RequestParam(value="age") Integer age){
        return "request传的参数默认为=="+name+" age==" +age;
    }

}
