package com.xhjc.design.abfactory;

import com.xhjc.design.abfactory.color.Color;
import com.xhjc.design.abfactory.shape.Shape;

public abstract class AbstractFactory {
	
	public abstract Color getColor(String color);

	public abstract Shape getShape(String shape);
}