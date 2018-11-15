package math.operation.SA;

import java.util.ArrayList;

public class Conf {
	public static double Radius = 6378.2f;// 赤道半径，单位km

	public static double getDistance(double long1, double lat1, double long2, double lat2) {
		   double radLat1 = Math.toRadians(lat1);
		   double radLat2 = Math.toRadians(lat2);
		   double a = radLat1 - radLat2;
		   double b = Math.toRadians(long1) - Math.toRadians(long2);

		   double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
		    Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
		   s = s * Radius;
		   s = Math.round(s * 10000) / 10000;
		   return s;
	
	}
	
	/**
	 * 返回沿途路线的总距离
	 * @param _citys
	 * @return
	 */
	public static double getTotalDistance(ArrayList<City> _citys) {
		
		double dis = 0.0f;
		
		for(int i=0;i<_citys.size()-1;i++) {
			dis+=_citys.get(i).distanceTo(_citys.get(i+1));
		}
		dis += _citys.get(_citys.size()-1).distanceTo(_citys.get(0));//最后一个城市返回第一个城市的距离
		return dis;
		
	}

}
