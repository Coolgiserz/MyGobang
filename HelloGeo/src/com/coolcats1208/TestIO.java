package com.coolcats1208;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TestIO {

	public static void main(String[] args) {
		new TestIO().myCopyFile("src\\com\\coolcats1208\\TestIO.java", "src\\com\\coolcats1208\\TestIO.test");
//		new TestIO().myBufferFile("src\\com\\coolcats1208\\TestIO.java", "src\\com\\coolcats1208\\TestIO.test1");

		// 测试两者区别
//		long start = System.currentTimeMillis();
//		new TestIO().myCopyFile("F:\\Class_Resource\\遥感原理与应用\\ENVI培训教程2015.pdf", "F:\\Class_Resource\\遥感原理与应用\\Envi.gdg");
//		System.out.println("字节流时间："+(System.currentTimeMillis()-start));
//		new TestIO().myBufferFile("F:\\Class_Resource\\遥感原理与应用\\ENVI培训教程2015.pdf", "F:\\Class_Resource\\遥感原理与应用\\Envi.buffer");
//		System.out.println("缓冲流时间："+(System.currentTimeMillis()-start));

		// 读取字符文件
//		new TestIO().myReader("F:\\Class_Resource\\SpatialAnalysis\\Projects\\Project2\\实验步骤.txt");
//		new TestIO().myReader("F:\\Class_Resource\\SpatialAnalysis\\Projects\\Project2\\poi1.mat");

	}

	public void myReader(String path) {
		try {
			Reader reader = new FileReader(new File(path));
			int i;
			while ((i = reader.read()) != -1) {
				System.out.print((char) i);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void myWriter() {

	}

	public void myBufferFile(String path, String newPath) {
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		FileInputStream fin = null;
		FileOutputStream fout = null;
		try {
			fin = new FileInputStream(path);
			fout = new FileOutputStream(newPath);

			bin = new BufferedInputStream(fin);
			int size = bin.available();
			bout = new BufferedOutputStream(fout);

//			bout = new BufferedOutputStream(fout,size-1);
			System.out.println("文件可读字节数：" + size + "byte");
			byte b[] = new byte[size];
			int i, j = 0;
			while ((i = bin.read()) != -1) {
				b[j] = (byte) i;
				bout.write(b[j]);

//				System.out.print(bin.available()+" ");

			}
//			System.out.print(new String(b));

			System.out.println("文件可读字节数：" + bin.available() + "byte");
			bin.close();
			bout.close();
			fin.close();
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 拷贝文件，字节流FileInputStream、FileOutputStream
	 * 
	 * @param path    需要拷贝的文件所在路径
	 * @param newPath 输出的新文件路径
	 */
	public void myCopyFile(String path, String newPath) {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(path);
			out = new FileOutputStream(newPath);
			int size = in.available(); // 获得文件当前可读的字节数
			System.out.println("文件可读字节数：" + size + "byte");
			int i;
			byte[] b = new byte[size];
			while ((i = in.read()) != -1) { // 想要查阅native修饰的函数源代码怎么办？
//				out.write(i);
				in.read(b);
				out.write(b);

//				System.out.print(in.available()+" ");

//				System.out.print((char) i);
			}
//			System.out.println(new String(b));
//			out.write(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
//				System.out.println("文件还剩字节数：" + in.available() + "byte");
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
