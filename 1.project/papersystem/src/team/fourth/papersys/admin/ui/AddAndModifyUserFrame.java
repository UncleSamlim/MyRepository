package team.fourth.papersys.admin.ui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import team.fourth.papersys.pojo.User;
import team.fourth.papersys.service.UserService;
import team.fourth.papersys.service.UserServiceImpl;
import team.fourth.papersys.util.FontStyleUtil;
import team.fourth.papersys.util.GBC;
import team.fourth.papersys.util.RandomIdFactory;

public class AddAndModifyUserFrame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel pane;
	private GridBagLayout gridBagLayout;
	private GBC gbc;
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel pswdLabel;
	private JLabel phoneLabel;
	private JLabel genderLabel;
	private JLabel ageLabel;
	private JLabel jobLabel;
	private JLabel emailLabel;
	private JTextField nameText;
	private JPasswordField pswdText;
	private JTextField phoneText;
	private JTextField ageText;
	private JTextField jobText;
	private JTextField emailText;
	private JRadioButton female;
	private JRadioButton male;
	private JButton addButton;
	private JButton exitButton;
	
	public AddAndModifyUserFrame() {
		this("���", "ȡ��");
	}

	public AddAndModifyUserFrame(String firstName, String secondName) {
		gridBagLayout = new GridBagLayout();
		idLabel = new JLabel();
		nameLabel = new JLabel("�û���:");
		pswdLabel = new JLabel("����:");
		phoneLabel = new JLabel("�ֻ���:");
		genderLabel = new JLabel("�Ա�:");
		ageLabel = new JLabel("����:");
		jobLabel = new JLabel("ְҵ:");
		emailLabel = new JLabel("����:");
		nameText = new JTextField(20);
		pswdText = new JPasswordField(20);
		phoneText = new JTextField(20);
		ageText = new JTextField(20);
		jobText = new JTextField(20);
		emailText = new JTextField(20);
		female = new JRadioButton("Ů");
		male = new JRadioButton("��");
		addButton = new JButton(firstName);
		exitButton = new JButton(secondName);
		gbc = new GBC(0, 0, 1, 1);
		init();
	}
	
	public void init() {
		pane = new JPanel();
		pane.setLayout(gridBagLayout);
		pane.setFont(new Font("����", Font.ITALIC, 14));
		// ��ʼ�����ֲ��������ж��룬�����µ��������С��������������ӱ߿�֮��ľ��룬��������	
		gbc.setAnchor(GridBagConstraints.CENTER)
			.setFill(GridBagConstraints.NONE)
			.setInsets(10);
		gridBagLayout.setConstraints(nameLabel, gbc);
		pane.add(nameLabel);
		gbc.setGridXY(1, 0);
		gridBagLayout.setConstraints(nameText, gbc);
		pane.add(nameText);
		
		gbc.setGridXY(0, 1);
		gridBagLayout.setConstraints(pswdLabel, gbc);
		pane.add(pswdLabel);
		gbc.setGridXY(1, 1);
		gridBagLayout.setConstraints(pswdText, gbc);
		pane.add(pswdText);
		
		gbc.setGridXY(0, 2);
		gridBagLayout.setConstraints(phoneLabel, gbc);
		pane.add(phoneLabel);
		gbc.setGridXY(1, 2);
		gridBagLayout.setConstraints(phoneText, gbc);
		pane.add(phoneText);
		
		gbc.setGridXY(0, 3);
		gridBagLayout.setConstraints(genderLabel, gbc);
		pane.add(genderLabel);
		gbc.setGridXY(1, 3);
		gridBagLayout.setConstraints(female, gbc);
		pane.add(female);
		gbc.setGridXY(2, 3);
		gridBagLayout.setConstraints(male, gbc);
		pane.add(male);
		ButtonGroup group = new ButtonGroup();
		group.add(female);
		group.add(male);
		
		gbc.setGridXY(0, 4);
		gridBagLayout.setConstraints(ageLabel, gbc);
		pane.add(ageLabel);
		gbc.setGridXY(1, 4);
		gridBagLayout.setConstraints(ageText, gbc);
		pane.add(ageText);
		
		gbc.setGridXY(0, 5);
		gridBagLayout.setConstraints(jobLabel, gbc);
		pane.add(jobLabel);
		gbc.setGridXY(1, 5);
		gridBagLayout.setConstraints(jobText, gbc);
		pane.add(jobText);
		
		gbc.setGridXY(0, 6);
		gridBagLayout.setConstraints(emailLabel, gbc);
		pane.add(emailLabel);
		gbc.setGridXY(1, 6);
		gridBagLayout.setConstraints(emailText, gbc);
		pane.add(emailText);
		
		// ��Ӱ�ť
		gbc.setGridXY(0, 7);
		gridBagLayout.setConstraints(addButton, gbc);
		pane.add(addButton);
		addButton.addActionListener(this);
		gbc.setGridXY(1, 7).setAnchor(GBC.EAST);	// �Ҷ���
		gridBagLayout.setConstraints(exitButton, gbc);
		pane.add(exitButton);
		exitButton.addActionListener(this);
		Font font = new Font("����", Font.ITALIC, 16);
		FontStyleUtil.setFontStyle(pane, font);
		
		this.getContentPane().add(pane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button.equals(exitButton)) {
			this.dispose();
			return;
		}
		String text = button.getText();
		UserService us = new UserServiceImpl();
		User user = new User();
		user.setUserId(RandomIdFactory.getRandomId());
		user.setUsername(nameText.getText());
		user.setPassword(String.valueOf(pswdText.getPassword()));
		user.setPhone(phoneText.getText());
		if (ageText.getText()!=null) {
			user.setAge(Integer.parseInt(ageText.getText()));
		}
		user.setJob(jobText.getText());
		user.setEmail(emailText.getText());
		if (female.isSelected()) {
			user.setGender(female.getText());
		}else {
			user.setGender(male.getText());
		}
		if ("���".equals(text)) {
			// ��֤�û�������Ϊ��
			if ("".equals(user.getUsername().trim())) {
				JOptionPane.showMessageDialog(this, "�û�������Ϊ�գ�", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/warn-icon.png"));
				return;
			}
			// ��֤11��λ�ֻ��ţ�����1��ͷ
			if (!user.getPhone().matches("1[0-9]{10}")) {
				JOptionPane.showMessageDialog(this, "������11λ�ֻ����룡", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/warn-icon.png"));
				return;
			}
			int res = us.addUser(user);
			if (res > 0) {
				JOptionPane.showMessageDialog(this, "��ӳɹ�!", "�����ɹ�", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "���ʧ�ܣ�������!", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
			}
		}else if ("�޸�".equals(text)){
			String userId = idLabel.getText();
			int res = us.modifyUser(userId,user);
			if (res > 0) {
				JOptionPane.showMessageDialog(this, "�޸ĳɹ�!", "�����ɹ�", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "�޸�ʧ�ܣ�������!", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
			}
		}
	}	
	
	public JTextField getNameText() {
		return nameText;
	}

	public JPasswordField getPswdText() {
		return pswdText;
	}

	public JTextField getPhoneText() {
		return phoneText;
	}

	public JTextField getAgeText() {
		return ageText;
	}

	public JTextField getJobText() {
		return jobText;
	}

	public JTextField getEmailText() {
		return emailText;
	}

	public JRadioButton getFemale() {
		return female;
	}

	public JRadioButton getMale() {
		return male;
	}
	
	public JLabel getIdLabel() {
		return idLabel;
	}

	public JPanel getPane() {
		return pane;
	}

}
