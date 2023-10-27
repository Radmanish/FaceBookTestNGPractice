package lecturesForAnnotations;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandlePrac {

	WebDriver driver;
	
	@BeforeTest
	public void launchApplication() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	
	@Test
	public void loginInstaGram() throws InterruptedException {
		
		driver.findElement(By.linkText("Instagram")).click();
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		
		driver.findElement(By.name("username")).sendKeys("Wakman@gmasil.com");
		driver.switchTo().window(tabs.get(0));
		driver.findElement(By.name("email")).sendKeys("Wakman@gmasil.com");
	}
	
	
	

}
