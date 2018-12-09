package com.coolcats1209;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class DataListener implements ActionListener {

	private JTextField textName;
	private JComboBox<Character> cbSex;
	private JComboBox<Integer> cbAge;
	private JTextField textScore;
	private JFrame frame;

	public DataListener(JFrame frame, JTextField textName, JComboBox<Character> cbSex, JComboBox<Integer> cbAge,
			JTextField textScore) {
		this.textName = textName;
		this.cbSex = cbSex;
		this.cbAge = cbAge;
		this.textScore = textScore;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("打开")) {
			readData();
		} else if (e.getActionCommand().equals("保存")) {
			writerData();
		}
	}

	private void writerData() {
		JFileChooser chooser = new JFileChooser("F:\\Learning\\Java\\IO流");
		chooser.showOpenDialog(frame);
		File f = chooser.getSelectedFile();
		if (f != null) {
			OutputStream out = null;
			DataOutputStream dout = null;
			try {
				out = new FileOutputStream(f);
				dout = new DataOutputStream(out);
				dout.writeUTF(textName.getText());
				dout.writeChar(cbSex.getSelectedItem().toString().charAt(0));
				dout.writeInt(Integer.parseInt(cbAge.getSelectedItem().toString()));
				dout.writeInt(Integer.parseInt(textScore.getText()));

			} catch (FileNotFoundException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					out.close();
					dout.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private void readData() {
		JFileChooser chooser = new JFileChooser("F:\\Learning\\Java\\IO流");
		chooser.showOpenDialog(frame);
		File f = chooser.getSelectedFile();
		if (f != null) {
			InputStream in = null;
			DataInputStream din = null;
			try {
				in = new FileInputStream(f);
				din = new DataInputStream(in);
				String name = din.readUTF();
				char sex = din.readChar();
				int age = din.readInt();
				int score = din.readInt();
			
				textName.setText(name);
				cbSex.setSelectedItem(sex);
				cbAge.setSelectedItem(age);
				textScore.setText(score+"");
			} catch (FileNotFoundException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
					din.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
