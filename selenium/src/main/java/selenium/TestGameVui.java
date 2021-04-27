package selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestGameVui {
	@Test
	public void dangNhapThanhCong() {
		WebDriver driver = null;
		String username = null;
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
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(hash("u1h2u3s4o5a6c7"));
			
			
			//click button đăng nhập
			driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();
			
			username = driver.findElement(By.xpath("//span[contains(text(),'phanmotau')]")).getText();
			
			if(username.equals("phanmotau")) {
				System.out.println("check okay");
			}
			
		} catch (Exception e) {
			System.out.println("check fail");
		} finally {
			driver.close();
		}
		assertEquals("phanmotau", username);
	}
	@Test
	public void dangNhapThatBai() {
		WebDriver driver = null;
		String res = null;
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
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(hash("u1h2u3s4o5a6dsfc7"));
			
			
			//click button đăng nhập
			driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();
			
			res = driver.findElement(By.xpath("//li[contains(text(),'Đăng nhập không thành công, vui lòng thử lại')]")).getText();
			
			if(res.equals("Đăng nhập không thành công, vui lòng thử lại")) {
				System.out.println("check okay");
			}
			
		} catch (Exception e) {
			System.out.println("check fail");
		} finally {
			driver.close();
		}
		assertEquals("Đăng nhập không thành công, vui lòng thử lại", res);
	}
	
	public static String hash(String password) {
		Pattern pattern = Pattern.compile("[^a-zA-Z]");
		return new StringBuilder(String.join("", pattern.split(password))).reverse().toString();
	}
	
	
	
}
