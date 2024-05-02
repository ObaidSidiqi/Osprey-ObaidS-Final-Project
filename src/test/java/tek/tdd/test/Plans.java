package tek.tdd.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITest;
import tek.tdd.pages.PlanPage;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Plans  extends BaseUITest {

    /*

        Navigate to Customer Service Portal with valid CSR credentials and navigate to Plans Page.
        Validate 4 row of data is present.
     */

    @Test
    public void validate4RowOfDataIsPresentInPlanPage()
    throws InterruptedException{
 String todaysPricePlanText = "Today's Plans Price";
        waitForClickable(homePage.loginBtn).click();
        // ClickOnElement(homePage.loginBtn);
        waitForClickable(loginPage.userName).click();
        sendText(loginPage.userName, "supervisor");
        waitForClickable(loginPage.userPassword).click();
        sendText(loginPage.userPassword, "tek_supervisor");
        ClickOnElement(loginPage.signInBtnSignInPage);
        Thread.sleep(1000);
        ClickOnElement(userProfile.planBtn);
        Thread.sleep(1000);

        String actualTodaysPricePlanText = getElementText(planPage.todaysPlanPriceTxt);
        Assert.assertEquals(todaysPricePlanText, actualTodaysPricePlanText);

        boolean is1stRowPresent = isElementDisplayed(planPage.motorcycleRow);
        boolean is2ndRowPresent = isElementDisplayed(planPage.boatRow);
        boolean is3rdRowPresent = isElementDisplayed(planPage.autoRow);
        boolean is4rdRowPresent = isElementDisplayed(planPage.rentersRow);

    }

    @Test
    public void validateCreateDateInPlanPageIsToday() throws InterruptedException{
          /*
    Navigate to Customer Service Portal with valid CSR credentials and navigate to Plans Page.
    Then validate Create Date is todays date in (EST Time zone) and Date Expire is a day after (EST Time Zone)
     */

        String todaysPricePlanText = "Today's Plans Price";
        waitForClickable(homePage.loginBtn).click();
        // ClickOnElement(homePage.loginBtn);
        waitForClickable(loginPage.userName).click();
        sendText(loginPage.userName, "supervisor");
        waitForClickable(loginPage.userPassword).click();
        sendText(loginPage.userPassword, "tek_supervisor");
        ClickOnElement(loginPage.signInBtnSignInPage);
        Thread.sleep(1000);
        ClickOnElement(userProfile.planBtn);
        Thread.sleep(1000);

        String actualTodaysPricePlanText = getElementText(planPage.todaysPlanPriceTxt);
        Assert.assertEquals(todaysPricePlanText, actualTodaysPricePlanText);

        String actualDateOnThePage = getElementText(planPage.dateCreatedOfMotorcycle);
        String actualExpDateOnThePage = getElementText(planPage.dateExpiredOfMotorcycle);


        LocalDate today = LocalDate.now(ZoneId.of("America/New_York"));
        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        // Formating the date using the defined formatter
        String formattedDate = today.format(formatter);
        LocalDate tomorrow = today.plusDays(1);
        String formattedDateOfTmrw = tomorrow.format(formatter);
        Assert.assertEquals(actualDateOnThePage,formattedDate);
        Assert.assertEquals(actualExpDateOnThePage,formattedDateOfTmrw);
    }



}
