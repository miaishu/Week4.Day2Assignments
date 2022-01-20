package week4.day2Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions builder= new Actions(driver);
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("oneplus 9 pro ");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		WebElement price = driver.findElement(By.xpath("(//div[@class='sg-col-inner']//div/a/span/span/span[@class='a-price-whole'])[3]"));
		String price1 = price.getText();
		String replaceAll=price1.replaceAll("[^1-9]","");
		int total= Integer.parseInt(replaceAll);
		System.out.println(total);
		Thread.sleep(1000);
		WebElement ra = driver.findElement(By.xpath("(//div[@class='sg-col-inner']//div/div//div/span/following-sibling::span/a/span)[3]"));
		String rating = ra.getText();
		System.out.println(rating);
		Thread.sleep(1000);
		WebElement star = driver.findElement(By.xpath("(//div/span/span/a/i)[3]"));
		//builder.moveToElement(star).perform();
		star.click();
		Thread.sleep(1000);
		WebElement per = driver.findElement(By.xpath("//table[@id='histogramTable']//tr[1]/td[3]/span/a"));
		String percent = per.getText();
		System.out.println(percent);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[3]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows= new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		File screenshot= driver.getScreenshotAs(OutputType.FILE);
		File destination= new File("./images/Homescreen.png");
		FileUtils.copyFile(screenshot, destination);
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		driver.findElement(By.xpath("//span[@id='attach-sidesheet-view-cart-button']//input")).click();
		WebElement subto = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']/span"));
		String subtotal = subto.getText();
		String replaceAll1=subtotal.replaceAll("[^1-9]","");
		int subtotal1 = Integer.parseInt(replaceAll);
		
		System.out.println(subtotal1);
		
		if(total==(subtotal1))
			System.out.println("Values are same");
		else
			System.out.println("Values are not same");
		
		driver.close();
		

	
	}
	
	
}