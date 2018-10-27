package com.coolcats.test1018;

import java.awt.Point;
import java.util.HashSet;
import java.util.Iterator;

public class TestIterator {
	private static HashSet<Point> maySet = new HashSet<>();
	public static void main(String[] args) {
		maySet.add(new Point(0,0));

		Iterator<Point> it = maySet.iterator();
//		System.out.println(it.hasNext());
//		System.out.println(it.hasNext());
		while(it.hasNext()) {
			it.next();

			System.out.println(it.hasNext());

		}
	}
}
