
package screenshotConcept;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotDemo {
	
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Eshu\\Desktop\\seleniumwith java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		takeSnapShot(driver, 
	"C:\\MyDrive\\NewWorkspace\\Java_projects\\MyTest\\src\\seleniumfirst\\src\\screenshot\\Manjushree"+generateTimeStamp()+".png");
		Thread.sleep(2000);
		driver.quit();
	}

	/***
	 *
	 * @param webdriver
	 * @param fileWithPath
	 * @throws Exception
	 */
	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		// path for these jars is
		// https://commons.apache.org/proper/commons-io/download_io.cgi
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	public static String generateTimeStamp() throws Exception {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		
		String[] dateValue = dtf.format(now).split(" ");
		System.out.println(dateValue[0]);
		System.out.println(dateValue[1]);
		String currentDate = dateValue[0].replaceAll("/", "-");
		System.err.println(currentDate);
		String currentDate1 = dateValue[1].replaceAll(":", "-");
		System.err.println(currentDate1);		
		String finalDate = currentDate + "-" + currentDate1;
		return finalDate;
	}

}
