package week4.day2Assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertAppearExpWait {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	driver.get("http://www.leafground.com/pages/alertappear.html");
	driver.manage().window().maximize();
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	driver.findElement(By.xpath("//button[@id='alert']")).click();
	wait.until(ExpectedConditions.alertIsPresent());
	Alert alert = driver.switchTo().alert();
	alert.accept();
	driver.close();

}


	
}
