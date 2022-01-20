package week4.day2Assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChangeExpWait {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://www.leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();	
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement element = driver.findElement(By.xpath("//button[text()='Click ME!']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.close();
		
		
	}

}
