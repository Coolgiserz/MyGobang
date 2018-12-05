import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Controller extends JFrame {

	private int FieldWidth = 1100;
	private int FieldHeight = 800;

	private JTextField searchField;
	private JTextField nameResField;
	private JTextField dirResField;
	private FileHelper fileHelper;

	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.initUI();
	}

	public void initUI() {
		this.setTitle("文件搜索器");
		this.setSize(FieldWidth, FieldHeight);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		fileHelper = new FileHelper();
		initTextField();
		this.setVisible(true);
	}

	public void initTextField() {
		searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(FieldWidth - 50, 50));
		this.add(searchField);
		searchField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					System.out.println("Enter");
					String searchStr = searchField.getText();
//					System.out.println(searchStr);
					fileHelper.listFiles(searchStr);
				}

			}
		});

		nameResField = new JTextField();
		dirResField = new JTextField();
		JPanel contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(FieldWidth - 50, FieldHeight - 130));
		contentPane.setLayout(new BorderLayout());
		contentPane.add(nameResField);
		contentPane.add(dirResField);
		// 添加拆分窗格
		contentPane.setBackground(Color.GRAY);
		this.add(contentPane);
	}
}
