package team.fourth.papersys.operation;

import javax.swing.JPanel;
import javax.swing.JTable;

public abstract class AbstractInfoOperation {
	public abstract JTable initInfo(int pageSize, int currentPage);
	public abstract void reloadInfo(int pageSize,int currentPage, String...parames);
	public abstract void reloadLabelData(JPanel southPane);
}
