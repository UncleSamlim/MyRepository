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
		int rowsIndex[] = table.getSelectedRows();// 获取选中行号
		// 单击右键
		if (e.getButton() == MouseEvent.BUTTON3) {
			if(rowsIndex.length>0) {
				JPopupMenu jMenu = new JPopupMenu(); // 创建弹出式菜单
				JMenuItem deleteItem = new JMenuItem("删除");
				JMenuItem updateItem = new JMenuItem("修改");
				String []ids = new String[rowsIndex.length];
				for (int i = 0; i < rowsIndex.length; i++) {
					ids[i] = (String) table.getValueAt(rowsIndex[i], 0);
				}
				jMenu.add(deleteItem);
				jMenu.addSeparator();
				jMenu.add(updateItem);
				jMenu.show(table, e.getX(), e.getY());// 在鼠标位置显示弹出式菜单
				PaperService paperService = new PaperServiceImpl();
				deleteItem.addActionListener(new MenuItemListener(ids, paperService));
				updateItem.addActionListener(new MenuItemListener(ids, paperService));
			}
		}
	}
	
}
