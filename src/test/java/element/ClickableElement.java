package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.Driver;
import element.BaseElement;

public class ClickableElement extends BaseElement {

    public ClickableElement(By locator) {
        super(locator);
    }

    public ClickableElement(WebElement element) {
        super(element);
    }

    public void click() {
        init();

        WebDriverWait wait = new WebDriverWait(driver, Driver.getDefaultExplicitWaitTimeout());

        wait.until((ExpectedCondition<Boolean>) driver -> {
            try {
                element.click();
                return true;
            } catch (Exception e) {
                return false;
            }
        });

    }
}
