package com.csuzhuge.gis.test;

public class ReadTest {

	public void read2Hex(String fileName) {
		try {

			java.io.FileInputStream fins = new java.io.FileInputStream(fileName);
			int mt = 0;
			int count = 0;
			while (mt != -1) {

				mt = fins.read();
				String hex = Integer.toHexString(mt);// ��ȡ�ļ��ֽڵ�ʮ�����Ʊ����ʽ
//			 String str =hex.toString();
				System.out.println(count + " " + mt + " " + hex + " ");
				count++;
			}
			System.out.println("������" + count);

			fins.close();

		} catch (Exception ef) {
			ef.printStackTrace();
		}

	}

	public String hex2string(String hex) {
			return null;
	}
	public String hex2int(String hex) {
		return null;
	}
	public static void main(String[] args) {
		String s = "�ؽ�����Ⱦ.shp";
		ReadTest rt = new ReadTest();
		rt.read2Hex(s);

	}

}
