package com.coolcats.gobang1013;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * �������ϲ��ѡ����Ϸģʽ��������ǰ��Ϸģʽ��״̬�Ȳ�����ʾ��״̬���� ����ť�¼����翪ʼ����Ϸ������
 * 
 * @author CoolCats
 *
 */
public class LabelListener implements ActionListener, ChangeListener {

	private final static String BTN_BEGIN = "��ʼ����Ϸ";
	private final static String BTN_REGRET = "����";
	public final static String BLACK_SIDE = "�ڷ�";
	public final static String WHITE_SIDE = "�׷�";
	public final static String MODE_PP = "���˶�ս";
	public final static String MODE_PM = "�˻���ս";
	public final static String MODE_AIFIRST = "AI����";
	public final static String MODE_AISECOND = "AI����";

	public static String _mode = MODE_PP;
	public static String ai_mode;

	public static int _turn;
	public static String selectedValue; // �洢��ѡ��AIģʽ
//	public static Stack<Point> _tmpchess = new Stack<>();
	static ArrayList<Point>  _tmpchess = new ArrayList<>();
	JRadioButton srcradiobtn;
	JButton srcbtn;
	LabelPanel _buddyLabPanel;
	ChessPanel _buttyChessPanel;
	CoolFrame _buddyFrame;
	WeigthPlayer weightAI;
	CanvasListener _canvasLis;
	Object[] possibleValues = { "Ȩֵ��", "������", "����ѧϰ" }; // �û���ѡ����Ŀ

	public LabelListener() {
		// TODO Auto-generated constructor stub
		srcbtn = new JButton();
		srcradiobtn = new JRadioButton();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println();
//		srcbtn = (JButton)e.getSource();
//		System.out.println(e.getSource());
		String mode = e.getActionCommand();
		switch (mode) {
		case BTN_BEGIN:
			System.out.println(mode);
			// ���Ϊ�˻�ģʽ
			if (_mode.equals(MODE_PM)) {
//				this._canvasLis.setAI(weightAI);

				Object[] possibleValues = { MODE_AISECOND, MODE_AIFIRST }; // �û���ѡ����Ŀ
				ai_mode = (String) JOptionPane.showInputDialog(null, "ѡ����Ķ���ģ��", "AIģʽ����",
						JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
				System.out.println("��ѡ����" + (String) selectedValue + "��Ŀ");
				// �������ֺ��ֵ����ý��в�ͬ�Ĵ���
				switch (ai_mode) {
				// AI����ʱ
				case MODE_AISECOND:
					LabelPanel.isBegin = true;
					_buddyFrame.setCanvasListener(); // ���ü���
					_turn = 0; // ��ʼ���غ���
//					_buddyLabPanel.c
//					System.out.println(_canvasLis);
//					_canvasLis.
//					CanvasListener.initChessTable();
//					_buddyLabPanel.repaint();
					_buddyLabPanel.setStatusLabel(_mode, selectedValue, _turn, BLACK_SIDE);// ���ó�ʼ״̬��

					break;
				// AI����ʱ
				case MODE_AIFIRST:
					break;
				}
			} else {// ���˶�սģʽ
				LabelPanel.isBegin = true; // ��Ϸ��ʼ
				_buddyFrame.setCanvasListener(); // ���ü���
//				System.out.println(_buddyFrame);
				System.out.println(LabelPanel.isBegin); // ��ӡ��ǰ��Ϸ�Ƿ�ʼ
				_turn = 0; // ��ʼ���غ���
				_buddyLabPanel.setStatusLabel(_mode, _turn, BLACK_SIDE);// ���ó�ʼ״̬��
			}

			break;
		case BTN_REGRET:
			// ����
			if(LabelListener._tmpchess!=null) {
				if (_mode.equals(MODE_PP)) {
					
					Point p = LabelListener._tmpchess.remove(_tmpchess.size()-1);
					CanvasListener._chesstable[p.x][p.y] = 0;
					System.out.println("LabelPanel's _buddyChessPanel:"+this._buttyChessPanel);
					this._buttyChessPanel.repaint();
				} else if (_mode.equals(MODE_PM)) {
					Point p = LabelListener._tmpchess.remove(_tmpchess.size()-1);
					CanvasListener._chesstable[p.x][p.y] = 0;
					 p = LabelListener._tmpchess.remove(_tmpchess.size()-1);
					CanvasListener._chesstable[p.x][p.y] = 0;
				}
			}
		
			System.out.println(mode);
			break;
		case MODE_PP:
			_mode = MODE_PP;
			_buddyLabPanel.setStatusLabel(_mode, _turn, BLACK_SIDE);

			System.out.println(mode);
			break;
		case MODE_PM:
			_mode = MODE_PM;
			_buddyLabPanel.setStatusLabel(_mode, _turn, BLACK_SIDE);
			selectedValue = (String) JOptionPane.showInputDialog(null, "ѡ����Ķ���ģ��", "AIģʽ����",
					JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
			System.out.println("��������" + (String) selectedValue + "��Ŀ");
			switch (selectedValue) {
			case "Ȩֵ��":
				System.out.println("Ȩֵ��AI������" + this._canvasLis);
				break;
			case "������":
				System.out.println("������AI���ˣ�");

				break;
			case "����ѧϰ":
				System.out.println("����ѧϰAI���ˣ�");

				break;
			}
//			ModeDialog dlg = new ModeDialog();
			System.out.println(mode);
			break;
		}

	}

	/**
	 * ��ȡCoolFrame�Ķ���
	 * 
	 * @param f
	 */
	public void setBuddy(CoolFrame f) {
		this._buddyFrame = f;
	}

	/**
	 * ��ȡLabelPanel�Ķ���
	 * 
	 * @param p
	 */
	public void setBuddy(LabelPanel p) {
		this._buddyLabPanel = p;
	}

	/**
	 * 
	 * ��ȡChessPanel�Ķ���
	 * 
	 * @param p
	 */
	public void setBuddy(ChessPanel p) {
		this._buttyChessPanel = p;
	}

	/**
	 * ��ȡCanvasListener�Ķ���
	 * 
	 * @param lis
	 */
	public void setCanvasLis(CanvasListener lis) {
		this._canvasLis = lis;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
//		System.out.println(e.getSource());
		srcradiobtn = (JRadioButton) e.getSource();
		String mode = srcradiobtn.getText();
		System.out.println(mode);
	}

}
