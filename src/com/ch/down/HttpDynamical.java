package com.ch.down;

import java.sql.Connection;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ch.pojo.WebSite;
import com.ch.util.MysqlOperation;
import com.ch.zhaobiao.ZhaoBiao;

public class HttpDynamical {
	MysqlOperation operation = new MysqlOperation();
	Connection conn = operation.mysqlConn();
	WebSite website = new WebSite();
	ZhaoBiao zb = new ZhaoBiao();
	//异步采集
	public void selenium() throws InterruptedException{
		long waitLoadBaseTime = 10000;
		int waitLoadRandomTime = 3000;
		Random random = new Random(System.currentTimeMillis());
		//设置浏览器驱动的位置，很重要，不然打开的话可能是空白页
		System.setProperty("webdriver.chrome.driver", "D:/Selenium/chromedriver.exe"); 
		//实例化一个浏览器对象
		WebDriver driver = new ChromeDriver();
		String baseUrl = "";
		//打开浏览器
		driver.get(baseUrl);
		//这个时候会打开一个浏览器，连接到你所get的网站
		//因为网站不一定可以马上打开，让进程停一下，否则页面的元素会找不到。
		Thread.sleep(5000);
		
		//用javascript方法点击
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//第一次点击
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("")));
		Thread.sleep(3000);
		//第二次点击
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("")));
	}
}
