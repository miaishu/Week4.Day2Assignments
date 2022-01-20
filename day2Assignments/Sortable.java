package week4.day2Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Sortable {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://jqueryui.com/sortable/");
	driver.manage().window().maximize();
	Actions builder= new Actions (driver);
	driver.switchTo().frame(0);
	WebElement item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
	WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
	WebElement item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
	WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
	Thread.sleep(1000);
	
	builder.clickAndHold(item6).moveToElement(item5).release().perform();
	builder.clickAndHold(item4).moveToElement(item2).release().perform();

}
}
