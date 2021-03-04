package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class Base {

	/**
	 * This is parent class of all classes in this framework This class have all
	 * properties of WebDriver This class have all properties of logger log4j This
	 * class will read input data from ProjectProp.properties files Framework URL,
	 * Implicit and pageload time and browser will be define in ProjectProp file
	 * 
	 */

	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;
	private static String projectPropertyFilePath = "./src/test/resources/InputData/projectProp.properties";
	private static String log4JFilePath = "./src/test/resources/InputData/log4j.properties";

	public Base() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(projectPropertyFilePath));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger = logger.getLogger("logger_File");
		PropertyConfigurator.configure(log4JFilePath);

	}
	public static String getURL() {
		String url = properties.getProperty("url");
		return url;
	}
	public static Long getImplicitWait() {
		String implicitWait = properties.getProperty("implicitlyWait");
		return Long.parseLong(implicitWait);
	}
	
	public static Long getPageLoadTimeOut() {
		String pageLoadTimeOutString = properties.getProperty("pageLoadTimeOut");
		return Long.parseLong(pageLoadTimeOutString);
	}
	public static String getBrowser() {
		String browser = properties.getProperty("browser");
		return browser;
		
	}
	public static void initializerDriver() {
		driver.get(getURL());
	}
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}
