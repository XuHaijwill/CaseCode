package com.atguigu.crud.dao;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {

	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Test
	public void testCrud() {
	 
		//departmentMapper.insert(new Department(null,"开发部"));
		//departmentMapper.insert(new Department(1,"测试部"));
		
		//测试员工插入
		//employeeMapper.insert(new Employee(null, "张三", "M", "123@qq.com", 1));
		
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		//批量操作，
		for(int i=0;i < 1000;i++) {
			String substring = UUID.randomUUID().toString().substring(0, 6);
			mapper.insertSelective(new Employee(null, substring, "M", substring + "@163.com", 1));
		}
		
		System.out.println("执行结束");
	}
}
