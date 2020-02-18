package team.fourth.papersys.util;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * �Զ���������ģ��
 * @author linyanbin
 *
 * 2018��3��12������9:40:25
 */
public class InfoTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	
	private String[] columnHeader; //��ͷ
	private Vector<Vector<String>> infoVector;	//�������
	
	public InfoTableModel() {
		
	}
	
	public InfoTableModel(String[] columnHeader, Vector<Vector<String>> infoVector) {
		super();
		this.columnHeader = columnHeader;
		this.infoVector = infoVector;
	}
	
	// ���õ�Ԫ��Ϊ�޷��༭
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
	
	// ���ñ����ʽ
	public void setTableStyle(JTable table) {
		table.setSelectionForeground(Color.RED);// ѡ�е������ֱ�ɺ�ɫ
		table.setSelectionBackground(Color.ORANGE);// ѡ�е��б���ɫ
		Font font = new Font("����", Font.ITALIC, 14);
		table.setRowHeight(30);// �еĸ߶�
		table.setFont(font);
		// ����table���е����ݾ�����ʾ
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		table.getTableHeader().setFont(font);
	}

}
