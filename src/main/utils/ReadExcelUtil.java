package main.utils;

import java.io.FileInputStream;
import java.util.Hashtable;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This class is used to read the Excel File Data
 * 
 * @author shaik
 *
 */
public class ReadExcelUtil {

	private static XSSFSheet WorkSheet;
	private static XSSFWorkbook WorkBook;
	private static XSSFCell Cell;
	private static Hashtable<String, String> cellData;
	private static String Data;

	/**
	 * This method is used to Get the Excel Sheet
	 * 
	 * @param filePath
	 *            File Path
	 * @param sheetName
	 *            Sheet Name
	 */
	public void getExcelFile(String filePath, String sheetName) {
		try {
			FileInputStream excelFile = new FileInputStream(filePath);
			WorkBook = new XSSFWorkbook(excelFile);
			WorkSheet = WorkBook.getSheet(sheetName);
		} catch (Exception exception) {
			System.out.println("Ecxeption from the setExcelFile :: " + exception.getMessage());

		}
	}

	/**
	 * This method is used to get the cell value from Excel Sheet
	 * 
	 * @param rowNumber
	 *            Row Number
	 * @param columnNumber
	 *            Column Number
	 * @return cellData
	 */
	public static String getCellData(int rowNumber, int columnNumber) {
		try {
			Cell = WorkSheet.getRow(rowNumber).getCell(columnNumber);
			Data = Cell.getStringCellValue();
		} catch (Exception exception) {
			System.out.println("Ecxeption from the getCellData :: " + exception.getMessage());

		}
		return Data;

	}

	/**
	 * This method is used to read the multiple data from the excel sheet
	 * 
	 */
	public Hashtable<String, String> getMultipleCellData() {

		cellData = new Hashtable<String, String>();
		try {
			for (int i = 1; i <= WorkSheet.getLastRowNum() + 1; i++) {
				for (int j = 0; j <= WorkSheet.getRow(i).getLastCellNum() - 1; j++) {
					Cell = WorkSheet.getRow(i).getCell(j);

					cellData.put(WorkSheet.getRow(0).getCell(j).toString(), WorkSheet.getRow(i).getCell(j).toString());
				}
			}
		} catch (Exception exception) {
			System.out.println("Ecxeption from the getMultipleCellData :: " + exception.getMessage());

		}
		return cellData;

	}
}
