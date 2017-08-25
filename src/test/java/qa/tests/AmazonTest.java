package qa.tests;

import com.persado.oss.quality.stevia.spring.SteviaTestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.Amazon;

/**
 * Created by Pithas on 23/08/2017.
 */
public class AmazonTest extends SteviaTestBase {
    @Autowired
    protected Amazon amazonPage;

    @Test
    public void searchPersadoInGoogle() throws Exception{
        amazonPage.buyNewAndInterestingProduct();
        amazonPage.goToCart();
        Assert.assertEquals(amazonPage.getAddedPrice(),amazonPage.getCartPrice(),"Product Value and Cart Value are not the same");
    }
}
