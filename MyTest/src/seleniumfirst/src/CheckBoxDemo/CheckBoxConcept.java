package CheckBoxDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxConcept {

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
		WebElement CheckboxSmoker = driver.findElement(By.id("personal_chkSmokeFlag"));

		// if not at all selected
		if (!CheckboxSmoker.isSelected()) {
			CheckboxSmoker.click();
		}
		// if already selected
		else {
			// uncheck first
			CheckboxSmoker.click();
			Thread.sleep(2000);
			// Then Check
			CheckboxSmoker.click();

		}
		Thread.sleep(2000);
		WebElement adminTab = driver.findElement(By.id("menu_admin_viewAdminModule"));
		adminTab.click();
		Thread.sleep(2000);
		checkBoxAdminPage("Cecil.Bonaparte").click();
		Thread.sleep(2000);
		checkBoxAdminPage("Charlie.Carter").click();
		Thread.sleep(2000);
		checkBoxAdminPage("becky.stark").click();
		Thread.sleep(2000);
		checkBoxAdminPage("Chenzira.Chuki").click();
		Thread.sleep(2000);
		driver.quit();

	}

	public static WebElement checkBoxAdminPage(String value) {
		return driver.findElement(By.xpath("//a[text()='" + value + "']//parent::td//preceding-sibling::td//input"));
	}

}
