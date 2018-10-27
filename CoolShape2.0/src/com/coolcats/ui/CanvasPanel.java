package com.coolcats.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.coolcats.fractal.FracThread;
import com.coolcats.fractal.Fractal;
import com.coolcats.fractal.IFS_A;
import com.coolcats.fractal.IFS_B;
import com.coolcats.fractal.IFS_C;
import com.coolcats.fractal.MapleLeaf;
import com.coolcats.fractal.RecursionFrac;
import com.coolcats.shape.CreateShape;
import com.coolcats.shape.CurseShape;
import com.coolcats.shape.FakePolygon;
import com.coolcats.shape.LineShape;
import com.coolcats.shape.PointShape;
import com.coolcats.shape.Shape;

public class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener {

	public final static Color DEFAULT_BACKGROUND = Color.LIGHT_GRAY;
	Graphics _g;
	ControlPanel _control;
	Shape shape;
	int _orix, _oriy;
	int _endx, _endy;
	int realx, realy;

	// 图形对象
	ArrayList<Shape> _shapes = new ArrayList<>();
	CurseShape _curse;
	FakePolygon _fakepolygon;
	// 分形对象
	ArrayList<Fractal> _fractals = new ArrayList<>();
	Fractal _frac;
	double x0 = 1.0f, y0 = 1.0f;
	double a = -2.2, b = -0.75, c = 0.9, d = -0.5, e = 2.0, f = 1.2;
	Point p1, p2, p3, p4, tp1, tp2, tp3, tp4;
	FracThread frathread;
	int[] xpoints;
	int[] ypoints;
	IFS_A ifsa;
	IFS_B ifsb;
	IFS_C ifsc;
	MapleLeaf maple;
	RecursionFrac recur;

	public CanvasPanel() {
		super();
		initCanvasPanel();
	}

	public void initCanvasPanel() {
		this.setBackground(Color.LIGHT_GRAY);
//		this.setPreferredSize(new Dimension(800,getHeight()));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		_shapes.clear();
		this.repaint();
	}

	/**
	 * 用于获取画笔对象
	 * 
	 * @param g
	 */
	public void getCanvasGraphics(Graphics g) {
		this._g = g;
		this._g.setColor(Color.BLACK);
//		System.out.println(this._g);

	}

	public void getInitValues(double x0, double y0) {
		this.x0 = x0;
		this.y0 = y0;
	}

