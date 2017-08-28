package page;

import element.LabelElement;

import java.io.IOException;

public class EpamsLoginPage {
    private final String AUTOIT_FOR_CHROME = "src/test/resources/logforchrome.exe";

    public EpamsMainPage logIn(){

        LabelElement siteLogoElement = new LabelElement(EpamsMainPage.SITE_LOGO_LOCATOR);
        if (siteLogoElement.isPresent(5)){
            return new EpamsMainPage();
        }else {

        }

        return new EpamsMainPage();
    }
}
