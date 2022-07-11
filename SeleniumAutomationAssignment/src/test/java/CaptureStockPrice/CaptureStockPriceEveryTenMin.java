package CaptureStockPrice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CaptureStockPriceEveryTenMin 
{
	WebDriver driver;
	public String url = "https://www1.nseindia.com/#";
	String driverPath = "C:\\Users\\VAISHNA\\OneDrive - Capgemini\\Desktop\\driverchrome\\chromedriver.exe";
  @Test
  public void f() throws InterruptedException 
  {
	  //Test for every 10 mins upto 1 hour
	  for (int i = 1;i<=6;)
	  {
	  
		try
		   {
			   System.setProperty("webdriver.chrome.driver",driverPath);
				driver=new ChromeDriver();
				//driver.get("https://www1.nseindia.com/live_market/dynaContent/live_watch/equities_stock_watch.htm");
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
				Thread.sleep(3000);
				System.out.println("PASSED: User entered into the website!!!");
				String expectedTitle = "NSE - National Stock Exchange of India Ltd.";
			    String actualTitle = driver.getTitle();
				Assert.assertEquals(actualTitle, expectedTitle);
				System.out.println("Webpage Actual Title: "+actualTitle);
		   }
		   catch(Exception e)
		   {
			   System.out.println("EXCEPTION FOUND: Cannot open the browser!!!"+e);
			   Assert.fail();
		   }
		try
		   {
			    driver.findElement(By.xpath("//a[text()='Live Market']"));
			    Thread.sleep(3000);
			    driver.findElement(By.xpath("//a[text()='Equity Stock']"));				
				System.out.println("PASSED: User entered into 'Equity Stock'!!!");
				
		   }
		   catch(Exception e)
		   {
			   System.out.println("EXCEPTION FOUND: Cannot enter into 'Equity Stock'!!!"+e);
			   Assert.fail();
		   }
		 try
		   {
			   WebElement symbol = driver.findElement(By.linkText("TATASTEEL"));			   
			   String tickerSymbol = symbol.getText();
			   System.out.println("Stock Symbol: "+ tickerSymbol);
	   
			   WebElement openPrice = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));			 
			   String op = openPrice.getText();
			   System.out.println(tickerSymbol+"'s Open Price: "+ op);
			   
			   WebElement  HighPrice = driver.findElement(By.xpath("//table/tbody/tr[4]/td[3]"));			 
			   String hp = HighPrice.getText();
			   System.out.println(tickerSymbol+"'s High Price: "+ hp);
 
			   WebElement LowPrice = driver.findElement(By.xpath("//table/tbody/tr[4]/td[4]"));			 
			   String lp = LowPrice.getText();
			   System.out.println(tickerSymbol+"'s Low Price: "+ lp);
			   
			   DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			   DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
			   Date date = new Date();
			   Date time = new Date();
			   String date1= dateFormat.format(date);
			   String time1= timeFormat.format(time);
			   System.out.println("Exact date while the price is captured: " +date1);
			   System.out.println("Exact time while the price is captured: " +time1);		  
		   
		  
		File file = new File("C:\\TestExcels\\StockPriceListSelenium.csv");
		System.out.println("Copying data to excel");
		FileWriter f = new FileWriter(file);
		BufferedWriter value = new BufferedWriter(f);

		value.write("TickerSymbol,OpenPrice,HighPrice,LowPrice,Date,Time");
		value.newLine();		
		 value.write(tickerSymbol+","+"\"" + op + "\""+","+hp+","+lp+","+date1+","+time1);
		 value.newLine();		
		System.out.println("Data Copied to Excel!!!");
		value.close();
		f.close(); 
		   
		    }
			   catch(Exception e)
			   {
				   System.out.println("EXCEPTION FOUND!!!"+e);
				   Assert.fail();
			   }
		 driver.close();
		 Thread.sleep(600000);
			i++;	
  }		 
		 	
	
 
  }
  
  @BeforeMethod
  public void beforeMethod() 
{
	System.out.println("Starting Test On Chrome Browser");
}
	
  @AfterMethod
   public void afterMethod() 
  {
	 driver.quit();
	 System.out.println("Finished Test On Chrome Browser");
  }
  
}


