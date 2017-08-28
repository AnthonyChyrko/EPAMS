package cucumberTst.step.search_link;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberTst.step.AbstractStep;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class SearchLinkStep extends AbstractStep {
    private final static Logger logger = Logger.getLogger(SearchLinkStep.class);
    @Given("^remove all created links$")
    public void removeAllCreatedLinks() {
        mainPage = mainPage.deleteAllLinks();
    }
    @Given("^three different shortlink")
    public void createThreeDiffShortlinks(DataTable arg) {
        logger.info("Create three links");
        List<Map<String, String>> table = arg.asMaps(String.class, String.class);
        mainPage.createShortLink(table.get(0).get("shortlink"), table.get(0).get("longlink"));
        mainPage.createShortLink(table.get(1).get("shortlink"), table.get(1).get("longlink"));
        mainPage.createShortLink(table.get(2).get("shortlink"), table.get(2).get("longlink"));
    }

    @When("user enter last created \"([^\"]*)\" in search field")
    public void enterShortlinkForSearch(String shortlink) {
        logger.info("User enter \"" + shortlink + "\" in search field");
        mainPage.enterLinkForSearch(shortlink);
    }

    @And("^click search button")
    public void clickSearchButton() {
        logger.info("User click \"Search\" button");
        mainPage.clickSearchButton();
    }

//    @Then("the required \"([^\"]*)\" is displayed in the list of references")
//    public void isDisplayedRequiredLink(String shortlink) {
//        logger.info("isDisplayedRequiredLink \"" + shortlink + "\"");
//        boolean state = mainPage.isSameLinkFoundBySearch(shortlink);
//        System.out.println(state);
//        Assert.assertTrue(state);
//    }

    @Then("a new \"([^\"]*)\" leads to the correct page \"([^\"]*)\"")
    public void shortLinkDirectsToFullLinkAddress(String shortlink, String longlink) {
        logger.info("Shortlink \"" + shortlink + "\" leads to \"" + longlink + "\"");
        mainPage.selectFilter("Created descending");
        String url = mainPage.getLinkTabURL();
        Assert.assertEquals(url, longlink);
        logger.info("Delete all created shortlinks");
        mainPage.deleteAllLinks();
    }

}
