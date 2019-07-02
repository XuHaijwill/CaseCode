package com.xhjc.spingbootdemo.controller;

import com.xhjc.spingbootdemo.bean.Department;
import com.xhjc.spingbootdemo.mapper.DepartmentMapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xhj
 * @Description //TODO
 * @Date 2019-07-02 10:53
 **/
@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @RequestMapping("/getDept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @RequestMapping("/delDept/{id}")
    public int delDept(@PathVariable("id") Integer id){
        return departmentMapper.deleteDeptById(id);
    }

    @RequestMapping("/update/{id}")
    public int updateDept(@PathVariable("id") Integer id){
        return departmentMapper.updateDept(new Department(id, "开发部"));
    }
    //获取
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @GetMapping("/insert")
    public int insertDepartment(Department dept){
        return departmentMapper.insertDept(dept);
    }
}
