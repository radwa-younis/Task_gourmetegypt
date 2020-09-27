package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import runner.Runner;

public class Hooks extends Runner{


	@cucumber.api.java.Before
	public static void ChromeNavigateURL() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options); 
		Driver = new ChromeDriver(options);
		Driver.manage().window().maximize();
		Driver.get("https://www.gourmetegypt.com/");
		Driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ; 
	}


}
