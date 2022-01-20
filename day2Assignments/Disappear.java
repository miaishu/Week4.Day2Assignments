package week4.day2Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Disappear {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/disapper.html");
		driver.manage().window().maximize();	
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(2));
		WebElement ele = driver.findElement(By.xpath("//button[@id='btn']"));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		WebElement ele2 = driver.findElement(By.tagName("strong"));
		System.out.println(ele2.getText());
		
		
	}

}
