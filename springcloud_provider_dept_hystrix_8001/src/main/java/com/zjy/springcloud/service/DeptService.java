package com.zjy.springcloud.service;

import com.zjy.springcloud.entity.Dept;

import java.util.List;

public interface DeptService {

    boolean addDept(Dept dept);
    Dept queryById(Long id);
    List<Dept> queryAll();
}
