package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utilities.SeleniumUtilities;

public class PlanPage extends SeleniumUtilities {

    public PlanPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy (xpath = "/html/body/div[1]/div/div[3]/div/div/div/h2")
    public WebElement todaysPlanPriceTxt;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/div/div/table/tbody/tr[1]/td[4]" )
    public WebElement dateCreatedOfMotorcycle;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/div/div/table/tbody/tr[1]/td[5]" )
    public WebElement dateExpiredOfMotorcycle;


    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/div/div/table/tbody/tr[1]")
    public WebElement motorcycleRow;


    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/div/div/table/tbody/tr[2]")
    public WebElement boatRow;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/div/div/table/tbody/tr[3]")
    public WebElement rentersRow;


    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/div/div/table/tbody/tr[4]")
    public WebElement autoRow;



}
