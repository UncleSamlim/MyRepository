package team.fourth.papersys.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import team.fourth.papersys.service.PaperService;
import team.fourth.papersys.service.PaperServiceImpl;
import team.fourth.papersys.util.PaperGlobalObject;

public class PaperTableListener extends MouseAdapter {
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JTable table = PaperGlobalObject.getjTable();
		int rowsIndex[] = table.getSelectedRows();// ��ȡѡ���к�
		// �����Ҽ�
		if (e.getButton() == MouseEvent.BUTTON3) {
			if(rowsIndex.length>0) {
				JPopupMenu jMenu = new JPopupMenu(); // ��������ʽ�˵�
				JMenuItem deleteItem = new JMenuItem("ɾ��");
				JMenuItem updateItem = new JMenuItem("�޸�");
				String []ids = new String[rowsIndex.length];
				for (int i = 0; i < rowsIndex.length; i++) {
					ids[i] = (String) table.getValueAt(rowsIndex[i], 0);
				}
				jMenu.add(deleteItem);
				jMenu.addSeparator();
				jMenu.add(updateItem);
				jMenu.show(table, e.getX(), e.getY());// �����λ����ʾ����ʽ�˵�
				PaperService paperService = new PaperServiceImpl();
				deleteItem.addActionListener(new MenuItemListener(ids, paperService));
				updateItem.addActionListener(new MenuItemListener(ids, paperService));
			}
		}
	}
	
}
