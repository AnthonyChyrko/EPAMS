package cucumberTst.step.edit_link;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberTst.step.AbstractStep;
import org.testng.Assert;
import util.DateGenerator;

/**
 * Created by Artur_Barkou on 8/24/2017.
 */
public class EditLinkStep extends AbstractStep {

    private String date="";

    public String getDate(){

        if(date.equals("")){
            date = new DateGenerator().getTomorrowDay();
            return date;
        }
      return date;
    }

    @Given("^short link with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void createShortLink(String originalShortlink, String originalLongLink) {
        mainPage.createShortLink(originalShortlink, originalLongLink);
    }
    @Given("^remove all created links$")
    public void removeAllCreatedLinks() {
        mainPage = mainPage.deleteAllLinks();
    }

    @When("^open edit pop-up, replace old name on short link \"([^\"]*)\" with \"([^\"]*)\"$")
    public void editShortLinkNameWithPositiveData(String oldShortLink, String newShortLink){
        mainPage.editShortLink(oldShortLink, newShortLink);
    }
    @When("^open edit pop-up, replace old name on long link \"([^\"]*)\" with \"([^\"]*)\"$")
    public void editLongLinkNameWithPositiveData(String oldLongLink, String newLongLink){
        mainPage.editLongLink(oldLongLink, newLongLink);
    }
    @When("^open edit pop-up, change expiration date of \"([^\"]*)\"$")
    public void editExpirationDateWithPositiveData(String shortLink){
        mainPage.editExpirationDate(shortLink, getDate());
    }
    @Then("^short link name is changed to \"([^\"]*)\" by long link \"([^\"]*)\"$")
    public void assertShortLinkMatchesLongLink(String newShortLink, String longLink){
        Assert.assertTrue(mainPage.isShortLinkMatchesLongLink(newShortLink, longLink));
    }

    @Then("^long link name is changed and presents \"([^\"]*)\"$")
    public void assertLongLinkPresent(String newLonglink){
        Assert.assertTrue(mainPage.isLongLinkPresent(newLonglink));
    }

    @Then("^expiration date of \"([^\"]*)\" is changed$")
    public void assertExpirationDateChanged(String shortLink){
        Assert.assertTrue(mainPage.isExpirationDateCorrect(shortLink, getDate()));
    }

}
