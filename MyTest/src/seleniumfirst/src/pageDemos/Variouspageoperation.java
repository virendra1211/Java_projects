
package pageDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Variouspageoperation{
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Eshu\\Desktop\\seleniumwith java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(2000);
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Thread.sleep(2000);
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys("admin");
		Thread.sleep(2000);
		WebElement passWord = driver.findElement(By.id("txtPassword"));
		passWord.sendKeys("admin123");
		Thread.sleep(2000);
		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		btnLogin.click();
		Thread.sleep(2000);
		URL =driver.getCurrentUrl();
		System.out.println(URL);
		String pageSourceCode = driver.getPageSource();
		System.err.println(pageSourceCode);
		Thread.sleep(2000);
		driver.quit();
		
	}

}
