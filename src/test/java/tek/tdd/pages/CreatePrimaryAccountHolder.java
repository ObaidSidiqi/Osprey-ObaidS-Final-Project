package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utilities.SeleniumUtilities;

public class CreatePrimaryAccountHolder extends SeleniumUtilities {

    public CreatePrimaryAccountHolder (){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/h2")
    public WebElement CreatePrimaryAccountHolderTitle;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/form/div/div[2]/button[1]")
    public WebElement CreateAccountButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/form/div/div[2]/button[2]")
    public WebElement ClearFormButton;


    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement EmailAddress;

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    public WebElement FirstName;

    @FindBy(xpath = "//*[@id=\"lastName\"]")
    public WebElement LastName;


    @FindBy(xpath = "  //*[@id=\"dateOfBirth\"]")
    public WebElement DateOfBirth;


    //Sign Up Your Account Page within Create Primary Account Holder Page
    @FindBy(css = "#field-\\:r2e\\:-label")
    public WebElement SignUpYourAccount;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/h2[3]")
    public WebElement EmailAddressDisplayedIn2ndPage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/form/div[1]")
    public WebElement SignUpPageErrorMessage;

    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement UserName;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement Password;

    @FindBy(xpath = "//*[@id=\"confirm\"]")
    public WebElement ConfirmPassword;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/form/div/div[4]/button[1]")
    public WebElement SubmitBtnIn2ndStageOfSigningUp;




}



