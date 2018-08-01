package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	

	public static void main(String[] args) throws Exception {
		File src=new File("C:\\Users\\PRASAD\\eclipse-workspace\\sample\\src\\testdata\\foodnearu.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);
		String data0 = sheet1.getRow(1).getCell(1).getStringCellValue();
		System.out.println("date is:"+data0);
		wb.close();
	}

}
