package exec;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class Exec {

	protected WindowsDriver<WindowsElement> driver;

	@BeforeSuite
	public void newSession() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Windows");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "D2018Q3709");
		capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
		URL url = new URL("http://localhost:4723/wd/hub");
		driver = new WindowsDriver<WindowsElement>(url, capabilities);
	}
	
	@AfterSuite
	public void endSession() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
