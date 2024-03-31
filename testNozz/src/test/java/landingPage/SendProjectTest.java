package landingPage;

import config.DriverConfig;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import webPages.LandingPage;


public class SendProjectTest extends DriverConfig {
    WebDriver driver;

    String userName = "1223";
    String email = "ghernandezhack+p1@gmail.com";
    String invalidMail = "gresult";

    @Test
    public void sendEmptyForm() {
        landingPage.clickSendInfo();
        Assert.assertTrue(landingPage.textNameAlert());

    }

    @Test
    public void emailNotCompleted() {
        landingPage.enterUserNameField(userName);
        landingPage.enterEmailField(invalidMail);
        landingPage.clickSendInfo();
        Assert.assertTrue(landingPage.textMailAlert());
    }

    @Test
    public void sendNewProject() {
        Assert.assertTrue(landingPage.titleDisplayed());
        landingPage.enterUserNameField(userName);
        landingPage.enterEmailField(email);
        landingPage.enterDescriptionProject("Este es un nuevo proyecto de prueba");
        landingPage.clickSendInfo();
        Assert.assertTrue(landingPage.successBannerDisplayed());
    }

    @Test
    public void navigateOnPage() {
        Assert.assertTrue(landingPage.titleDisplayed());
        landingPage.enterUserNameField(userName);
        landingPage.enterEmailField(email);
        landingPage.enterDescriptionProject("Este es un proyecto pensado en gente común");
        landingPage.clickSendInfo();
        Assert.assertTrue(landingPage.successBannerDisplayed());
        landingPage.scrollIntoView();
        landingPage.clickAccording();
        Assert.assertTrue(landingPage.setOurProcessTitle());
    }

}
