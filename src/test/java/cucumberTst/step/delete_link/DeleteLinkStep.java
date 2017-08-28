package cucumberTst.step.delete_link;

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

public class DeleteLinkStep extends AbstractStep {
    private final static Logger logger = Logger.getLogger(DeleteLinkStep.class);

    @Given("^three different shortlink")
    public void createThreeDiffShortlinks(DataTable arg) {
        logger.info("Create three links");
        List<Map<String, String>> table = arg.asMaps(String.class, String.class);
        mainPage.createShortLink(table.get(0).get("shortlink"), table.get(0).get("longlink"));
        mainPage.createShortLink(table.get(1).get("shortlink"), table.get(1).get("longlink"));
        mainPage.createShortLink(table.get(2).get("shortlink"), table.get(2).get("longlink"));
    }

    @When("click on the checkbox \"select all links\"")
    public void clickCheckboxDeleteAllLinks() {
        logger.info("User click on checkbox \"Delete All Links\"");
        mainPage.selectAllLinks();
    }

    @When("delete the first link")
    public void deleteAllLinks() {
        logger.info("User click on checkbox \"Delete All Links\"");
        mainPage.deleteNotAllLinks();
    }

    @And("^press button \"Delete selected links\"$")
    public void clickButtonDeleteAllLinks() {
        logger.info("User click \"Delete All links\" button");
        mainPage.clickButtonDeleteAllLinks();
    }

    @And("^press button \"Delete\" on pop up")
    public void clickDeleteButtonOnPopUp() {
        logger.info("User click \"Delete\" button on pop up");
        mainPage.clickDeleteOnPopUp();
    }

    @Then("list of links is empty")
    public void isEmptyListOfLink() {
        int numberOfLinks = mainPage.checkNumberOflinks();
        logger.info("checkNumberOflinks \"" + numberOfLinks + "\"");
        Assert.assertTrue(numberOfLinks == 0);
    }

    @Then("check \"([^\"]*)\" of links")
    public void numberOfLinks(int exp) {
        int numberOfLinks = mainPage.checkNumberOflinks();
        logger.info("checkNumberOflinks \"" + numberOfLinks + "\"");
        Assert.assertEquals(numberOfLinks, exp);
        mainPage.deleteAllLinks();
    }

}
