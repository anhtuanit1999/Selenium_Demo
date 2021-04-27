package selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCalculator {
	@Test
	public void tinhCong() {
		WebDriver driver = null;
		String res = null;
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
			res = driver.findElement(By.xpath("//div[@id='sciOutPut']")).getText();
			
			//show result
			System.out.println("Result is : " + res);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//close the browser
			driver.close();
		}
		assertEquals("12", res.trim());
	}
}
