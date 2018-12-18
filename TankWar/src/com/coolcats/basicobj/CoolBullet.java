package com.coolcats.basicobj;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class CoolBullet extends GameObject {
	private Graphics g;

	public CoolBullet(int _x, int _y, int _r, int _speedX, int _speedY, ImageIcon _objIcon, Graphics g) {
		super(_x, _y, _r, _speedX, _speedY, _objIcon, g);
		this._x = _x;
		this._y = _y;
		this._r = _r;
		this._speedX = _speedX;
		this._speedY = _speedY;
		this._objIcon = _objIcon;
		this.g = g;

	}

//	public CoolBullet(int x0, int y0, int bULLET_RADUS, int i, int j, Graphics _g) {
//		// TODO Auto-generated constructor stub
//	}

}
