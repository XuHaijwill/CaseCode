package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import com.atguigu.crud.bean.EmployeeExample.Criteria;
import com.atguigu.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;

	public List<Employee> getAll() {

		return employeeMapper.selectByExampleWithDept(null);
	}

	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);

	}

	// 检验用户名是否可用
	public boolean checkUser(String empName) {
		EmployeeExample example = new EmployeeExample();

		Criteria criteria = example.createCriteria();

		criteria.andEmpNameEqualTo(empName);

		long count = employeeMapper.countByExample(example);
		return count == 0;
	}

	/**
	 * 按照员工id查询员工
	 * 
	 * @param id
	 * @return
	 */
	public Employee getEmp(Integer id) {
		// TODO Auto-generated method stub
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		return employee;
	}

	/**
	 * 员工更新
	 * 
	 * @param employee
	 */
	public void updateEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.updateByPrimaryKeySelective(employee);
	}

	/**
	 * 员工删除
	 * 
	 * @param id
	 */
	public void deleteEmp(Integer id) {
		// TODO Auto-generated method stub
		employeeMapper.deleteByPrimaryKey(id);
	}

	public void deleteBatch(List<Integer> ids) {
		EmployeeExample example = new EmployeeExample();

		Criteria criteria = example.createCriteria();
		// delete from xxx where emp_id in(1,2,3)
		criteria.andEmpIdIn(ids);
		employeeMapper.deleteByExample(example);
	}

}
