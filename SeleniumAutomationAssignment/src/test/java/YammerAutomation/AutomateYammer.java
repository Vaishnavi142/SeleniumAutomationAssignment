package YammerAutomation;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test; 

public class AutomateYammer 
{
	@Test
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		try
		   {
			   System.setProperty("webdriver.chrome.driver","C:\\Users\\VAISHNA\\OneDrive - Capgemini\\Desktop\\driverchrome\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.get("https://web.yammer.com/main/capgemini.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
				System.out.println("PASSED: User entered into the website!!!");
		   }
		   catch(Exception e)
		   {
			   System.out.println("EXCEPTION FOUND: Cannot open the browser!!!");
			   Assert.fail();
		   }
		try
		   {			  
				driver.findElement(By.xpath("//input[@type='email']")).sendKeys("vaishnavi.a.vaishnavi@capgemini.com");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				driver.findElement(By.id("idBtn_Back")).click();
				Thread.sleep(3000);				
				System.out.println("PASSED: User logged into Yammer!!!");
		   }
		   catch(Exception e)
		   {
			   System.out.println("EXCEPTION FOUND: Cannot enter into Yammer!!!");
			   Assert.fail();
		   }
		try
		   {	
				driver.findElement(By.xpath("//div[text()='OneTeamOneFamily']")).click();
				//driver.findElement(By.xpath("//input[@type='button']")).click();
				System.out.println("PASSED: User entered into the OTOF group!!!");
				driver.findElement(By.xpath("//div[@class='inner-204']")).sendKeys(" ");
				System.out.println("PASSED: User entered into the Post content tab!!!");
		   }
		   catch(Exception e)
		   {
			   System.out.println("EXCEPTION FOUND: Cannot click OTOF group!!!");
			   Assert.fail();
		   }
		
	}

}
