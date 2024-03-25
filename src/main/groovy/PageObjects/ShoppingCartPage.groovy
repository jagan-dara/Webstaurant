package PageObjects

import Common.BasePage
import org.openqa.selenium.By

class ShoppingCartPage extends BasePage{
    static  at = {
        getTitle().toString().containsIgnoreCase("WebstaurantStore Cart")
    }
    static content = {
        emptyCartModule {module EmptyCartModal}
        emptyCartButton { $(By.className("emptyCartButton"))}
        cartItems(wait:"quick", required: false) {$(By.className("cartItem"),dynamic:true)}
        cartEmptyBanner(wait:"quick", required:false) {$(By.className("cartEmpty"),dynamic:true)}
    }

    void clickEmptyCartButton(){
        emptyCartButton.click()
    }

    boolean verifyCartIsNotEmpty(){
        !cartItems.empty
    }

    boolean verifyCartIsEmpty(){
        cartEmptyBanner.isDisplayed()
    }
}
