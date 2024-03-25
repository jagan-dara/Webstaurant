package Specs

import Common.BaseSpec
import PageObjects.HomePage
import PageObjects.SearchResultsPage
import PageObjects.ShoppingCartPage

class SearchSpec extends BaseSpec{


    void verifySearchResults(){
        given: "user is at home page"
            HomePage homePage = at HomePage
        when: "user searches for an item"
            homePage.enterSearchTerm("stainless work table")
        then:"user is taken to search results page"
            SearchResultsPage searchResultsPage = at SearchResultsPage
        and: "all search results displayed contain the word table"
            assert searchResultsPage.verifySearchResultDescrition("table")
        when: "user adds the last item displayed to his cart"
            searchResultsPage.navigateLastPage()
            searchResultsPage.addLastItemOnPageToCart()
        then :"item is added to his cart"
            searchResultsPage.clickCartButton()
            ShoppingCartPage shoppingCartPage = at ShoppingCartPage
            assert shoppingCartPage.verifyCartIsNotEmpty()
        when: "user empties the cart"
            shoppingCartPage.clickEmptyCartButton()
        and: "user clicks on the empty cart modal"
            shoppingCartPage.emptyCartModule.clickEmptyCartModalButton()
        then: "shopping cart is empty"
            assert shoppingCartPage.verifyCartIsEmpty()
   }

}
