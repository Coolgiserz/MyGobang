package com.coolcats.fractal;

public class Fractal {
	public String _type;
	public final static String UNKNOWN_FRAC = "未知";
	public final static String MENGER = "门格海绵";
	public final static String KOCH = "科赫曲线";
	public final static String BIDAKELASI = "毕达哥拉斯树";
	public final static String FENXINGSHU = "分形树";
	public final static String IFS_A = "迭代分形A";
	public final static String IFS_B = "迭代分形B";
	public final static String IFS_C = "迭代分形C";
	public final static String IFS_D = "迭代分形D";
	public final static String MAPLELEAF = "枫叶";
	public final static String SIERPINSKITri = "谢尔宾斯基三角形";
	public final static String SIERPINSKIRec = "谢尔宾斯基地毯";

	protected int thea;// 迭代次数
	protected double a, b, c, d, e, f;// 控制参数
	protected double x0, y0;// 初始值
	protected int delta_x, delta_y;// 初始值

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
	 * 设置迭代起始值
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