	public void setFracPram(double a, double b, double c, double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	/**
	 * 用于获取控制面板的参数，包括当前模式，所选取的颜色等等
	 * 
	 * @param panel
	 */
	public void setBuddy(ControlPanel panel) {
		this._control = panel;
//		this._g.setColor(Color.BLACK);
//		System.out.println(this._g.toString());
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

		if (this._control._shapeBtn.isSelected()) {
			if (true) {
//				e.getButton()==MouseEvent.BUTTON1
//				System.out.println("左键");
				switch (this._control._shape) {
				case Shape.LINESHAPE:
//					this.drawLine();
					_endx = e.getX();
					_endy = e.getY();
					this.repaint();
					this._g.drawLine(_orix, _oriy, _endx, _endy);

					break;
				case Shape.CURSESHAPE:
					_endx = e.getX();
					_endy = e.getY();
					this._g.drawLine(_orix, _oriy, _endx, _endy);
					_curse.add(new PointShape(_endx, _endy));

					_orix = _endx;
					_oriy = _endy;

//					this.drawCurse();
					break;
				case Shape.FAKEPOLYGONSHAPE:
					_endx = e.getX();
					_endy = e.getY();
					this._g.drawLine(_orix, _oriy, _endx, _endy);
//					_fakepolygon.add(new PointShape(_endx, _endy));
//					_fakepolygon.append(new LineShape(_orix, _oriy, _endx, _endy));

					_fakepolygon.addPoint(new PointShape(_endx, _endy));
					_orix = _endx;
					_oriy = _endy;

				}
			}

		} else if (this._control._fraBtn.isSelected()) {
			System.out.println("当前为分形模式");

		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (this._control._shapeBtn.isSelected()) {
			System.out.println("鼠标点击");
			switch (this._control._shape) {
			case Shape.FAKEPOLYGONSHAPE:
//				System.out.println("假多边形模式"+_fakepolygon.getLength()+_fakepolygon.get(3));
				if (e.getButton() == MouseEvent.BUTTON3) {
//					int lastx = realx;
//					int lasty = realy;
					System.out.println("BUTTON3");

					this._g.drawLine(_orix, _oriy, realx, realy);
					_fakepolygon.addPoint(new PointShape(realx, realy));
//					_fakepolygon.append(new LineShape(_endx, _endy, realx, realy));
					System.out.println(_fakepolygon.getLength());
					_shapes.add(_fakepolygon);
					realx = 0;
					realy = 0;
				}
				break;
			case Shape.TRIANGLE:
				// 绘制三角形
				CreateShape create = new CreateShape();
				int centx = e.getX();
				int centy = e.getY();
				int r = 200;
				int[] xpoints = new int[3];
				int[] ypoints = new int[3];
				xpoints[0] = centx;
				ypoints[0] = centy + r;
				xpoints[1] = ((int) ((centx - Math.cos(Math.toRadians(30)) * r) * 100)) / 100;
				ypoints[1] = ((int) ((centy - Math.sin(Math.toRadians(30)) * r) * 100)) / 100;
				xpoints[2] = ((int) ((centx + Math.cos(Math.toRadians(30)) * r) * 100)) / 100;
				ypoints[2] = ((int) ((centy - Math.sin(Math.toRadians(30)) * r) * 100)) / 100;
				System.out.println(xpoints[0] + "," + ypoints[0]);

				System.out.println(xpoints[1] + "," + ypoints[1]);
				create.drawTriangle(xpoints, ypoints, _g);
				break;
			case "连续求和":
				System.out.println("连续求和");

				CreateShape sum = new CreateShape();
				this._g.drawString(sum.drawSumTable(100, e) + "", e.getX(), e.getY());
				break;
			case Shape.FIBONACCI:
				System.out.println("斐波那契");

				CreateShape fib = new CreateShape();
//				fib.drawFib(_g, 20,e.getX(),e.getY(),20,this.getHeight());
//				for(int i=0;i<=100;i++) {

//					System.out.println(fib.Fib(50));

//				}
				break;
			case Shape.MUTILTABLE:
				System.out.println("九九");

				CreateShape ta = new CreateShape();
				ta.drawMutilTable(_g, 9, e);
				break;
			}
		} else if (this._control._fraBtn.isSelected()) {
			System.out.println("当前为分形模式");
			switch (this._control._frac) {
			case Fractal.IFS_A:
//				System.out.println("迭代分形A模式");
				ifsa = new IFS_A(e.getX() - 500, e.getY() - 500);
//				ifsa.setPram(-1.8, -2.0, -0.5, -0.9);
				ifsa.setPram(a, b, c, d);
				_fractals.add(ifsa);

				ifsa.drawIFS_A(_g);
				break;
			case Fractal.IFS_B:
//				System.out.println("迭代分形B模式");
				ifsb = new IFS_B(e.getX() - 500, e.getY() - 500);
//				ifsb.setPram(-2.2, -0.75, 0.9, -0.5);
				ifsb.setPram(a, b, c, d);
				_fractals.add(ifsb);

				ifsb.drawIFS_B(_g);
				break;
			case Fractal.IFS_C:
//				System.out.println("迭代分形C模式");
//				ifsc = new IFS_C();
				frathread = new FracThread(this._control,this._g,e);
				frathread.setInitValue(x0,y0);
				frathread.start();
//				ifsc = new IFS_C(x0, y0, e.getX() - 500, e.getY() - 500);
//				ifsc.setPram(a,b,c);

//				_fractals.add(ifsc);

//				ifsc.drawIFS_C(_g);

//				this.drawLine();
				break;
			case Fractal.SIERPINSKITri:
				System.out.println("谢尔宾斯基三角形模式");
				this._g.setColor(new Color(255, 0, 0));
				frathread = new FracThread(this._control,this._g,e);
				frathread.start();
//				RecursionFrac create = new RecursionFrac(this._control,e,_g);
//				create.run();
				
				break;
			case Fractal.SIERPINSKIRec:
				this._g.setColor(new Color(255, 255, 255));
				recur = new RecursionFrac();

				int a = 400;
				xpoints = new int[4];
				ypoints = new int[4];
				xpoints[0] = e.getX() - a / 2;
				ypoints[0] = e.getY() - a / 2;
				xpoints[1] = e.getX() + a / 2;
				ypoints[1] = e.getY() - a / 2;
				xpoints[2] = e.getX() + a / 2;
				ypoints[2] = e.getY() + a / 2;
				xpoints[3] = e.getX() - a / 2;
				ypoints[3] = e.getY() + a / 2;
				p1 = new Point(xpoints[0], ypoints[0]);
				p2 = new Point(xpoints[1], ypoints[1]);
				p3 = new Point(xpoints[2], ypoints[2]);
				p4 = new Point(xpoints[3], ypoints[3]);
//				recur.fillRectangle(_g, p1, p2, p3, p4);
				this._g.setColor(_control._color);
				recur.fillRectangle(_g, p1, p3);

				recur.drawSierpinskiRec(_g, p1, p3, 0, 5);
				break;
			case Fractal.MAPLELEAF:
//				System.out.println("MapleLeaf模式");
				maple = new MapleLeaf();

//				maple = new MapleLeaf(this.a,this.b,this.c,this.d,this.e,f);
				maple.setPram(0.5, 0.5, e.getX() - 500, e.getY() - 500);

				_fractals.add(maple);

				maple.drawMapleleaf(_g);

//				this.drawLine();
				break;
			case Fractal.KOCH:
//				System.out.println("科赫曲线模式");
				_orix = e.getX();
				_oriy = e.getY();

				_curse = new CurseShape(this._control._color);
				_curse.add(new PointShape(_orix, _oriy));

				// this.drawCurse();
				break;
			case Fractal.MENGER:
//				System.out.println("门格海棉模式");
				_orix = e.getX();
				_oriy = e.getY();
				System.out.println(realx + " " + realy);
				if (realx == 0 && realy == 0) {
					realx = _orix;
					realy = _oriy;
				}
				break;

			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("当前模式");

		// TODO Auto-generated method stub
		if (this._control._shapeBtn.isSelected()) {
			// 鼠标左键按下时，避免右键点击的冲突
			if (e.getButton() == MouseEvent.BUTTON1) {
				System.out.println("当前为图形模式");
				switch (this._control._shape) {
				case Shape.LINESHAPE:
//					System.out.println("直线模式");
					_orix = e.getX();
					_oriy = e.getY();
//					this.drawLine();
					break;
				case Shape.CURSESHAPE:
//					System.out.println("曲线模式");
					_orix = e.getX();
					_oriy = e.getY();

					_curse = new CurseShape(this._control._color);
					_curse.add(new PointShape(_orix, _oriy));

					// this.drawCurse();
					break;
				case Shape.FAKEPOLYGONSHAPE:
//					System.out.println("假多边形模式");
					_orix = e.getX();
					_oriy = e.getY();
					System.out.println(realx + " " + realy);
					if (realx == 0 && realy == 0) {
						realx = _orix;
						realy = _oriy;
					}
					_fakepolygon = new FakePolygon(this._control._color);
					_fakepolygon.addPoint(new PointShape(_orix, _oriy));
					break;

				}
			}

		}
	}

	private void drawCurse() {
		// TODO Auto-generated method stub

	}

	private void drawLine() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (this._control._shapeBtn.isSelected()) {
			System.out.println("当前为图形模式");
			switch (this._control._shape) {
			case Shape.LINESHAPE:
				System.out.println("直线模式");
				_endx = e.getX();
				_endy = e.getY();
				this._g.drawLine(_orix, _oriy, _endx, _endy);
				LineShape line = new LineShape(_orix, _oriy, _endx, _endy, this._control._color);
				this._shapes.add(line);
				// this.drawLine();
				break;
			case Shape.CURSESHAPE:
				System.out.println("曲线模式");

				this._shapes.add(_curse);
//				this.drawCurse();
				break;
			case Shape.FAKEPOLYGONSHAPE:
//				realx = 0;
//				realy = 0;
				break;
			}

		} else if (this._control._fraBtn.isSelected()) {
			System.out.println("当前为分形模式");

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void paint(Graphics g) {
		super.paint(g);
//		g.setColor(_control._color);
		if (_control._shapeBtn.isSelected()) {
			repaintcanvas(g);

		}
//		else if (_control._fraBtn.isSelected()) {
//			repaintfrac(g);
//		}
	}

	/**
	 * 重绘分形
	 * 
	 * @param g
	 */
	private void repaintfrac(Graphics g) {
		for (int i = 0; i < _fractals.size(); i++) {
			_frac = _fractals.get(i);
			switch (_frac.getType()) {
			case Fractal.IFS_A:
				IFS_A ifs = (IFS_A) _frac;
				ifs.setPram(a, b, c, d);

				ifs.drawIFS_A(_g);
				this.repaint();

				break;
			case Fractal.IFS_B:
				IFS_B ifs_b = (IFS_B) _frac;
				ifs_b.setPram(a, b, c, d);
				ifs_b.drawIFS_B(_g);
				this.repaint();

				break;
			case Fractal.IFS_C:
				IFS_C ifs_c = (IFS_C) _frac;
				ifs_c.setPram(a, b, c);
				ifs_c.drawIFS_C(_g);
				this.repaint();

				break;
			case Fractal.KOCH:
				CurseShape curse = (CurseShape) shape;
				g.setColor(curse._color);
				for (int i1 = 0; i1 < curse.getLength() - 1; i1++) {
					g.drawLine(curse._points.get(i1).x, curse._points.get(i1).y, curse._points.get(i1 + 1).x,
							curse._points.get(i1 + 1).y);
				}
				break;

			}

		}
	}

	/**
	 * 重绘图形
	 * 
	 * @param g
	 */
	public void repaintcanvas(Graphics g) {
		for (int i = 0; i < _shapes.size(); i++) {
			shape = _shapes.get(i);
			switch (shape.getType()) {
			case Shape.LINESHAPE:
				LineShape line = (LineShape) shape;
				g.setColor(line.color);
				this.repaint();

				g.drawLine(line.x1, line.y1, line.x2, line.y2);
//				this.repaint();

				break;
			case Shape.CURSESHAPE:
				CurseShape curse = (CurseShape) shape;
				g.setColor(curse._color);
				for (int i1 = 0; i1 < curse.getLength() - 1; i1++) {
					g.drawLine(curse._points.get(i1).x, curse._points.get(i1).y, curse._points.get(i1 + 1).x,
							curse._points.get(i1 + 1).y);
				}
				break;
			case Shape.FAKEPOLYGONSHAPE:
//				System.out.println("重绘多边形");

				FakePolygon fakepolygon = (FakePolygon) shape;
//				System.out.println(fakepolygon.getLength());
				g.setColor(fakepolygon._color);
				int i2;
				for (i2 = 0; i2 < fakepolygon.getLength() - 2; i2++) {
					g.drawLine(fakepolygon.get(i2).x, fakepolygon.get(i2).y, fakepolygon.get(i2 + 1).x,
							fakepolygon.get(i2 + 1).y);
				}
				g.drawLine(fakepolygon.get(i2).x, fakepolygon.get(i2).y, fakepolygon.get(i2 + 1).x,
						fakepolygon.get(i2 + 1).y);
//				for(i2=0;i2<_fakepolygon._lines.size();i2++) {
//					this._g.drawLine(x1, y1, x2, y2);
//				}
			}

		}
	}
}
