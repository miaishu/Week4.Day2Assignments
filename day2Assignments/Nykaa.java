package week4.day2Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions builder= new Actions(driver);
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brand).perform();
		driver.findElement(By.xpath("//div[@class='css-ov2o3v']/a[text()=\"L'Oreal Paris\"]")).click();
		
		
		//WebElement brand1 = driver.findElement(By.xpath("(//div[@class='css-ov2o3v']/a)[6]"));
		System.out.println(driver.getTitle());
		
		
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(2000);
		List<WebElement> filter = driver.findElements(By.xpath("//div[@class='css-rtde4j']"));
		for(WebElement names:filter) {
			String filterApp = names.getText();
			System.out.println(filterApp);
			if(filterApp.contains("Shampoo"))
				System.out.println("Filter Applied");
			else System.out.println("Filter not applied");
		}
		
		driver.findElement(By.xpath("//div[@class='css-43m2vm']/img")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows= new ArrayList<String>(windowHandles);			
		driver.switchTo().window(windows.get(1));
		WebElement dropdown = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select size= new Select(dropdown);
		size.selectByIndex(2);
		//System.out.println(size);
		String mrp = driver.findElement(By.xpath("//span[@class='css-12x6n3h']")).getText();
		System.out.println(mrp);
		driver.findElement(By.xpath("//div[@class='css-1rn9gza']//span")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@class='css-5s18zx eoh7kvv0']")).click();
		Thread.sleep(500);
		int size1 = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size1);
			
		driver.switchTo().frame(0);
		
		WebElement value = driver.findElement(By.xpath("//div[@class='payment-tbl-data']/div[4]/div[2]"));
		Thread.sleep(1000);
		String value1 = value.getText();
		String replaceAll = value1.replaceAll("[^0-9]","");
		int pricevalue = Integer.parseInt(replaceAll);
		System.out.println(pricevalue);
		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
		
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		String finalvalue = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		
		String replaceAll1 = value1.replaceAll("[^0-9]","");
		int pricevalue1 = Integer.parseInt(replaceAll);
		System.out.println(pricevalue1);
			if(pricevalue==pricevalue1)
				System.out.println("Values are same");
			else
				System.out.println("Values are not same");
			driver.quit();
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
