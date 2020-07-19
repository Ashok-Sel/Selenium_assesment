package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;



public class SeleniumBase {

	public int i = 1;
	public RemoteWebDriver driver;
	public static Properties prop;

	public static void loadObjects() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./objectRep/english.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void unloadObjects() {
		prop = null;
	}

	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		} catch (WebDriverException e) {			
			
		}
	}


	public void startApp(String url) {
		try {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		} catch (WebDriverException e) {			
			
		}
	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator) {
			case "id"	 : return driver.findElementById(locValue);
			case "class" : return driver.findElementByClassName(locValue);
			case "name" : return driver.findElementByName(locValue);
			case "link" : return driver.findElementByLinkText(locValue);
			case "partialLink" : return driver.findElementByPartialLinkText(locValue);
			case "tagname" : return driver.findElementByTagName(locValue);
			case "xpath" : return driver.findElementByXPath(locValue);
			case "cssSelect" : return driver.findElementByCssSelector(locValue);
			}
		} catch (NoSuchElementException e) {
			 
		} catch (WebDriverException e) {
			 
		}
		return null;
	}

	public WebElement locateElement(String locValue) {
		return driver.findElementById(locValue);
	}


	public List<WebElement> locateElements(String type, String locValue) {
		try {
			switch(type) {
			case "id"	 : return driver.findElementsById(locValue);
			case "class" : return driver.findElementsByClassName(locValue);
			case "name" : return driver.findElementsByName(locValue);
			case "link" : return driver.findElementsByLinkText(locValue);
			case "partialLink" : return driver.findElementsByPartialLinkText(locValue);
			case "tagname" : return driver.findElementsByTagName(locValue);
			case "xpath" : return driver.findElementsByXPath(locValue);
			case "cssSelect" : return driver.findElementsByCssSelector(locValue);
			}
		} catch (NoSuchElementException e) {
			 
		} catch (WebDriverException e) {
			
		}
		return null;
	}

	public void clearAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			
		} catch (InvalidElementStateException e) {
			
		} catch (WebDriverException e) {
			
		}
	}

	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {
			ele.click();			
					} catch (InvalidElementStateException e) {
			
		} catch (WebDriverException e) {
			
		} 
	}


	public void click(WebElement ele) {
		String text = "";
		try {			
			ele.click();
			
		} catch (InvalidElementStateException e) {
			
		} catch (WebDriverException e) {
			
		} 
	}

	public String getTitle() {		
		String bReturn = "";
		try {
			bReturn =  driver.getTitle();
		} catch (WebDriverException e) {
			
		} 
		return bReturn;
	}


	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			new Select(ele).selectByVisibleText(value);
			
		} catch (WebDriverException e) {
			
		}
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
		
		} catch (WebDriverException e) {
			
		} 
	}


		


}