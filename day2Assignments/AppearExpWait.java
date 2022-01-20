package week4.day2Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppearExpWait {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/appear.html");
		driver.manage().window().maximize();	
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		//driver.findElement(By.className("flex"));
		WebElement element = driver.findElement(By.xpath("//button[@id='btn']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println(element.getText());
		
	}

}
