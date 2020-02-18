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
 * ����������excel��񹤾�
 * POI: Poor Obfuscation Implementation
 * @author linyanbin
 *
 * 2018��3��18������6:48:40
 */
public class POIUtil {
	private final static String XLS = ".xls";
	private final static String XLSX = ".xlsx";
	
	public static boolean exportData(List<Newspaper>list, String themeName, String[] headNames, String path) {
		String extendName = path.substring(path.indexOf("."));
		if (!(POIUtil.XLS.equals(extendName) || POIUtil.XLSX.equals(extendName))) {
			return false;
		}
		// Workbook����(excel���ĵ�����)
		Workbook wb = null;
		if (POIUtil.XLS.equals(extendName)){
			wb = new HSSFWorkbook();
		}else if (POIUtil.XLSX.equals(extendName)) {
			wb = new XSSFWorkbook();
		}
		// �����µ�sheet����excel�ı���
		Sheet sheet = wb.createSheet(themeName);
		// ��sheet�ﴴ����һ�У�����Ϊ������(excel����)��������0��65535֮����κ�һ��
		Row theme = sheet.createRow(0);
		// ������Ԫ��excel�ĵ�Ԫ�񣬲���Ϊ��������������0��255֮����κ�һ��
		Cell cell = theme.createCell(0);
		// ���õ�Ԫ�������
		cell.setCellValue(themeName);
		// �ϲ���Ԫ��CellRangeAddress����������α�ʾ��ʼ�У������У���ʼ�У� ������
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,headNames.length));
		// ������Ԫ����ʽ����
		CellStyle cellStyle = wb.createCellStyle();
		// ���þ��ж���
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		Row rowHeader = sheet.createRow(1);
		// ������Ԫ�����õ�Ԫ������
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
		// �����ļ���������Excel�ļ�
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
		// �����ļ�����������excel�ļ�
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			// ����ָ�����ļ�����������Excel�Ӷ�����Workbook����
			Workbook wb = null;
			if (POIUtil.XLS.equals(extendName)){
				wb = new HSSFWorkbook(fis);
			}else if (POIUtil.XLSX.equals(extendName)) {
				wb = new XSSFWorkbook(fis);
			}
			// ��ȡExcel�ĵ��еĵ�һ����
			Sheet sheet0 = wb.getSheetAt(0);
			for (Row row : sheet0) {
				 // �����ǰ�е��кţ���0��ʼ��δ�ﵽ2�������У������ѭ��
				if (row.getRowNum() < 2) {
					continue;
				}
				// ����ʵ����
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
		// ������Ԫ�����õ�Ԫ������
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
		// �����ļ���������Excel�ļ�
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
