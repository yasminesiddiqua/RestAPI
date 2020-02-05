package sample;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcel {
	public static void main(String[] args) throws Exception {

		Map<String, Integer> response = HittingServerJava.hittingServer();
		System.out.println(response);

		// Create blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();	
		// Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet(" Employee Info ");
		// Create row object
		XSSFRow row;
		// This data needs to be written (Object[])
		row = spreadsheet.createRow(0);
		row.createCell(0).setCellValue("TestCaseId");
		row.createCell(1).setCellValue("input");
		row.createCell(2).setCellValue("output status");

		int i=1;
		for(Entry<String, Integer> resp : response.entrySet()) {
			row = spreadsheet.createRow(i);
			row.createCell(0).setCellValue(i);
			row.createCell(1).setCellValue(resp.getKey());
			row.createCell(2).setCellValue(resp.getValue());
			i++;
		}
		// Write the workbook in file system
		FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Dell1\\Downloads\\sampleapi.xlsx"));
		workbook.write(out);
		workbook.close();
		out.close();
		System.out.println("Writesheet.xlsx written successfully");
	}
}
