package com.xhjc.design.abfactory;

import com.xhjc.design.abfactory.color.Color;
import com.xhjc.design.abfactory.shape.Circle;
import com.xhjc.design.abfactory.shape.Rectangle;
import com.xhjc.design.abfactory.shape.Shape;
import com.xhjc.design.abfactory.shape.Square;

public class ShapeFactory extends AbstractFactory {

	@Override
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}

	@Override
	public Color getColor(String color) {
		return null;
	}

}
