package Homepage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import util.c3p0utils;

public class Delete extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  Delete(String getorderid) {
	super("删除订单");
	JLabel jte = new JLabel("确定删除订单？");
	JButton jbu = new JButton("确定");
	JButton jbu1 = new JButton("取消");
	JPanel p1 =new JPanel();
	JPanel p2 =new JPanel();
	
	p1.add(jte);
	p2.add(jbu);
	p2.add(jbu1);
	 
	
	jbu.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Connection conn = null;
			ResultSet rs = null;
			PreparedStatement ps = null;
			try {
				conn = c3p0utils.getConnection();
				ps = conn
						.prepareStatement("DELETE  FROM orders WHERE order_id = ? ");
				ps.setString(1,getorderid);
				int res = ps.executeUpdate();
				System.out.println(res);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					c3p0utils.release(conn, ps, rs);
					
				}
			JOptionPane.showMessageDialog(null, "删除成功！"); 
			
			}
	 
		 
	});
	
	jbu1.addActionListener(this);
	
	this.add(p1);
	this.add(p2);
	this.setLayout(new GridLayout(2, 1));
	this.setLocation(600, 200);
	this.setSize(200, 200);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}
	
}
