package PageObjects

import Common.BasePage
import geb.Page
import org.openqa.selenium.By

class HomePage extends Page{
    static  at = {
        getTitle() == "WebstaurantStore: Restaurant Supplies & Foodservice Equipment"
    }
    static content = {
//        select by id
//        searchField                 {$("#searchval")}
//        select by test-dataid
        searchField                 {$('[data-testid="searchval"]')}
//        searchButton                { By.xpath('//*[@id="searchForm"]/div/button')}
        searchButton                {$("button[type=submit][value=Search]")}
    }

    void enterSearchTerm(String searchTerm){
        searchField[0].click()
        searchField[0] << searchTerm
        searchButton.first().click()
    }
}
