package week4Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowEx {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();
		String parentwindow = driver.getWindowHandle();
		Thread.sleep(5000);
		driver.findElement(By.linkText("FLIGHTS")).click();
		Set<String> windowsset = driver.getWindowHandles();
		List<String> windowslist = new ArrayList<String>(windowsset);
		driver.switchTo().window(windowslist.get(1));
		String childwindowtitle = driver.getTitle();
		System.out.println(childwindowtitle);
		driver.close();		
		driver.switchTo().window(parentwindow);
		String parentwindowtitle = driver.getTitle();
		System.out.println(parentwindowtitle);	
	}
}
