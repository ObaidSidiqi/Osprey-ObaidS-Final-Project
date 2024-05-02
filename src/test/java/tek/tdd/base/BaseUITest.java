package tek.tdd.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tek.tdd.pages.*;
import tek.tdd.utilities.SeleniumUtilities;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tek.tdd.utilities.SeleniumUtilities;

import java.time.LocalDate;

@Listeners({ExtentITestListenerAdapter.class})
public class BaseUITest extends SeleniumUtilities {
    public HomePage homePage;
    public CreatePrimaryAccountHolder createPrimaryAccountHolder;
    public LoginPage loginPage;
    public AccountPage accountPage;
    public UserProfile userProfile;
    public PlanPage planPage;




    @BeforeMethod
    public void initiateTestMethod(){
        super.openBrowser();
       homePage = new HomePage();
       createPrimaryAccountHolder = new CreatePrimaryAccountHolder();
       loginPage = new LoginPage();
       accountPage= new AccountPage();
       userProfile= new UserProfile();
       planPage= new PlanPage();

    }

    @AfterMethod
    public void endTestMethod (ITestResult result) throws InterruptedException {
        // Thread.sleep(20000);
        if(result.getStatus()== ITestResult.FAILURE){
            TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
            String screenShot = takesScreenshot.getScreenshotAs(OutputType.BASE64);
            ExtentTestManager.getTest().fail("Test Failed Taking Screen Shot"
                    , MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
        }
        super.quitBrowser();
    }





}
