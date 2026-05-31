import pytest
from pages.home_page import HomePage


@pytest.mark.usefixtures("driver")
class TestApiDemos:

    def test_home_screen_loads(self, driver):
        """La pantalla principal carga con items en el menu"""
        home = HomePage(driver)
        items = home.get_menu_items()

        assert len(items) > 0, "El menu no deberia estar vacio"
        print(f"\nItems encontrados: {items}")

    def test_views_section_exists(self, driver):
        """La seccion Views existe en el menu principal"""
        home = HomePage(driver)

        assert home.is_item_present("Views"), \
            "'Views' deberia estar en el menu principal"
        print("\nSeccion Views encontrada")

    def test_navigate_to_accessibility(self, driver):
        """Tap en Accessibility navega a la pantalla correcta"""
        home = HomePage(driver)
        home.tap_on_item("Accessibility")

        page_source = driver.page_source
        assert "Accessibility" in page_source, \
            "Deberia estar en la pantalla de Accessibility"
        print("\nNavegacion a Accessibility exitosa")
