package com.math.test;

import java.util.ArrayList;

import math.operation.SA.City;
import math.operation.SA.Conf;
import math.operation.SA.CoolSA;
import math.operation.SA.Route;

public class testSA {

	public static void main(String[] args) {
		System.out.println(Conf.getDistance(1, 1, 1, 0));
		CoolSA sa = new CoolSA(new City(3, 112, 30), 1000, 10, 0.90);
		sa.initCityLists();
		Route route = sa.HeuristicLearning();
		System.out.println(route.toString());
		System.out.println();

//		System.out.println(route.getCountIter()+" "+route.getDistance()+" "+route.getTemperature());
		for(int i=0;i<route.get_citysList().size();i++) {
			System.out.println(route.get_citysList().get(i).toString());
			
		}
		sa.printRoute(route);
	}

}
