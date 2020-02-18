package team.fourth.papersys.util;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JPanel;

public class FontStyleUtil {
	
	public static void setFontStyle(JPanel jpanel, Font font) {
		Component[] components = jpanel.getComponents();
		for (int i = 0; i < components.length; i++) {
			components[i].setFont(font);
		}
	};
	
}
