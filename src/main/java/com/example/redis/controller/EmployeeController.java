package com.example.redis.controller;

import com.example.redis.bean.Employee;
import com.example.redis.service.EmployeeService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 事务练习
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @ResponseBody
    @GetMapping("/list")
    public List<Employee> list() {
        long l = System.currentTimeMillis();
        List<Employee> EmployeeList = employeeService.list();
        System.out.println(System.currentTimeMillis() - l);

        return EmployeeList;

    }

    @ResponseBody
    @PostMapping("/getId")
    public Employee getId(@RequestParam("id") Integer id) {
        long l = System.currentTimeMillis();
        Employee EmployeeList = employeeService.list2(id);
        System.out.println(System.currentTimeMillis() - l);

        return EmployeeList;

    }

    @ResponseBody
    @PostMapping("/getCondId")
    public Employee getCondId(@RequestParam("id") Integer id) {
        long l = System.currentTimeMillis();
        Employee EmployeeList = employeeService.list3(id);
        System.out.println(System.currentTimeMillis() - l);

        return EmployeeList;

    }

}
