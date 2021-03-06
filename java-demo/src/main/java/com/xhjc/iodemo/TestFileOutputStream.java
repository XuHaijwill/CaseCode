package com.xhjc.iodemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
	
	public static void main(String[] args) throws IOException {
		//写入测试
//		FileOutputStream os = null;
//		String name = "我是写入测试！";
//		try {
//			os = new FileOutputStream("d:/a.txt",true);
//			os.write(name.getBytes());
//		}catch(Exception e) {
//			
//		}finally {
//			if( os != null) {
//				os.close();
//			}
//		}		
		copyFile("d:/a.txt", "d:/b.txt");
	}
	
	public static String copyFile(String src,String dec) throws IOException {
		FileInputStream is = null;
		FileOutputStream os = null;
		
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dec);
			
			byte[] buffer = new byte[1024];
			int temp = 0;
			if((temp = is.read(buffer)) != -1) {
				/*将缓存数组中的数据写入文件中，注意：写入的是读取的真实长度；
                 *如果使用fos.write(buffer)方法，那么写入的长度将会是1024，即缓存
                 *数组的长度*/
				os.write(buffer, 0, temp);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(is != null) {
				is.close();
			}
			if(os != null) {
				os.close();
			}		
			
		}
		
		
		return "";
	}
}
