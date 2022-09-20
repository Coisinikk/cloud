package com.zjy.springcloud.controller;

import com.zjy.springcloud.entity.Dept;
import com.zjy.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class DeptConsumerController {


    @Autowired
    private DeptClientService service = null;


    @RequestMapping("/consumer_1/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return this.service.queryById(id);
    }

    @RequestMapping("/consumer_1/dept/add")
    public boolean add(Dept dept){
        return this.service.addDept(dept);
    }
    @RequestMapping("/consumer_1/dept/list")
    public List<Dept> list(){
        return this.service.queryAll();
    }
}
