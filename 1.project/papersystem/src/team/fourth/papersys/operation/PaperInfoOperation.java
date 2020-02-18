package team.fourth.papersys.operation;

import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import team.fourth.papersys.listener.PaperTableListener;
import team.fourth.papersys.pojo.Newspaper;
import team.fourth.papersys.service.PaperService;
import team.fourth.papersys.service.PaperServiceImpl;
import team.fourth.papersys.util.InfoTableModel;
import team.fourth.papersys.util.PaperGlobalObject;

public class PaperInfoOperation extends AbstractInfoOperation {
	private final String[] columnHeader = 	{"�������", "������", "�������", "������", "����", "����", "��������", "�����", "ͼƬ��ַ"};// ��ͷ;
	private PaperService paperService = new PaperServiceImpl();
	@Override
	public JTable initInfo(int pageSize, int currentPage) {
		List<Newspaper>papers = paperService.findPapers(pageSize, currentPage, null, null);
		Vector<Vector<String>> info = transListToTwoDimension(papers);
		int count = paperService.countPapers(null, null);
		int totalPage = (int) Math.ceil((count*1.0/pageSize));
		if(totalPage==0) {
			PaperGlobalObject.setTotalPage(1);
		}else {
			PaperGlobalObject.setTotalPage(totalPage);
		}
		PaperGlobalObject.setTotalPage(totalPage);
		PaperGlobalObject.setCount(count);
		InfoTableModel tableModel = new InfoTableModel(columnHeader, info);
		JTable table = new JTable(tableModel);
		tableModel.setTableStyle(table);	// ���ñ����ʽ
		return table;
	}

	@Override
	public void reloadInfo(int pageSize, int currentPage, String... parames) {
		String paperName = parames[0];
		String publisher = parames[1];
		List<Newspaper> papers = paperService.findPapers(pageSize, currentPage, paperName, publisher);
		Vector<Vector<String>> info = transListToTwoDimension(papers);
		int count = paperService.countPapers(paperName, publisher);
		int totalPage = (int) Math.ceil((count*1.0/pageSize));
		if(totalPage==0) {
			PaperGlobalObject.setTotalPage(1);
		}else {
			PaperGlobalObject.setTotalPage(totalPage);
		}
		PaperGlobalObject.setCount(count);
		InfoTableModel tableModel = new InfoTableModel(columnHeader, info);
		JTable table = new JTable(tableModel);
		tableModel.setTableStyle(table);	// ���ñ����ʽ
		// �������ñ����ͼ
		PaperGlobalObject.setjTable(table);
		// Ϊ������������¼�
		table.addMouseListener(new PaperTableListener());
		PaperGlobalObject.getjScrollPane().setViewportView(table);
	}

	// ���б�ת��Ϊ��ά���� 
	private Vector<Vector<String>> transListToTwoDimension(List<Newspaper>papers) {
		Vector<Vector<String>>info = new Vector<Vector<String>>();
		for (Newspaper paper : papers) {
			Vector<String>line = new Vector<String>();
			line.add(paper.getPaperId());
			line.add(paper.getPaperName());
			line.add(paper.getCategory());
			line.add(paper.getPublisher());
			line.add(String.valueOf(paper.getPrice()));
			line.add(String.valueOf(paper.getPublishNumber()));
			line.add(paper.getPublishDate());
			line.add(String.valueOf(paper.getStorageNum()));
			line.add(paper.getPaperImg());
			info.add(line);
		}
		return info;
	}

	@Override
	// ���¼��ر�ǩ����
	public void reloadLabelData(JPanel southPane) {
		JLabel countDynamicLabel = (JLabel) southPane.getComponent(1);
		JLabel currDynamicLabel = (JLabel) southPane.getComponent(3);
		JLabel totalDynamicLabel = (JLabel) southPane.getComponent(5);
		countDynamicLabel.setText(String.valueOf(PaperGlobalObject.getCount()));
		currDynamicLabel.setText(String.valueOf(PaperGlobalObject.getCurrentPage()));
		totalDynamicLabel.setText(String.valueOf(PaperGlobalObject.getTotalPage()));
	}
	
}
