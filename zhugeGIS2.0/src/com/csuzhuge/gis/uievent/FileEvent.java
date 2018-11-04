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
	String currentDirectory = "F:\\GIS\\DATA";//设置当前默认工作目录
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
			System.out.println("打开文件");
			File file = openFile();
			//如果返回的文件不为空，则得到所选文件的路径及文件名
			if(file!=null) {
				this._controlpanel._shapepath = file.getPath();
				this._currentFname = file.getName();
				
			}
			
			break;
		}
	}
	/**
	 * 如果选择了文件，则返回文件对象，如果没选择文件，即点击了取消按钮或直接关闭窗口，则返回空
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
