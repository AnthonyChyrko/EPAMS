package test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import test.AbstractTest;
import util.LinkKey;

public class DeleteNotAllLinksTest extends AbstractTest {

	@BeforeGroups(groups = { "delete_not_all" })
	public void setUpDeleteLinks() {
		for (Map<LinkKey, String> map : links) {
			String longLink = map.get(LinkKey.LONG_LINK);
			mainPage.createShortLink(longLink);
		}
	}


	@Test(groups = "delete_not_all")
	public void test_deleteNotAllLinks() {
		mainPage = mainPage.deleteNotAllLinks();
		Assert.assertEquals(mainPage.checkNumberOflinks(), 1);
	}

	@AfterGroups(groups = { "delete_not_all" })
	public void tearDownDeleteLinks() {
		mainPage = mainPage.deleteAllLinks();
	}

}
