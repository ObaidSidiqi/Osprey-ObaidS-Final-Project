package tek.tdd.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITest;
import tek.tdd.pages.AccountPage;

public class Accounts extends BaseUITest {


    @Test
    public void verify5RowIsDefault () throws InterruptedException{

        //   Navigate to Customer Service Portal with valid CSR credentials
        //   and navigate to Accounts verify 5 row /page is default

        tek.tdd.pages.HomePage homePage = new tek.tdd.pages.HomePage();
        tek.tdd.pages.LoginPage loginPage = new tek.tdd.pages.LoginPage();
        tek.tdd.pages.AccountPage accountPage = new tek.tdd.pages.AccountPage();

        String ExptRowNo = "Show 5";

        waitForClickable(homePage.loginBtn).click();
        // ClickOnElement(homePage.loginBtn);
        waitForClickable(loginPage.userName).click();
        sendText(loginPage.userName, "supervisor");
        waitForClickable(loginPage.userPassword).click();
        sendText(loginPage.userPassword, "tek_supervisor");
        ClickOnElement(loginPage.signInBtnSignInPage);
        Thread.sleep(1000);

        ClickOnElement(accountPage.accountBtn);
        Thread.sleep(1000);


        String actualDefaultRowNo = (getElementText(accountPage.default5Row));
        Assert.assertEquals(actualDefaultRowNo, ExptRowNo);
        
    }

    /*
    Navigate to Customer Service Portal with valid CSR credentials
    and navigate to Accounts change show per page to 10, 25, 50 and validate table
    records per page according to selected show per page.
     */

    @Test
    public void changeTablesTo10()throws InterruptedException{
        tek.tdd.pages.HomePage homePage = new tek.tdd.pages.HomePage();
        tek.tdd.pages.LoginPage loginPage = new tek.tdd.pages.LoginPage();
        tek.tdd.pages.AccountPage accountPage = new tek.tdd.pages.AccountPage();

        waitForClickable(homePage.loginBtn).click();
        // ClickOnElement(homePage.loginBtn);
        waitForClickable(loginPage.userName).click();
        sendText(loginPage.userName, "supervisor");
        waitForClickable(loginPage.userPassword).click();
        sendText(loginPage.userPassword, "tek_supervisor");
        ClickOnElement(loginPage.signInBtnSignInPage);
        Thread.sleep(1000);

        ClickOnElement(accountPage.accountBtn);
        Thread.sleep(1000);

        selectDropdownByVisibleText(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div[2]/div/div/div[3]/select"),"Show 10");


        int recordCounting = accountPage.countRecordPage();
        recordCounting--;
        int actualRecordNo = recordCounting;
        int expectedRecordNo = 10;
        Assert.assertEquals(actualRecordNo, expectedRecordNo);
    }



        @Test
    public void changeTables25()throws InterruptedException{
        tek.tdd.pages.HomePage homePage = new tek.tdd.pages.HomePage();
        tek.tdd.pages.LoginPage loginPage = new tek.tdd.pages.LoginPage();
        tek.tdd.pages.AccountPage accountPage = new tek.tdd.pages.AccountPage();

        waitForClickable(homePage.loginBtn).click();
        // ClickOnElement(homePage.loginBtn);
        waitForClickable(loginPage.userName).click();
        sendText(loginPage.userName, "supervisor");
        waitForClickable(loginPage.userPassword).click();
        sendText(loginPage.userPassword, "tek_supervisor");
        ClickOnElement(loginPage.signInBtnSignInPage);
        Thread.sleep(1000);

        ClickOnElement(accountPage.accountBtn);
        Thread.sleep(1000);

        selectDropdownByVisibleText(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div[2]/div/div/div[3]/select"),"Show 25");


        int recordCounting = accountPage.countRecordPage();
        recordCounting--;
        int actualRecordNo = recordCounting;
        int expectedRecordNo = 25;
        Assert.assertEquals(actualRecordNo, expectedRecordNo);
    }

    @Test
    public void changeTables50()throws InterruptedException{
        tek.tdd.pages.HomePage homePage = new tek.tdd.pages.HomePage();
        tek.tdd.pages.LoginPage loginPage = new tek.tdd.pages.LoginPage();
        tek.tdd.pages.AccountPage accountPage = new tek.tdd.pages.AccountPage();

        waitForClickable(homePage.loginBtn).click();
        // ClickOnElement(homePage.loginBtn);
        waitForClickable(loginPage.userName).click();
        sendText(loginPage.userName, "supervisor");
        waitForClickable(loginPage.userPassword).click();
        sendText(loginPage.userPassword, "tek_supervisor");
        ClickOnElement(loginPage.signInBtnSignInPage);
        Thread.sleep(1000);

        ClickOnElement(accountPage.accountBtn);
        Thread.sleep(1000);

        selectDropdownByVisibleText(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div[2]/div/div/div[3]/select"),"Show 50");


        int recordCounting = accountPage.countRecordPage();
        recordCounting--;
        int actualRecordNo = recordCounting;
        int expectedRecordNo = 50;
        Assert.assertEquals(actualRecordNo, expectedRecordNo);
    }





    }





