package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    WebDriver webDriver;

    @FindBy(tagName = "h1")
    WebElement title;

    @FindBy(id = "name")
    WebElement nameUser;

    @FindBy(id = "email")
    WebElement emailUser;

    @FindBy(id = "more")
    WebElement descriptionBox;

    @FindBy(xpath = "//button[text()='Send']")
    WebElement sendButton;

    @FindBy(xpath = "//div[text()='Name is required']")
    WebElement alertNameField;

    @FindBy(xpath = "//div[text()='Must be a valid email']")
    WebElement alertMailField;

    @FindBy(xpath = "//div[text()='Received, will get in touch soon!']")
    WebElement successBanner;

    @FindBy(xpath = "//*[@class=\"md:pl-64 appearing appearing-turn-2\"]//*[contains(text(),\"Understanding your needs\")]")
    WebElement ourProcessTitle;

    @FindBy(xpath = "//*[@class=\"border-b border-black/50 cursor-pointer duration-500 pl-14 pt-7 relative transition-all last:border-b-0 pb-0\"]")
    WebElement expandElement;

    public LandingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean titleDisplayed() {
        title.isDisplayed();
        return true;
    }

    public void enterUserNameField(String name) {
        nameUser.sendKeys(name);
    }

    public void enterEmailField(String userEmail) {
        emailUser.sendKeys(userEmail);
    }

    public void enterDescriptionProject(String description) {
        descriptionBox.sendKeys(description);
    }

    public void clickSendInfo() {
        sendButton.click();
    }

    public boolean textNameAlert() {
        alertNameField.isDisplayed();
        return true;
    }

    public boolean textMailAlert() {
        alertMailField.isDisplayed();
        return true;
    }

    public boolean successBannerDisplayed() {
        successBanner.isDisplayed();
        return true;
    }

    public boolean setOurProcessTitle() {
        ourProcessTitle.isDisplayed();
        return true;
    }

    public void scrollIntoView() {
        Actions actions = new Actions(webDriver);
        actions.scrollToElement(ourProcessTitle);
        System.out.println(ourProcessTitle.getText());
    }

    public void clickAccording() {
        expandElement.click();
    }

}
