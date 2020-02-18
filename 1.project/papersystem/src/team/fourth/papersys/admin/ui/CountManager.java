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
	private String[] columnHeader = {"�������", "������", "�������", "���۽��", "��������"};	//��ͷ
	private JPanel northPane;	// �������
	private JScrollPane centerPane;	//�в����
	private JTable table;
	private JButton countButton;
	private JButton exportButton;

	public CountManager() {
		northPane = new JPanel();
		centerPane = new JScrollPane();
		table = new JTable();
		countButton = new JButton("��������ͳ��"); 
		exportButton = new JButton("����excel����",new ImageIcon("img/excel-icon.png")); 
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
		if (countButton.equals(button)) {	// �ó�ͳ�ƽ��
			InfoTableModel tableModel = new InfoTableModel(columnHeader, info);
			table = new JTable(tableModel);
			tableModel.setTableStyle(table);
			centerPane.setViewportView(table);
			this.add(centerPane, BorderLayout.CENTER);	
		}else {		// ����excel�������
			if (list.size()==0) {
				JOptionPane.showMessageDialog(this, "�����ݿɵ���");
			}else {
				Frame frame = JOptionPane.getFrameForComponent(this);
				FileDialog fileDialog = new FileDialog(frame, "����excel�ļ�", FileDialog.SAVE);
				fileDialog.setVisible(true);
				String directory = fileDialog.getDirectory();
				String fileName = fileDialog.getFile();
				if (directory!=null && fileName!=null) {
					String path = directory+fileName;
					boolean result = POIUtil.exportSaleData(list, "����������Ϣ��", columnHeader, path);
					if (result) {
						JOptionPane.showMessageDialog(this, "�����ɹ���", "�����ɹ�", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
					}else {
						JOptionPane.showMessageDialog(this, "����ʧ�ܣ������ԣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
					}
				}
				
			}
		}
	}

	// ���б�ת��Ϊ��ά���� 
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
