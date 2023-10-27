package lecturesForAnnotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckWindowhandle {
	
	WebDriver driver;
	
	@Test
	public void tabs() {
		
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		System.out.println(driver.getWindowHandles());
	}
	

}
