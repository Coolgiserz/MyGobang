package math.operation.SA;

import java.util.ArrayList;

public class Route {
	private ArrayList<City> _citysList;// 城市路径
	private double Temperature;
	private double distance;

	private int countIter = 0;// 总迭代次数;

	public Route(ArrayList<City> _citysList, double distance, double Temperature, int countIter) {
		this._citysList = _citysList;
		this.Temperature = Temperature;
		this.countIter = countIter;
		this.distance = distance;
	}

	public String toString() {
		return "距離："+this.distance + ",迭代次數：" + this.countIter + ",溫度" + this.Temperature;

	}

	public ArrayList<City> get_citysList() {
		return _citysList;
	}

	public void set_citysList(ArrayList<City> _citysList) {
		this._citysList = _citysList;
	}

	public double getTemperature() {
		return Temperature;
	}

	public void setTemperature(double temperature) {
		Temperature = temperature;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getCountIter() {
		return countIter;
	}

	public void setCountIter(int countIter) {
		this.countIter = countIter;
	}
}
