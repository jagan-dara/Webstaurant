package PageObjects

import Common.BasePage

class SearchResultsPage extends BasePage{
    static  at = {
        getTitle().toString().containsIgnoreCase("- WebstaurantStore")
    }
    static content = {
        searchResults {$('[data-testid="itemDescription"]')}
        paginationButtons {$('[data-testid=paging] nav ul li')}
        addToCartButtons {$('[data-testid="itemAddCart"]')}
    }

    boolean verifySearchResultDescrition(String searchTerm){
        boolean resultsContainTable = true
        while (verifyAtNotLastPage() && resultsContainTable){
            searchResults.every {
                resultsContainTable && it.text().containsIgnoreCase(searchTerm)
            }
            navigateToNextPage()
        }
        return resultsContainTable
    }

    void navigateLastPage(){
        while(verifyAtNotLastPage()){
            navigateToNextPage()
        }
    }
    void selectLastSearchResultOnPage(){
        searchResults.last().click()
    }

    boolean verifyNotAtFirstPage(){
        paginationButtons.first().text() == ""
    }

    boolean verifyAtNotLastPage(){
        paginationButtons.last().text() == ""
    }

    void navigateToNextPage(){
        paginationButtons.last().click()
    }

    void navigateToPreviousPage(){
        paginationButtons.first().click()
    }

    void addLastItemOnPageToCart(){
        addToCartButtons.last().click()
    }

    void clickCartButton(){
        cartButton.click()
    }
}
