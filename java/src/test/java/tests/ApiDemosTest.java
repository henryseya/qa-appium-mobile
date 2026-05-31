package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ApiDemosHomePage;

import java.util.List;

public class ApiDemosTest extends BaseTest {

    @Test(description = "Verify home screen loads with menu items")
    public void testHomeScreenLoads() {
        ApiDemosHomePage homePage = new ApiDemosHomePage(driver);
        List<String> items = homePage.getMenuItemTexts();
        Assert.assertFalse(items.isEmpty(), "El menu no deberia estar vacio");
        System.out.println("Items encontrados: " + items);
    }

    @Test(description = "Verify Views section exists in main menu")
    public void testViewsSectionExists() {
        ApiDemosHomePage homePage = new ApiDemosHomePage(driver);
        Assert.assertTrue(
            homePage.isItemPresent("Views"),
            "'Views' deberia estar en el menu principal"
        );
        System.out.println("Seccion Views encontrada");
    }

    @Test(description = "Navigate to Accessibility section")
    public void testNavigateToAccessibility() {
        ApiDemosHomePage homePage = new ApiDemosHomePage(driver);
        homePage.tapOnItem("Accessibility");
        String pageSource = driver.getPageSource();
        Assert.assertTrue(
            pageSource.contains("Accessibility"),
            "Deberia estar en la pantalla de Accessibility"
        );
        System.out.println("Navegacion a Accessibility exitosa");
        driver.navigate().back();
    }
}