package tek.tdd.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITest;



public class Login extends BaseUITest {

    @Test
    public void loginWithValidCredential() throws InterruptedException {
        tek.tdd.pages.HomePage homePage = new tek.tdd.pages.HomePage();
        tek.tdd.pages.LoginPage loginPage = new tek.tdd.pages.LoginPage();

        ClickOnElement(homePage.loginBtn);
        waitForClickable(loginPage.userName);
        ClickOnElement(loginPage.userName);
        sendText(loginPage.userName, "supervisor");
        waitForClickable(loginPage.userPassword);
        ClickOnElement(loginPage.userPassword);
        sendText(loginPage.userPassword, "tek_supervisor");
        ClickOnElement(loginPage.signInBtnSignInPage);

        boolean isCustomerServicePortalTitleDisplayedAfterLogin = isElementDisplayed(loginPage.customerServicePortalText);
        Assert.assertTrue(isCustomerServicePortalTitleDisplayedAfterLogin,
                "User should be able to validate login page");
    }

    @Test
    public void loginWithWrongUserNameAndValidPassword()throws InterruptedException{
        tek.tdd.pages.HomePage homePage = new tek.tdd.pages.HomePage();
        tek.tdd.pages.LoginPage loginPage = new tek.tdd.pages.LoginPage();

        Thread.sleep(2000);
        ClickOnElement(homePage.loginBtn);
        Thread.sleep(2000);
        waitForClickable(loginPage.userName);
        ClickOnElement(loginPage.userName);
        sendText(loginPage.userName, "WrongSupervisor");
        Thread.sleep(500);
        waitForClickable(loginPage.userPassword);
        ClickOnElement(loginPage.userPassword);
        sendText(loginPage.userPassword, "tek_supervisor");
        Thread.sleep(500);
        ClickOnElement(loginPage.signInBtnSignInPage);

        String expectedErrorMessage = "User WrongSupervisor not found";
        String actualMessage = getElementText(loginPage.errorMessageForWrongCredentials);
        String  withOutError = actualMessage.replace("ERROR", "").trim();
        Assert.assertEquals(withOutError,expectedErrorMessage, "Remove ERROR from your message");

    }
    @Test
    public void loginWithWrongPasswordAndValidUserName()throws InterruptedException{
        tek.tdd.pages.HomePage homePage = new tek.tdd.pages.HomePage();
        tek.tdd.pages.LoginPage loginPage = new tek.tdd.pages.LoginPage();
        //Thread.sleep(500);
        ClickOnElement(homePage.loginBtn);
        //Thread.sleep(2000);
        waitForClickable(loginPage.userName);
        ClickOnElement(loginPage.userName);
        sendText(loginPage.userName, "supervisor");
        //Thread.sleep(500);
        waitForClickable(loginPage.userPassword);
        ClickOnElement(loginPage.userPassword);
        sendText(loginPage.userPassword, "WrongTek_supervisor");
       // Thread.sleep(500);
        ClickOnElement(loginPage.signInBtnSignInPage);

        String expectedErrorMessage = "Password not matched";
        String actualErrorMessage = getElementText(loginPage.errorMessageForWrongCredentials);
        System.out.println(actualErrorMessage);
        String withOutError = actualErrorMessage.replace("ERROR", "").trim();
        Assert.assertEquals(withOutError,expectedErrorMessage, "Remove ERROR from your message");



    }



    }




