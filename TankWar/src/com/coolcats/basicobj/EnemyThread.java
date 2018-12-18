package com.coolcats.basicobj;

import java.util.Random;

public class EnemyThread extends Thread {
	private GameControl _gameControl;
	private Random _ran;

	public EnemyThread(GameControl gameControl) {
		this._gameControl = gameControl;
		_ran = new Random();
	}

	public void run() {
		while (!GameControl.isStop) {
			// 生成敌方坦克
			if (Math.random() < _gameControl.lowProb) {
				int x0 = _ran.nextInt(600) + 100;
				int y0 =  _ran.nextInt(100) + 100;
				// 生成小坦克
				LowTank lowTank = new LowTank(x0,y0, _gameControl.TANK_RADUS, 10, 10,
						_gameControl._lowTankIconArr,_gameControl._g);
				_gameControl._tanks.add(lowTank);
				//每個小坦克發一顆子彈
//				CoolBullet lowBullet = new CoolBullet(x0, y0, _gameControl.BULLET_RADUS, 20, 20, _gameControl._g);
			} else {
				// 生成大坦克
				
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
