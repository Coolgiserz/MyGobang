package com.coolcats20181113;

import java.math.BigInteger;

public class Fibonacci {

	int n = 101;
	int[] f = new int[n];

	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();

//		fib.testFib1(40);

		// Fib2����
		fib.testFib2(80);
//		Fib3����
		fib.testFib3(80);
//		Fib4����
		fib.testFib4(80);

//		System.out.println(fib.Fib3(60)+" "+fib.Fib2(60)+" "+fib.Fib4(60));
//		System.out.println(fib.Fib2(100));
		System.out.println(fib.Fib5(50) + " " + fib.Fib3(50) + " " + fib.Fib4(50));

	}

	/**
	 * 쳲��������д��ݹ�
	 * 
	 * @param n
	 * @return
	 */
	public int Fib1(int n) {
		if (n == 1 || n == 0) {
			return 1;
		}

		return Fib1(n - 1) + Fib1(n - 2);
	}

	/**
	 * ʹ��һ�������������Ѿ������������ forѭ��ʵ��쳲����������޵ݹ飬Ч�����Ը���Fib1
	 * 
	 * @param n
	 * @return
	 */
	public int Fib2(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n - 1] + f[n - 2];
	}

	/**
	 * �ݹ飬���Ҽ��ٱ���ݹ�����е��ظ����� ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(n)
	 * 
	 * @param n
	 * @return
	 */
	public int Fib3(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		if (f[n] != 0) {
			return f[n];
		}
		return f[n] = Fib3(n - 1) + Fib3(n - 2);
	}

	/**
	 * ���g�}�s��O(1)���r�g�}�s��O(n)�㷨
	 * @param n
	 * @return
	 */
	public int Fib4(int n) {
		int sum = 0, a = 0, b = 1, i;
		for (i = 0; i < n; i++) {
			sum = a + b;
			a = b;
			b = sum;
		}
		return sum;
	}
	/**
	 * Ӌ���Fibonacci
	 */
	private BigInteger[] fb = new BigInteger[n];
	public BigInteger Fib5(int n) {
		if (n==(1) || n==(0)) {
			return new BigInteger("1");
		}
//		System.out.print(fb[n].);
		if (fb[n]!=null) {
			return fb[n];
		}
		return fb[n] = Fib5(n - 1).add(Fib5(n - 2));
	}

	public void testFib1(int v) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			Fib1(v);

		}
		System.out.println(System.currentTimeMillis() - start);
	}

	public void testFib2(int v) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			Fib2(v);

		}
		System.out.println(System.currentTimeMillis() - start);
	}

	public void testFib3(int v) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			Fib3(v);

		}
		System.out.println(System.currentTimeMillis() - start);
	}

	public void testFib4(int v) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			Fib4(v);

		}
		System.out.println(System.currentTimeMillis() - start);
	}
}
