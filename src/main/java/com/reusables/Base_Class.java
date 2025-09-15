package com.reusables;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.junit.Assert;

import java.awt.AWTException;
import java.awt.Checkbox;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;



public abstract class Base_Class {

	public static WebDriver driver;
	
	public static ExtentReports extentReports;
	
	public static File file;

	
	
	public static void extentReportStart(String location) throws IOException {
		try {
			extentReports = new ExtentReports();
			file =  new File(location);
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
			extentReports.attachReporter(sparkReporter);
			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
			extentReports.setSystemInfo("Java Version",System.getProperty("java.version"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	 
	public static void extentReportTearDown(String location) throws IOException{
		extentReports.flush();
		file= new File(location);
		Desktop.getDesktop().browse(file.toURI());

	}
	
	protected String takeScreenshot() throws IOException{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(0));
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("Screenshot\\.png"+ " " + timeStamp +  ".png");
		FileHandler.copy(scrfile, destfile);
		return destfile.getAbsolutePath();
		
		
	}
	
	
	
	
	
	
	
	
	

	protected static void browserLaunch(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			}
			driver.manage().window().maximize();

		} catch (Exception e) {

			Assert.fail("ERROR: Entered browser name is invalid");
		}
	}

	protected static void sessionTerminate(String options) {
		try {
			if (options.equalsIgnoreCase("close")) {
				driver.close();
			} else if (options.equalsIgnoreCase("quit")) {
				driver.quit();
			}
		} catch (Exception e) {
			Assert.fail("ERROR OCCURS DURING TERMINATION OF A SESSION");
		}
	}

	protected static void navigateTo(String Url) {
		driver.navigate().to(Url);
	}

	protected static void navigate(String option) {
		try {
			if (option.equalsIgnoreCase("back")) {
				driver.navigate().back();
			} else if (option.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			} else if (option.equalsIgnoreCase("forward")) {
				driver.navigate().forward();

			}
		} catch (Exception e) {
			Assert.fail("ERROR: INVALID OPTIONS");
		}
	}

	protected static void urlLaunch(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR: URL IS INVALID");

		}
	}

