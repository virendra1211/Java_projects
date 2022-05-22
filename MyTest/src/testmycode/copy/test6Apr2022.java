
package testmycode.copy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test6Apr2022 {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", 
				C:\Users\Eshu\Desktop\seleniumwith java\sel jar\chromedriver_win32.exe");
		driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		Thread.sleep(2500);		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(2500);
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys("admin");
		Thread.sleep(2500);
		WebElement passWord = driver.findElement(By.id("txtPassword"));
		passWord.sendKeys("admin123");
		Thread.sleep(2500);
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		loginBtn.click();
		Thread.sleep(2500);
		driver.quit();
		
	}

}
