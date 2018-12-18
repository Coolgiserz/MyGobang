package com.coolcats.basicobj;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;

import com.coolcats.tankinter.TankInterface;

public class CoolTank extends GameObject implements TankInterface {

	public ImageIcon[] _objIconArr;
	private Random _random;
	public int _tankDir;
	public int _tankLabel;
	public Graphics _g;
	public CoolTank(int _x, int _y, int _r, int _speedX, int _speedY, ImageIcon[] _objIcon, Graphics g) {
		super(_x, _y, _r, _speedX, _speedY, _objIcon, g);
		this._x = _x;
		this._y = _y;
		this._r = _r;
		this._speedX = _speedX;
		this._speedY = _speedY;
		this._objIconArr = _objIcon;
//		this._gameControl = _gameControl;
		initObject();
	}

	public void initObject() {
		_random = new Random();
		_tankDir = _random.nextInt(4);

	}

	@Override
	public void drawGameObject(Graphics g) {
		g.drawImage(_objIconArr[_tankDir].getImage(), _x, _y, _r, _r, null);
		
//		System.out.println("Huizh");
	}

	/**
	 * 移动坦克的方法，分上下左右四个方向
	 */
	@Override
	public void moveGameObject() {
		switch (_tankDir) {
		case GameObject.UP_DIRECTION://向上移动
			moveUp();
			break;
		case GameObject.DOWN_DIRECTION://向下移动
			moveDown();
			break;
		case GameObject.LEFT_DIRECTION://向左移动
			moveLeft();
			break;
		case GameObject.RIGHT_DIRECTION://向右移动
			moveRight();
			break;
		}
	}

	@Override
	public void crashDetect() {

	}

	/**
	 * 向下移动方法
	 */
	@Override
	public void moveDown() {
		_y += _speedY;
		//判断是否超出边界，并由一定概率
		if(_y<Game.GAME_WIDTH) {
			
		}
	}

	@Override
	public void moveUp() {
		_y -= _speedY;
	}

	@Override
	public void moveRight() {
		_x += _speedX;
	}

	@Override
	public void moveLeft() {
		_x -= _speedX;
	}

}
