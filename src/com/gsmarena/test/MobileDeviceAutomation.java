package com.gsmarena.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.wego.test.ProjectConfig;

public class MobileDeviceAutomation {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",ProjectConfig.prop.getProperty("chromePath"));
		driver = new ChromeDriver();
		
		driver.get(ProjectConfig.prop.getProperty("mobileappurl"));
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//*[@id='topsearch-text']")).sendKeys(ProjectConfig.prop.getProperty("mobiledevice"));
		driver.findElement(By.xpath("//*[@id='topsearch-text']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"topsearch\"]/div[1]/div[2]/ul/li[1]/a/img")).click();
		Thread.sleep(4000);

		try {
			driver.findElement(By.xpath("//a[text()='GPS']"));
			driver.findElement(By.xpath("//td[@data-spec='gps' and contains(text(),'Yes')]"));
			System.out.println("Device is GPS Enabled");
		} catch (Exception e) {
			System.out.println("Device is Not GPS Enabled");
		}
	driver.quit();
	}
	
	
}
