package lecturesForAnnotations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HamidtestCase {
	
	
	WebDriver driver;
	
	@BeforeTest(alwaysRun = true)
	public void launchApplication() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.globalsqa.com/samplepagetest/");
		
	}
	@Test(groups = "Title")
	public void verifyTitleHamid() throws InterruptedException {
		
	
		WebElement name = driver.findElement(By.xpath("//input[@class='name']"));
		name.sendKeys("Jhon");
		
		Thread.sleep(2000);
		
		
		name.clear();
		name.sendKeys("hamid");
		String namevisible= name.getText();
		System.out.println(" Name value = "+ namevisible);
		String namevisible1= name.getAttribute("value");
		
		WebElement email = driver.findElement(By.xpath("//input[@class='email']"));
		email.sendKeys("Jhon@gmail.com");
		
		Thread.sleep(2000);
		
		email.clear();
		email.sendKeys("Hamid@gmail.com");
	
}

//	@AfterTest
//	public void closeBrowser() {
//		
//		driver.close();
//	}

}
