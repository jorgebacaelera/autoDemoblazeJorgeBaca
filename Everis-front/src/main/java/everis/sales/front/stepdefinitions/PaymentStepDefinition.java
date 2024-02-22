package everis.sales.front.stepdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import everis.sales.front.steps.PaymentSteps;
import net.thucydides.core.annotations.Steps;

public class PaymentStepDefinition {

    @Steps
    PaymentSteps paymentSteps;

    public static String userName="";
    public static String passwordUser="";


    @Dado("que un cliente ingresa al portal de Demo Blaze")
    public void loginBS(){
        paymentSteps.openWeb();

    }

    @Y ("se registra con su usuario (.*) y contraseña (.*)")
    public void openWeb(String usuario, String contraseña){
        userName=usuario;
        passwordUser=contraseña;
        paymentSteps.registryUser(usuario,contraseña);
    }

    @Y("el cliente accede al login de acceso")
    public void loginPortal(){
        paymentSteps.signIn();
    }

    @Cuando("el cliente añada dos productos mayor a 300 soles al carrito de compras")

    public void addProduct(){
        paymentSteps.addCard("Phones", "Samsung galaxy s6");
        paymentSteps.returnHome();
        paymentSteps.addCard("Laptops", "Sony vaio i5");

    }

    @Entonces("el cliente validara el precio final como la cantidad de los productos en el carrito de compras")

    public void VerifyProduct(){
        paymentSteps.verifyPrice();
        paymentSteps.getResult(PaymentSteps.expectResult);
    }

}
