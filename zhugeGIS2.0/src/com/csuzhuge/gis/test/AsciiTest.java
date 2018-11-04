package com.csuzhuge.gis.test;

public class AsciiTest {

	//大于128的ascii码该怎么处理
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ascii2Char(109));
		byte[] byteArray = new byte[8];
		byteArray[0] = (byte) 0xC0;
		byteArray[1] = (byte) 0x3E;
		byteArray[2] = (byte) 0xE2;
		byteArray[3] = (byte) 0x73;
		byteArray[4] = (byte) 0x81;
		byteArray[5] = (byte) 0x81;
		byteArray[6] = (byte) 0x5C;
		byteArray[7] = (byte) 0x40;
		for(int i=0;i<byteArray.length;i++) {
			System.out.println(byteArray[i]);
		}
		System.out.println(byte2double(byteArray));
		System.out.println(double2byte(114.02352616400003
));

	}
	
	public static double byte2double(byte[] arr) {
//		Array.Reverse(arr);
//		Byte.
		long value = 0;
		for(int i=0;i<8;i++) {
			value |=((long)(arr[i]&0xff))<<(8*i);
		}
		return Double.longBitsToDouble(value);
		
		
	}
	
	public static byte[] double2byte(double d) {
		long value = Double.doubleToRawLongBits(d);
		byte[] byteRet = new byte[8];
		for(int i=0;i<8;i++) {
			byteRet[i] = (byte)((value>>8*i)&0xff);
			
		}
		return byteRet;
	}
    public static char ascii2Char(int ASCII) {  
        return (char) ASCII;  
    }  
}
