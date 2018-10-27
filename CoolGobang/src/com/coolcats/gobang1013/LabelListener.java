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
 * 根据玩家喜好选择游戏模式，并将当前游戏模式、状态等参数显示在状态栏中 处理按钮事件，如开始新游戏、悔棋
 * 
 * @author CoolCats
 *
 */
public class LabelListener implements ActionListener, ChangeListener {

	private final static String BTN_BEGIN = "开始新游戏";
	private final static String BTN_REGRET = "悔棋";
	public final static String BLACK_SIDE = "黑方";
	public final static String WHITE_SIDE = "白方";
	public final static String MODE_PP = "人人对战";
	public final static String MODE_PM = "人机对战";
	public final static String MODE_AIFIRST = "AI先手";
	public final static String MODE_AISECOND = "AI后手";

	public static String _mode = MODE_PP;
	public static String ai_mode;

	public static int _turn;
	public static String selectedValue; // 存储所选的AI模式
//	public static Stack<Point> _tmpchess = new Stack<>();
	static ArrayList<Point>  _tmpchess = new ArrayList<>();
	JRadioButton srcradiobtn;
	JButton srcbtn;
	LabelPanel _buddyLabPanel;
	ChessPanel _buttyChessPanel;
	CoolFrame _buddyFrame;
	WeigthPlayer weightAI;
	CanvasListener _canvasLis;
	Object[] possibleValues = { "权值法", "博弈树", "机器学习" }; // 用户的选择项目

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
			// 如果为人机模式
			if (_mode.equals(MODE_PM)) {
//				this._canvasLis.setAI(weightAI);

				Object[] possibleValues = { MODE_AISECOND, MODE_AIFIRST }; // 用户的选择项目
				ai_mode = (String) JOptionPane.showInputDialog(null, "选择你的对手模型", "AI模式设置",
						JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
				System.out.println("你选择了" + (String) selectedValue + "项目");
				// 根据先手后手的设置进行不同的处理
				switch (ai_mode) {
				// AI后手时
				case MODE_AISECOND:
					LabelPanel.isBegin = true;
					_buddyFrame.setCanvasListener(); // 设置监听
					_turn = 0; // 初始化回合数
//					_buddyLabPanel.c
//					System.out.println(_canvasLis);
//					_canvasLis.
//					CanvasListener.initChessTable();
//					_buddyLabPanel.repaint();
					_buddyLabPanel.setStatusLabel(_mode, selectedValue, _turn, BLACK_SIDE);// 设置初始状态栏

					break;
				// AI先手时
				case MODE_AIFIRST:
					break;
				}
			} else {// 人人对战模式
				LabelPanel.isBegin = true; // 游戏开始
				_buddyFrame.setCanvasListener(); // 设置监听
//				System.out.println(_buddyFrame);
				System.out.println(LabelPanel.isBegin); // 打印当前游戏是否开始
				_turn = 0; // 初始化回合数
				_buddyLabPanel.setStatusLabel(_mode, _turn, BLACK_SIDE);// 设置初始状态栏
			}

			break;
		case BTN_REGRET:
			// 悔棋
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
			selectedValue = (String) JOptionPane.showInputDialog(null, "选择你的对手模型", "AI模式设置",
					JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
			System.out.println("您按下了" + (String) selectedValue + "项目");
			switch (selectedValue) {
			case "权值法":
				System.out.println("权值法AI出生！" + this._canvasLis);
				break;
			case "博弈树":
				System.out.println("博弈树AI来了！");

				break;
			case "机器学习":
				System.out.println("机器学习AI来了！");

				break;
			}
//			ModeDialog dlg = new ModeDialog();
			System.out.println(mode);
			break;
		}

	}

	/**
	 * 获取CoolFrame的对象
	 * 
	 * @param f
	 */
	public void setBuddy(CoolFrame f) {
		this._buddyFrame = f;
	}

	/**
	 * 获取LabelPanel的对象
	 * 
	 * @param p
	 */
	public void setBuddy(LabelPanel p) {
		this._buddyLabPanel = p;
	}

	/**
	 * 
	 * 获取ChessPanel的对象
	 * 
	 * @param p
	 */
	public void setBuddy(ChessPanel p) {
		this._buttyChessPanel = p;
	}

	/**
	 * 获取CanvasListener的对象
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
