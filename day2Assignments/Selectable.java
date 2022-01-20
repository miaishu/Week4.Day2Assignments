package week4.day2Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		Actions builder= new Actions(driver);
		driver.switchTo().frame(0);
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement item4 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		builder.keyDown(Keys.CONTROL).click(item1).click(item2).click(item3).click(item4).keyUp(Keys.CONTROL).perform();
		driver.close();
		
	}
}