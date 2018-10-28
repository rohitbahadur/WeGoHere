package com.wego.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Location {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",ProjectConfig.prop.getProperty("chromePath"));
		driver = new ChromeDriver();
		
		driver.get(ProjectConfig.prop.getProperty("appurl"));
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath((String) "//*[@id=\"searchbar\"]/div/div/input"))
				.sendKeys( ProjectConfig.prop.getProperty("destination"));
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath((String) "//span[@title='Delhi, India']")).click();
		Thread.sleep(4000L);
		
		System.out.println("ok");
		driver.findElement(By.xpath((String) "//span[@class='star']")).click();
		Thread.sleep(4000L);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='here-account-sdk']")));

		
		driver.findElement(By.xpath((String) "//input[@id='sign-in-email']")).sendKeys(ProjectConfig.prop.getProperty("username"));	
		
		Thread.sleep(2000L);
		driver.findElement(By.xpath((String) "//input[@id='sign-in-password-encrypted']")).sendKeys(ProjectConfig.prop.getProperty("password"));
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath((String) "//button[@id='signInBtn']")).click();
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath((String) "//button[text()='Start a collection']")).click();
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath((String) "//input[@id=\"collection_name\"]")).sendKeys("My Collection");
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath((String) "//button[text()='Create']")).click();
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath((String) "//button[text()='Done']")).click();
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath((String) "//span[text()='Get directions']")).click();
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath((String) "//*[@id=\"itinerary_item_input_0\"]")).sendKeys(ProjectConfig.prop.getProperty("source"));
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath((String) "//div[@title='Lucknow, Uttar Pradesh']")).click();
		Thread.sleep(2000L);
		

		boolean routeExist = false;
		
		
		driver.findElement(By.xpath((String) "//button[@title='Drive']")).click();
		Thread.sleep(2000L);
		
		try {
			driver.findElement(By.xpath((String) "//section[@data-ng-switch-when='noRouteFound']"));
			System.out.println("Fail for Car");
		} catch (Exception e) {
			routeExist = true;
			System.out.println("Pass for Car");
		}
		
		driver.findElement(By.xpath((String) "//button[@title='Public transit']")).click();
		Thread.sleep(2000L);
		
		try {
			driver.findElement(By.xpath((String) "//section[@data-ng-switch-when='noRouteFound']"));
			System.out.println("Fail for Public Trasport");
		} catch (Exception e) {
		
			routeExist = true;
			System.out.println("Pass for Public Trasport");
		}
		
		driver.findElement(By.xpath((String) "//button[@title='Bicycle']")).click();
		Thread.sleep(2000L);

		try {
			driver.findElement(By.xpath((String) "//section[@data-ng-switch-when='noRouteFound']"));
			System.out.println("Fail for Bicycle");
		} catch (Exception e) {
			routeExist = true;
			System.out.println("Pass for Bicycle");
		}
		
		driver.findElement(By.xpath((String) "//button[@class='menu_access_btn icon_btn']")).click();
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath((String) "//a[text()='Collections']")).click();
		Thread.sleep(2000L);
		try {
			driver.findElement(By.xpath((String) "//a[text()='My Collection']"));
			System.out.println("Collection Test Pass.");
		} catch (Exception e) {
			System.out.println("Collection Test Fail.");
		}
		
		driver.close();
	}
}