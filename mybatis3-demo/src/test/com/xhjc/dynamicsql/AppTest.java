package com.xhjc.dynamicsql;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.xhjc.common.bean.Employee;

public class AppTest {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "com/xhjc/dynamicsql/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testInnerParam() throws IOException {

		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();

		try {

			EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);

			Employee employee2 = new Employee();
			employee2.setLastName("%e%");
			List<Employee> list = mapper.getEmpsTestInnerParameter(employee2);
			for (Employee employee : list) {
				System.out.println(employee);
			}
		} finally {
			openSession.close();
		}
	}

	@Test
	public void testDynamicSql() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();

		try {
			EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);

			Employee employee = new Employee(1, "", null, null);
			List<Employee> emps = mapper.getEmpsByConditionIf(employee);
			for (Employee emp : emps) {
				System.out.println(emp);
			}
		} finally {
			openSession.close();
		}
	}

}
