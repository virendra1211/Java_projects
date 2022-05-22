package seleniumfirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstselenium {

	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		driver.get("https:www.//orangehrm.com/");
	}
}
