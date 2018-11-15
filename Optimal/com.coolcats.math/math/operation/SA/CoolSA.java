package math.operation.SA;

import java.util.ArrayList;
import java.util.Random;

public class CoolSA {
	private final static int PRETURB_REVERSE = 0;
	private final static int PRETURB_SWAP = 1;

	private ArrayList<City> _citysList;// 城市路径
	private double Temperature = 1000.0;// 加热到的温度
	private double Temper_Thre = 1.0f;// 温度阈值
	private int iterNumRecord = 0;// 迭代次数;
	private int countIter = 0;// 总迭代次数;

	private double coolrate = 0.95;// 冷却率
	private City startCity;// 起始城市

	public CoolSA(City startCity, ArrayList<City> _citysList, double Temperature, double Temper_Thre, double coolrate) {
		this.startCity = startCity;
		this._citysList = _citysList;
		this.Temperature = Temperature;
		this.Temper_Thre = Temper_Thre;
		this.coolrate = coolrate;
	}

	public CoolSA(City startCity, double Temperature, double Temper_Thre, double coolrate) {
		this.startCity = startCity;
		this.Temperature = Temperature;
		this.Temper_Thre = Temper_Thre;
		this.coolrate = coolrate;
		_citysList = new ArrayList<>();
	}

	// 测试数据
	public void initCityLists() {
		_citysList.add(new City(0, 116.28, 39.54));
		_citysList.add(new City(1, 121.21, 31.14));
		_citysList.add(new City(2, 117.11, 39.09));
		_citysList.add(new City(3, 106.32, 29.32));
		_citysList.add(new City(4, 126.41, 45.45));
		_citysList.add(new City(5, 125.19, 43.52));
		_citysList.add(new City(6, 123.24, 41.50));
		_citysList.add(new City(7, 111.48, 40.49));
		_citysList.add(new City(8, 114.28, 38.02));
		_citysList.add(new City(9, 112.34, 37.52));
		_citysList.add(new City(10, 117, 36.38));
		_citysList.add(new City(11, 113.42, 34.48));
		_citysList.add(new City(12, 108.54, 34.16));
		_citysList.add(new City(13, 103.49, 36.49));
		_citysList.add(new City(14, 106.16, 38.38));
		_citysList.add(new City(15, 101.45, 36.38));
		_citysList.add(new City(16, 87.36, 43.48));
		_citysList.add(new City(17, 117.18, 31.51));
		_citysList.add(new City(18, 118.50, 32.02));
		_citysList.add(new City(19, 120.09, 30.14));
		_citysList.add(new City(20, 113, 28.11));
		_citysList.add(new City(21, 115.52, 28.41));
		_citysList.add(new City(22, 114.21, 30.37));
		_citysList.add(new City(23, 114.05, 30.39));

	}

	/**
	 * 随机选取初始值，实际操作中也可不随机
	 */
	public void randPerturb() {

	}

	public Route HeuristicLearning() {
		Route route = null;
		int count = 1;
		double previous_dis = Conf.getTotalDistance(_citysList);
		while (this.Temperature > this.Temper_Thre) {
//			ArrayList<City> tmpCitys = perturb(_citysList, CoolSA.PRETURB_SWAP);
			ArrayList<City> tmpCitys = perturb(_citysList, CoolSA.PRETURB_REVERSE);

			double current_dis = Conf.getTotalDistance(tmpCitys);
			double diff = current_dis - previous_dis;
			System.out.println(countIter + ":" + current_dis + " " + previous_dis + " " + this.Temperature);

			if (diff < 0 || Math.random() < Math.exp(-diff / this.Temperature)) {

				previous_dis = current_dis;
				
				count++;
			}
			if (count >= 10) {
				this.Temperature = this.coolrate * this.Temperature;
				count = 1;
			}
			countIter++;
			route = new Route(tmpCitys, current_dis, this.Temperature, countIter);

//			if(route!=null) {
//				this.printRoute(route);
//			}

		}
		return route;
	}

	public void printRoute(Route route) {
		for (int i = 0; i < route.get_citysList().size(); i++) {
			System.out.print(route.get_citysList().get(i).getId() + " ");

		}
		System.out.println();
	}

	/**
	 * 邻域内扰动
	 * 
	 * @param _citysList
	 */
	public ArrayList<City> perturb(ArrayList<City> _citysList, int method) {
		ArrayList<City> route = new ArrayList<>();
		Random rand = new Random();
		int numofcity = _citysList.size();
		int mini;
		int maxi;
		do {
			int indexi = rand.nextInt(numofcity);
			int indexj = rand.nextInt(numofcity);
			mini = (int) Math.ceil(Math.random() * numofcity) - 1;
//			int mini = Math.min(indexi, indexj);
//			int maxi = Math.max(indexi, indexj);
			maxi = (int) Math.ceil(Math.random() * numofcity) - 1;
		} while (maxi == mini);

		// 设置扰动
		switch (method) {
		case CoolSA.PRETURB_REVERSE:
			// 列表局部倒序
//			ArrayList<City> _tmpLists = new ArrayList<>();
			for (int i = 0; i < mini; i++) {
				route.add(_citysList.get(i));
			}
			for (int i = mini; i <= maxi; i++) {
				route.add( _citysList.get(maxi+mini-i));
			}
			for (int i = maxi + 1; i < _citysList.size(); i++) {
				route.add(_citysList.get(i));
			}

			break;

		case CoolSA.PRETURB_SWAP:
			City tmp = new City(_citysList.get(mini));
			_citysList.set(mini, new City(_citysList.get(maxi)));
			_citysList.set(maxi, new City(tmp));
			for (int i = 0; i < _citysList.size(); i++) {
				route.add(_citysList.get(i));
			}
			break;
		}

		return route;
//		this._citysList = _citysList;
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

	public double getTemper_Thre() {
		return Temper_Thre;
	}

	public void setTemper_Thre(double temper_Thre) {
		Temper_Thre = temper_Thre;
	}

	public int getIterNumRecord() {
		return iterNumRecord;
	}

	public void setIterNumRecord(int iterNumRecord) {
		this.iterNumRecord = iterNumRecord;
	}

	public City getStartCity() {
		return startCity;
	}

	public void setStartCity(City startCity) {
		this.startCity = startCity;
	}

}
