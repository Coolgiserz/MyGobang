package com.coolcats.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.coolcats.fractal.Fractal;
import com.coolcats.shape.Shape;

public class ControlPanel extends JPanel implements ActionListener, ChangeListener {

//	JColorChooser _colors;
	// 模式选择按钮和按钮组
	JRadioButton _colorBtn;
	public JRadioButton _fraBtn;
	JRadioButton _shapeBtn;
	ButtonGroup _group;
	JButton _saveImageBtn;
	JButton[] _someBtns = new JButton[10];
	// 用于控制参数的滑块
	JSlider a_slider;
	JSlider b_slider;
	JSlider c_slider;
	JSlider d_slider;
	double a, b, c, d;
	JSlider initx0;
	JSlider inity0;

	// 用于记录当前所选的图形或者分形
	String _shape;
	public String _frac;
	private final static String FRACBTN = "分形";
	private final static String COLORBTN = "颜色";
	private final static String SHAPEBTN = "图形";
	private final static String IMAGEBTN = "保存为图片";
	private final static String CLEARCANVAS = "清空画板";
	private final static String MATHCORROSION = "腐蚀运算";
	private final static String MATHEXPANSION = "膨胀运算";

	private final static String MATHOPENING = "开运算";
	private final static String MATHCLOSE = "闭运算";

	private String[] _possibleShape = { "直线", "曲线", "假多边形", "等边三角形", "正方形", "立方体", "斐波那契数列", "连续求和",Shape.MUTILTABLE };
	private String[] _possibleFrac = { "谢尔宾斯基三角形",Fractal.SIERPINSKIRec,"迭代分形A", "迭代分形B", "迭代分形C", "枫叶", "科赫曲线", "分形龙", "三角形", "喷枪", "橡皮" };
	private CanvasPanel _canvas;
	public Color _color;

	public ControlPanel() {
		initControlPanel();
	}

	/**
	 * 初始化控制面板的UI
	 */
	public void initControlPanel() {
		this.setPreferredSize(new Dimension(200, getHeight()));
//		this.setPreferredSize(new Dimension(200,getHeight()));

		this.setBackground(Color.GRAY);

//		_colors = new JColorChooser();
		_fraBtn = new JRadioButton(FRACBTN);
		_colorBtn = new JRadioButton(COLORBTN);
		_shapeBtn = new JRadioButton(SHAPEBTN);
		_saveImageBtn = new JButton(IMAGEBTN);

		_color = new Color(0, 0, 0);
		_fraBtn.addActionListener(this);
		_colorBtn.addActionListener(this);
		_shapeBtn.addActionListener(this);
		_saveImageBtn.addActionListener(this);
		_group = new ButtonGroup();
		_group.add(_shapeBtn);
		_group.add(_fraBtn);
		_shapeBtn.setSelected(true);
		this.add(_shapeBtn);
		this.add(_fraBtn);
		this.add(_colorBtn);
		// 设置滑块
		a_slider = new JSlider(-100, 100, -45);
		b_slider = new JSlider(-100, 100, -15);
		c_slider = new JSlider(-100, 100, 18);
		d_slider = new JSlider(-100, 100, -10);
		a_slider.addChangeListener(this);
		b_slider.addChangeListener(this);
		c_slider.addChangeListener(this);
		d_slider.addChangeListener(this);

		this.add(a_slider);
		this.add(b_slider);
		this.add(c_slider);
		this.add(d_slider);
		initx0 = new JSlider(0, 100, 100);
		inity0 = new JSlider(0, 100, 100);
		initx0.addChangeListener(this);
		inity0.addChangeListener(this);
		this.add(initx0);
		this.add(inity0);
//		JColorChooser.showDialog(this, "颜色选择", Color.BLACK);
		_shape = _possibleShape[0];
		_frac = _possibleFrac[0];

		// 一些功能性按钮
		for (int i = 0; i < 5; i++) {
			_someBtns[i] = new JButton();
			_someBtns[i].addActionListener(this);
		}

		_someBtns[0].setText(CLEARCANVAS);
		_someBtns[1].setText(MATHEXPANSION);
		_someBtns[2].setText(MATHCORROSION);
		_someBtns[3].setText(MATHOPENING);
		_someBtns[4].setText(MATHCLOSE);
		this.add(_saveImageBtn);// 为控制面板添加保存为图片按钮
		for (int i = 0; i < 5; i++) {
			this.add(_someBtns[i]);

		}
	}

	public void setBuddy(CanvasPanel panel) {
		this._canvas = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case FRACBTN:
			System.out.print(FRACBTN);
			_canvas.setBackground(Color.BLACK);
//			_canvas.repaint();
			this._frac = (String) JOptionPane.showInputDialog(null, "图形选择", "AI模式设置", JOptionPane.INFORMATION_MESSAGE,
					null, _possibleFrac, _possibleFrac[0]);

			break;
		case SHAPEBTN:
			System.out.print(SHAPEBTN);
			_canvas.setBackground(_canvas.DEFAULT_BACKGROUND);

			this._shape = (String) JOptionPane.showInputDialog(null, "图形选择", "AI模式设置", JOptionPane.INFORMATION_MESSAGE,
					null, _possibleShape, _possibleShape[0]);
			break;
		case COLORBTN:
			System.out.print(COLORBTN);
			this._color = JColorChooser.showDialog(this, "颜色选择", Color.BLACK);
			if (this._color == null) {
				this._color = Color.BLACK;
			}

			this._canvas._g.setColor(_color);
			System.out.println("已设置成" + this._color);

			break;
		case IMAGEBTN:
			System.out.print(IMAGEBTN);
			try {
				SaveToImage(_canvas);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case CLEARCANVAS:
			System.out.print(CLEARCANVAS);
			_canvas.initCanvasPanel();// 初始化画板

			break;
		case MATHEXPANSION:
			System.out.print(MATHEXPANSION);

			break;
		case MATHCORROSION:
			System.out.print(MATHCORROSION);

			break;
		}

	}

	private void SaveToImage(CanvasPanel canvas) throws IOException {
		// TODO Auto-generated method stub
		if (canvas == null) {
			return;
		}
		Dimension imagesize = canvas.getSize();
		BufferedImage image = new BufferedImage(imagesize.width, imagesize.height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = image.createGraphics();
		System.out.println(image);
		canvas.paint(graphics);
		graphics.dispose();
		Image newImage = image.getScaledInstance(1000, 1000, Image.SCALE_SMOOTH);
		BufferedImage myImage = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
		Graphics graphics1 = myImage.getGraphics();
		graphics1.drawImage(newImage, 0, 0, null);
		graphics1.dispose();

		File fa = new File("src/1.jpg");
		if (!fa.exists()) {
			fa.createNewFile();
			System.out.println(123);
		}

		ImageIO.write(myImage, "jpg", fa);
		JOptionPane.showMessageDialog(this, "保存为图片成功");
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		a = a_slider.getValue() * 0.1;
		b = b_slider.getValue() * 0.1;
		c = c_slider.getValue() * 0.1;
		d = d_slider.getValue() * 0.1;
		System.out.println("值已改变" + a + "," + b + "," + c + "," + d);
		double x0 = initx0.getValue();
		double y0 = inity0.getValue();

		_canvas.setFracPram(a, b, c, d);
		_canvas.getInitValues(x0 / 100, y0 / 100);
		System.out.println("C值已改变" + x0 / 100 + "," + y0 / 100);

		// _canvas.ifsa.drawIFS_A(_canvas._g);
	}

}
