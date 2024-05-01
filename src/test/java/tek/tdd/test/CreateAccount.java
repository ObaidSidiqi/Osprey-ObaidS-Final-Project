package tek.tdd.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITest;
import tek.tdd.pages.CreatePrimaryAccountHolder;

import java.sql.Driver;


public class CreateAccount extends BaseUITest {
    @Test
    public void TEKInsuranceAppLogo(){
        tek.tdd.pages.HomePage homePage = new tek.tdd.pages.HomePage();
        boolean isDispalyed = isElementDisplayed(homePage.topNavLogo);

        Assert.assertTrue(isDispalyed, "Top left corner Logo should display always ");
    }

    @Test
    public void ValidateCreatePrimaryAccountHolderButton(){
        tek.tdd.pages.HomePage homePage = new tek.tdd.pages.HomePage();
        // Navigate to TEK Insurance App and Validate " Create Primary Account Button"

        boolean isCreatePrimaryAccountEnabled = isElementEnabled(homePage.createPrimaryAccount);
        Assert.assertTrue(isCreatePrimaryAccountEnabled, "Create Primary Account Button is not Enable in Home Page");
    }

    @DataProvider(name = "dataTest")
    private String[][] dataTest(){
        String[][] data = {
                {"AlexJames1@gmail.com","ALex","James","Mr.","Male","single","01/01/1999"},
                {"AlexJames2@gmail.com","ALex","James","Mr.","Male","single","01/01/1999"}
        };
        return data;
    };

    @Test
    public void ValidateCreatePrimaryAccountHolderPage() throws InterruptedException {
        tek.tdd.pages.HomePage homePage = new tek.tdd.pages.HomePage();

        String name = "alex";
        String Email = "AlexFLJ@gmail.com";
        String EmailAddFromSignUpPageForValidation;

        /*
        Navigate to Home page then click on Create Primary Account Button.
        User should navigate to Create Account form page validate Form Title as Expected “Create Primary Account Holder”
         */
        ClickOnElement(homePage.createPrimaryAccount);
        Thread.sleep(500);
        tek.tdd.pages.CreatePrimaryAccountHolder createPrimaryAccountHolder  = new tek.tdd.pages.CreatePrimaryAccountHolder();
        sendText(createPrimaryAccountHolder.EmailAddress,Email);
        sendText(createPrimaryAccountHolder.FirstName,name);
        sendText(createPrimaryAccountHolder.LastName, "James");
        selectDropdownByVisibleText(By.cssSelector("#title"),"Mr.");
        selectDropdownByVisibleText(By.cssSelector("#gender"),"Male");
        selectDropdownByVisibleText(By.cssSelector("#maritalStatus"),"Single");
        sendText(createPrimaryAccountHolder.DateOfBirth, "01/01/1999");
        ClickOnElement(createPrimaryAccountHolder.CreateAccountButton);
        Thread.sleep(500);

       // boolean isSignUpSuccessfull = isElementDisplayed(createPrimaryAccountHolder.SignUpYourAccount);
        String emailFrom2ndPage = getElementText(createPrimaryAccountHolder.EmailAddressDisplayedIn2ndPage);
        Assert.assertEquals(emailFrom2ndPage,Email);



        //Assert.assertTrue(isSignUpSuccessfull, "Create Primary Account Button is not Enable in Home Page");


    }

    @Test(dataProvider = "dataTest")
    public void CreatePrimaryAccountWithExistingEmailAndValidateErrorMessage(

            String email,
            String firstName,
            String lastName,
            String title,
            String gender,
            String maritalStatus,
            String DateOfBirth


    ) throws InterruptedException {

        tek.tdd.pages.HomePage homePage = new tek.tdd.pages.HomePage();
        tek.tdd.pages.CreatePrimaryAccountHolder createPrimaryAccountHolder  = new tek.tdd.pages.CreatePrimaryAccountHolder();
        /*
      Create account with existing email address and validate error message as expected
         */
        ClickOnElement(homePage.createPrimaryAccount);
        sendText(createPrimaryAccountHolder.EmailAddress, email);
        sendText(createPrimaryAccountHolder.FirstName,firstName);
        sendText(createPrimaryAccountHolder.LastName,lastName);
        selectDropdownByVisibleText(By.cssSelector("#title"),title);
        selectDropdownByVisibleText(By.cssSelector("#gender"),gender);
        selectDropdownByVisibleText(By.cssSelector("#maritalStatus"),maritalStatus);
        sendText(createPrimaryAccountHolder.DateOfBirth, DateOfBirth);
        ClickOnElement(createPrimaryAccountHolder.CreateAccountButton);
        Thread.sleep(2000);
        boolean isSignUpUnSuccessful = isElementDisplayed(createPrimaryAccountHolder.SignUpPageErrorMessage);
        Assert.assertTrue(isSignUpUnSuccessful, "Create Primary Account Button is not Enable in Home Page");

    }



}
