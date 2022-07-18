package YammerAutomation;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
			   System.out.println("EXCEPTION FOUND: Cannot enter into Yammer!!!"+e);
			   Assert.fail();
		   }
		try
		   {	
				driver.findElement(By.xpath("//div[text()='OneTeamOneFamily']")).click();
				//driver.findElement(By.xpath("//input[@type='button']")).click();
				System.out.println("PASSED: User entered into the OTOF group!!!");
				driver.findElement(By.xpath("//div[text()='Share thoughts, ideas, or updates']")).click();
				System.out.println("PASSED: User entered into the Post content tab!!!");
		   }
		   catch(Exception e)
		   {
			   System.out.println("EXCEPTION FOUND: Cannot click OTOF group!!!"+e);
			   Assert.fail();
		   }
		try
		   {	
				driver.findElement(By.xpath("//div[text()='Share thoughts, ideas, or updates']")).click();
				System.out.println("PASSED: User entered into the Post content window!!!");
				driver.findElement(By.xpath("//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")).sendKeys(" ");
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div[5]/div[2]/div/ul/li/div/div/button/span/div")).click();
				System.out.println("PASSED: User posted content in OTOF group!!!");
		   }
		   catch(Exception e)
		   {
			   System.out.println("EXCEPTION FOUND: Cannot post content in OTOF group!!!"+e);
			   Assert.fail();
		   } 
		try
		   {	
				driver.findElement(By.xpath("//span[text()='About']")).click();
				System.out.println("PASSED: User entered into 'About' window to check most !!!");
				driver.findElement(By.xpath("//span[text()='See more']")).click();
				WebElement act=driver.findElement(By.xpath("//span[text()='1.09k'][1]"));
				String activeUser = act.getText();
				System.out.println("PASSED: No of Active Users for the week July 10th to July 17th: !!!"+activeUser);
		
		   }
		   catch(Exception e)
		   {
			   System.out.println("EXCEPTION FOUND: Cannot find most active users in OTOF group!!!"+e);
			   Assert.fail();
		   }
		try
		   {	
			WebElement act1=driver.findElement(By.xpath("//tspan[text()='Jun 11'][1]"));
			String activeDay = act1.getText();
			System.out.println("PASSED: Day when users are more active in OTOF group for the week July 10th to July 17th: !!!"+activeDay);
		   }
		   catch(Exception e)
		   {
			   System.out.println("EXCEPTION FOUND: Cannot find the day when users are more active in OTOF group!!!"+e);
			   Assert.fail();
		   }
	}

}
