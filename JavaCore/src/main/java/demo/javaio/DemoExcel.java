package demo.javaio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import demo.entities.Staff;

public class DemoExcel {
	public static void main(String[] args) throws IOException {
		Path resourceDirectory = Paths.get("src", "main", "resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();        // Get path resources
		Workbook workbook = null;        // handle excel
		ArrayList<Staff> staffs = new ArrayList<Staff>();        // List staff read from excel

		// Demo read file Excel
		staffs = readExcel(workbook, absolutePath, staffs);
		for (Staff staff : staffs) {
			System.out.println(staff.getFullname() + " " + staff.getAge() + " " + staff.getAddress());
		}
		
		// Demo write file Excel
		staffs.add(new Staff("Tran Van H", 20, "HCM"));
		writeExcel(workbook, absolutePath, staffs);
	}

	private static ArrayList<Staff> readExcel(Workbook workbook, String absolutePath,
			ArrayList<Staff> staffs) throws IOException {
		FileInputStream fin = null;
		Sheet sheet = null;        // Create param sheet
		
		// Demo read excel
		try {
			fin = new FileInputStream(absolutePath + "\\file\\demoExcel.xlsx");
			workbook = new XSSFWorkbook(fin);
			sheet = workbook.getSheetAt(0);        // Get sheet at index

			// Add to ArrayList
			for (Row row : sheet) {
				Cell cellAge = row.getCell(1);
				String fullname = row.getCell(0).getStringCellValue();
				String address = row.getCell(2).getStringCellValue();
				int age = (int) cellAge.getNumericCellValue();
				Staff staff = new Staff(fullname, age, address);
				staffs.add(staff);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			workbook.close();
			fin.close();
		}
		return staffs;
	}

	@SuppressWarnings("resource")
	private static void writeExcel(Workbook workbook, String absolutePath,
			ArrayList<Staff> staffs) throws IOException {
		FileInputStream fin = null;
		FileOutputStream fou = null;
		String newSheet = null;
		int rowNum = 0;
		Sheet sheet = null;
		
		// Demo write Excel
		try {
			fin = new FileInputStream(absolutePath + "\\file\\demoExcel.xlsx");
			workbook = new XSSFWorkbook(fin);
			newSheet = "StaffData";
			
			if(workbook.getSheet(newSheet) == null) {
				sheet = workbook.createSheet(newSheet);
			} else {
				sheet = workbook.getSheet(newSheet);
				
				// Continue write the old sheet
//				rowNum = sheet.getLastRowNum();
				
				// Clear sheet and write
				int lastRowNum = sheet.getLastRowNum();
			    for (int i = 0; i <= lastRowNum; i++) {
			        Row row = sheet.getRow(i);
			        if (row != null) {
			            sheet.removeRow(row);
			        }
			    }
			}
			
			if(sheet != null) {
				for (Staff staff : staffs) {
					Row row = sheet.createRow(rowNum++);
					Cell cell0 = row.createCell(0);
					Cell cell1 = row.createCell(1);
					Cell cell2 = row.createCell(2);

					cell0.setCellValue(staff.getFullname());
					cell1.setCellValue(staff.getAge());
					cell2.setCellValue(staff.getAddress());
				}
				
				fou = new FileOutputStream(absolutePath + "\\file\\demoExcel.xlsx");
				workbook.write(fou);
				System.out.println("Staff data has been written to Excel file successfully!");
			} else {
				System.out.println("Can't Get/create Sheet!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			workbook.close();
			if(fin != null) {
				fin.close();
			}
			if(fou != null) {
				fou.close();
			}
		}
	}
}
