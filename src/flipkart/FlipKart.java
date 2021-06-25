package flipkart;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;


public class FlipKart {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * System.setProperty("webdriver.gecko.driver", "c:\\Data\\geckodriver.exe");
		 * WebDriver driver=new FirefoxDriver();
		 */
		System.setProperty("webdriver.chrome.driver","C:\\Data\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://flipkart.co.in");
		driver.manage().window().maximize();
		
		takeSnapShot(driver,"C://Data//test.jpeg");
		//click on forgot password link
		WebElement wb=driver.findElement(By.linkText("Forgot?"));
		wb.click();
		//back to login page
		driver.navigate().back();
		//click on browserforward button
		driver.navigate().forward();
		//delete all browser history n cookies
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		//close the browsers
		driver.close();

	}
	public static void takeSnapShot(WebDriver driver,String fileWithPath)throws Exception
	{
		//convert webdriver object to take screenshot
		TakesScreenshot ts=((TakesScreenshot)driver);
		
		//call getscreenshotAs method to create image file
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		
		//move image file to new destination
		File destFile=new File(fileWithPath);
		
		//copy file at destination
		FileUtils.copyFile(srcFile,destFile);
	}
}