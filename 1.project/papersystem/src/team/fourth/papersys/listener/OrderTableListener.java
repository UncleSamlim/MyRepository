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
			int rowsIndex[] = table.getSelectedRows();// ��ȡѡ���к�
			// �����Ҽ�
			if (e.getButton() == MouseEvent.BUTTON3) {
				if(rowsIndex.length>0) {
					JPopupMenu jMenu = new JPopupMenu(); // ��������ʽ�˵�
					JMenuItem deleteItem = new JMenuItem("ɾ��");
					JMenuItem passItem = new JMenuItem("ͨ�����");
					ids = new String[rowsIndex.length];
					for (int i = 0; i < rowsIndex.length; i++) {
						ids[i] = (String) table.getValueAt(rowsIndex[i], 0);
					}
					jMenu.add(deleteItem);
					jMenu.addSeparator();
					jMenu.add(passItem);
					jMenu.show(table, e.getX(), e.getY());// �����λ����ʾ����ʽ�˵�
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
		if ("ɾ��".equals(text)) {
			int yesOrNo = JOptionPane.showConfirmDialog(menuItem, "�Ƿ�ȷ��ɾ��?");
			// ���ȷ��ɾ��
			if(yesOrNo == JOptionPane.OK_OPTION) {
				int res = orderService.removeOrderById(ids);
				if(res==ids.length) {
					JOptionPane.showMessageDialog(menuItem, "ɾ���ɹ�����ˢ�£�", "�����ɹ�", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
				}else {
					JOptionPane.showMessageDialog(menuItem, "ɾ��ʧ�ܣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
				}	
			}
		}else {
			String status = "�����";
			int res = orderService.modifyOrderStatus(ids, status);
			if(res==ids.length) {
				JOptionPane.showMessageDialog(menuItem, "�ɹ���", "�����ɹ�", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
			}else {
				JOptionPane.showMessageDialog(menuItem, "ʧ�ܣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
			}
		}
		
	}
}
