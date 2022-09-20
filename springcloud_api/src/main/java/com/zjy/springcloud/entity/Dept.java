package com.zjy.springcloud.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@NoArgsConstructor
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {// Dept实体类，orm(类表关系映射)
    private Long deptno;//主键
    private String dname;
    private String db_source;//这个数据 表示存在哪个数据库的字段
    // 微服务架构 一个服务对应一个数据库，同一个信息可能存在不同的数据库

    public Dept(String dname) {
        this.dname = dname;
    }

    /*
    * 链式写法
    * Dept dept = new Dept();
    * dept.setDeptno(12).serDname('local').setDb_source('001');
    *
    * */
}
