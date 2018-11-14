package math.operation.SA;

import java.util.ArrayList;
import java.util.Random;

public class CoolSA {
	private final static int PRETURB_REVERSE = 0;
	private final static int PRETURB_SWAP = 1;

	private ArrayList<City> _citysList;//����·��
	private double Temperature = 1000.0;//���ȵ����¶�
	private double Temper_Thre = 1.0f;//�¶���ֵ
	private int iterNumRecord = 0;//��������;
	private double coolrate = 0.95;//��ȴ��
	private City startCity;//��ʼ����
	
	public CoolSA(City startCity,ArrayList<City> _citysList,double Temperature,double Temper_Thre,double coolrate) {
		this.startCity = startCity;
		this._citysList = _citysList;
		this.Temperature = Temperature;
		this.Temper_Thre = Temper_Thre;
	}
	
	public CoolSA(City startCity,double Temperature,double Temper_Thre,double coolrate) {
		this.startCity = startCity;
		this.Temperature = Temperature;
		this.Temper_Thre = Temper_Thre;
		_citysList = new ArrayList<>();
	}
	//��������
	public void initCityLists() {
		_citysList.add(new City(0, 111, 22));
		_citysList.add(new City(1, 113, 24));
		_citysList.add(new City(2, 114, 27));
		_citysList.add(new City(3, 112, 30));
		_citysList.add(new City(4, 112, 21));

	}
	/**
	 * �������Ŷ�
	 * @param _citysList
	 */
	public void perturb(ArrayList<City> _citysList,int method) {
		Random rand = new Random();
		int numofcity = _citysList.size();
		int indexi = rand.nextInt(numofcity);
		int indexj = rand.nextInt(numofcity);
		int mini = Math.min(indexi, indexj);
		int maxi = Math.max(indexi, indexj);
		//�����Ŷ�
		switch(method) {
		case CoolSA.PRETURB_REVERSE:
			
			break;
			
		case CoolSA.PRETURB_SWAP:
			
			break;
		}
		
		this._citysList = _citysList;
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
