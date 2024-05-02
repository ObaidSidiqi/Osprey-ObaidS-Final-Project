package tek.tdd.utilities;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import tek.tdd.base.BaseSetup;
import java.time.Duration;




public class SeleniumUtilities extends BaseSetup {

    private static final Logger LOGGER = LogManager.getLogger(SeleniumUtilities.class);

    public WebDriverWait getWait(){
        return new WebDriverWait(getDriver(),Duration.ofSeconds(20));
    }
    public WebElement waitForVisibility(WebElement element){
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickable(WebElement element){
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public void selectDropdownByVisibleText(By locator, String visibleText) {
        WebElement dropdownElement = getDriver().findElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    // Click
    public void ClickOnElement(WebElement element) {
        LOGGER.info("Click on element {}", element);
        waitForClickable(element).click();
    }


    public void sendText (WebElement element, String textValue){
        LOGGER.info("Send key to element {} with value {} ",element, textValue);
        waitForVisibility(element).sendKeys(textValue);
    }

    public boolean isElementDisplayed (WebElement element){

        LOGGER.info("Checking element is displayed {}", element);
        return waitForVisibility(element).isDisplayed();
    }

    public boolean isElementEnabled(WebElement element){
        return waitForVisibility(element).isEnabled();
    }

    public String getElement(WebElement element){
       return waitForVisibility(element).getText();
    }
    public void selectFromDropDown (WebElement element, String visibleText)
    { WebElement selectElement=waitForVisibility(element);
    }
    public String getElementText(WebElement element){
        LOGGER.info("Getting Element Text" + element);
        return waitForVisibility(element).getText();
    }

}
