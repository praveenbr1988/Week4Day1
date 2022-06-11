package week4Day1;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithWindowsEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
		
		String parentwindow= driver.getWindowHandle();
		WebElement window1btn = driver.findElement(By.id("home"));
		window1btn.click();
		
		Set<String> setofwindows = driver.getWindowHandles();		
		for (String i:setofwindows) {
			
			driver.switchTo().window(i);
		}		
		driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[1]")).click();
		driver.close();
		driver.switchTo().window(parentwindow);
		driver.findElement(By.xpath("//button[text()=\"Open Multiple Windows\"]")).click();
		int noofwindows = driver.getWindowHandles().size();
		System.out.println("No of windows opened: " +noofwindows);
		driver.findElement(By.xpath("//*[@id=\"color\"]")).click();
		
		Set<String> nextsetofwindows = driver.getWindowHandles();		
		for (String i:nextsetofwindows) {
			if(!i.equals(parentwindow)) {
				driver.switchTo().window(i);
				driver.close();
			}
		}	
	}
}
