package config;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import webPages.LandingPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverConfig {

    WebDriver webDriver;
    protected LandingPage landingPage;

    @Before
    public void setUp() {
        try {
            webDriver = new ChromeDriver();
            webDriver.get("https://nozzmo.com/recruiting");
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

            landingPage = new LandingPage(webDriver);

        } catch (Exception e) {
            Assert.fail("Can not create driver session");
        }
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

}
