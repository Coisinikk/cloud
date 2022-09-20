package com.zjy.springcloud.dao;

import com.zjy.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
     boolean addDept(Dept dept);
     Dept queryById(Long id);
     List<Dept> queryAll();
}
