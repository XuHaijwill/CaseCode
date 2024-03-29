package com.xhjc.javabase.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.xhjc.javabase.lambda.impl.MyProgrammer;
import com.xhjc.javabase.lambda.intf.Displayable;
//import com.xhjc.javabase.lambda.impl.MyProgrammer;
import com.xhjc.javabase.lambda.intf.Programer;

public class LambdaDemo {

	static void info(Programer programer) {
		programer.listLangurages();
		programer.introduceMyself();
	}

	// https://blog.csdn.net/zzy7075/article/details/80318679
	public static void main(String[] args) {
		// 案例1
		// 普通写法
		info(new MyProgrammer());

		// 匿名内部类

		info(new Programer() {

			@Override
			public void listLangurages() {
				System.out.println("匿名内部类----->listLangurages");

			}

			@Override
			public void introduceMyself() {
				System.out.println("匿名内部类----->introduceMyself");

			}
		});

		// 案例2
		// lambda表达式
		ArrayList<String> list = new ArrayList<>();
		list.add("Objective-C");
		list.add("Swift");
		list.add("Python");
		list.add("Golang");
		list.add("Java");
		list.sort(new MyComparator());
		list.forEach(System.out::println);

		ArrayList<String> list1 = new ArrayList<>();
		list1.add("Objective-C");
		list1.add("Swift");
		list1.add("Python");
		list1.add("Golang");
		list1.add("Java");
		list1.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				return o1.compareTo(o2);
			}
		});
		list1.forEach(System.out::println);

		ArrayList<String> list2 = new ArrayList<>();
		list2.add("Objective-C");
		list2.add("Swift");
		list2.add("Python");
		list2.add("Golang");
		list2.add("Java");
		list2.sort((String o1, String o2) -> {
			return o1.compareTo(o2);
		});
		list2.forEach(System.out::println);

		List<String> languages = Arrays.asList("java", "scala", "python");
		// before java8
		for (String each : languages) {
			System.out.println(each);
		}
		// after java8
		languages.forEach(x -> System.out.println(x));
		languages.forEach(System.out::println);

	}

	// Lambda表达式只支持函数式接口 也就是只有一个抽象方法的接口
	public String testLamber() {
		Displayable dis = () -> {
			// 访问"effectively final"局部变量
			System.out.println("book局部变量为：");
			// 访问外部类的实力变量和类变量
			System.out.println("外部类的实例变量age：");
			System.out.println("外部类的类变量name:");
		};
		System.out.println(dis);
		return "";
	}

}
