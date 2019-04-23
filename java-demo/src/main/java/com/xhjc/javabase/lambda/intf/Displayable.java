package com.xhjc.javabase.lambda.intf;

public interface Displayable {

	public void display();

	default int add(int a, int b) {
		return a + b;
	}
}
