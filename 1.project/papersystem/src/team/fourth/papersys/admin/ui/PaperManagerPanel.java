package team.fourth.papersys.admin.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import team.fourth.papersys.listener.PaperTableListener;
import team.fourth.papersys.operation.AbstractInfoOperation;
import team.fourth.papersys.operation.PaperInfoOperation;
import team.fourth.papersys.pojo.Newspaper;
import team.fourth.papersys.service.PaperService;
import team.fourth.papersys.service.PaperServiceImpl;
import team.fourth.papersys.util.JFrameUtil;
import team.fourth.papersys.util.POIUtil;
import team.fourth.papersys.util.PaperGlobalObject;

public class PaperManagerPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel northPane;	// �������
	private JPanel southPane;	// �ϲ����
	private JScrollPane centerPane;	//�в����
	private AbstractInfoOperation infoOperation = new PaperInfoOperation();
	
	public PaperManagerPanel() {}
	
	public PaperManagerPanel(int pageSize, int currentPage) {
		PaperGlobalObject.setPageSize(pageSize);
		PaperGlobalObject.setCurrentPage(currentPage);
		northPane = new JPanel();
		southPane = new JPanel();
		centerPane = new JScrollPane();
		init();
	}

	public void init() {
		this.setLayout(new BorderLayout());
		createNorthPane();
		createCenterPane();
		createSouthPane();
	}

	private void createCenterPane() {
		JTable paperTable = infoOperation.initInfo(PaperGlobalObject.getPageSize(), PaperGlobalObject.getCurrentPage());
		centerPane.setViewportView(paperTable);
		this.add(centerPane, BorderLayout.CENTER);
		// Ϊ������������¼�
		PaperGlobalObject.setjTable(paperTable);
		paperTable.addMouseListener(new PaperTableListener());
		PaperGlobalObject.setjScrollPane(centerPane);
	}

	private void createNorthPane() {
		// ������ǩ������������ʽ
		JLabel paperNameLabel = new JLabel("��������");
		JLabel publisherLabel = new JLabel("������ ��");
		Font font = new Font("����", Font.ITALIC, 14);
		paperNameLabel.setFont(font);
		publisherLabel.setFont(font);
		// ������ѯ�����ı���Ͳ�ѯ��ť
		JTextField paperNameField = new JTextField();
		JTextField publisherField = new JTextField();
		JButton searchButton = new JButton("��ѯ", new ImageIcon("img/search-icon.png"));
		JButton addButton = new JButton("���", new ImageIcon("img/add-icon.png"));
		ImageIcon icon = new ImageIcon("img/excel-icon.png");
		JButton importButton = new JButton("����excel����", icon);
		JButton exportButton = new JButton("����excel����", icon);
		paperNameField.setColumns(12);
		publisherField.setColumns(12);
		
		// ���������������ӵ������
		northPane.add(paperNameLabel);
		northPane.add(paperNameField);
		northPane.add(publisherLabel);
		northPane.add(publisherField);
		northPane.add(searchButton);
		northPane.add(addButton);
		northPane.add(importButton);
		northPane.add(exportButton);
		//����������ڵ�λ��
		this.add(northPane, BorderLayout.NORTH);
		// Ϊ��Ӱ�ť��ӵ���¼�
		addButton.addActionListener(event -> {
			JFrame frame = new AddAndModifyPaperFrame();
			frame.setTitle("��ӱ���");
			JFrameUtil.init(frame, 700, 600, JFrame.DISPOSE_ON_CLOSE);
		});
		
		// Ϊ��ѯ��ť��ӵ���¼�
		searchButton.addActionListener(event -> {
			String paperName = paperNameField.getText();
			String publisher = publisherField.getText();
			// ����ѯ��������Ϊȫ�ֱ���
			PaperGlobalObject.setPaperName(paperName);
			PaperGlobalObject.setPublisher(publisher);
			// ������������
			paperNameField.setText("");
			publisherField.setText("");
			// �����ѯĬ����ʾ�ص�һҳ
			PaperGlobalObject.setCurrentPage(1);
			infoOperation.reloadInfo(PaperGlobalObject.getPageSize(), PaperGlobalObject.getCurrentPage(), paperName, publisher);
			// ���¼��ر������
			infoOperation.reloadLabelData(southPane);	
		});
		
		// Ϊ������ť��ӵ���¼�
		exportButton.addActionListener(event -> {
			Frame frame = JOptionPane.getFrameForComponent(this);
			FileDialog fileDialog = new FileDialog(frame, "����excel�ļ�", FileDialog.SAVE);
			fileDialog.setVisible(true);
			String directory = fileDialog.getDirectory();
			String fileName = fileDialog.getFile();
			if (directory!=null && fileName!=null) {
				String path = directory+fileName;
				String paperName = PaperGlobalObject.getPaperName();
				String publisher = PaperGlobalObject.getPublisher();
				PaperService paperService = new PaperServiceImpl();
				boolean result = paperService.exportExcelData(paperName, publisher, path);
				if (result) {
					JOptionPane.showMessageDialog(this, "�����ɹ���", "�����ɹ�", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
				}else {
					JOptionPane.showMessageDialog(this, "����ʧ�ܣ������ԣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
				}
			}
		});
		
		// Ϊ�������ݰ�ť��ӵ���¼�
		importButton.addActionListener(event -> {
			Frame frame = JOptionPane.getFrameForComponent(this);
			FileDialog fileDialog = new FileDialog(frame, "��excel�ļ�", FileDialog.LOAD);
			fileDialog.setVisible(true);
			String directory = fileDialog.getDirectory();
			String fileName = fileDialog.getFile();
			if (directory!=null && fileName!=null) {
				String path = directory+fileName;
				List<Newspaper> papers = POIUtil.importData(path);
				PaperService paperService = new PaperServiceImpl();
				int res = paperService.importPapers(papers);
				if (res==papers.size()) {
					JOptionPane.showMessageDialog(this, "����ɹ�����ˢ���б�鿴��", "�����ɹ�", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
				}else {
					JOptionPane.showMessageDialog(this, "����ʧ�ܣ������ԣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
				}
			}
		});
	}

	private void createSouthPane() {
		// ���徲̬��ǩ�Ͷ�̬��ǩ
		JLabel countStaticLabel = new JLabel();	// �ܼ�¼��
		JLabel currStaticLabel = new JLabel();	// ��ǰҳ��
		JLabel totalStaticLabel = new JLabel();	// ��ǰҳ��
		JLabel countDynamicLabel = new JLabel(String.valueOf(PaperGlobalObject.getCount()));
		JLabel currDynamicLabel = new JLabel(String.valueOf(PaperGlobalObject.getCurrentPage()));
		JLabel totalDynamicLabel = new JLabel(String.valueOf(PaperGlobalObject.getTotalPage()));
		countStaticLabel.setText("�ܼ�¼����");
		currStaticLabel.setText("��ǰҳ����");
		totalStaticLabel.setText("��ҳ����");
		// ���尴ť
		JButton first = new JButton("��ҳ");// ��ҳ
		JButton last = new JButton("βҳ");// βҳ
		JButton previous = new JButton("��һҳ");// ��һҳ
		JButton next = new JButton("��һҳ");// ��һҳ
		// Ϊ��ť��ӵ���¼�
		first.addActionListener(this);
		last.addActionListener(this);
		previous.addActionListener(this);
		next.addActionListener(this);
		// ���������������ӵ������
		southPane.add(countStaticLabel);
		southPane.add(countDynamicLabel);
		southPane.add(currStaticLabel);
		southPane.add(currDynamicLabel);
		southPane.add(totalStaticLabel);
		southPane.add(totalDynamicLabel);
		southPane.add(first);
		southPane.add(previous);
		southPane.add(next);
		southPane.add(last);
		// Ϊ�����������������ʽ
		Component[] components = southPane.getComponents();
		for (Component component : components) {
			component.setFont(new Font("����", Font.ITALIC, 14));
		}
		this.add(southPane,BorderLayout.SOUTH);
	}
	
	// �����ϲ����İ�ť
	@Override
	public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			// ������ȡ��
			String paperName = PaperGlobalObject.getPaperName();
			String publisher = PaperGlobalObject.getPublisher();
			int pageSize = PaperGlobalObject.getPageSize();
			int currentPage = PaperGlobalObject.getCurrentPage();
			int totalPage = PaperGlobalObject.getTotalPage();
			
			if(source instanceof JButton) {
				JButton button = (JButton) source;
				String text = button.getText();
				if("��ҳ".equals(text)) {
					if(currentPage==1) {
						JOptionPane.showMessageDialog(this, "��ǰ������ҳ�ˣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					}
					currentPage = 1;
					// ���¼��ر������
					infoOperation.reloadInfo(pageSize, currentPage, paperName, publisher);
					// �ı䵱ǰҳ����
					PaperGlobalObject.setCurrentPage(currentPage);
					// ���¼��ض�̬��ǩ����
					infoOperation.reloadLabelData(southPane);
				}else if ("��һҳ".equals(text)){
					currentPage = currentPage - 1;
					if(currentPage<=0) {
						JOptionPane.showMessageDialog(this, "�Ѿ�����ҳ�ˣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					}
					infoOperation.reloadInfo(pageSize, currentPage, paperName, publisher);
					PaperGlobalObject.setCurrentPage(currentPage);
					infoOperation.reloadLabelData(southPane);
				}else if ("��һҳ".equals(text)){
					currentPage = currentPage + 1;
					if(currentPage>totalPage) {
						JOptionPane.showMessageDialog(this, "�Ѿ������һҳ�ˣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					}
					infoOperation.reloadInfo(pageSize, currentPage, paperName, publisher);
					PaperGlobalObject.setCurrentPage(currentPage);
					infoOperation.reloadLabelData(southPane);
				}else {		// βҳ
					if(currentPage==totalPage) {
						JOptionPane.showMessageDialog(this, "��ǰ�������һҳ�ˣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					}
					currentPage = totalPage;
					infoOperation.reloadInfo(pageSize, currentPage, paperName, publisher);
					PaperGlobalObject.setCurrentPage(currentPage);
					infoOperation.reloadLabelData(southPane);
				}
			}
	}
	
}
