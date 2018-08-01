package l;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

	
	
	public void loginTo(String email, String password) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PRASAD\\Desktop\\S\\chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://foodnearu.com/");
		
		Thread.sleep(2000);		
		driver.findElement(By.id("loginBtn")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("email1")).click();
		
		driver.findElement(By.id("email1")).sendKeys(email);
		
		

	}
}
