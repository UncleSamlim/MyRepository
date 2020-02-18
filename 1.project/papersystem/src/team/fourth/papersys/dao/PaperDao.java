package team.fourth.papersys.dao;

import java.util.List;
import team.fourth.papersys.pojo.CountBean;
import team.fourth.papersys.pojo.Newspaper;

public interface PaperDao {
	/**
	 * ����������ѯ���Ա���
	 * @param pageSize
	 * @param currentPage
	 * @param paperName
	 * @param publisher
	 * @return
	 */
	List<Newspaper> selectPapers(int pageSize, int currentPage, String paperName, String publisher);
	/**
	 * ��������ͳ�Ʊ����� 
	 * @param paperName
	 * @param publisher
	 * @return
	 */
	int countPapers(String paperName, String publisher);
	/**
	 * ��ӱ�����Ϣ
	 * @param paper
	 * @return
	 */
	int insertPaper(Newspaper paper);
	/**
	 * ɾ��������Ϣ
	 * @param ids
	 * @return
	 */
	int deletePaperById(String[] ids);
	/**
	 * ���ݱ�����Ų�ѯ����
	 * @param paperId
	 * @return
	 */
	Newspaper selectPaperById(String paperId);
	/**
	 * �޸ı���
	 * @param paperId
	 * @param paper
	 * @return
	 */
	int updatePaper(String paperId, Newspaper paper);
	/**
	 * ����������ѯ�������ݣ����ڵ�������
	 * @param paperName
	 * @param publisher
	 * @return
	 */
	List<Newspaper> selectPapersByNameAndPub(String paperName, String publisher);
	/**
	 * �������뱨������
	 * @param papers
	 * @return
	 */
	int insertPapers(List<Newspaper> papers);
	/**
	 * ͳ�Ʊ������������
	 * @return
	 */
	List<CountBean> selectPaperSale();

}
