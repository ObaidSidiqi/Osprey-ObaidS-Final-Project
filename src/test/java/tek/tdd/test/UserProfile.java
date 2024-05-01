package tek.tdd.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITest;

public class UserProfile extends BaseUITest {


    /*
    Navigate to login and enter valid CSR credentials
    and navigate to Customer Service Portal then click on profile button validate
    information is in Profile Side Drawer is correct.
     */

    @Test
    public void validateInformationOnCustomerServiceLoginPage()
            throws InterruptedException{
        tek.tdd.pages.HomePage homePage = new tek.tdd.pages.HomePage();
        tek.tdd.pages.LoginPage loginPage = new tek.tdd.pages.LoginPage();
        tek.tdd.pages.UserProfile userProfile = new tek.tdd.pages.UserProfile();

        String fullName = "Supervisor";
        String userName = "supervisor";
        String authorities = "admin";
        String profileTxt = "Profile";



        waitForClickable(homePage.loginBtn).click();
       // ClickOnElement(homePage.loginBtn);
        waitForClickable(loginPage.userName).click();
        sendText(loginPage.userName, "supervisor");
        waitForClickable(loginPage.userPassword).click();
        sendText(loginPage.userPassword, "tek_supervisor");
        ClickOnElement(loginPage.signInBtnSignInPage);


        Thread.sleep(3000);

        ClickOnElement(userProfile.profileBtn);
        Thread.sleep(1000);


      // waitForClickable(userProfile.profileBtn).click();
        boolean isProfileDisplayed = isElementDisplayed(userProfile.profile);
        Assert.assertTrue(isProfileDisplayed,"Profile is not displayed");

        String actualProfileText = getElementText(userProfile.profile);
        String actualAuthorities = getElementText(userProfile.authorities);
        String actualUserName = getElementText(userProfile.userName);
        String actualFullName = getElementText(userProfile.fullName);
        Assert.assertEquals(actualProfileText, profileTxt);
        Assert.assertEquals(actualAuthorities,authorities);
        Assert.assertEquals(actualFullName,fullName);
        Assert.assertEquals(actualUserName, userName);
    }
}