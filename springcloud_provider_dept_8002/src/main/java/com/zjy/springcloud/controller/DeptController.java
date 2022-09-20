package com.zjy.springcloud.controller;

import com.zjy.springcloud.entity.Dept;
import com.zjy.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService service;
    //获取一些配置的信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return service.addDept(dept);
    }
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return service.queryById(id);
    }
    @GetMapping("/dept/list")
    public List<Dept> getAll(){
        return service.queryAll();
    }
    //注册进来的微服务，获取一些消息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务列表信息清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services"+services);
        //得到一个具体的微服务信息,通过具体的微服务id,applicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD_PROVIDER_DEPT");
        for(ServiceInstance instance:instances){
            System.out.println(instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri()+"\t"+instance.getServiceId());
        }
        return this.client;
    }
}
