package week4.day2Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions builder= new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//span[@class='catText']"));
		builder.moveToElement(element).perform();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		WebElement count = driver.findElement(By.xpath("//span[@class='category-name category-count']"));
		System.out.println(count.getText());
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/div/i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		driver.findElement(By.xpath("//ul/li[@data-sorttype='plth']")).click();
		
		ArrayList<String> obtList=new ArrayList<String>();
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='product-price-row clearfix]']"));
		Thread.sleep(2000);
		for(WebElement s:findElements) {
			obtList.add(s.getText());
			}	
		
		ArrayList<String> sortList = new ArrayList<String>();   
		for(String s:obtList){
		sortList.add(s);
		}
		Collections.sort(sortList);
		if(obtList==sortList)
			System.out.println("Sorted correctly");
		else
			System.out.println("Not Sorted correctly");
		
		Thread.sleep(2000);
		
		WebElement fromVal = driver.findElement(By.xpath("//div/input[@name='fromVal']"));
		fromVal.clear();
		fromVal.sendKeys("900",Keys.TAB);
		WebElement toVal = driver.findElement(By.xpath("//div/input[@name='toVal']"));
		toVal.clear();
		toVal.sendKeys("1200");
		
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@class='view-more-button btn btn-line btn-theme-secondary viewMoreFilter']")).click();
		driver.findElement(By.xpath("//span[@class='filter-color-tile Navy ']")).click();
		Thread.sleep(1000);
		List<WebElement> filter = driver.findElements(By.xpath("//div[@class='filters']"));
		for(WebElement names:filter) {
			String filterApp = names.getText();
			System.out.println(filterApp);
			//if(filterApp.contains("900")) (filterApp.contains("1200"))
				//System.out.println("Filter Applied");
			//else System.out.println("Filter not applied");
			WebElement firstele = driver.findElement(By.xpath("//div[@class='product-tuple-image ']"));
			builder.moveToElement(firstele).perform();
			driver.findElement(By.xpath("//div[@supc='SDL182790023']")).click();
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> childWindow=new ArrayList<String>(windowHandles);
			System.out.println(childWindow.size());
			
			driver.switchTo().window(childWindow.get(1));
			String cost = driver.findElement(By.xpath("//div[@class='disp-table']//div/div")).getText();
			System.out.println(cost);
			String percent = driver.findElement(By.xpath("//div[@class='disp-table']//div/span[2]")).getText();
			System.out.println(percent);
			File screenshot= driver.getScreenshotAs(OutputType.FILE);
			File destination= new File("./images/Homescreen.png");
			FileUtils.copyFile(screenshot, destination);
			driver.close();
			driver.switchTo().window(childWindow.get(0)).close();
			
			
			
			
			
			
		}
		
		
		
		
	}		
		
}
