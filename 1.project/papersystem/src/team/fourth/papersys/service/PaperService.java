package team.fourth.papersys.service;

import java.util.List;
import team.fourth.papersys.pojo.CountBean;
import team.fourth.papersys.pojo.Newspaper;

public interface PaperService {

	List<Newspaper> findPapers(int pageSize, int currentPage, String paperName, String publisher);

	int countPapers(String paperName, String publisher);

	int addPaper(Newspaper paper);

	int removePaperById(String[] ids);

	Newspaper findPaperById(String paperId);

	int modifyPaper(String paperId, Newspaper paper);

	boolean exportExcelData(String paperName, String publisher, String path);

	int importPapers(List<Newspaper> papers);

	List<CountBean> findPaperSale();

}
