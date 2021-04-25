package selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestGameVui {
	public static void main(String[] args) {
		WebDriver driver = null;
		try {
			DriverManagerType chrome = DriverManagerType.CHROME;
			WebDriverManager.getInstance(chrome).setup();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
			driver = new ChromeDriver(options);
			
			//wait 3s before throw exception
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			//open website
			driver.get("https://gamevui.vn/");
			
			//click đăng nhập
			driver.findElement(By.xpath("//a[contains(text(),'Đăng nhập')]")).click();
			
			//skip quảng cáo
			driver.manage().window().maximize();
			
			//type "phanmotau" input email
			driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("phanmotau");
			
			//type password
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(hash("u1h2u3s4o5ac6"));
			
			
			//click button đăng nhập
			driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();
			
			String username = driver.findElement(By.xpath("//span[contains(text(),'phanmotau')]")).getText();
			
			if(username.equals("phanmotau")) {
				System.out.println("check okay");
			}

		} catch (Exception e) {
			System.out.println("check fail");
		} finally {
			driver.close();
		}
	}
	
	public static String hash(String password) {
		Pattern pattern = Pattern.compile("[^a-zA-Z]");
		return new StringBuilder(String.join("", pattern.split(password))).reverse().toString();
	}
	
}
