package lecturesForAnnotations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnnotationPractie {
	
	WebDriver driver;
	
	@BeforeTest(alwaysRun = true)
	@Parameters("browser")
	public void launchApplication(String browser) {
        
		if (browser.equals("FireFox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		}
		
		if (browser.equals("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		
		if (browser.equals("Edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		
		driver.get("https://www.facebook.com");
		
	}
	@Test(groups = "Title")
	public void verifyTitle() {
		String expectedTitle= "Facebook - log in or sign up";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle );}
	
	@Test (priority = 1, groups = "Title")
	public void verifyPageText() {
		Boolean pageText = driver.findElement(By.xpath("//h2[@class='_8eso']")).isDisplayed();
		System.out.println(pageText);
		Assert.assertTrue(pageText);
	}
	
	
	@Test(priority =2)
	public void VerifyColorLogin() {
		String expectedColor = "rgb(24, 119, 242)";
		System.out.println(expectedColor);
		String actualColor= driver.findElement(By.name("login")).getCssValue("background-color");
		System.out.println(actualColor);
		Assert.assertEquals(expectedColor, actualColor);
	}

//	@AfterTest
//	public void closeBrowser() {
//		
//		driver.close();
//	}

}
