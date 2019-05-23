package com.xhjc.annotation.table;
import java.lang.reflect.Field;

public class Client {

	public static void main(String[] args) {
		
		try {
			@SuppressWarnings("unchecked")
			Class<Person> clazz = (Class<Person>) Class.forName("com.xhjc.annotation.table.Person");
			
			boolean b = clazz.isAnnotationPresent(Table.class);
		
			System.out.println(b);
			if(!b) {
				return;
			}
			
			StringBuilder stb = new StringBuilder();
			
			Table table = clazz.getAnnotation(Table.class);
			System.out.println(table.value());
			stb.append("select * from " + table.value() + " where ");
			
			Field filed = clazz.getDeclaredField("name");
			
			if(filed.isAnnotationPresent(Column.class)) {
				Column column = filed.getAnnotation(Column.class);
				stb.append(column.name() + "=" + column.res());
			}
			
			stb.append(" and ");
			
			filed = clazz.getDeclaredField("age");
			
			if(filed.isAnnotationPresent(Column.class)) {
				Column column = filed.getAnnotation(Column.class);
				System.out.println(column.name());
				stb.append(column.name() + "=" + column.res());
			}
			
			System.out.println(stb.toString());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
