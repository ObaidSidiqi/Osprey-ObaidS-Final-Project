package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utilities.SeleniumUtilities;

public class UserProfile extends SeleniumUtilities {
    public UserProfile(){
        PageFactory.initElements(getDriver(),this);
    };


    @FindBy(css = "#root > div > div.css-175rvmj > div > button")
    public WebElement profileBtn;


    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/div/div/div/div[3]/p[2]")
    public WebElement fullName;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/div/div/div/div[4]/p[2]")
    public WebElement userName;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/div/div/div/div[5]/ul/li")
    public WebElement authorities;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/header")
    public WebElement profile;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/a[2]")
    public WebElement planBtn;




}
