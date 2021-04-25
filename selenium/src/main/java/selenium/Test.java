package selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	public static void main(String[] args) {
		//set chrome driver
//		System.setProperty("webdriver.chrome.driver", 
//				"D:\\taiLieuOneDrive\\Du Lieu\\Nam3\\Hoc ky 2\\Dam bao chat luong & kiem thu\\chromedriver\\chrome91\\chromedriver.exe");
		WebDriver driver = null;
		try {
			DriverManagerType chrome = DriverManagerType.CHROME;
			WebDriverManager.getInstance(chrome).setup();
			driver = new ChromeDriver();
			
			//wait 10s before throw exception
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//open website
			driver.get("http://www.calculator.net/");
			
			//maximize the browser
			driver.manage().window().maximize();
			
			//click button 7
			driver.findElement(By.xpath("//span[contains(text(),'7')]")).click();
			
			//click button +
			driver.findElement(By.xpath("//tbody/tr[2]/td[2]/div[1]/div[1]/span[4]")).click();
			
			//click button 7
			driver.findElement(By.xpath("//span[contains(text(),'5')]")).click();
			
			//click button =
			driver.findElement(By.xpath("//span[contains(text(),'=')]")).click();
			
			//get result
			String res = driver.findElement(By.xpath("//div[@id='sciOutPut']")).getText();
			
			//show result
			System.out.println("Result is : " + res);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//close the browser
			driver.close();
		}
		
		
		
		
		
	}
}
