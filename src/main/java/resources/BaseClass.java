package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public Properties prop;
	String url="";


	@BeforeMethod
	public void startbrowser() throws IOException, InterruptedException {
		prop=new Properties();
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Globalsettings.properties";
		FileInputStream fis=new FileInputStream(path);
		prop.load(fis);
		 url=prop.getProperty("URL");
		String Browser=prop.getProperty("Browser");
		switch(Browser) {
			case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		
			case "ff":
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				
		}
		driver.get(url);
		Thread.sleep(2000);
		
		}

	
	

}
