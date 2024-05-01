package tek.tdd.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITest;

public class HomePage extends BaseUITest {
    @Test
    public void TEKInsuranceAppLogo(){
        boolean isDispalyed = isElementDisplayed(homePage.topNavLogo);
        Assert.assertTrue(isDispalyed, "Top left corner Logo should display always ");
    }
    @Test
    public void ValidateCreatePrimaryAccountHolderButton(){
            // Navigate to TEK Insurance App and Validate " Create Primary Account Button"
       boolean isCreatePrimaryAccountEnabled = isElementEnabled(homePage.createPrimaryAccount);
       Assert.assertTrue(isCreatePrimaryAccountEnabled, "Create Primary Account Button is not Enable in Home Page");
    }
    @Test
    public void ValidateCreatePrimaryAccountHolderPage(){
         /*
        Navigate to Home page then click on Create Primary Account Button.
        User should navigate to Create Account form page validate Form Title as Expected “Create Primary Account Holder”
         */
        String ExpText = "Create Primary Account Holder";
        ClickOnElement(homePage.createPrimaryAccount);
       String Title =  getElementText(homePage.createPrimaryAccountHolderTitle);
        Assert.assertEquals(Title,ExpText,"The title is not matching!");
    }
}
