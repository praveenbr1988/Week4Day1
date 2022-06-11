package week4Day1;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("oneplus 9 pro"+Keys.ENTER);
		
		String firstproductprice = driver.findElement(By.xpath("//div[@data-cel-widget=\"search_result_4\"]//span[@class=\"a-price-whole\"]")).getText();
		System.out.println("First Product Price: "+firstproductprice);
		String firstproductreviews = driver.findElement(By.xpath("//div[@data-cel-widget=\"search_result_4\"]//div[@class=\"a-row a-size-small\"]/span[2]")).getAttribute("aria-label");
		System.out.println("First Product- Total Reviews: "+firstproductreviews);
		
		driver.findElement(By.xpath("//div[@data-cel-widget=\"search_result_4\"]//h2/a")).click();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
		}
		
		//Taking Screenshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./amazon.png");
		FileUtils.copyFile(src, dest);
		
		//Clicking Add to cart
		driver.findElement(By.xpath("//input[@id=\"add-to-cart-button\"]")).click();
		
		String subtotal = driver.findElement(By.xpath("//span[@id=\"attach-accessory-cart-subtotal\"]")).getText();
		System.out.println(subtotal);
		subtotal= subtotal.replace(".00", "");
		System.out.println(subtotal);
		subtotal= subtotal.replace("?", "");
		//subtotal= subtotal.substring(1);
		System.out.println(subtotal);

		System.out.println("SubTotal is : "+subtotal);
		
		
		if(firstproductprice.equalsIgnoreCase(subtotal))
			System.out.println("Subtotal is correct");
		else
			System.out.println("Subtotal is incorrect");	
		
	}

}
