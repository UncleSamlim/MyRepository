package team.fourth.papersys.dao;

import java.util.List;
import team.fourth.papersys.pojo.CountBean;
import team.fourth.papersys.pojo.Newspaper;

public interface PaperDao {
	/**
	 * 根据条件查询所以报刊
	 * @param pageSize
	 * @param currentPage
	 * @param paperName
	 * @param publisher
	 * @return
	 */
	List<Newspaper> selectPapers(int pageSize, int currentPage, String paperName, String publisher);
	/**
	 * 根据条件统计报刊数 
	 * @param paperName
	 * @param publisher
	 * @return
	 */
	int countPapers(String paperName, String publisher);
	/**
	 * 添加报刊信息
	 * @param paper
	 * @return
	 */
	int insertPaper(Newspaper paper);
	/**
	 * 删除报刊信息
	 * @param ids
	 * @return
	 */
	int deletePaperById(String[] ids);
	/**
	 * 根据报刊编号查询报刊
	 * @param paperId
	 * @return
	 */
	Newspaper selectPaperById(String paperId);
	/**
	 * 修改报刊
	 * @param paperId
	 * @param paper
	 * @return
	 */
	int updatePaper(String paperId, Newspaper paper);
	/**
	 * 根据条件查询报刊数据，用于导出数据
	 * @param paperName
	 * @param publisher
	 * @return
	 */
	List<Newspaper> selectPapersByNameAndPub(String paperName, String publisher);
	/**
	 * 批量插入报刊数据
	 * @param papers
	 * @return
	 */
	int insertPapers(List<Newspaper> papers);
	/**
	 * 统计报刊的销售情况
	 * @return
	 */
	List<CountBean> selectPaperSale();

}
