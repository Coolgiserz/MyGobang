package com.coolcats.fractal;

public class Fractal {
	public String _type;
	public final static String UNKNOWN_FRAC = "δ֪";
	public final static String MENGER = "�Ÿ���";
	public final static String KOCH = "�ƺ�����";
	public final static String BIDAKELASI = "�ϴ����˹��";
	public final static String FENXINGSHU = "������";
	public final static String IFS_A = "��������A";
	public final static String IFS_B = "��������B";
	public final static String IFS_C = "��������C";
	public final static String IFS_D = "��������D";
	public final static String MAPLELEAF = "��Ҷ";
	public final static String SIERPINSKITri = "л����˹��������";
	public final static String SIERPINSKIRec = "л����˹����̺";

	protected int thea;// ��������
	protected double a, b, c, d, e, f;// ���Ʋ���
	protected double x0, y0;// ��ʼֵ
	protected int delta_x, delta_y;// ��ʼֵ

	public Fractal() {
		this._type = UNKNOWN_FRAC;
	}

	public Fractal(int thea) {
		this._type = UNKNOWN_FRAC;
		this.thea = thea;
	}

	public String toString() {
		return "FRACTAL";
	}

	public void setThea(int thea) {
		this.thea = thea;
	}

	/**
	 * ���õ�����ʼֵ
	 * @param x0
	 * @param y0
	 */
	public void setInitValue(double x0, double y0) {
		this.x0 = x0;
		this.y0 = y0;
	}

	public Fractal(double a, double b, double c, double d, double e, double f) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;

	}

	public void setPram(double a, double b, double c, double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public void setPram(int a, int b, int c, int d, int e, int f) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
	}
	
	public String getType() {
		return _type;
	}

}
