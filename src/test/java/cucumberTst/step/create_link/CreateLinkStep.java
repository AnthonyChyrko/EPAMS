package cucumberTst.step.create_link;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberTst.step.AbstractStep;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class CreateLinkStep extends AbstractStep {
    private final static Logger logger = Logger.getLogger(CreateLinkStep.class);

    @Given("^an open browser with ([^\\s]*)$")
    public void navigateToMainPage(String url) {
        logger.info("Open browser on page " + url);
    }

    @When("enter longlink with text \"([^\"]*)\"$")
    public void userEnterLongLink(String longLink) {
        logger.info("User enter longlink \"" + longLink + "\"");
        mainPage.enterLonglink(longLink);
    }

    @When("enter shortlink with text \"([^\"]*)\"$")
    public void userEnterShortLink(String shortLink) {
        logger.info("User enter shortlink \"" + shortLink + "\"");
        mainPage.enterShortlink(shortLink);
    }

    @When("create shortlink with text \"([^\"]*)\" and \"([^\"]*)\"")
    public void createShortLink(String longlink, String shortlink) {
        logger.info("User create shortlink \"" + shortlink + "\" for \"" + longlink + "\"");
        mainPage.createShortLink(shortlink, longlink);
    }

    @And("^press button with text \"([^\"]*)\"$")
    public void userClickSubmitButtons(String submit) {
        logger.info("User click submit button");
        mainPage.clickSubmitButton();
    }

    @And("^repeat")
    public void stub() {
    }

    @Then("appears hint with text \"([^\"]*)\"$")
    public void appearsHint(String hint) {
        logger.info("Appears \"" + hint + "\"");
        Assert.assertTrue(mainPage.isHintForLinks(hint));
    }

    @Then("a new \"([^\"]*)\" appears in the general list of links")
    public void newLinkPresent(String longlink) {
        logger.info("New shortlink \"" + longlink + "\" is present");
        Assert.assertTrue(mainPage.isLongLinkPresent(longlink));
        logger.info("Delete all created shortlinks");
        mainPage.deleteAllLinks();
    }

    @Then("server return error")
    public void serverReturnError() {
        logger.info("Server return error");
        Assert.assertTrue(mainPage.isServerReturnedError());
        logger.info("Delete all created shortlinks");
        mainPage.deleteAllLinks();
    }

    @Then("a new \"([^\"]*)\" is matches \"([^\"]*)\"")
    public void isShortLinkMatchesLongLink(String shortlink, String longlink) {
        logger.info("Shortlink \"" + shortlink + "\" is matches \"" + longlink + "\"");
        Assert.assertTrue(mainPage.isShortLinkMatchesLongLink(shortlink, longlink));
        logger.info("Delete all created shortlinks");
        mainPage.deleteAllLinks();
    }

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
