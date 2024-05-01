package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utilities.SeleniumUtilities;

import java.util.List;

public class AccountPage extends SeleniumUtilities {
    public AccountPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/a[1]")
    public WebElement accountBtn;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/div/div[2]/div/div/div[3]/select/option[1]")
    public WebElement default5Row;

    @FindBy(xpath = "//tr[@class= 'css-0']")
    public List<WebElement> recordPage;

    public int countRecordPage() {
        return recordPage.size();
    }

}
