package demo.javaio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.html2pdf.HtmlConverter;

import demo.entities.Staff;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class DemoPDF {
	public static void main(String[] args) {
		// Get absolutePath
		Path resourceDirectory = Paths.get("src", "main", "resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		ArrayList<Staff> listStaffs = new ArrayList<Staff>();

		// Add data to ArrayList
		listStaffs.add(new Staff("Nguyen Van A", 20, "HCM"));
		listStaffs.add(new Staff("Nguyen Van B", 18, "HN"));
		listStaffs.add(new Staff("Nguyen Van D", 23, "HCM"));
		listStaffs.add(new Staff("Nguyen Van E", 22, "GL"));
        
		// Run function export PDF
		exportPDF(absolutePath, listStaffs);
	}
	
	private static void exportPDF(String absolutePath, ArrayList<Staff> listStaffs) {
		FileOutputStream outputStream = null;        
		Writer out = null;
		File outputFile = null;
		Map<String, Object> templateData = new HashMap<>();
		
		// Demo export PDF
		try {
            // Load template HTML from file freemarker
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
            cfg.setClassForTemplateLoading(DemoPDF.class, "/");
            Template template = cfg.getTemplate("file/templateHTMLExportPDF.ftl");

            // Fill data into the template
            templateData.put("users", listStaffs); 
            out = new StringWriter();
            template.process(templateData, out);

            // Create PDF and convert HTML to PDF
            outputFile = new File(absolutePath + "\\file\\demoExportPDF.pdf");
            outputStream = new FileOutputStream(outputFile);
            HtmlConverter.convertToPdf(out.toString(), outputStream);

            // Close
            out.close();
            outputStream.close();
            
            System.out.println("PDF created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
