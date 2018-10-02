import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GraphicController {

	public JFrame frame;
	int typecount = 14;
	int colorcount = 4;
	JButton[] typebutton = new JButton[typecount];
	JButton[] colorbutton = new JButton[colorcount];

	public void initUI() {
		// TODO Auto-generated method stub
		frame = new JFrame("CoolCats����ͼ��1.0");
		frame.setSize(1200,700);
		frame.setDefaultCloseOperation(3);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		
		DrawingListener ll = new DrawingListener(frame);

		for(int i=0;i<typecount;i++) {
			typebutton[i] = new JButton();			
			typebutton[i].setPreferredSize(new Dimension(150,50));
			typebutton[i].addActionListener(ll);
			frame.add(typebutton[i]);
			
		}
		typebutton[1].setText("ֱ��");
		typebutton[2].setText("����");
		typebutton[3].setText("���Բ");
		typebutton[4].setText("���3D����");
		typebutton[5].setText("ͼƬ");
		typebutton[6].setText("����");
		typebutton[7].setText("�����");
		typebutton[8].setText("ˢ��");
		typebutton[9].setText("��������");
		typebutton[10].setText("����������");
		typebutton[11].setText("������");
		typebutton[12].setText("����");
		typebutton[13].setText("��ǹ");
		typebutton[0].setText("��Ƥ");

		for(int i=0;i<colorcount;i++) {
			colorbutton[i] = new JButton();
			colorbutton[i].setPreferredSize(new Dimension(150,50));
			colorbutton[i].addActionListener(ll);
			
			frame.add(colorbutton[i]);
		
		}
		colorbutton[0].setBackground(Color.RED);
		colorbutton[1].setBackground(Color.BLUE);
		colorbutton[2].setBackground(Color.GREEN);
		colorbutton[3].setBackground(Color.BLACK);

		
		frame.addMouseListener(ll);
		frame.addMouseMotionListener(ll);
		frame.setVisible(true);
		
		
	}

	
}
