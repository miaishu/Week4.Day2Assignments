package week4.day2Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tablesortable {
	public static void main(String[] args) throws InterruptedException {
		
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://www.leafground.com/pages/sorttable.html");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			//xpath  to get size
			int size = driver.findElements(By.xpath("//table[@id='table_id']//tbody/tr")).size();
			
			//Create List and get the data in the particular column by sorting
			List<String> names= new ArrayList<String>();
			
			for(int i=1;i<=size;i++)
			{
				String name = driver.findElement(By.xpath("//table[@id='table_id']//tbody/tr["+ i +"]/td[2]")).getText();
				
				names.add(name);
				}
			System.out.println(names);
			
			Collections.sort(names);
			System.out.println(names);
						
			driver.findElement(By.xpath("//th[text()='Name']")).click();
			List<String>names1 = new ArrayList<String>();
			
			for(int i=1;i<=size;i++)
			{
				String name1 = driver.findElement(By.xpath("//table[@id='table_id']//tbody/tr["+ i +"]/td[2]")).getText();
				names1.add(name1);
				}
			System.out.println(names1);
			
			if(names1.equals(names))
				System.out.println("Sorting Functionality is working in Names table");
			else
				System.out.println("Sorting Functionality  not working");
			
			
			
			
			
			
			
			//call the  particular header xpath & click to get sorted
			
			//th[text()='Name']
			
			
	}

}
