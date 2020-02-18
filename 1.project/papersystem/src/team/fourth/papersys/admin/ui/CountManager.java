package team.fourth.papersys.admin.ui;
import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import team.fourth.papersys.pojo.CountBean;
import team.fourth.papersys.service.PaperService;
import team.fourth.papersys.service.PaperServiceImpl;
import team.fourth.papersys.util.InfoTableModel;
import team.fourth.papersys.util.POIUtil;

public class CountManager extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private String[] columnHeader = {"报刊编号", "报刊名", "报刊类别", "销售金额", "已售数量"};	//表头
	private JPanel northPane;	// 北部面板
	private JScrollPane centerPane;	//中部面板
	private JTable table;
	private JButton countButton;
	private JButton exportButton;

	public CountManager() {
		northPane = new JPanel();
		centerPane = new JScrollPane();
		table = new JTable();
		countButton = new JButton("报刊销售统计"); 
		exportButton = new JButton("生成excel报表",new ImageIcon("img/excel-icon.png")); 
		init();
	}

	private void init() {
		this.setLayout(new BorderLayout());
		createNorthPane();
		createCenterPane();
	}

	private void createCenterPane() {
		Vector<Vector<String>> info = new Vector<Vector<String>>();
		InfoTableModel tableModel = new InfoTableModel(columnHeader, info);
		table = new JTable(tableModel);
		tableModel.setTableStyle(table);
		centerPane.setViewportView(table);
		this.add(centerPane, BorderLayout.CENTER);
	}

	private void createNorthPane() {
		northPane.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.add(countButton);
		panel.add(exportButton);
		northPane.add(panel, BorderLayout.CENTER);
		this.add(northPane, BorderLayout.NORTH);
		countButton.addActionListener(this);
		exportButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		PaperService paperService = new PaperServiceImpl();
		List<CountBean> list = new ArrayList<CountBean>();
		list = paperService.findPaperSale();
		Vector<Vector<String>>info = new Vector<Vector<String>>();
		info = transListToTwoDimension(list);
		if (countButton.equals(button)) {	// 得出统计结果
			InfoTableModel tableModel = new InfoTableModel(columnHeader, info);
			table = new JTable(tableModel);
			tableModel.setTableStyle(table);
			centerPane.setViewportView(table);
			this.add(centerPane, BorderLayout.CENTER);	
		}else {		// 导出excel表格数据
			if (list.size()==0) {
				JOptionPane.showMessageDialog(this, "无数据可导出");
			}else {
				Frame frame = JOptionPane.getFrameForComponent(this);
				FileDialog fileDialog = new FileDialog(frame, "保存excel文件", FileDialog.SAVE);
				fileDialog.setVisible(true);
				String directory = fileDialog.getDirectory();
				String fileName = fileDialog.getFile();
				if (directory!=null && fileName!=null) {
					String path = directory+fileName;
					boolean result = POIUtil.exportSaleData(list, "报刊销售信息表", columnHeader, path);
					if (result) {
						JOptionPane.showMessageDialog(this, "导出成功！", "操作成功", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
					}else {
						JOptionPane.showMessageDialog(this, "导出失败，请重试！", "操作失败", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
					}
				}
				
			}
		}
	}

	// 将列表转换为二维向量 
	private Vector<Vector<String>> transListToTwoDimension(List<CountBean>list) {
		Vector<Vector<String>>info = new Vector<Vector<String>>();
		if (list==null) {
			return info;
		}
		for (CountBean cbean : list) {
			Vector<String>line = new Vector<String>();
			line.add(cbean.getPaperId());
			line.add(cbean.getPaperName());
			line.add(cbean.getCategory());
			line.add(String.valueOf(cbean.getSalePrice()));
			line.add(String.valueOf(cbean.getSaleNum()));
			info.add(line);
		}
		return info;
	}
}
