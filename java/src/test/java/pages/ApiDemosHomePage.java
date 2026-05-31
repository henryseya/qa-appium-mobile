package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ApiDemosHomePage {

    private final AndroidDriver driver;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<WebElement> menuItems;

    public ApiDemosHomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public List<String> getMenuItemTexts() {
        return menuItems.stream()
            .map(WebElement::getText)
            .filter(t -> !t.isEmpty())
            .toList();
    }

    public void tapOnItem(String itemText) {
        menuItems.stream()
            .filter(el -> el.getText().equals(itemText))
            .findFirst()
            .ifPresentOrElse(
                WebElement::click,
                () -> { throw new RuntimeException("Item no encontrado: " + itemText); }
            );
    }

    public boolean isItemPresent(String itemText) {
        return getMenuItemTexts().contains(itemText);
    }
}
