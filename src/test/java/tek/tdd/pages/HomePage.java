package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utilities.SeleniumUtilities;

public class HomePage extends SeleniumUtilities {

    public HomePage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/h2")
    public WebElement topNavLogo;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/a")
    public WebElement createPrimaryAccount;
    @FindBy (css = "#root > div > div.css-175rvmj > div > a.chakra-button.css-ez23ye")
    public WebElement loginBtn;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/h2")
    public WebElement createPrimaryAccountHolderTitle;
}
