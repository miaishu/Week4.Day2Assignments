package week4.day2Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions builder= new Actions(driver);
		WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
		builder.moveToElement(men).perform();
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		String count = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		//System.out.println(count);
		String s =count.replaceAll("[^0-9]","");
		int countValue = Integer.parseInt(s);
		System.out.println(countValue);
		
		
		List<WebElement> cate = driver.findElements(By.xpath("//ul[@class='categories-list']"));
		//for(WebElement ele:cate) {
			//String category = ele.getText();
			//System.out.println(category);
			//String[] split = category.split("^");
			//System.out.println(split);
			//String replaceAll = category.replaceAll("[^0-9]","");
			
			//Integer.parseInt(replaceAll);
		//System.out.println(replaceAll);
			
		//}
		String num1=driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		String repAll=num1.replaceAll("[^0-9]","");
		int cat1 = Integer.parseInt(repAll);
		System.out.println(cat1);
		
		String num2 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		String repAll1=num2.replaceAll("[^0-9]","");
		int cat2 = Integer.parseInt(repAll1);
		System.out.println(cat2);
		int categorySum= cat1+cat2;
		System.out.println(categorySum);
		if(categorySum==countValue)
			System.out.println("Validate matches");
		else System.out.println("Not matching the count");
		
		driver.findElement(By.xpath("//div[@class='common-checkboxIndicator']")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
		driver.findElement(By.xpath("//input[@value='Duke']/parent::label[@class=' common-customCheckbox']")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		//to confirm all the brand is duke?
		List<WebElement> brand = driver.findElements(By.className("product-brand"));
		System.out.println(brand.size());
		//for(WebElement brandname:brand) {
			//String text = brandname.getText();
		//}
		Thread.sleep(1000);
		WebElement sort = driver.findElement(By.xpath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']"));
		//builder.moveToElement(sort).perform();
		sort.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@class='sort-list']/li[3]")).click();
		Thread.sleep(1000);
		String firstProd = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		System.out.println(firstProd);
		driver.findElement(By.xpath("//div[@class='product-sliderContainer'][1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows= new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		File screenshot= driver.getScreenshotAs(OutputType.FILE);
		File destination= new File("./images/Homescreen.png");
		FileUtils.copyFile(screenshot, destination);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconWishlist sprites-headerWishlist']")).click();
		driver.close();
		driver.switchTo().window(windows.get(0)).close();
		
}
}