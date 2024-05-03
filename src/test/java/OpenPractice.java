import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class OpenPractice {

    @Given("User is opened home web-page")
    public void openWebPage() {
        Configuration.browser = "chrome";
        open("https://practice-automation.com/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Then("Title of pages should be {string}")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = title();

        Assert.assertEquals("Page title is not as expected", expectedTitle, actualTitle);
    }

    @Given("User go to the hover page")
    public void openFormPage() {
        $(byXpath("//a[normalize-space()='Hover']")).click();
    }

    @Then("Hover mouse on object")
    public void hoverOverElement() {
        $(byId("mouse_over")).hover();
    }
}
