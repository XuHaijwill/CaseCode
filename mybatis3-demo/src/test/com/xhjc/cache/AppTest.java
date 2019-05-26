package com.xhjc.cache;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.xhjc.common.bean.Employee;

public class AppTest {
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "com/xhjc/cache/mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(resource);		
		return new SqlSessionFactoryBuilder().build(is);
	}
	
	//测试一级缓存
	@Test
	public void testFirstLevelCache() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			
			Employee emp01 = mapper.getEmpById(1);
			System.out.println(emp01);
			
			Employee emp02 = mapper.getEmpById(1);
			System.out.println(emp02);
			System.out.println(emp01 == emp02);
		}finally {
			openSession.close();
		}
	}

}
