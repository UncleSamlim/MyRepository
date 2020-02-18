package team.fourth.papersys.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import team.fourth.papersys.service.OrderService;
import team.fourth.papersys.service.OrderServiceImpl;

public class OrderTableListener extends MouseAdapter implements ActionListener{
	
	private String []ids = null;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object source = e.getSource();
		if (source instanceof JTable) {
			JTable table = (JTable) source;
			int rowsIndex[] = table.getSelectedRows();// 获取选中行号
			// 单击右键
			if (e.getButton() == MouseEvent.BUTTON3) {
				if(rowsIndex.length>0) {
					JPopupMenu jMenu = new JPopupMenu(); // 创建弹出式菜单
					JMenuItem deleteItem = new JMenuItem("删除");
					JMenuItem passItem = new JMenuItem("通过审核");
					ids = new String[rowsIndex.length];
					for (int i = 0; i < rowsIndex.length; i++) {
						ids[i] = (String) table.getValueAt(rowsIndex[i], 0);
					}
					jMenu.add(deleteItem);
					jMenu.addSeparator();
					jMenu.add(passItem);
					jMenu.show(table, e.getX(), e.getY());// 在鼠标位置显示弹出式菜单
					deleteItem.addActionListener(this);
					passItem.addActionListener(this);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem menuItem = (JMenuItem) e.getSource();
		OrderService orderService = new OrderServiceImpl();
		String text = menuItem.getText();
		if ("删除".equals(text)) {
			int yesOrNo = JOptionPane.showConfirmDialog(menuItem, "是否确认删除?");
			// 点击确认删除
			if(yesOrNo == JOptionPane.OK_OPTION) {
				int res = orderService.removeOrderById(ids);
				if(res==ids.length) {
					JOptionPane.showMessageDialog(menuItem, "删除成功，请刷新！", "操作成功", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
				}else {
					JOptionPane.showMessageDialog(menuItem, "删除失败！", "操作失败", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
				}	
			}
		}else {
			String status = "已审核";
			int res = orderService.modifyOrderStatus(ids, status);
			if(res==ids.length) {
				JOptionPane.showMessageDialog(menuItem, "成功！", "操作成功", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
			}else {
				JOptionPane.showMessageDialog(menuItem, "失败！", "操作失败", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
			}
		}
		
	}
}
