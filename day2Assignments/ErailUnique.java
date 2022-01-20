package week4.day2Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {
	public static void main(String[] args) throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("chkSelectDateOnly")).click();
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
		
	
		//driver.findElement(By.id("buttonFromTo")).click();
		Thread.sleep(2000);
		int size = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr")).size();
		List<String> trainnames=new ArrayList<String>();
		
		for(int i=1;i<=size;i++) {
			String names = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+ i +"]/td[2]")).getText();
			Thread.sleep(500);
			trainnames.add(names);
			}
		int namessize = trainnames.size();
		System.out.println(namessize);
		
		Set<String> uniqueNames= new HashSet<String>(trainnames);
		uniqueNames.addAll(trainnames);
		int uniqueNamessize = uniqueNames.size();
		System.out.println(uniqueNamessize);
		
		if(uniqueNamessize==namessize)
			System.out.println("There are no duplicates");
		else
			System.out.println("Duplicates are present");
		driver.close();
			
		
		
	}

}
