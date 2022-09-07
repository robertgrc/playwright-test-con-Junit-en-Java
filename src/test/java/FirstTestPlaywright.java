import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.MouseButton;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class FirstTestPlaywright {

    @Test
    public void LaunchBrowserTest(){
        try(Playwright playwright = Playwright.create()){
            Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200)).newPage();
            page.setViewportSize(1920,1080);
            page.navigate("https://www.saucedemo.com/");
            //By Text
            //page.click("text=login");
            //By Id
            //page.click("id=login-button");
            //page.click("#login-button");
            //page.click("input#login-button");
            //page.click("input.submit-button.btn_action");
            //page.click("div input#login-button");
            //By Placeholder
            //page.type("[placeholder=Username]","admin");
            //page.type("[placeholder=Password]","password");
            //page.click("id=login-button", new Page.ClickOptions().setButton(MouseButton.RIGHT));
            //page.type("[placeholder=Username]","standard_user");
            //page.type("[placeholder=Password]","secret_sauce");
            //page.click("id=login-button");
            //page.selectOption("select.product_sort_container","hilo");
            //String textElement = page.innerText("a#item_5_title_link div");
            //System.out.println("Texto: "+textElement);
        }
    }

    @Test
    public void VerifyThatItemCanBeAddedToTheCart(){
        try(Playwright playwright = Playwright.create()){
            Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200)).newPage();
            page.setViewportSize(1920,1080);
            page.navigate("https://www.saucedemo.com/");
            page.type("[placeholder=Username]","standard_user");
            page.type("[placeholder=Password]","secret_sauce");
            page.click("id=login-button");
            page.click("text=Sauce Labs Backpack");
            page.click("id=add-to-cart-sauce-labs-backpack");
            page.click("a.shopping_cart_link");
            boolean itemIsDisplayed = page.isVisible("text=Sauce Labs Backpack");
            Assert.assertTrue(itemIsDisplayed);
        }
    }

    @Test
    public void VerifyThatItemCanBeDeleteToTheCart(){
        try(Playwright playwright = Playwright.create()){
            Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200)).newPage();
            page.setViewportSize(1920,1080);
            page.navigate("https://www.saucedemo.com/");
            page.type("[placeholder=Username]","standard_user");
            page.type("[placeholder=Password]","secret_sauce");
            page.click("id=login-button");
            page.click("text=Sauce Labs Backpack");
            page.click("id=add-to-cart-sauce-labs-backpack");
            page.click("a.shopping_cart_link");
            page.click("#remove-sauce-labs-backpack");
            boolean itemIsDisplayed = page.isVisible("text=Sauce Labs Backpack");
            Assert.assertFalse(itemIsDisplayed);

        }
    }

    @Test
    public void VerifyAddItemToCheckout(){
        try(Playwright playwright = Playwright.create()){
            Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200)).newPage();
            page.setViewportSize(1920,1080);
            page.navigate("https://www.saucedemo.com/");
            page.type("[placeholder=Username]","standard_user");
            page.type("[placeholder=Password]","secret_sauce");
            page.click("id=login-button");
            page.click("text=Sauce Labs Backpack");
            page.click("id=add-to-cart-sauce-labs-backpack");
            page.click("a.shopping_cart_link");
            page.click("#checkout");

            page.type("#first-name","Marcelo");
            page.type("#last-name","Rodriguez");
            page.type("#postal-code","00000");
            page.click("#continue");

            boolean itemIsDisplayed = page.isVisible("text=Sauce Labs Backpack");
            Assert.assertTrue(itemIsDisplayed);

        }
    }

    @Test
    public void VerifyAddThreeItemsToCar(){
        try(Playwright playwright = Playwright.create()){
            Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200)).newPage();
            page.setViewportSize(1920,1080);
            page.navigate("https://www.saucedemo.com/");
            page.type("[placeholder=Username]","standard_user");
            page.type("[placeholder=Password]","secret_sauce");
            page.click("id=login-button");
            page.click("id=add-to-cart-sauce-labs-backpack");
            page.click("id=add-to-cart-sauce-labs-bike-light");
            page.click("id=add-to-cart-sauce-labs-bolt-t-shirt");
            //boolean itemsAreDisplayed = page.isVisible("id=cart_item",)
            //assertThat(page.locator()).hasCount(3);

        }
    }
}
