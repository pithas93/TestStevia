package page.objects;

import com.persado.oss.quality.stevia.selenium.core.WebComponent;

import java.text.MessageFormat;

/**
 * Created by Pithas on 23/08/2017.
 */
public class AmazonPages extends WebComponent {
    public AmazonPages(){

    }
    public enum AmazonPagesLocators
    {
        LINK_NEW_AND_INTERESTING("nav-upnav"),
        TITLE_NEW_AND_INTERESTING("css=#a-page > div.a-section.a-spacing-none.aux-stream-header > div.a-section.a-text-center.airstream-header-title-container.s-ember-font > span.airstream-header-title.aux-base-color"),
        THIRD_PRODUCT("css=#airstream-results > li:nth-child(3) > div > span > div"),
        BTN_BUYING_DETAILS("css=#a-popover-content-3 > span > div > div > div.a-fixed-right-grid-col.airstream-mini-detail-details.a-col-right > div > div > ul > li > span > div > a"),
        POP_UP_MODAL("a-popover-content-3"),
        BTN_ADD_TO_CART("add-to-cart-button"),
        ADDED_PRODUCT_VALUE("//*[@id=\"hlb-subcart\"]/div[1]/span/span[2]"),
        LINK_CART("nav-cart"),
        CART_PRODUCT_VALUE("css=#activeCartViewForm > div.sc-list-body.sc-java-remote-feature > div > div.sc-list-item-content > div > div.a-column.a-span2.a-text-left > p > span"),
        ;

        private String myLocator;
        AmazonPagesLocators(String locator){
            myLocator = locator;
        }

        public String get()
        {
            return myLocator;
        }
        public String getWithParams(Object... params)
        {
            return MessageFormat.format(myLocator, params);
        }

    }
    //Navigation Methods//

    //Navigate to www.amazon.com
    public void goToAmazonPage (){
        controller().navigate("https://www.amazon.com");
    }

    //Navigate to New & Interesting products
    public void goToNewAndInteresting()  {
        controller().click(AmazonPagesLocators.LINK_NEW_AND_INTERESTING.get());
      if ( !controller().getText(AmazonPagesLocators.TITLE_NEW_AND_INTERESTING.get()).equals("INTERESTING FINDS")){
            throw new WrongPageException("Test is not at the 'New & Interesting' Page");
        }
    }

    //Select the third product from the list
    public void selectThirdProduct(){
        controller().click(AmazonPagesLocators.THIRD_PRODUCT.get());
        controller().waitForElementPresence(AmazonPagesLocators.POP_UP_MODAL.get());
    }

    //See details,clin on modal
    public void seeBuyingDetails(){
        controller().moveToElement(AmazonPagesLocators.POP_UP_MODAL.get());
        controller().press(AmazonPagesLocators.BTN_BUYING_DETAILS.get());
    }

    //add amazon product to cart
    public void AddProductToCart(){
        controller().press(AmazonPagesLocators.BTN_ADD_TO_CART.get());
    }

    //Go to Cart
    public void goToCart() {
        controller().click(AmazonPagesLocators.LINK_CART.get());
    }

    //Get value methods//
    //Get add prduct price
    public String getAddedProductPrice(){
        String productPrice =controller().getText(AmazonPages.AmazonPagesLocators.ADDED_PRODUCT_VALUE.get());
        return productPrice;
    }

    //Get product in cart price
    public String getCartProductPrice(){
        String cartprice=controller().getText(AmazonPages.AmazonPagesLocators.CART_PRODUCT_VALUE.get());
        return cartprice;
    }

}
