package com.xhjc.ioc.helloworld;

public class HelloWorld {

	private String user;

	public HelloWorld() {
		System.out.println("HelloWorld's constructor...");
	}

	public HelloWorld(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void hello() {
		System.out.println("Hello: " + user);
	}

}
