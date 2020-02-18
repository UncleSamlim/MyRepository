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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import obj.User;
import shoporders.Myorderinfo;
import util.GetData;
import util.TableUtil;

public class FristInterface extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTable table = null;

	public FristInterface(User user) {
		this.setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane();
		JButton jbu1 = new JButton("按报刊名查找");
		JButton jbu2 = new JButton("按出版社查找");
		JButton jbu3 = new JButton("浏览全部图书");
		JButton jbu4 = new JButton("订阅报刊");
		JTextField jte1 = new JTextField("", 20);
		JTextField jte2 = new JTextField("", 20);
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel pane = new JPanel();
		GetData t = new GetData();
		Object[][] data1 = null;

		pane.add(jbu1);
		pane.add(jte1);
		pane.add(jbu2);
		pane.add(jte2);
		// pane.add(jbu3);
		pane.setLayout(new GridLayout(2, 1));
		p.add(pane);

		p1.add(jbu3);
		p1.add(jbu4);
		p1.setLayout(new GridLayout(1, 2));
		p.add(p1);
		this.add(p, BorderLayout.NORTH);
		this.add(p1, BorderLayout.SOUTH);

		String[][] row = new String[20][10];
		String[] columnhead = { "报刊编号", "报刊名称", "报刊类别", "出版社", "价格", "刊期",
				"出版日期", "报刊图片", "报刊库存量" };
		DefaultTableModel tmd = new DefaultTableModel(row, columnhead);
		table = new JTable(tmd);
		TableUtil.setTable(table);
		data1 = t.queryDataall();
		tmd.setDataVector(data1, columnhead);
		scrollPane.setViewportView(table);
		this.add(scrollPane, BorderLayout.CENTER);

		jbu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = jte1.getText();
				Object[][] data2 = null;
				DefaultTableModel tmd = new DefaultTableModel(row, columnhead);
				table = new JTable(tmd);
				TableUtil.setTable(table);
				data2 = t.queryDataname(name);
				tmd.setDataVector(data2, columnhead);
				scrollPane.setViewportView(table);
			}
		});
		jbu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String publisher = jte2.getText();
				Object[][] data3 = null;
				DefaultTableModel tmd = new DefaultTableModel(row, columnhead);
				table = new JTable(tmd);
				TableUtil.setTable(table);
				data3 = t.queryDatapublisher(publisher);
				tmd.setDataVector(data3, columnhead);
				scrollPane.setViewportView(table);
			}
		});
		jbu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[][] data1 = null;
				DefaultTableModel tmd = new DefaultTableModel(row, columnhead);
				table = new JTable(tmd);
				TableUtil.setTable(table);
				data1 = t.queryDataall();
				tmd.setDataVector(data1, columnhead);
				scrollPane.setViewportView(table);
			}
		});
		jbu4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rownumber = table.getSelectedRow();
				if (rownumber<0) {
					JOptionPane.showMessageDialog(table,"请选中报刊订购！","操作失败",JOptionPane.ERROR_MESSAGE,new ImageIcon("img/error-icon.png"));
					return;
				}
				String getpaper_id = table.getValueAt(rownumber, 0).toString();
				//Frame f = JOptionPane.getFrameForComponent(this);
				new Myorderinfo(getpaper_id, user);
				
			}
		});
		
	} 
}
 