package PageObjects

import Common.BasePage

class HomePage extends BasePage {
    static at = {
        getTitle() == "WebstaurantStore: Restaurant Supplies & Foodservice Equipment"
    }
    static content = {
        searchField(wait: true) { $('[data-testid="searchval"]') }
        searchButton(wait: true) { $("button[type=submit][value=Search]") }
    }

    void enterSearchTerm(String searchTerm) {
        searchField[0] << searchTerm
        clickSearchButton()
    }

    void clickSearchButton() {
        searchButton.first().click()
    }
}
