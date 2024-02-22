import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/features/DemoBlaze.feature",
        glue = {"everis.sales.front"})
public class everisFront {
    @Managed
    WebDriver driver;
}
