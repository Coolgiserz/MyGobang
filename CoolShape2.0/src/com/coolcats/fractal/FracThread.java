package com.coolcats.fractal;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import com.coolcats.ui.ControlPanel;

public class FracThread extends Thread {
	private Graphics g;
	private MouseEvent e;
	private ControlPanel control;
	private double x0 = 1.0f, y0 = 1.0f;

	public FracThread(ControlPanel control, Graphics g, MouseEvent e) {
		this.g = g;
		this.e = e;
		this.control = control;
	}

	public FracThread() {

	}

	public void setInitValue(double x0, double y0) {
		this.x0 = x0;
		this.y0 = y0;
	}

	public void run() {
		switch (this.control._frac) {
		case Fractal.IFS_A:
			break;
		case Fractal.IFS_B:
			break;
		case Fractal.IFS_C:
			IFS_C ifsc = new IFS_C(x0, y0, e.getX() - 500, e.getY() - 500);
			ifsc.drawIFS_C(g);
			break;
		case Fractal.IFS_D:
			break;
		case Fractal.KOCH:
			break;
		}
	}
}
