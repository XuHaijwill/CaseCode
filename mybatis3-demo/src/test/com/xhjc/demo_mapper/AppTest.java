package com.xhjc.demo_mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.xhjc.demo_mapper.bean.Department;
import com.xhjc.demo_mapper.bean.Employee;
import com.xhjc.demo_mapper.dao.DepartmentMapper;
import com.xhjc.demo_mapper.dao.EmployeeMapper;

public class AppTest {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "com/xhjc/demo_mapper/dao/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testAdd() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			// 测试添加
			Employee employee = new Employee(null, "bilibilir", "bilibili@163.com", "1");
			mapper.addEmp(employee);
			System.out.println(employee.getId());

			openSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			openSession.close();
		}
	}

	@Test
	public void testUp() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			// 测试修改
			// Employee employee = new Employee(1, "Tom", "jerry@atguigu.com",
			// "0");
			// boolean updateEmp = mapper.updateEmp(employee);
			// System.out.println(updateEmp);
			// 测试删除
			mapper.deleteEmpById(2);
			openSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			openSession.close();
		}
	}

	@Test
	public void testMapper() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 1、获取到的SqlSession不会自动提交数据
		SqlSession openSession = sqlSessionFactory.openSession();

		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			// Employee employee = mapper.getEmpByIdAndLastName(1, "tom");
			Map<String, Object> map1 = new HashMap<>();
			map1.put("id", 1);
			map1.put("lastName", "Tom");
			map1.put("tableName", "tbl_employee");
			Employee emp = mapper.getEmpByMap(map1);

			System.out.println(emp);

			/*List<Employee> like = mapper.getEmpsByLastNameLike("%i%");
			for (Employee employee : like) {
				System.out.println(employee);
			}

			Map<String, Object> map = mapper.getEmpByIdReturnMap(1);
			System.out.println(map);

			Map<String, Employee> map2 = mapper.getEmpByLastNameLikeReturnMap("%r%");
			System.out.println(map2);*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			openSession.close();
		}
	}
	
	@Test
	public void testStep() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 1、获取到的SqlSession不会自动提交数据
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try{
			DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
			Department department = mapper.getDeptByIdPlus(1);
			System.out.println(department);
			System.out.println(department.getEmps());	
			
			Department deptByIdStep = mapper.getDeptByIdStep(1);
			System.out.println(deptByIdStep.getDepartmentName());
			System.out.println(deptByIdStep.getEmps());
		}finally{
			openSession.close();
		}
	}

}
