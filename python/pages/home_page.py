from appium.webdriver.common.appiumby import AppiumBy


class HomePage:

    _MENU_ITEMS = (AppiumBy.CLASS_NAME, "android.widget.TextView")

    def __init__(self, driver):
        self.driver = driver

    def get_menu_items(self) -> list:
        elements = self.driver.find_elements(*self._MENU_ITEMS)
        return [el.text for el in elements if el.text]

    def tap_on_item(self, text: str) -> None:
        elements = self.driver.find_elements(*self._MENU_ITEMS)
        for el in elements:
            if el.text == text:
                el.click()
                return
        raise ValueError(f"Item '{text}' no encontrado en el menu")

    def is_item_present(self, text: str) -> bool:
        return text in self.get_menu_items()
