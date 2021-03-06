package com.xhjc.collection;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;

public class TestGenerics {
	public static void main(String[] args) throws UnknownHostException {
		//ArrayList,LinkedList,Vector,HashMap<K, V>,HashSet<E>
		// 这里的”String”就是实际传入的数据类型；
		MyCollection<String> mc = new MyCollection<String>();
		mc.set("aaa", 0);
		mc.set("bbb", 1);
		String str = mc.get(1); // 加了泛型，直接返回String类型，不用强制转换;
		System.out.println(str);
		
		InetAddress addr = InetAddress.getLocalHost();
        //返回IP地址：192.168.1.110
        System.out.println(addr.getHostAddress()); 
        //输出计算机名：
        System.out.println(addr.getHostName()); 
	}
}

class MyCollection<E> {

	Object[] objs = new Object[5];

	public E get(int index) {
		return (E) objs[index];
	}

	public void set(E e, int index) {// E:表示泛型;
		objs[index] = e;
	}

}
