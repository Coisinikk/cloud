package com.zjy.springcloud.controller;

import com.zjy.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    //消费者不会有service层
    //RestTemplate....供我们调用  注册到spring中
    //(url,实体:Map,Class<T> responseType)

    @Autowired
    private RestTemplate template;//提供多种便捷访问远程http服务的方法，简单的restful服务模板
    //Ribbon 地址应该是一个变量，通过服务名来访问
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
   private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";
    /* http://localhost:8001/dept/list */
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return template.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return template.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return template.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }
}
