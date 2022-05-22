
package RadioDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioConcept {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Eshu\\Desktop\\seleniumwith java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(2000);
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys("admin");
		Thread.sleep(2000);
		WebElement passWord = driver.findElement(By.id("txtPassword"));
		passWord.sendKeys("admin123");
		Thread.sleep(2000);
		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		btnLogin.click();
		Thread.sleep(2000);
		WebElement myInfo = driver.findElement(By.id("menu_pim_viewMyDetails"));
		myInfo.click();
		Thread.sleep(2000);

		WebElement btnEditPersonalInfo = driver.findElement(By.id("btnSave"));
		btnEditPersonalInfo.click();
		Thread.sleep(2000);
		
		if(radioMyInfoPage("Male").isSelected())
		{
			radioMyInfoPage("Female").click();
		}
		else
		{
			radioMyInfoPage("Male").click();
		}
		Thread.sleep(2000);
		driver.quit();
		
	}

	public static WebElement radioMyInfoPage(String value) {
		return driver.findElement(By.xpath("//label[text()='"+value+"']//preceding-sibling::input"));
	}
}
