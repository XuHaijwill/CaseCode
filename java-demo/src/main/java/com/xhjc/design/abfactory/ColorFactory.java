package com.xhjc.design.abfactory;

import com.xhjc.design.abfactory.color.Blue;
import com.xhjc.design.abfactory.color.Color;
import com.xhjc.design.abfactory.color.Green;
import com.xhjc.design.abfactory.color.Red;
import com.xhjc.design.abfactory.shape.Shape;

public class ColorFactory extends AbstractFactory {

	@Override
	public Shape getShape(String shapeType) {
		return null;
	}

	@Override
	public Color getColor(String color) {
		if (color == null) {
			return null;
		}
		if (color.equalsIgnoreCase("RED")) {
			return new Red();
		} else if (color.equalsIgnoreCase("GREEN")) {
			return new Green();
		} else if (color.equalsIgnoreCase("BLUE")) {
			return new Blue();
		}
		return null;
	}
}