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

		// ������������
//		long start = System.currentTimeMillis();
//		new TestIO().myCopyFile("F:\\Class_Resource\\ң��ԭ����Ӧ��\\ENVI��ѵ�̳�2015.pdf", "F:\\Class_Resource\\ң��ԭ����Ӧ��\\Envi.gdg");
//		System.out.println("�ֽ���ʱ�䣺"+(System.currentTimeMillis()-start));
//		new TestIO().myBufferFile("F:\\Class_Resource\\ң��ԭ����Ӧ��\\ENVI��ѵ�̳�2015.pdf", "F:\\Class_Resource\\ң��ԭ����Ӧ��\\Envi.buffer");
//		System.out.println("������ʱ�䣺"+(System.currentTimeMillis()-start));

		// ��ȡ�ַ��ļ�
//		new TestIO().myReader("F:\\Class_Resource\\SpatialAnalysis\\Projects\\Project2\\ʵ�鲽��.txt");
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
			System.out.println("�ļ��ɶ��ֽ�����" + size + "byte");
			byte b[] = new byte[size];
			int i, j = 0;
			while ((i = bin.read()) != -1) {
				b[j] = (byte) i;
				bout.write(b[j]);

//				System.out.print(bin.available()+" ");

			}
//			System.out.print(new String(b));

			System.out.println("�ļ��ɶ��ֽ�����" + bin.available() + "byte");
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
	 * �����ļ����ֽ���FileInputStream��FileOutputStream
	 * 
	 * @param path    ��Ҫ�������ļ�����·��
	 * @param newPath ��������ļ�·��
	 */
	public void myCopyFile(String path, String newPath) {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(path);
			out = new FileOutputStream(newPath);
			int size = in.available(); // ����ļ���ǰ�ɶ����ֽ���
			System.out.println("�ļ��ɶ��ֽ�����" + size + "byte");
			int i;
			byte[] b = new byte[size];
			while ((i = in.read()) != -1) { // ��Ҫ����native���εĺ���Դ������ô�죿
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
//				System.out.println("�ļ���ʣ�ֽ�����" + in.available() + "byte");
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
