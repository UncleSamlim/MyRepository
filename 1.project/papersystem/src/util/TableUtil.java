package util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableUtil {
	public static void setTable(JTable table) {
		table.setSelectionForeground(Color.red);
		table.setSelectionBackground(Color.ORANGE);
		table.setRowHeight(30);
		table.setFont(new Font("宋体", Font.ITALIC, 14));
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
	}
}
