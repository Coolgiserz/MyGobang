package com.csuzhuge.gis.uievent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import com.csuzhuge.gis.ui.MapControl;
import com.csuzhuge.gis.ui.MapMenu;

public class FileEvent implements ActionListener {
	
	JButton srcbtn;		
	JMenuItem srcitem;
	MapControl _controlpanel;		
	String currentDirectory = "F:\\GIS\\DATA";//���õ�ǰĬ�Ϲ���Ŀ¼
	String _currentFname = "";
	public FileEvent() {
		
		srcbtn = new JButton();
		srcitem = new JMenuItem();
		
	}
	
	public FileEvent(MapControl panel) {
		this._controlpanel = panel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		srcitem = (JMenuItem) e.getSource();
		String btntype = srcitem.getText();
//		System.out.println(btntype);

		switch(btntype) {
		case MapMenu.SUBMENU_OPEN:
			System.out.println("���ļ�");
			File file = openFile();
			//������ص��ļ���Ϊ�գ���õ���ѡ�ļ���·�����ļ���
			if(file!=null) {
				this._controlpanel._shapepath = file.getPath();
				this._currentFname = file.getName();
				
			}
			
			break;
		}
	}
	/**
	 * ���ѡ�����ļ����򷵻��ļ��������ûѡ���ļ����������ȡ����ť��ֱ�ӹرմ��ڣ��򷵻ؿ�
	 * @return
	 */
	private File openFile() {
		JFileChooser chooser = new JFileChooser(currentDirectory);
		
		if(chooser.showOpenDialog(this._controlpanel)==0) {
//			String dir = chooser.getSelectedFile().getPath();
//			String fname = chooser.getSelectedFile().getName();
//			String path = chooser.getSelectedFile().getAbsolutePath();
//			System.out.println(path+":"+dir+" "+fname);
			return 	chooser.getSelectedFile();

		}
//		System.out.println("openfile");
		return null;
	}
}
