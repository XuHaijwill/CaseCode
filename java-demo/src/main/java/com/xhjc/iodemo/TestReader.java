package com.xhjc.iodemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestReader {

	public static void main(String[] args) throws IOException {
		FileReader fr = null;
		FileWriter fw = null;

		try {
			fr = new FileReader("d:/a.txt");
			fw = new FileWriter("d:/c.txt");

			char[] buffer = new char[1024];
			int len = 0;
			if ((len = fr.read(buffer)) != -1) {
				fw.write(buffer, 0, len);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fr != null)
				fr.close();
			if (fw != null)
				fw.close();
		}

	}
}
