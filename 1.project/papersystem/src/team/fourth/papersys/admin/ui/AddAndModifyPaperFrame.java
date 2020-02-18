package team.fourth.papersys.admin.ui;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.commons.lang.StringUtils;
import team.fourth.papersys.pojo.Newspaper;
import team.fourth.papersys.service.PaperService;
import team.fourth.papersys.service.PaperServiceImpl;
import team.fourth.papersys.util.GBC;
import team.fourth.papersys.util.RandomIdFactory;

public class AddAndModifyPaperFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel pane;
	private GridBagLayout gridBagLayout;
	private GBC gbc;
	private JLabel idLabel;
	private JLabel[] labels;
	private JTextField pNameText;
	private JTextField publisherText;
	private JTextField priceText;
	private JTextField dateText;
	private JTextField publishNumberText;
	private JTextField storageText;
	private JTextField fileText;
	private JComboBox<String>categorys;
	private JButton openFileButton;
	private JButton addButton;
	private JButton exitButton;
	
	public AddAndModifyPaperFrame() {
		this("添加", "取消");
	}
	
	public AddAndModifyPaperFrame(String firstName, String secondName) {
		pane = new JPanel();
		gridBagLayout = new GridBagLayout();
		gbc = new GBC();
		idLabel = new JLabel();
		String[] labelsName = new String[] {"报刊名", "报刊类别", "出版社", "定价", "出版日期", "刊期", "预存量", "报刊图片"};
		String[] items = new String[] {"党报党刊", "全国性报刊", "晚报", "都市报", "行业报", "国际军事", "财经商业", "科学技术",
				"文化艺术", "生活休闲", "医学保健", "教育传媒", "时尚娱乐", "其他"};
		labels = new JLabel[labelsName.length];
		for (int i = 0; i < labelsName.length; i++) {
			labels[i] = new JLabel(labelsName[i]+"：");
		}
		pNameText = new JTextField(15);
		publisherText = new JTextField(15);
		priceText = new JTextField(15);
		dateText = new JTextField(15);
		publishNumberText = new JTextField(15);
		storageText = new JTextField(15);
		categorys = new JComboBox<String>(items);
		fileText = new JTextField(15);
		addButton = new JButton(firstName);
		openFileButton = new JButton("浏览");
		exitButton = new JButton(secondName);
		init();
	}
	
	public void init() {
		pane.setLayout(gridBagLayout);
		pane.setFont(new Font("宋体", Font.ITALIC, 14));
		gbc.setAnchor(GridBagConstraints.CENTER)
			.setFill(GridBagConstraints.NONE)
			.setInsets(10);
		for (int i = 0; i < labels.length; i++) {
			gbc.setGridXY(0, i);
			gridBagLayout.setConstraints(labels[i], gbc);
			pane.add(labels[i]);
		}
		gbc.setGridXY(1, 0);
		gridBagLayout.setConstraints(pNameText, gbc);
		pane.add(pNameText);
		
		gbc.setGridXY(1, 1);
		gridBagLayout.setConstraints(categorys, gbc);
		pane.add(categorys);
		
		gbc.setGridXY(1, 2);
		gridBagLayout.setConstraints(publisherText, gbc);
		pane.add(publisherText);
		
		gbc.setGridXY(1, 3);
		gridBagLayout.setConstraints(priceText, gbc);
		pane.add(priceText);
		
		gbc.setGridXY(1, 4);
		gridBagLayout.setConstraints(dateText, gbc);
		pane.add(dateText);
		
		gbc.setGridXY(1, 5);
		gridBagLayout.setConstraints(publishNumberText, gbc);
		pane.add(publishNumberText);
		
		gbc.setGridXY(1, 6);
		gridBagLayout.setConstraints(storageText, gbc);
		pane.add(storageText);
		
		gbc.setGridXY(1, 7);
		gridBagLayout.setConstraints(fileText, gbc);
		pane.add(fileText);
		fileText.setEditable(false);
		
		gbc.setGridXY(2, 7);
		gridBagLayout.setConstraints(openFileButton, gbc);
		pane.add(openFileButton);
		openFileButton.addActionListener(this);
	
		gbc.setGridXY(0, 8).setAnchor(GridBagConstraints.CENTER);
		gridBagLayout.setConstraints(addButton, gbc);
		pane.add(addButton);
		addButton.addActionListener(this);
		
		gbc.setGridXY(1, 8).setAnchor(GridBagConstraints.EAST);
		gridBagLayout.setConstraints(exitButton, gbc);
		pane.add(exitButton);
		exitButton.addActionListener(this);
		
		this.getContentPane().add(pane);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		String text = button.getText();
		if (button.equals(exitButton)) {
			this.dispose();
			return;
		}
		PaperService paperService = new PaperServiceImpl();
		Newspaper paper = new Newspaper();
		paper.setPaperId(RandomIdFactory.getRandomId());
		paper.setPaperName(pNameText.getText());
		paper.setCategory((String) categorys.getSelectedItem());
		paper.setPublisher(publisherText.getText());
		paper.setPublishDate(dateText.getText());
		if (!StringUtils.isEmpty(priceText.getText())) {
			paper.setPrice(Double.parseDouble(priceText.getText()));
		}
		paper.setPublishNumber(publishNumberText.getText());
		if (!StringUtils.isEmpty(storageText.getText())) {
			paper.setStorageNum(Integer.parseInt(storageText.getText()));
		}
		paper.setPaperImg(fileText.getText());
		
		if ("添加".equals(text)) {
			int res = paperService.addPaper(paper);
			if (res > 0) {
				JOptionPane.showMessageDialog(this, "添加成功!", "操作成功", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "添加失败，请重试!", "操作失败", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
			}
		}else if ("修改".equals(text)){
			String paperId = idLabel.getText();
			int res = paperService.modifyPaper(paperId,paper);
			if (res > 0) {
				JOptionPane.showMessageDialog(this, "修改成功!", "操作成功", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "修改失败，请重试!", "操作失败", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
			}
		}else if (openFileButton.equals(button)){
			FileDialog fileDialog = new FileDialog(this, "上传图片", FileDialog.LOAD);
			fileDialog.setVisible(true);
			String path = fileDialog.getDirectory();
			String fileName = fileDialog.getFile();
			fileText.setText(path+fileName);
		}else {
			this.dispose();
		}
	}

	public JLabel getIdLabel() {
		return idLabel;
	}

	public JTextField getpNameText() {
		return pNameText;
	}

	public JTextField getPublisherText() {
		return publisherText;
	}

	public JTextField getPriceText() {
		return priceText;
	}

	public JTextField getDateText() {
		return dateText;
	}

	public JTextField getPublishNumberText() {
		return publishNumberText;
	}

	public JTextField getStorageText() {
		return storageText;
	}

	public JTextField getFileText() {
		return fileText;
	}

	public JComboBox<String> getCategorys() {
		return categorys;
	}

}
