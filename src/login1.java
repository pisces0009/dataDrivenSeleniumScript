import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import ReadExcelData.ReadExcel;

public class login1 {
	
	
	public void loginTo() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PRASAD\\Desktop\\S\\chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://foodnearu.com/");
		
		ArrayList<String> email=readExcelData(0);
		ArrayList<String> password=readExcelData(1);
		ArrayList<String> name=readExcelData(2);
		
		for(int i=0;i<email.size();i++)
		{
			Thread.sleep(8000);		
			driver.findElement(By.id("loginBtn")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.id("email1")).click();
			
			driver.findElement(By.id("email1")).sendKeys(email.get(i));
			
			driver.findElement(By.id("password")).click();
			
			driver.findElement(By.id("password")).sendKeys(password.get(i));
			
			driver.findElement(By.xpath("//*[@id=\"LoginForm\"]/div[4]/div[1]/button")).click();
			
			//driver.findElement(By.xpath("//*[@id=\"usrBtn\"]/a")).sendKeys(name.get(i));
			
			Thread.sleep(9000);
			//name button,account name
			//driver.findElement(By.xpath("//*[@id=\"usrBtn\"]/a")).click();
			//driver.findElement(By.xpath("//*[@id=\"usrBtn\"]/ul/li[1]/a")).click();
			/*String my_title=driver.getTitle();
			System.out.println("name is:"+my_title);
			Assert.assertTrue(my_title.contains("Names"));
			System.out.println("s");*/
			WebElement button = driver.findElement(By.id("usrName"));

		    if(button.getAttribute("id").matches("usrName"))
		    {
		        System.out.println("Test Pass");
		        
		    }
		    else{
		       System.out.println("Test Failed");
		        
		    } 
			Thread.sleep(9000);
			//name button
			driver.findElement(By.xpath("//*[@id=\"usrBtn\"]/a")).click();
			
			Thread.sleep(6000);
			//signout
			driver.findElement(By.xpath("//*[@id=\"usrBtn\"]/ul/li[8]/a")).click();
			Thread.sleep(6000);
			//driver.findElement(By.linkText("Login/Signup")).click();
			
			
			
		}
		
		
		
		
		

	}

	public ArrayList<String> readExcelData(int colNo) throws Exception
	{
		File src=new File("C:\\Users\\PRASAD\\eclipse-workspace\\sample\\src\\testdata\\foodnearu.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);
		
		Iterator<Row> rowIterator=sheet1.iterator();
		ArrayList<String> list=new ArrayList<String>();
		rowIterator.next();
		while (rowIterator.hasNext())
		{
			list.add(rowIterator.next().getCell(colNo).getStringCellValue());
			
		}
		
		System.out.println("Excel Data="+list);
		return list;
		
	}

	public static void main(String[] args) throws Exception
	{
		login1 data=new login1();
		data.loginTo();
	}
	
	

}
