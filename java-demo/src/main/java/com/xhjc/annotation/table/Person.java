package com.xhjc.annotation.table;

/**
 * 
 *  [一句话功能简述]
 *  [功能详细描述] 注释不能被其他程序读取 
 * @author xhj
 * @version [版本号, 2019-05-23 16:08]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Table("person")
public class Person {

	// 注解的设计目标？
	// 对类做出解释,被其它程序读取,被反射读取
	@Column(name = "name", res = "xhj")
	private String name;

	@Column(name = "age", res = "25")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
		super();
	}

}
