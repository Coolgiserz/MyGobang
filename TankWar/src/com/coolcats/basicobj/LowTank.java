package com.coolcats.basicobj;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class LowTank extends CoolTank {

	public LowTank(int _x, int _y, int _r, int _speedX, int _speedY, ImageIcon[] _objIcon, Graphics g) {
		super(_x, _y, _r, _speedX, _speedY, _objIcon, g);
		_tankLabel = 0;
	}

	@Override
	public void drawGameObject(Graphics g) {
		g.drawImage(_objIconArr[_tankDir].getImage(), _x, _y, _r, _r, null);

//		System.out.println("Huizh");
	}

	/**
	 * 向下移动方法
	 */
	@Override
	public void moveDown() {
		_y += _speedY;
		// 判断是否超出边界,触碰边界则转向
//		if (_y + _r + 5 > Game.GAME_HEIGHT) {
//			_tankDir = GameObject.UP_DIRECTION;
////			_speedY = -_speedY;
//
//		}
//		// 判断是否超出边界，并有一定概率转向
//		if(Math.random()<0.3) {
//			_tankDir = GameObject.RIGHT_DIRECTION;
//		}
	}

	@Override
	public void moveUp() {
		_y -= _speedY;
		// 判断是否超出边界,触碰边界则转向
//		if (_y - _r < 5) {
//			_tankDir = GameObject.DOWN_DIRECTION;
////			_speedY = -_speedY;
//
//		}
//		// 判断是否超出边界，并有一定概率转向
//		if(Math.random()<0.3) {
//			_tankDir = GameObject.RIGHT_DIRECTION;
//		}
	}

	@Override
	public void moveRight() {
		_x += _speedX;
		// 判断是否超出边界,触碰边界则转向
//		if (_x + _r + 5 > Game.WIDTH) {
//			_tankDir = GameObject.LEFT_DIRECTION;
////			_speedX = -_speedX;
//
//		}
		// 判断是否超出边界，并有一定概率转向
//		if(Math.random()<0.3) {
//			_tankDir = GameObject.UP_DIRECTION;
//		}
	}

	@Override
	public void moveLeft() {
		_x -= _speedX;
		// 判断是否超出边界,触碰边界则转向
//		if (_x - _r < 3) {
//			_tankDir = GameObject.RIGHT_DIRECTION;
////			_speedX = -_speedX;
//
//		}
//		// 判断是否超出边界，并有一定概率转向
//		if(Math.random()<0.3) {
//			_tankDir = GameObject.DOWN_DIRECTION;
//		}
	}
}
