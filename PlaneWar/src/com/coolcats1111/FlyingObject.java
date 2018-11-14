package com.coolcats1111;

import javax.swing.ImageIcon;

public class FlyingObject {
	protected int TYPE;

	protected final static int UNKNOWN = 0;

	protected final static int PLANE = 1;

	protected final static int BULLET = 2;

	protected int x, y, r, speedx, speedy, blood;// 飛行物共同屬性：位置、速度、血量
	protected ImageIcon obgimg;// 飛行物圖片

	public FlyingObject() {
		this.TYPE = 0;

	}

	public FlyingObject(int x, int y, int r, int speedx, int speedy, int blood, ImageIcon obgimg) {
		this();
		this.x = x;
		this.y = y;
		this.r = r;
		this.speedx = speedx;
		this.speedy = speedy;
		this.blood = blood;
		this.obgimg = obgimg;
	}

	public int getTYPE() {
		return TYPE;
	}

	public void setTYPE(int tYPE) {
		TYPE = tYPE;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeedx() {
		return speedx;
	}

	public void setSpeedx(int speedx) {
		this.speedx = speedx;
	}

	public int getSpeedy() {
		return speedy;
	}

	public void setSpeedy(int speedy) {
		this.speedy = speedy;
	}

	public int getBlood() {
		return blood;
	}

	public void setBlood(int blood) {
		this.blood = blood;
	}

	public ImageIcon getObgimg() {
		return obgimg;
	}

	public void setObgimg(ImageIcon obgimg) {
		this.obgimg = obgimg;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

}