	protected static void alert(String option) {
		Alert alert = driver.switchTo().alert();
		try {
			if (option.equalsIgnoreCase("accept")) {
				alert.accept();
			} else if (option.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: ALERT NOT FOUND");
		}
	}

	protected static void Actions(WebElement element, String options) {
		try {
			org.openqa.selenium.interactions.Actions acts = new Actions(driver);
			if (options.equalsIgnoreCase("click")) {
				acts.click(element).perform();
			} else if (options.equalsIgnoreCase("doubleclick")) {
				acts.doubleClick(element).perform();
			} else if (options.equalsIgnoreCase("rightclick")) {
				acts.contextClick(element).perform();
			} else if (options.equalsIgnoreCase("hold")) {
				acts.clickAndHold(element).perform();
			} else if (options.equalsIgnoreCase("release")) {
				acts.release(element).perform();
			} else if (options.equalsIgnoreCase("move")) {
				acts.moveToElement(element).perform();

			}
		} catch (Exception e) {
			Assert.fail("ERROR : INVALID OPTIONS");
		}
	}

	protected static void frame(String type, String value) {
		try {
			if (type.equalsIgnoreCase("index")) {
				int value1 = Integer.parseInt(value);
				driver.switchTo().frame(value1);
			} else if (type.equalsIgnoreCase("idname")) {
				driver.switchTo().frame(value);
			} else if (type.equalsIgnoreCase("elementname")) {
				WebElement frameElement = driver.findElement(By.name(value));
				driver.switchTo().frame(frameElement);
			} else {
				Assert.fail("ERROR: INVALID FRAME TYPE");
			}
		} catch (NumberFormatException e) {
			Assert.fail("ERROR : " + e.getMessage());
		}

	}

	protected static void frameParent(String option) {
		try {
			if (option.equalsIgnoreCase("parent")) {
				driver.switchTo().parentFrame();
			} else if (option.equalsIgnoreCase("default")) {
				driver.switchTo().defaultContent();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: CANT SWITCH TO RESPECTIVE FRAME");
		}
	}

	protected static void fullScreenshots(String fileName) throws AWTException, IOException {
		Robot robot = new Robot();

		Date currentDate = new Date(0);
		String dateAndTime = currentDate.toString().replace(" ", "_").replace(":", "_");

		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage screenCapture = robot.createScreenCapture(screenRect);
		File image = new File(".//screenshots//" + dateAndTime + "-" + fileName + ".png");
		ImageIO.write(screenCapture, "png", image);
	}

	protected static void switchTab(String tab) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandles1 = new ArrayList<String>(windowHandles);
		int tabNumber = Integer.parseInt(tab);
		String window = windowHandles1.get(tabNumber);
		driver.switchTo().window(window);
	}

	protected static void selectDropDowns(WebElement element, String type, String value) {
		Select select = new Select(element);

		try {
			if (type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			} else if (type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(value);
			} else if (type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			}
		} catch (NumberFormatException e) {
			Assert.fail("ERROR : CANT SELECT DROPDOWN PLEASE CHECK THE INPUT");
		}
	}

	protected static void clickCheckBox(WebElement element) {

		try {
			WebElement checkbox = driver.findElement(By.id("checkboxId"));
			checkbox.click();
			if (!checkbox.isSelected()) {
				checkbox.click();
			}
			System.out.println("Checkbox is selected:" + checkbox.isSelected());
		} catch (Exception e) {
			Assert.fail("ERROR WHILE HANDING CHECKBOX");
		}

	}

	protected static void elementIsEnabled(WebElement element) {
		try {
			if (element.isEnabled()) {
				System.out.println("The element is enabled");
			} else {
				System.out.println("The element is not enabled");

			}
		} catch (Exception e) {
			Assert.fail("ERROR: THE ELEMENT IS NOT PRESENT");
		}
	}

	protected static void elementIsDisplayed(WebElement element) {
		try {
			if (element.isDisplayed()) {
				System.out.println("Element is Displayed");
			} else {
				System.out.println("Element is not displayed");
			}
		} catch (Exception e) {
			Assert.fail("ERROR: IN DISPLAYING ELEMENTS");
		}
	}

	protected static void elementIsSelected(WebElement element) {
		try {
			if (element.isSelected()) {
				System.out.println("Element is selected");
			} else {
				System.out.println("Element is not selected");
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING ELEMENT SELECTION");

		}

	}

	protected static String title() {
		String title = driver.getTitle();
		return title;

	}

	protected static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	protected static String gettingText(WebElement element) {
		String text = element.getText();
		return text;

	}

	public static void gettingAttribute() {
		try {
			String attribute = driver.findElement(By.id("email")).getAttribute("id");
			System.out.println("The attribute is" + attribute);
		} catch (Exception e) {
			Assert.fail("ERROR WHILE GETTINF ATTRIBUTE");
		}
	}

	protected static void implicitWait(String type, int duration) {

		try {
			if (type.equalsIgnoreCase("seconds")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
			} else if (type.equalsIgnoreCase("minutes")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(duration));
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING IMPLICIT WAIT");
		}

	}

	protected static void explicitWait(int sec) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element_id")));
		} catch (Exception e) {
			Assert.fail("ERROR OCCURS DURING EXPLICIT WAIT");

		}

	}

	protected static void staticWait(int seconds) throws InterruptedException {
		Thread.sleep(seconds * 1000);
	}

	protected static void valuePassing(WebElement element, String value) {

		try {
			element.sendKeys(value);
		} catch (Exception e) {

		//	Assert.fail("ERROR: 0CCUR DURING VALUE PASSING");
		}
	}

	protected static void elementClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING THE ELEMENT CLICK");
		}

	}

	protected static void submit(WebElement element) {
		element.submit();

	}

	protected static void deselectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	protected static void scrollBy(int x, int y) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("Window.scrollBy(arguments[0],arguments[1];", x, y);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING SCROLLING");
		}

	}

	protected static String javaScriptGetTitle() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return (String) js.executeScript("return document.title;");
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING SCROLLING");
		}
		return null;
	}

	protected static void scrollIntoView(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0],scrollIntoView(true);", element);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING SCROLLING UP AND DOWN");
		}

	}

	protected static void javaScriptScrollBottom() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("Window.scrollTo(0,document.body.scrollHeight;");
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING SCROLLING TO BOTTOM");

		}

	}

	protected static void javaScriptClick(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0],click();", element);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING JAVASCRIPT CLICKING");
		}

	}

	

	
}
