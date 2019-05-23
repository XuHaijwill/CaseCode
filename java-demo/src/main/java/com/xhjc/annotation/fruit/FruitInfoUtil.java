package com.xhjc.annotation.fruit;

import java.lang.reflect.Field;

/**
 * 
 *  [一句话功能简述] 参考https://www.cnblogs.com/znicy/p/6852090.html
 *  https://www.cnblogs.com/peida/archive/2013/04/26/3038503.html
 *  [功能详细描述]
 * @author 11511
 * @version [版本号, 2019-05-23 11:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class FruitInfoUtil {

	public static void getFruitInfo(Class<?> clazz) {
		String strFruitName = "水果名称: ";
		String strFruitColor = "水果颜色: ";
		String strFruitProvider = "供应商信息: ";

		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(FruitName.class)) {
				FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
				strFruitName += fruitName.value();
				System.out.println(strFruitName);
			}

			if (field.isAnnotationPresent(FruitColor.class)) {
				FruitColor fruitColor = (FruitColor) field.getAnnotation(FruitColor.class);
				strFruitColor += fruitColor.fruitColor().toString();
				System.out.println(strFruitColor);
			}

			if (field.isAnnotationPresent(FruitProvider.class)) {
				FruitProvider fruitProvider = (FruitProvider) field.getAnnotation(FruitProvider.class);
				strFruitProvider += " 供应商编号：" + fruitProvider.id() + " 供应商名称：" + fruitProvider.name() + " 供应商地址："
						+ fruitProvider.address();
				System.out.println(strFruitProvider);
			}
		}
	}
	
	public static void main(String[] args) {
		getFruitInfo(Apple.class);
	}
}
