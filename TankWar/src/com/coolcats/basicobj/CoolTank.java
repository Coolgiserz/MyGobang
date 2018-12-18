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
	 * �ƶ�̹�˵ķ����������������ĸ�����
	 */
	@Override
	public void moveGameObject() {
		switch (_tankDir) {
		case GameObject.UP_DIRECTION://�����ƶ�
			moveUp();
			break;
		case GameObject.DOWN_DIRECTION://�����ƶ�
			moveDown();
			break;
		case GameObject.LEFT_DIRECTION://�����ƶ�
			moveLeft();
			break;
		case GameObject.RIGHT_DIRECTION://�����ƶ�
			moveRight();
			break;
		}
	}

	@Override
	public void crashDetect() {

	}

	/**
	 * �����ƶ�����
	 */
	@Override
	public void moveDown() {
		_y += _speedY;
		//�ж��Ƿ񳬳��߽磬����һ������
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
