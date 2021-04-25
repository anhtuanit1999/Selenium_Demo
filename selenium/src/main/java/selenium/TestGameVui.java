package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestGameVui {
	public static void main(String[] args) {
		WebDriver driver = null;
		try {
			// đang test chưa chạy okay lắm
			DriverManagerType chrome = DriverManagerType.CHROME;
			WebDriverManager.getInstance(chrome).setup();
			driver = new ChromeDriver();
			
			//wait 3s before throw exception
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			//open website
			driver.get("https://gamevui.vn/");
			
			//click đăng nhập
			driver.findElement(By.xpath("//a[contains(text(),'Đăng nhập')]")).click();
			
			Thread.sleep(30000);
			
			//type "phanmotau" input email
			driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("phanmotau");;
			
			//type password
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("caosuhu");
			
			//click button đăng nhập
			driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();
			
			String username = driver.findElement(By.xpath("//span[contains(text(),'phanmotau')]")).getText();
			
			if(username.equals("phanmotau")) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
			
			
		} catch (Exception e) {
			System.out.println("Error");
		} finally {
			driver.close();
		}
	}
	
}
