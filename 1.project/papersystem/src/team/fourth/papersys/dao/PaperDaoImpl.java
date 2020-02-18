package team.fourth.papersys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

import team.fourth.papersys.pojo.CountBean;
import team.fourth.papersys.pojo.Newspaper;
import team.fourth.papersys.util.C3P0Utils;

public class PaperDaoImpl implements PaperDao {

	@Override
	public List<Newspaper> selectPapers(int pageSize, int currentPage, String paperName, String publisher) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = C3P0Utils.getConnection();
		StringBuilder sql = new StringBuilder("select paper_id, category, paper_name, publisher, price, publish_number, publish_date, paper_img, storage_num" + 
				" from newspaper where 1=1");
		if(!StringUtils.isEmpty(paperName)) {
			sql.append(" and paper_name like "+"\'%"+paperName+"%\'");
		}
		if(!StringUtils.isEmpty(publisher)) {
			sql.append(" and publisher like "+"\'%"+publisher+"%\'");
		}
		sql.append(" order by paper_id");
		sql.append(" limit "+ (currentPage-1)*pageSize + "," + pageSize);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());
			LinkedList<Newspaper>list = new LinkedList<Newspaper>();
			while (rs.next()) {
				Newspaper paper = new Newspaper();
				paper.setPaperId(rs.getString(1));
				paper.setCategory(rs.getString(2));
				paper.setPaperName(rs.getString(3));
				paper.setPublisher(rs.getString(4));
				paper.setPrice(rs.getDouble(5));
				paper.setPublishNumber(rs.getString(6));
				paper.setPublishDate(rs.getString(7));
				paper.setPaperImg(rs.getString(8));
				paper.setStorageNum(rs.getInt(9));
				list.addFirst(paper);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, stmt, rs);
		}
		return null;
	}

	@Override
	public int countPapers(String paperName, String publisher) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = C3P0Utils.getConnection();
		StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM NEWSPAPER WHERE 1=1");
		if(!StringUtils.isEmpty(paperName)) {
			sql.append(" and paper_name like "+"\'%"+paperName+"%\'");
		}
		if(!StringUtils.isEmpty(publisher)) {
			sql.append(" and publisher like "+"\'%"+publisher+"%\'");
		}
		sql.append(" order by paper_id");
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());
			// 如果查询成功，返回统计值
			if(rs.next()) {
				return rs.getInt(1);
			}else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, stmt, rs);
		}
		return 0;
	}

	@Override
	public int insertPaper(Newspaper paper) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = C3P0Utils.getConnection();
		String sql = "insert into newspaper(paper_id,paper_name,category,publisher,price,publish_number,storage_num,publish_date,paper_img) values(?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paper.getPaperId());
			pstmt.setString(2, paper.getPaperName());
			pstmt.setString(3, paper.getCategory());
			pstmt.setString(4, paper.getPublisher());
			pstmt.setDouble(5, paper.getPrice());
			pstmt.setString(6, paper.getPublishNumber());
			pstmt.setInt(7, paper.getStorageNum());
			pstmt.setString(8, paper.getPublishDate());
			pstmt.setString(9, paper.getPaperImg());
			int res = pstmt.executeUpdate();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, null);
		}
		return 0;
	}

	@Override
	public int deletePaperById(String[] ids) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		conn = C3P0Utils.getConnection();
		String sql = "delete from newspaper where paper_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < ids.length; i++) {
				pstmt.setString(1, ids[i]);
				int res = pstmt.executeUpdate();
				result += res;
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, null);
		}
		return 0;
	}

	@Override
	public Newspaper selectPaperById(String paperId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		conn = C3P0Utils.getConnection();
		String sql = "select * from newspaper where paper_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paperId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Newspaper paper = new Newspaper();
				paper.setPaperId(rs.getString("paper_id"));
				paper.setPaperName(rs.getString("paper_name"));
				paper.setCategory(rs.getString("category"));
				paper.setPublisher(rs.getString("publisher"));
				paper.setPrice(rs.getDouble("price"));
				paper.setPublishNumber(rs.getString("publish_number"));
				paper.setPublishDate(rs.getString("publish_date"));
				paper.setPaperImg(rs.getString("paper_img"));
				paper.setStorageNum(rs.getInt("storage_num"));
				return paper;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, rs);
		}
		return null;
	}

	@Override
	public int updatePaper(String paperId, Newspaper paper) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = C3P0Utils.getConnection();
		String sql = "update newspaper set paper_name=?,category=?,publisher=?,price=?,publish_number=?,storage_num=?"
				+ ",publish_date=?,paper_img=? where paper_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paper.getPaperName());
			pstmt.setString(2, paper.getCategory());
			pstmt.setString(3, paper.getPublisher());
			pstmt.setDouble(4, paper.getPrice());
			pstmt.setString(5, paper.getPublishNumber());
			pstmt.setInt(6, paper.getStorageNum());
			pstmt.setString(7, paper.getPublishDate());
			pstmt.setString(8, paper.getPaperImg());
			pstmt.setString(9, paperId);
			int res = pstmt.executeUpdate();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, null);
		}
		return 0;
	}

	@Override
	public List<Newspaper> selectPapersByNameAndPub(String paperName, String publisher) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = C3P0Utils.getConnection();
		StringBuilder sql = new StringBuilder("SELECT paper_id,paper_name,category,publisher,price,publish_number,publish_date,paper_img,storage_num"
				+ " FROM NEWSPAPER WHERE 1=1");
		if(!StringUtils.isEmpty(paperName)) {
			sql.append(" and paper_name like "+"\'%"+paperName+"%\'");
		}
		if(!StringUtils.isEmpty(publisher)) {
			sql.append(" and publisher like "+"\'%"+publisher+"%\'");
		}
		sql.append(" order by paper_id");
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());
			LinkedList<Newspaper>list = new LinkedList<Newspaper>();
			while (rs.next()) {
				Newspaper paper = new Newspaper();
				paper.setPaperId(rs.getString(1));
				paper.setPaperName(rs.getString(2));
				paper.setCategory(rs.getString(3));
				paper.setPublisher(rs.getString(4));
				paper.setPrice(rs.getDouble(5));
				paper.setPublishNumber(rs.getString(6));
				paper.setPublishDate(rs.getString(7));
				paper.setPaperImg(rs.getString(8));
				paper.setStorageNum(rs.getInt(9));
				list.addFirst(paper);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, stmt, rs);
		}
		return null;
	}

	@Override
	public int insertPapers(List<Newspaper> papers) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		conn = C3P0Utils.getConnection();
		String sql = "insert into newspaper(paper_id,paper_name,category,publisher,price,publish_number,storage_num,publish_date,paper_img) values(?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			for (Newspaper paper : papers) {
				pstmt.setString(1, paper.getPaperId());
				pstmt.setString(2, paper.getPaperName());
				pstmt.setString(3, paper.getCategory());
				pstmt.setString(4, paper.getPublisher());
				pstmt.setDouble(5, paper.getPrice());
				pstmt.setString(6, paper.getPublishNumber());
				pstmt.setInt(7, paper.getStorageNum());
				pstmt.setString(8, paper.getPublishDate());
				pstmt.setString(9, paper.getPaperImg());
				pstmt.addBatch();
			}
			int[] res = pstmt.executeBatch();
			for (int i = 0; i < res.length; i++) {
				result += res[i];
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, null);
		}
		return 0;
	}

	@Override
	public List<CountBean> selectPaperSale() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select n.paper_id,paper_name,category,sum(money),sum(num) from newspaper n,orders o,order_item oi "
				+ "where n.paper_id=oi.paper_id and o.order_id=oi.order_id group by n.paper_id,paper_name,category";
			conn = C3P0Utils.getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				List<CountBean>list = new ArrayList<CountBean>();
				while(rs.next()) {
					CountBean cbane = new CountBean();
					cbane.setPaperId(rs.getString(1));
					cbane.setPaperName(rs.getString(2));
					cbane.setCategory(rs.getString(3));
					cbane.setSalePrice(rs.getDouble(4));
					cbane.setSaleNum(rs.getInt(5));
					list.add(cbane);
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				C3P0Utils.release(conn, pstmt, rs);
			}
			return null;
	}
}
