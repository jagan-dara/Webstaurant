package Common

import geb.Page

class BasePage extends Page{

    static content = {
        cartButton(wait:true)   {$('[data-testid="cart-button')}
    }


}