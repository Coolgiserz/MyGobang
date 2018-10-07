package com.coolcats1007.copy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CanvasListener implements MouseListener, ActionListener {

	DrawCanvas _frame;
	Graphics g;
	private final int chess_size = 36;
	JButton srcbtn;
	private int chessR, chessC;
	private int x, y;
	private int interval = 40;
	private int whitecount, blackcount;
	
	public CanvasListener(DrawCanvas frame) {
		this._frame = frame;
		srcbtn = new JButton();
		blackcount = 0;
		whitecount = 0;
	}

	/**
	 * �������ӵĺ���
	 * 
	 * @param xx ����Ӧ��������Ľ���������
	 * @param yy ����Ӧ��������Ľ����������
	 * @param g  ���ʶ���
	 */
	public void drawchess(int xx, int yy, Graphics g) {

		System.out.println(blackcount % 2);
		
		if (blackcount <= whitecount) {
			for (int i = 0; i < 50; i++) {
				Color color = new Color(5 * i, 5 * i, 5 * i);
				g.setColor(color);
				g.fillArc(xx - (chess_size - i) / 2, yy - (chess_size - i) / 2, chess_size - i, chess_size - i, 0, 360);
			}
			blackcount++;

		} else {
			for (int i = 50; i > 0; i--) {
				Color color = new Color(255 - 5 * i, 255 - 5 * i, 255 - 5 * i);
				g.setColor(color);
				g.fillArc(xx - (chess_size - i) / 2, yy - (chess_size - i) / 2, chess_size - i, chess_size - i, 0, 360);

			}
			whitecount++;
		}

	}

	public void mouseClicked(MouseEvent e) {
		g = this._frame.getGraphics();

		if (srcbtn.getText().equals("����")) {
			x = e.getX();
			y = e.getY();
			System.out.println(new Point(x, y));
			if (x < 100 || y < 100 || x > 900 || y > 900) {
				System.out.println("����");
				return;
			}
			/**
			 * ֱ��ͨ���������̱Ƚ�ȷ���������λ�÷�Χ
			 */

			int delta_x = x - this._frame.getOriX();
			int delta_y = y - this._frame.getOriY();
			int loc_xmod;int loc_ymod;
			int maxax = Math.max(delta_x, interval);
			int maxbx = Math.max(delta_y, interval);
			int minax = Math.min(delta_x, interval);
			int minbx = Math.min(delta_y, interval);
			System.out.println("�������:" + e.getX() + " " + e.getY());
			System.out.println("�仯����:" + delta_x  + " " + delta_y);
			
			chessR = delta_y / interval;
			chessC = delta_x / interval;
			System.out.println("������仯����:" + chessC + " " + chessR);

//			loc_xmod = maxax%minax;
//			loc_ymod = maxbx%minbx;
			loc_xmod = delta_x % interval;
			loc_ymod = delta_y % interval;
			if(loc_xmod>20) {
				chessC++;
			}
			if(loc_ymod>20) {
				chessR++;
			}
			System.out.println("������仯����:" + chessC + " " + chessR);

			System.out.println("����:" + loc_xmod + " " + loc_ymod);
			
			System.out.println("����:" + delta_x % interval + " " + delta_y % interval);

			 int xx = this._frame.getOriX()+chessC*interval;
			 int yy = this._frame.getOriY()+chessR*interval;

				g.setColor(Color.BLACK);
				System.out.println("xx:" + xx + "yy:" + yy);
				drawchess(xx, yy, g);
//	    					g.fillOval(xx-chess_size/2, yy-chess_size/2, chess_size, chess_size);
		
			return;
		}
//		System.out.println(e.getX()+" "+e.getY());

		int x = e.getX();
		int y = e.getY();
		for (int i = 0; i < 50; i++) {
//				Color color = new Color(255,0,0);   		

			for (int j = 0; j < 10; j++) {
				Color color = new Color(255 - i - 5 * j, 255 - 5 * i, i * 4 + 5 + j * 2);
				g.setColor(color);

				g.fillOval(x - i * 2 + 5 * j, y - i * 2 - 5 * j, 50 + i, 50 + i);
				g.fillOval(x + i * 2 + 5 * j, y - i * 2 - 5 * j, 50 + i, 50 + i);
				g.fillOval(x - i * 2 + 5 * j, y + i * 2 - 5 * j, 50 + i, 50 + i);
				g.fillOval(x + i * 2 + 5 * j, y + i * 2 - 5 * j, 50 + i, 50 + i);
			}

		}
	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 */
	public void mousePressed(MouseEvent e) {
	}

	/**
	 * Invoked when a mouse button has been released on a component.
	 */
	public void mouseReleased(MouseEvent e) {

	}

	/**
	 * Invoked when the mouse enters a component.
	 */
	public void mouseEntered(MouseEvent e) {

	}

	/**
	 * Invoked when the mouse exits a component.
	 */
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		srcbtn = (JButton) e.getSource();
		if (srcbtn.getText().equals("ͼ��")) {
			return;
		}

	}
}
