package com.example.redis.service;

import com.example.redis.bean.Employee;
import com.example.redis.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;


    @Cacheable(value = "client")//设置了缓存
    public List<Employee> list(){
        return employeeDao.list();
    }

    @Cacheable(value = "idCache", key = "#id")
    public Employee list2(Integer id){
        return employeeDao.list3(id);
    }

    @Cacheable(value = "idCache", key = "#id", condition = "#id>1000")
    public Employee list3(Integer id){
        return employeeDao.list3(id);
    }

}
