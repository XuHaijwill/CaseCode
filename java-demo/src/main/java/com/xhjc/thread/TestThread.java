package com.xhjc.thread;

public class TestThread extends Thread {

	// run()方法里是线程体
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.getName() + ":" + i);// getName()方法是返回线程名称
		}
	}

	public static void main(String[] args) {
		TestThread thread1 = new TestThread();// 创建线程对象
		thread1.start();// 启动线程
		TestThread thread2 = new TestThread();
		thread2.start();
	}
}