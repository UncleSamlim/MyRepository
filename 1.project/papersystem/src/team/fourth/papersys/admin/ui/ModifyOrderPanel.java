package team.fourth.papersys.admin.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import team.fourth.papersys.pojo.Order;
import team.fourth.papersys.service.OrderService;
import team.fourth.papersys.service.OrderServiceImpl;
import team.fourth.papersys.util.GBC;

public class ModifyOrderPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private GridBagLayout gridBagLayout;
	private GBC gbc;
	private JLabel orderIdLabel;
	private JLabel receiverLabel;
	private JLabel phoneLabel;
	private JLabel addressLabel;
	private JTextField orderIdText;
	private JTextField receiverText;
	private JTextField phoneText;
	private JTextField addressText;
	private JButton showButton;
	private JButton modifyButton;
	private JButton resetButton;
	
	public ModifyOrderPanel() {
		gridBagLayout = new GridBagLayout();
		gbc = new GBC();
		init();
	}
	
	public void init() {
		this.setBorder(BorderFactory.createTitledBorder("�޸Ķ���"));
		this.setLayout(gridBagLayout);
		gbc.setAnchor(GridBagConstraints.CENTER)
		.setFill(GridBagConstraints.NONE)
		.setInsets(10);
		orderIdLabel = new JLabel("�����ţ�");
		receiverLabel = new JLabel("�ռ��ˣ�");
		phoneLabel = new JLabel("��ϵ��ʽ��");
		addressLabel = new JLabel("��ַ��");
		orderIdText = new JTextField(10);
		receiverText = new JTextField(10);
		phoneText = new JTextField(10);
		addressText = new JTextField(10);
		showButton = new JButton("���ݻ���");
		modifyButton = new JButton("�޸�");
		resetButton = new JButton("���");
		
		JLabel[] labels = {orderIdLabel,receiverLabel,phoneLabel,addressLabel};
		JTextField[] texts = {orderIdText,receiverText,phoneText,addressText};
		for (int i = 0; i < labels.length; i++) {
			gbc.setGridXY(0, i);
			gridBagLayout.setConstraints(labels[i], gbc);
			this.add(labels[i]);
			gbc.setGridXY(1, i);
			gridBagLayout.setConstraints(texts[i], gbc);
			this.add(texts[i]);
		}
		gbc.setGridXY(0, labels.length);
		gridBagLayout.setConstraints(showButton, gbc);
		this.add(showButton);
		gbc.setGridXY(1, labels.length);
		gridBagLayout.setConstraints(modifyButton, gbc);
		this.add(modifyButton);
		gbc.setGridXY(2, labels.length);
		gridBagLayout.setConstraints(resetButton, gbc);
		this.add(resetButton);
		showButton.addActionListener(this);
		modifyButton.addActionListener(this);
		resetButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		JButton button = (JButton) source;
		OrderService orderService = new OrderServiceImpl();
		if (showButton.equals(button)) {	// ���ݻ���
			String orderId = orderIdText.getText();
			if ("".equals(orderId)) {
				JOptionPane.showMessageDialog(this, "�����붩���ţ�", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/warn-icon.png"));
				return;
			}
			Order order = orderService.findOrderById(orderId);
			if (order!=null) {
				receiverText.setText(order.getReceiver());
				phoneText.setText(order.getPhone());
				addressText.setText(order.getAddress());
			}else {
				JOptionPane.showMessageDialog(this, "���޴˶����������ԣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
			}
		}else if (modifyButton.equals(button)){		// �޸�
			String orderId = orderIdText.getText();
			String receiver = receiverText.getText();
			String phone = phoneText.getText();
			String address= addressText.getText();
			if (!"".equals(receiver) && !"".equals(phone) && !"".equals(address)) {
				int result = orderService.modifyOrder(orderId, receiver, phone, address);
				if (result > 0) {
					JOptionPane.showMessageDialog(this, "�޸ĳɹ���", "�����ɹ�", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
					orderIdText.setText("");
					receiverText.setText("");
					phoneText.setText("");
					addressText.setText("");
				}else {
					JOptionPane.showMessageDialog(this, "�޸�ʧ�ܣ������ԣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
				}
			}else {
				JOptionPane.showMessageDialog(this, "����д������Ϣ��", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
			}
		}else {		// �������
			orderIdText.setText("");
			receiverText.setText("");
			phoneText.setText("");
			addressText.setText("");
		}
	}

}
