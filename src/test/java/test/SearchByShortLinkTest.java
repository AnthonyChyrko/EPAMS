package test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import test.AbstractTest;
import util.LinkKey;

public class SearchByShortLinkTest extends AbstractTest {

	@BeforeGroups(groups = { "search" })
	public void setUpSearchLinks() {
		for (Map<LinkKey, String> map : links) {
			String longLink = map.get(LinkKey.LONG_LINK);
			mainPage.createShortLink(longLink);
		}
	}


	@Test(groups = "search")
	public void test_searchByShortLink() {
		String linkNameForSearch = mainPage.searchByShortLinkName();
		Assert.assertTrue(mainPage.isSameLinkFoundBySearch(linkNameForSearch));
	}

	@Test(groups = "search_appear_link")
	public void test_searchByShortLink_OneLinkAppears() {
		Assert.assertEquals(mainPage.checkNumberOflinks(), 1);
	}

	@AfterGroups(groups = { "search_appear_link" })
	public void tearDownSearchLinks() {
		mainPage = mainPage.deleteAllLinks();
	}

}
