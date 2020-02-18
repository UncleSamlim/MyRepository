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
	private JPanel northPane;	// 北部面板
	private JPanel southPane;	// 南部面板
	private JScrollPane centerPane;	//中部面板
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
		// 为表格添加鼠标点击事件
		PaperGlobalObject.setjTable(paperTable);
		paperTable.addMouseListener(new PaperTableListener());
		PaperGlobalObject.setjScrollPane(centerPane);
	}

	private void createNorthPane() {
		// 创建标签并设置字体样式
		JLabel paperNameLabel = new JLabel("报刊名：");
		JLabel publisherLabel = new JLabel("出版社 ：");
		Font font = new Font("宋体", Font.ITALIC, 14);
		paperNameLabel.setFont(font);
		publisherLabel.setFont(font);
		// 创建查询输入文本框和查询按钮
		JTextField paperNameField = new JTextField();
		JTextField publisherField = new JTextField();
		JButton searchButton = new JButton("查询", new ImageIcon("img/search-icon.png"));
		JButton addButton = new JButton("添加", new ImageIcon("img/add-icon.png"));
		ImageIcon icon = new ImageIcon("img/excel-icon.png");
		JButton importButton = new JButton("导入excel数据", icon);
		JButton exportButton = new JButton("导出excel数据", icon);
		paperNameField.setColumns(12);
		publisherField.setColumns(12);
		
		// 将以上组件按序添加到面板中
		northPane.add(paperNameLabel);
		northPane.add(paperNameField);
		northPane.add(publisherLabel);
		northPane.add(publisherField);
		northPane.add(searchButton);
		northPane.add(addButton);
		northPane.add(importButton);
		northPane.add(exportButton);
		//设置面板所在的位置
		this.add(northPane, BorderLayout.NORTH);
		// 为添加按钮添加点击事件
		addButton.addActionListener(event -> {
			JFrame frame = new AddAndModifyPaperFrame();
			frame.setTitle("添加报刊");
			JFrameUtil.init(frame, 700, 600, JFrame.DISPOSE_ON_CLOSE);
		});
		
		// 为查询按钮添加点击事件
		searchButton.addActionListener(event -> {
			String paperName = paperNameField.getText();
			String publisher = publisherField.getText();
			// 将查询条件设置为全局变量
			PaperGlobalObject.setPaperName(paperName);
			PaperGlobalObject.setPublisher(publisher);
			// 清空输入框内容
			paperNameField.setText("");
			publisherField.setText("");
			// 点击查询默认显示回第一页
			PaperGlobalObject.setCurrentPage(1);
			infoOperation.reloadInfo(PaperGlobalObject.getPageSize(), PaperGlobalObject.getCurrentPage(), paperName, publisher);
			// 重新加载表格数据
			infoOperation.reloadLabelData(southPane);	
		});
		
		// 为导出按钮添加点击事件
		exportButton.addActionListener(event -> {
			Frame frame = JOptionPane.getFrameForComponent(this);
			FileDialog fileDialog = new FileDialog(frame, "保存excel文件", FileDialog.SAVE);
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
					JOptionPane.showMessageDialog(this, "导出成功！", "操作成功", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
				}else {
					JOptionPane.showMessageDialog(this, "导出失败，请重试！", "操作失败", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
				}
			}
		});
		
		// 为导入数据按钮添加点击事件
		importButton.addActionListener(event -> {
			Frame frame = JOptionPane.getFrameForComponent(this);
			FileDialog fileDialog = new FileDialog(frame, "打开excel文件", FileDialog.LOAD);
			fileDialog.setVisible(true);
			String directory = fileDialog.getDirectory();
			String fileName = fileDialog.getFile();
			if (directory!=null && fileName!=null) {
				String path = directory+fileName;
				List<Newspaper> papers = POIUtil.importData(path);
				PaperService paperService = new PaperServiceImpl();
				int res = paperService.importPapers(papers);
				if (res==papers.size()) {
					JOptionPane.showMessageDialog(this, "导入成功，可刷新列表查看！", "操作成功", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
				}else {
					JOptionPane.showMessageDialog(this, "导入失败，请重试！", "操作失败", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
				}
			}
		});
	}

	private void createSouthPane() {
		// 定义静态标签和动态标签
		JLabel countStaticLabel = new JLabel();	// 总记录数
		JLabel currStaticLabel = new JLabel();	// 当前页数
		JLabel totalStaticLabel = new JLabel();	// 当前页数
		JLabel countDynamicLabel = new JLabel(String.valueOf(PaperGlobalObject.getCount()));
		JLabel currDynamicLabel = new JLabel(String.valueOf(PaperGlobalObject.getCurrentPage()));
		JLabel totalDynamicLabel = new JLabel(String.valueOf(PaperGlobalObject.getTotalPage()));
		countStaticLabel.setText("总记录数：");
		currStaticLabel.setText("当前页数：");
		totalStaticLabel.setText("总页数：");
		// 定义按钮
		JButton first = new JButton("首页");// 首页
		JButton last = new JButton("尾页");// 尾页
		JButton previous = new JButton("上一页");// 上一页
		JButton next = new JButton("下一页");// 下一页
		// 为按钮添加点击事件
		first.addActionListener(this);
		last.addActionListener(this);
		previous.addActionListener(this);
		next.addActionListener(this);
		// 将所有组件按序添加到面板中
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
		// 为面板的组件设置字体样式
		Component[] components = southPane.getComponents();
		for (Component component : components) {
			component.setFont(new Font("楷书", Font.ITALIC, 14));
		}
		this.add(southPane,BorderLayout.SOUTH);
	}
	
	// 监听南部面板的按钮
	@Override
	public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			// 将数据取出
			String paperName = PaperGlobalObject.getPaperName();
			String publisher = PaperGlobalObject.getPublisher();
			int pageSize = PaperGlobalObject.getPageSize();
			int currentPage = PaperGlobalObject.getCurrentPage();
			int totalPage = PaperGlobalObject.getTotalPage();
			
			if(source instanceof JButton) {
				JButton button = (JButton) source;
				String text = button.getText();
				if("首页".equals(text)) {
					if(currentPage==1) {
						JOptionPane.showMessageDialog(this, "当前已是首页了！", "操作失败", JOptionPane.ERROR_MESSAGE);
						return;
					}
					currentPage = 1;
					// 重新加载表格数据
					infoOperation.reloadInfo(pageSize, currentPage, paperName, publisher);
					// 改变当前页面数
					PaperGlobalObject.setCurrentPage(currentPage);
					// 重新加载动态标签数据
					infoOperation.reloadLabelData(southPane);
				}else if ("上一页".equals(text)){
					currentPage = currentPage - 1;
					if(currentPage<=0) {
						JOptionPane.showMessageDialog(this, "已经是首页了！", "操作失败", JOptionPane.ERROR_MESSAGE);
						return;
					}
					infoOperation.reloadInfo(pageSize, currentPage, paperName, publisher);
					PaperGlobalObject.setCurrentPage(currentPage);
					infoOperation.reloadLabelData(southPane);
				}else if ("下一页".equals(text)){
					currentPage = currentPage + 1;
					if(currentPage>totalPage) {
						JOptionPane.showMessageDialog(this, "已经是最后一页了！", "操作失败", JOptionPane.ERROR_MESSAGE);
						return;
					}
					infoOperation.reloadInfo(pageSize, currentPage, paperName, publisher);
					PaperGlobalObject.setCurrentPage(currentPage);
					infoOperation.reloadLabelData(southPane);
				}else {		// 尾页
					if(currentPage==totalPage) {
						JOptionPane.showMessageDialog(this, "当前已是最后一页了！", "操作失败", JOptionPane.ERROR_MESSAGE);
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
