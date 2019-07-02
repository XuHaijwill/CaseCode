package com.xhjc.spingbootdemo.mapper;

import com.xhjc.spingbootdemo.bean.Employee;

/**
 * @Author xhj
 * @Description //TODO
 * @Date 2019-07-02 10:19
 **/
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    public void insetEmp(Employee employee);
}
