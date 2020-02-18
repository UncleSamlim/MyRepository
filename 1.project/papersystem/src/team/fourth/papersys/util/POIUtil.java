package team.fourth.papersys.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import team.fourth.papersys.pojo.CountBean;
import team.fourth.papersys.pojo.Newspaper;
/**
 * 导出，导入excel表格工具
 * POI: Poor Obfuscation Implementation
 * @author linyanbin
 *
 * 2018年3月18日下午6:48:40
 */
public class POIUtil {
	private final static String XLS = ".xls";
	private final static String XLSX = ".xlsx";
	
	public static boolean exportData(List<Newspaper>list, String themeName, String[] headNames, String path) {
		String extendName = path.substring(path.indexOf("."));
		if (!(POIUtil.XLS.equals(extendName) || POIUtil.XLSX.equals(extendName))) {
			return false;
		}
		// Workbook对象(excel的文档对象)
		Workbook wb = null;
		if (POIUtil.XLS.equals(extendName)){
			wb = new HSSFWorkbook();
		}else if (POIUtil.XLSX.equals(extendName)) {
			wb = new XSSFWorkbook();
		}
		// 建立新的sheet对象（excel的表单）
		Sheet sheet = wb.createSheet(themeName);
		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		Row theme = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		Cell cell = theme.createCell(0);
		// 设置单元格的内容
		cell.setCellValue(themeName);
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,headNames.length));
		// 建立单元格样式对象
		CellStyle cellStyle = wb.createCellStyle();
		// 设置居中对齐
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		Row rowHeader = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		for (int i = 0; i < headNames.length; i++) {
			rowHeader.createCell(i).setCellValue(headNames[i]);
		}
		for (int i = 0; i < list.size(); i++) {
			Row row = sheet.createRow(i+2);
			Newspaper paper = (Newspaper) list.get(i);
			row.createCell(0).setCellValue(paper.getPaperId());
			row.createCell(1).setCellValue(paper.getPaperName());    
			row.createCell(2).setCellValue(paper.getCategory());
			row.createCell(3).setCellValue(paper.getPublisher()); 
			row.createCell(4).setCellValue(paper.getPrice()); 
			row.createCell(5).setCellValue(paper.getPublishNumber()); 
			row.createCell(6).setCellValue(paper.getPublishDate()); 
			row.createCell(7).setCellValue(paper.getStorageNum()); 
		}
		// 创建文件输出流输出Excel文件
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
			wb.write(fos);
			fos.flush();
			fos.close();
			wb.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false; 
	}
	
	public static List<Newspaper> importData(String path) {
		String extendName = path.substring(path.indexOf("."));
		if (!(POIUtil.XLS.equals(extendName) || POIUtil.XLSX.equals(extendName))) {
			return null;
		}
		List<Newspaper>list = new ArrayList<Newspaper>();
		// 创建文件输入流导入excel文件
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			// 根据指定的文件输入流导入Excel从而产生Workbook对象
			Workbook wb = null;
			if (POIUtil.XLS.equals(extendName)){
				wb = new HSSFWorkbook(fis);
			}else if (POIUtil.XLSX.equals(extendName)) {
				wb = new XSSFWorkbook(fis);
			}
			// 获取Excel文档中的第一个表单
			Sheet sheet0 = wb.getSheetAt(0);
			for (Row row : sheet0) {
				 // 如果当前行的行号（从0开始）未达到2（第三行）则从新循环
				if (row.getRowNum() < 2) {
					continue;
				}
				// 创建实体类
				Newspaper paper = new Newspaper();
				paper.setPaperId(RandomIdFactory.getRandomId());
				paper.setPaperName(row.getCell(0).getStringCellValue());
				paper.setCategory(row.getCell(1).getStringCellValue());
				paper.setPublisher(row.getCell(2).getStringCellValue());
				paper.setPrice(row.getCell(3).getNumericCellValue());
				paper.setPublishNumber(row.getCell(4).getStringCellValue());
				paper.setPublishDate(row.getCell(5).getStringCellValue());
				paper.setStorageNum((int) row.getCell(6).getNumericCellValue());
				list.add(paper);
			}
			fis.close();
			wb.close();
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public static boolean exportSaleData(List<CountBean>list, String themeName, String[] headNames,String path) {
		String extendName = path.substring(path.indexOf("."));
		if (!(POIUtil.XLS.equals(extendName) || POIUtil.XLSX.equals(extendName))) {
			return false;
		}
		Workbook wb = null;
		if (POIUtil.XLS.equals(extendName)){
			wb = new HSSFWorkbook();
		}else if (POIUtil.XLSX.equals(extendName)) {
			wb = new XSSFWorkbook();
		}
		Sheet sheet = wb.createSheet(themeName);
		Row theme = sheet.createRow(0);
		Cell cell = theme.createCell(0);
		cell.setCellValue(themeName);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,headNames.length));
		Row rowHeader = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		for (int i = 0; i < headNames.length; i++) {
			rowHeader.createCell(i).setCellValue(headNames[i]);
		}
		for (int i = 0; i < list.size(); i++) {
			Row row = sheet.createRow(i+2);
			CountBean cbean = (CountBean) list.get(i);
			row.createCell(0).setCellValue(cbean.getPaperId());
			row.createCell(1).setCellValue(cbean.getPaperName());    
			row.createCell(2).setCellValue(cbean.getCategory());
			row.createCell(3).setCellValue(cbean.getSalePrice()); 
			row.createCell(4).setCellValue(cbean.getSaleNum()); 
		}
		// 创建文件输出流输出Excel文件
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
			wb.write(fos);
			fos.flush();
			fos.close();
			wb.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false; 
	}
	
}
