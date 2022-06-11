package week4Day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAndAlertsEx {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		WebElement frameEle = driver.findElement(By.xpath("//*[@id=\"iframeResult\"]"));
		driver.switchTo().frame(frameEle);
		driver.findElement(By.xpath("//button[text()=\"Try it\"]")).click();
		Thread.sleep(6000);
		Alert alert = driver.switchTo().alert();
		String name="Praveen";
		alert.sendKeys(name);
		alert.accept();		
		String text = driver.findElement(By.xpath("//p[@id=\"demo\"]")).getText();
		System.out.println(text);
		String[] textEntered = text.split(" ");
		for (String text1 : textEntered) {
			if(text1.contains(name)) {
				System.out.println("Name Entered: "+text1);
				break;
			}
		}	
	}

}
