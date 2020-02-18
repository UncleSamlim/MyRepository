package team.fourth.papersys.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class JFrameUtil {
	
	public static void init(JFrame frame,int width,int height,int closeOperation) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		//得到屏幕的宽
		int screenWidth = (int) screenSize.getWidth();
		//得到屏幕的高
		int screenHeight = (int) screenSize.getHeight();
		frame.setBounds((screenWidth-width)/2,(screenHeight-height)/2,width,height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(closeOperation);
	}
}
