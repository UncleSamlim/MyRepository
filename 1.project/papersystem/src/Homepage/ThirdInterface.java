package Homepage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import obj.Order;
import obj.User;
import util.GetData;
import util.PackData;
import util.TableUtil;

public class ThirdInterface extends JPanel {
	private Order order = null;
	private static final long serialVersionUID = 1L;
	private static JTable table = null;
	private static JTable table1 = null;
private Object[][] data1 = null,data2 = null;
	public ThirdInterface(User user) {
		this.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		JPanel pane = new JPanel(new GridLayout(2, 1));
		JButton jbu = new JButton("修改");
		JButton jbu1 = new JButton("刷新");
		JButton jbu2 = new JButton("删除");
		JScrollPane scrollPane = new JScrollPane();
		JScrollPane scrollPane1 = new JScrollPane();

		PackData pa= new PackData();
		GetData t = new GetData();
	//	Object[][] data1 = null;
	//	Object[][] data2 = null;

		p.add(jbu);
		p.add(jbu2);
		p.add(jbu1);
		

		this.add(p, BorderLayout.SOUTH);

		String[][] row = new String[20][10];
		String[] columnhead = { "订单编号", "用户编号", "收件人", "手机号码", "地址", "数量",
				"金额", "日期", "状态" };
		DefaultTableModel tmd = new DefaultTableModel(row, columnhead);
		DefaultTableModel tmd1 = new DefaultTableModel(row, columnhead);
		table = new JTable(tmd);
		table1 = new JTable(tmd1);
		TableUtil.setTable(table);
		TableUtil.setTable(table1);
		data1 = t.queryorderchecked(user.getUser_id());
		data2 = t.queryorderunchecked(user.getUser_id());
		tmd.setDataVector(data1, columnhead);
		tmd1.setDataVector(data2, columnhead);
		scrollPane.setViewportView(table);
		scrollPane1.setViewportView(table1);

		pane.add(scrollPane);
		pane.add(scrollPane1);
		this.add(pane, BorderLayout.CENTER);

		jbu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rownumber = table1.getSelectedRow();
				if (rownumber<0) {
					JOptionPane.showMessageDialog(table1,"请选中未审核进行报刊修改！","操作失败",JOptionPane.ERROR_MESSAGE,new ImageIcon("img/error-icon.png"));
					return;
				}
				String getorderid = table1.getValueAt(rownumber, 0).toString();
				System.out.println(getorderid );
				//Frame f = JOptionPane.getFrameForComponent(this);
				order= new Order();
				order = pa.findorder( getorderid);
				new Modify(getorderid, order );
				
			}
		});
		
		jbu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rownumber = table1.getSelectedRow();
				if (rownumber<0) {
					JOptionPane.showMessageDialog(table1,"请选中未审核进行报刊删除！","操作失败",JOptionPane.ERROR_MESSAGE,new ImageIcon("img/error-icon.png"));
					return;
				}
				String getorderid = table1.getValueAt(rownumber, 0).toString();
				//Frame f = JOptionPane.getFrameForComponent(this);
				order= new Order();
				order = pa.findorder( user.getUser_id());
				new Delete(getorderid);
				
			}
		});
		jbu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 	String[][] row = new String[20][10];
			String[] columnhead = { "订单编号", "用户编号", "收件人", "手机号码", "地址", "数量",
					"金额", "日期", "状态" };
			DefaultTableModel tmd = new DefaultTableModel(row, columnhead);
			DefaultTableModel tmd1 = new DefaultTableModel(row, columnhead);
			table = new JTable(tmd);
			table1 = new JTable(tmd1);
			TableUtil.setTable(table);
			TableUtil.setTable(table1);
			data1 = t.queryorderchecked(user.getUser_id());
			data2 = t.queryorderunchecked(user.getUser_id());
			tmd.setDataVector(data1, columnhead);
			tmd1.setDataVector(data2, columnhead);
			scrollPane.setViewportView(table);
			scrollPane1.setViewportView(table1);

			pane.add(scrollPane);
			pane.add(scrollPane1);
			//this.add(pane, BorderLayout.CENTER);}
			}
		});
	}
}
