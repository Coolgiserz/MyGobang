package com.csuzhuge.gis.test;

public class ReadTest {

	public void read2Hex(String fileName) {
		try {

			java.io.FileInputStream fins = new java.io.FileInputStream(fileName);
			int mt = 0;
			int count = 0;
			while (mt != -1) {

				mt = fins.read();
				String hex = Integer.toHexString(mt);// 获取文件字节的十六进制编码格式
//			 String str =hex.toString();
				System.out.println(count + " " + mt + " " + hex + " ");
				count++;
			}
			System.out.println("行数：" + count);

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
		String s = "重金属污染.shp";
		ReadTest rt = new ReadTest();
		rt.read2Hex(s);

	}

}
