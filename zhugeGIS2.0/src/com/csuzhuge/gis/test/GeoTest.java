package com.csuzhuge.gis.test;

import com.csuzhuge.gis.geom.CoolLineString;
import com.csuzhuge.gis.geom.CoolPoint;
import com.csuzhuge.gis.geom.Geometry;

public class GeoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Geometry geo = new Geometry();
		CoolPoint cool = new CoolPoint();
		System.out.println(cool.toString());
		System.out.println(cool.toWKT());

		System.out.println(geo.getType());
		System.out.println(cool.getType());
		
		CoolLineString ls = new CoolLineString();
		ls.add(new CoolPoint(1,2));
		ls.add(new CoolPoint(2,2));
		ls.add(new CoolPoint(6,5));
		System.out.println(ls.toWKT());
//		ls.append(ls);
		CoolLineString ls2 =new CoolLineString(ls);
		
		ls.append(ls2);

		System.out.println(ls.getLength());
		System.out.println(ls.toWKT());


	}

}
