package PageObjects

class EmptyCartModal extends BaseModule{
    static content = {
        modalTitle {$('#empty-cart-title')}
        emptyCartButton {$("button", text: "Empty Cart")}
    }

    void clickEmptyCartModalButton(){
        emptyCartButton.last().click()
    }
}
