package demo.javaio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import demo.entities.Staff;

public class DemoCSV {
	public static void main(String[] args) throws IOException {
		// Get absolutePath
		Path resourceDirectory = Paths.get("src", "main", "resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		ArrayList<Staff> staffs = new ArrayList<Staff>();

		// Demo read CSV
		staffs = readCSV(absolutePath, staffs);
		
		// Demo write CSV
		writeCSV(absolutePath, staffs);
	}

	private static ArrayList<Staff> readCSV(String absolutePath, ArrayList<Staff> staffs) {
		CSVReader csvReader = null;
		String[] line;

		// Demo Read file CSV
		try {
			csvReader = new CSVReader(new FileReader(absolutePath + "\\file\\demoCSV.csv"));
			System.out.println("Demo read file CSV: ");
			while ((line = csvReader.readNext()) != null) {
				for (int i = 0; i < line.length; i++) {
					String string = line[i];
					System.out.print(string);
				}
				System.out.println();

				// Read file and save to arraylist
				if (line.length == 3) {
					String fullName = line[0];
					int age = Integer.parseInt(line[1].trim());
					String address = line[2];
					Staff staff = new Staff(fullName, age, address);
					staffs.add(staff);
				}
			}

			// Close
			csvReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return staffs;
	}

	private static void writeCSV(String absolutePath, ArrayList<Staff> staffs) {
		CSVWriter csvWriter = null;
		
		// Demo write file to CSV
		try {
			csvWriter = new CSVWriter(new FileWriter(absolutePath + "\\file\\demoCSV.csv"));
			staffs.add(new Staff("Tran Van V", 23, "HCM"));
			for (Staff staff : staffs) {
				csvWriter.writeNext(staff.toArray());
			}
			
			// Close
			csvWriter.close();
			
			System.out.println("\nWrite file CSV successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
