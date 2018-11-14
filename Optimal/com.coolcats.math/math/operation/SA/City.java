package math.operation.SA;

public class City {
	private double longx,laty;//经纬度
	private int x,y;//平面坐标，可以是经纬度经仿射变换后的坐标，也可是北京54、西安80等坐标系下的坐标
	private String name;//城市名字
	private int id;//城市id
	public City(int id,int longx,int laty ) {
		this.id = id;
		this.longx = longx;
		this.laty = laty;
	}
	
	public City(City city) {
		this.longx = city.longx;
		this.laty = city.laty;
		this.id = city.id;
		this.name = city.name;
		
	}
	public City(int id,double longx,double laty,String name ) {
		this.id = id;
		this.longx = longx;
		this.laty = laty;
		this.name = name;
	}
	
	/**
	 * 计算该城市到另一城市的距离
	 * @param other
	 * @return
	 */
	public double distanceTo(City other) {
		double dis = Conf.getDistance(this.longx, this.laty, other.longx, other.laty);
		return dis;
	}
	
	/**
	 * 由经纬度计算x、y
	 * @param longx
	 * @param laty
	 */
	public void calcXY(double longx,double laty) {
		
	}
}
