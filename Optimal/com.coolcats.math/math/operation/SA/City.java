package math.operation.SA;

public class City {
	private double longx,laty;//��γ��
	private int x,y;//ƽ�����꣬�����Ǿ�γ�Ⱦ�����任������꣬Ҳ���Ǳ���54������80������ϵ�µ�����
	private String name;//��������
	private int id;//����id
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
	 * ����ó��е���һ���еľ���
	 * @param other
	 * @return
	 */
	public double distanceTo(City other) {
		double dis = Conf.getDistance(this.longx, this.laty, other.longx, other.laty);
		return dis;
	}
	
	/**
	 * �ɾ�γ�ȼ���x��y
	 * @param longx
	 * @param laty
	 */
	public void calcXY(double longx,double laty) {
		
	}
}
