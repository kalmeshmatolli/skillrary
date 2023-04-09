package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	private Workbook wb;

	/**
	 * This method is used to Initialize the Excel file
	 * 
	 * @param excelPath
	 */
	public void ExcelInitialization(String excelPath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to read the single data from excel
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public String readSingleData(String sheetName, int rowNum, int cellNum) {
		return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}

	/**
	 * This method is used to read the data from excel file and store them in one
	 * MAP interface
	 * 
	 * @param sheetName
	 * @return map
	 */
	public Map<String, String> readData(String sheetName) {
		Map<String, String> map = new HashMap<>();
		Sheet sh = wb.getSheet(sheetName);

		for (int i = 0; i <= sh.getLastRowNum(); i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();

			map.put(key, value);
		}
		return map;
	}

	public void closeWorkbook() {
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
