package team.fourth.papersys.service;

import java.util.List;
import team.fourth.papersys.dao.PaperDao;
import team.fourth.papersys.dao.PaperDaoImpl;
import team.fourth.papersys.pojo.CountBean;
import team.fourth.papersys.pojo.Newspaper;
import team.fourth.papersys.util.POIUtil;

public class PaperServiceImpl implements PaperService {
	private PaperDao paperDao = new PaperDaoImpl();

	@Override
	public List<Newspaper> findPapers(int pageSize, int currentPage, String paperName, String publisher) {
		return paperDao.selectPapers(pageSize, currentPage, paperName, publisher);
	}

	@Override
	public int countPapers(String paperName, String publisher) {
		return paperDao.countPapers(paperName, publisher);
	}

	@Override
	public int addPaper(Newspaper paper) {
		return paperDao.insertPaper(paper);
	}

	@Override
	public int removePaperById(String[] ids) {
		return paperDao.deletePaperById(ids);
	}

	@Override
	public Newspaper findPaperById(String paperId) {
		return paperDao.selectPaperById(paperId);
	}

	@Override
	public int modifyPaper(String paperId, Newspaper paper) {
		return paperDao.updatePaper(paperId, paper);
	}

	@Override
	public boolean exportExcelData(String paperName, String publisher, String path) {
		List<Newspaper>papers = paperDao.selectPapersByNameAndPub(paperName, publisher);
		String themeName = "报刊信息总览表";
		String[] headNames = {"报刊编号","报刊名","报刊类别","出版社","报刊定价", "刊期", "出版日期",  "报刊库存量"};
		return POIUtil.exportData(papers, themeName, headNames , path);
	}

	@Override
	public int importPapers(List<Newspaper> papers) {
		return paperDao.insertPapers(papers);
	}

	@Override
	public List<CountBean> findPaperSale() {
		return paperDao.selectPaperSale();
	}	
		
}
