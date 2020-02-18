package team.fourth.papersys.util;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * 自定义表格数据模型
 * @author linyanbin
 *
 * 2018年3月12日上午9:40:25
 */
public class InfoTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	
	private String[] columnHeader; //表头
	private Vector<Vector<String>> infoVector;	//表格数据
	
	public InfoTableModel() {
		
	}
	
	public InfoTableModel(String[] columnHeader, Vector<Vector<String>> infoVector) {
		super();
		this.columnHeader = columnHeader;
		this.infoVector = infoVector;
	}
	
	// 设置单元格为无法编辑
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	
	@Override
	public String getColumnName(int column) {
		return this.columnHeader[column];
	}

	@Override
	public int getRowCount() {
		return infoVector.size();
	}

	@Override
	public int getColumnCount() {
		return columnHeader.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return infoVector.get(rowIndex).get(columnIndex);
	}
	
	// 设置表格样式
	public void setTableStyle(JTable table) {
		table.setSelectionForeground(Color.RED);// 选中的行文字变成红色
		table.setSelectionBackground(Color.ORANGE);// 选中的行背景色
		Font font = new Font("宋体", Font.ITALIC, 14);
		table.setRowHeight(30);// 行的高度
		table.setFont(font);
		// 设置table表中的数据居中显示
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		table.getTableHeader().setFont(font);
	}

}
