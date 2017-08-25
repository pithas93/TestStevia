package page.objects;

import com.persado.oss.quality.stevia.selenium.core.WebComponent;

/**
 * Created by Pithas on 23/08/2017.
 */
public class Amazon extends WebComponent {
    AmazonPages amazonPages = new AmazonPages();
    private String price;
  public void buyNewAndInterestingProduct(){
        amazonPages.goToAmazonPage();
        amazonPages.goToNewAndInteresting();
        amazonPages.selectThirdProduct();
        amazonPages.seeBuyingDetails();
        amazonPages.AddProductToCart();
        this.price= amazonPages.getAddedProductPrice();
  }
  public void goToCart(){
      amazonPages.goToCart();
  }
  public String getCartPrice(){
      String cartPrice=amazonPages.getCartProductPrice();
      return cartPrice;
  }
  public String getAddedPrice(){
      return this.price;
  }

}
