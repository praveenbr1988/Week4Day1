package week4Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.name("PASSWORD"));
		WebElement submit = driver.findElement(By.className("decorativeSubmit"));
		username.sendKeys("DemoSalesManager");
		password.sendKeys("crmsfa");
		submit.click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Merge Contacts\"]")).click();
		
		//From Contact Widget
		driver.findElement(By.xpath("(//a/img)[4]")).click();
		
		//Window Handling for From
		String parentwindow = driver.getWindowHandle();
		Set<String> windowsopenedset = driver.getWindowHandles();
		List<String> windowsopenedlist = new ArrayList<String>(windowsopenedset);
		driver.switchTo().window(windowsopenedlist.get(1));
		driver.findElement(By.xpath("(//div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]/a)[1]")).click();
		//driver.close();
		driver.switchTo().window(parentwindow);
			
		//To Contact Widget
		driver.findElement(By.xpath("(//a/img)[5]")).click();
		
		//Window Handling for To
		windowsopenedset = driver.getWindowHandles();
		windowsopenedlist = new ArrayList<String>(windowsopenedset);
		driver.switchTo().window(windowsopenedlist.get(1));
		driver.findElement(By.xpath("(//div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]/a)[2]")).click();
		driver.switchTo().window(parentwindow);
		
		//Merge Button
		driver.findElement(By.xpath("//a[text()=\"Merge\"]")).click();
		
		//Alert		
		Alert mergealertconfirm = driver.switchTo().alert();
		mergealertconfirm.accept();
		String title = driver.getTitle();
		
		//Title of Browser
		System.out.println("Title of the browser is: "+title);
	}
}
