package week4.day2Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		Actions builder= new Actions(driver);
		driver.switchTo().frame(0);
		WebElement ele = driver.findElement(By.xpath("//div[@id='resizable']"));
//		Point location = ele.getLocation();
//		int x = location.getX();
//		int y = location.getY();
		WebElement ele1 = driver.findElement(By.xpath("//div[@id='resizable']/div[@class='ui-resizable-handle ui-resizable-e']"));
	builder.clickAndHold(ele1).moveToElement(ele,200,56).release().perform();
	
		
}
}