package com.xhjc.spingbootdemo.controller;

import com.xhjc.spingbootdemo.bean.Employee;
import com.xhjc.spingbootdemo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @Author xhj
 * @Description //TODO
 * @Date 2019-07-02 10:22
 **/
@RestController
public class EmployeeMabatisController {

    @Autowired
    EmployeeMapper employeeMapper;

    @RequestMapping("/getEmp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }


}
