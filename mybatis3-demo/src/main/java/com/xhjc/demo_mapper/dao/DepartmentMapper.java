package com.xhjc.demo_mapper.dao;

import com.xhjc.demo_mapper.bean.Department;

public interface DepartmentMapper {

	public Department getDeptById(Integer id);

	public Department getDeptByIdPlus(Integer id);

	public Department getDeptByIdStep(Integer id);

}
