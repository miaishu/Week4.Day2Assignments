package week4.day2Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {
	
	public static void main(String[] args) throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement findElement = driver.findElement(By.id("txtStationFrom"));
		findElement.clear();
		findElement.sendKeys("MS");
		Thread.sleep(500);
		findElement.sendKeys(Keys.TAB);
		
		WebElement findElement2 = driver.findElement(By.id("txtStationTo"));
		findElement2.clear();
		findElement2.sendKeys("MDU");
		Thread.sleep(500);
		findElement2.sendKeys(Keys.TAB);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		//driver.findElement(By.id("buttonFromTo")).click();
		Thread.sleep(500);
		int size = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr")).size();
		List<String> trainnames=new ArrayList<String>();
		
		for(int i=1;i<=size;i++) {
			String names = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+ i +"]/td[2]")).getText();
			Thread.sleep(500);
			trainnames.add(names);
			}
		Collections.sort(trainnames);
		System.out.println(trainnames);
		driver.close();
}
}