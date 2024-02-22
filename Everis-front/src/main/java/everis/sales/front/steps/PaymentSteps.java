package everis.sales.front.steps;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.*;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.*;
import everis.sales.front.Util.Util;
import everis.sales.front.Util.PaymentPage;
import everis.sales.front.stepdefinitions.PaymentStepDefinition;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class PaymentSteps extends PageObject {

    public static String comprobarItem;
    public static int priceProducto1;
    public static int priceProducto2;
    public static int expectResult;
    public static int sumTotalPrice;

    @Step ("Ingresamos a la web de ventas de Demoblaze")
    public void openWeb() {
        setDefaultBaseUrl("https://www.demoblaze.com/index.html");
        open();
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Serenity.takeScreenshot();
        Util.waitFor(3);
    }
    @Step ("Registrando a usuario en la web Demoblaze")
    public void registryUser(String usuario, String password) {
        (getDriver().findElement(By.id(PaymentPage.butonRegister))).click();
        Util.waitFor(2);
        (getDriver().findElement(By.id("sign-username"))).sendKeys(usuario);
        (getDriver().findElement(By.id("sign-password"))).sendKeys(password);
        (getDriver().findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]"))).click();
        Serenity.takeScreenshot();
        Util.waitFor(2);
        Alert alert = getDriver().switchTo().alert();
        // Accepting alert
        alert.accept();
    }

    @Step ("Cliente se logea con su usuario")
    public void signIn(){

      (getDriver().findElement(By.id("login2"))).click();
      (getDriver().findElement(By.id("loginusername"))).sendKeys(PaymentStepDefinition.userName);
        Util.waitFor(2);
      (getDriver().findElement(By.id("loginpassword"))).sendKeys(PaymentStepDefinition.passwordUser);
        Serenity.takeScreenshot();
      (getDriver().findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"))).click();
      Util.waitFor(2);

    }

    @Step ("Agregamos dos productos al carrito de compras")
    public void addCard(String categoria, String producto){
        (getDriver().findElement(By.linkText(categoria))).click();
        Util.waitFor(2);
        (getDriver().findElement(By.linkText(producto))).click();
        Serenity.takeScreenshot();
        Util.waitFor(2);
        (getDriver().findElement(By.linkText("Add to cart"))).click();
        Util.waitFor(2);
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
        Serenity.takeScreenshot();
        (getDriver().findElement(By.linkText("Cart"))).click();
        Util.waitFor(2);
        comprobarItem=getDriver().findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]")).getText();
        Util.waitFor(2);
    }

    public void returnHome(){
        Serenity.takeScreenshot();
        (getDriver().findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a"))).click();
    }
    @Step ("Verificamos la suma total de los precios")
    public void verifyPrice(){
      expectResult = Integer.parseInt((getDriver().findElement(By.id("totalp"))).getText());
      priceProducto1 = Integer.parseInt((getDriver().findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[3]"))).getText());
      priceProducto2 = Integer.parseInt((getDriver().findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[2]/td[3]"))).getText());
      sumTotalPrice = priceProducto1 + priceProducto2;
      assertThat(priceProducto1, greaterThanOrEqualTo(300));
      assertThat(priceProducto2, greaterThanOrEqualTo(300));
      assertThat(sumTotalPrice, equalTo(expectResult));
    }

    @Step ("Resultado de la suma es: {0} ")
    public void getResult(int result){
        System.out.println(result);
      Serenity.takeScreenshot();
    }
}