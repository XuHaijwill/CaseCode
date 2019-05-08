package com.xhjc.demo01.dao;

import org.apache.ibatis.annotations.Select;

import com.xhjc.demo01.bean.Employee;

public interface EmployeeMapperAnnotation {
	@Select("select * from tbl_employee where id=#{id}")
	public Employee getEmpById(Integer id);
}
