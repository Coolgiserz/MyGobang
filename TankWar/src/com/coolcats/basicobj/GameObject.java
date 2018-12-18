package com.coolcats.basicobj;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import com.coolcats.tankinter.TankInterface;

/**
 * 移动类游戏对象的基类
 * 
 * @author CoolCats
 *
 */
public class GameObject implements TankInterface {

	public  int _x, _y, _r, _speedX, _speedY;// 基本属性
	public ImageIcon _objIcon; // 游戏图标对象
	public GameControl _gameControl; // 游戏控制器
	public Graphics g; // 游戏控制器

	//方向
	public final static int UP_DIRECTION = 0;
	public final static int DOWN_DIRECTION = 1;
	public final static int LEFT_DIRECTION = 2;
	public final static int RIGHT_DIRECTION = 3;

	public GameObject(int _x, int _y, int _r, int _speedX, int _speedY, ImageIcon _objIcon, Graphics g) {
		super();
		this._x = _x;
		this._y = _y;
		this._r = _r;
		this._speedX = _speedX;
		this._speedY = _speedY;
		this._objIcon = _objIcon;
		this.g = g;
	}
	public ImageIcon[] _objIconArr;
	public GameObject(int _x, int _y, int _r, int _speedX, int _speedY, ImageIcon[] _objIcon,Graphics g) {
		this._x = _x;
		this._y = _y;
		this._r = _r;
		this._speedX = _speedX;
		this._speedY = _speedY;
		this._objIconArr = _objIcon;
		this.g = g;
	}
	public GameObject(int x0, int y0, int bULLET_RADUS, int i, int j, Graphics _g) {
		// TODO Auto-generated constructor stub
	}
	public void drawGameObject(Graphics g) {

	}

	@Override
	public void moveGameObject() {

	}

	@Override
	public void crashDetect() {

	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

}
