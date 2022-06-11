package week4Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		String pageheading = driver.findElement(By.xpath("//*[@id=\"page-top\"]/div/div/div/div/div/label")).getText();
		System.out.println(pageheading);
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//*[@id=\"topic\"]/following-sibling::input")).sendKeys("Praveen");
		
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//*[@id=\"a\"]")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		
		
		WebElement dd= driver.findElement(By.xpath("//*[@id=\"animals\"]"));
		Select dropdown = new Select(dd);
		dropdown.selectByValue("babycat");
		
		
	}

}
