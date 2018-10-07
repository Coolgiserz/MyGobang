import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DrawingListener  extends MouseAdapter implements ActionListener{

	protected String _type;
	public Color _color;
	public Graphics g;
	public JFrame _frame;
	public int x1,y1,x2,y2,x3,y3;
	int x0 = x1;
	int y0 =y1;
		//立方体坐标
	boolean isDown = false;
	public DrawingListener(JFrame frame) {
//		super();
		this._frame = frame;
		_color = new Color(0,0,0);
		System.out.println(this._frame.getTitle());
		System.out.println(x2+" "+y1);
		//		g.setColor(_color);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/**
		 * 监听选择类型的按钮
		 * 
		 */
		JButton btn = (JButton)e.getSource();
		
		if(btn.getText().equals("")) {
			_color = btn.getBackground();

		}else {
			_type = btn.getText();
			_color = new Color(100,100,100);
		} 
		

//		System.out.println(_type);
//		System.out.println(_color);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		x1 = e.getX();
//		y1 = e.getY();
//		if(_type.equals("五角星")) {
//			int width = 10;
//			
//		}
		if(_type.equals("任意多边形")) {
			if(e.getButton()==MouseEvent.BUTTON3) {
				System.out.println(x2+" "+y2);
				System.out.println(x0+" "+y0);

				g.drawLine(x2, y2, x0, y0);
				return;
			}
		}else if(_type.equals("喷枪")) {
			System.out.println(isDown);
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		g = this._frame.getGraphics();
		System.out.println(_color);
		System.out.println("按下");
		isDown = true;
		g.setColor(_color);
		x1 = e.getX();
		y1 = e.getY();
		if(e.getButton()==MouseEvent.BUTTON1) {
			
			x0 = x1;
			 y0 =y1;
			System.out.println(new Point(x1,y1));
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = e.getX();
		y2 = e.getY();
		System.out.println(new Point(x2,y2));
		isDown = false;
		System.out.println("释放");

		if(_type.equals("直线")) {
			System.out.println(_type);
			System.out.println(g);
			
			g.drawLine(x1, y1, x2,y2);
//			g.fillArc(x2, y2, 5, 5, 0, 0);
			System.out.println("绘制");

//			g.setColor(_color);
			
		}else if(_type.equals("矩形")) {
			g.fillRect(x1, y1, x2-x1, y2-y1);
		}else if(_type.equals("填充圆")) {
			int r = Math.abs(x2-x1);
			g.fillArc(x1, y1, r, r, 0, 360);
		}else if(_type.equals("填充3D矩形")) {
//		g.fill
			g.fill3DRect(x1, y1, x2-x1, y2-y1, false);
		}else if(_type.equals("图片")) {
			ImageIcon icon = new ImageIcon("C:\\Users\\CoolCats\\Pictures\\001.jpg");
			Image img = icon.getImage();
//			g.drawIm
			g.drawImage(img, x2, y2, _color,_frame);
//			System.out.println(img);
			
		}else if(_type.equals("文字")) {
			g.drawString("Hello武功山", x2, y2);
		}else if(_type.equals("五角星")) {
			/**
			 *给定中心点，和其中一个角点的坐标值，算出此连线与屏幕垂直方向的夹角 ，依据如下坐标计算出五个角点的坐标值
			 *x -(R * cos(90°+ k * 72°+ yDegree)),  y - (R * sin(90°+ k * 72°+yDegree))）
			 */
			int[] xpoints = new int[5];
			int[] ypoints = new int[5];
			
//			int r = (int) Math.sqrt(((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)));
			int delta_x = x2-x1;
			int delta_y = y2-y1;
			System.out.println("x:"+delta_x+" y:"+ delta_y);
//			int x0 = 0;
//			int y0 = -10;
//			int cos = (x0*delta_x + y0*delta_y)/(10*r);
//			double degree  = Math.acos(cos);
//			System.out.println(cos);

//			System.out.println(r);
			int r = (int) Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
			int R = (int) (2*r*Math.cos(Math.toRadians(18)));
			xpoints[0] = x2;ypoints[0] = y2;
			xpoints[3] = (int) (xpoints[0] - R*Math.sin(Math.toRadians(18)));
			xpoints[2] = (int) (xpoints[0] + R*Math.sin(Math.toRadians(18)));
			xpoints[1] = xpoints[0] + R/2;
			xpoints[4] = xpoints[0] - R/2;
			ypoints[3] = ypoints[2] = (int) (ypoints[0] + Math.cos(Math.toRadians(18))*R);
			ypoints[1] = ypoints[4] = (int) (ypoints[0] + Math.sqrt(Math.pow(xpoints[2]-xpoints[3], 2)-Math.pow(R/2, 2)));
			System.out.println("R="+R);
			System.out.println("r="+r);
			g.drawLine(xpoints[0], ypoints[0], xpoints[3], ypoints[3]);
			g.drawLine(xpoints[3], ypoints[3], xpoints[1], ypoints[1]);
			g.drawLine(xpoints[1], ypoints[1], xpoints[4], ypoints[4]);
			g.drawLine(xpoints[4], ypoints[4], xpoints[2], ypoints[2]);
			g.drawLine(xpoints[2], ypoints[2], xpoints[0], ypoints[0]);
			for(int i = 0;i<5;i++) {
				System.out.println(xpoints[i]+" "+ypoints[i]);

			}


		}else if(_type.equals("等腰三角形")) {
			int[] xpoints = new int[3];
			int[] ypoints = new int[3];

			int r = Math.abs(x2-x1);
			xpoints[0] = x1 - r;
			ypoints[0] = y1;

			xpoints[1] = x1 + r;
			ypoints[1] = y1;

			xpoints[2] = x1 ;
			ypoints[2] = y2;

					
			g.drawPolygon(xpoints, ypoints, 3);//还没考虑三角形的角度
		}else if(_type.equals("立方体")) {
			int[] xpoints = new int[13];
			int[] ypoints = new int[13];

			int r = Math.abs(x2-x1);
			xpoints[0] = x1;ypoints[0] = y1;
			xpoints[1] = x2;ypoints[1] = y1;
			xpoints[2] = x2;ypoints[2] = y2;
			xpoints[3] = x1;ypoints[3] = y2;	
			xpoints[4] = x1;ypoints[4] = y1;
			xpoints[5] = x1 + r/2;ypoints[5] = y1 - r/2;
			xpoints[6] = x2 + r/2;ypoints[6] = y1 - r/2;
			xpoints[7] = x2 + r/2;ypoints[7] = y2 -r/2;
			xpoints[8] = x2;ypoints[8] = y2;
			xpoints[9] = x2;
			ypoints[9] = y1;
			xpoints[10] = x2 + r/2;ypoints[10] = y1 -r/2;
			xpoints[11] = x1 + r/2;ypoints[11] = y1 - r/2;
			xpoints[12] = x1;ypoints[12] = y1;
			g.drawPolygon(xpoints, ypoints, 13);
			g.fillPolygon(xpoints, ypoints, 13);
//			g.fillPolygon(xpoints, ypoints, 4);

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
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = e.getX();
		y2 = e.getY();
		if(_type.equals("曲线")) {
			g.drawLine(x1, y1, x2, y2);
			x1 = x2;
			y1 = y2;
		}else if(_type.equals("橡皮")) {
//			g.drawRect(x2, y2, 5, 5);
			_color = Color.WHITE;
			g.setColor(new Color(238,238,238));
			g.fillRect(x2, y2, 15, 15);
		}else if(_type.equals("刷子")) {
			int[] rgb = new int[3];
			rgb[0] = _color.getBlue();
			rgb[1]= _color.getRed();			
			rgb[2] = _color.getGreen();
			if(rgb[0]<238) {
				rgb[0] = rgb[0]+1;
			}
			if(rgb[1]<238) {
				rgb[1] = rgb[1]+1;
			}if(rgb[2]<238) {
				rgb[2] = rgb[2]+1;
			}
			_color = new Color(rgb[0],rgb[1],rgb[2]);
			g.setColor(_color);
//			g.fillRect(x2, y2, 15, 15);
			g.fillArc(x2, y2, 15, 15, 0, 360);
		}else if(_type.equals("任意多边形")) {
		
			g.drawLine(x1, y1, x2, y2);
			x1 = x2;
			y1 = y2;
		
		}else if(_type.equals("喷枪")) {
			int r = 30;
//			while(isDown==true) {
				int x=(int) (x2+ (r)*Math.random());
				int y=(int) (y2 +(r)*Math.random());
				System.out.println("x="+x+"y="+y);
				g.fillArc(x, y, 5, 5, 0, 360);
//			}
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
//		int _x = e.getX();
//		int _y = e.getY();
		
//		System.out.println(new Point(_x,_y));
	}
	
	


}
