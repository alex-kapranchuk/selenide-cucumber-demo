import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class FormField {

    @Given("User go to the form page")
    public void openFormPage() {
        $(byXpath("//a[normalize-space()='Form Fields']")).click();
    }

    @When("User enters {string} in the name field")
    public void enterName(String name) {
        $("#name").setValue(name);
    }

    @And("User click {string} as favorite drink")
    public void selectFavoriteDrink(String drink) {
        Map<String, String> drinkMap = new HashMap<>();
        drinkMap.put("Water", "#drink1");
        drinkMap.put("Milk", "#drink2");
        drinkMap.put("Coffee", "#drink3");
        drinkMap.put("Wine", "#drink4");
        drinkMap.put("Ctrl-Alt-Delight", "#drink5");

        String selector = drinkMap.get(drink);
        $(selector).click();

        $(selector).shouldHave(exactValue(drink));
    }

    @And("User click {string} as favorite color")
    public void selectFavoriteColor(String color) {
        Map<String, String> colorMap = new HashMap<>();
        colorMap.put("Red", "#color1");
        colorMap.put("Blue", "#color2");
        colorMap.put("Yellow", "#color3");
        colorMap.put("Green", "#color4");
        colorMap.put("#FFC0CB", "#color5");

        String selector = colorMap.get(color);
        $(selector).click();

        $(selector).shouldHave(exactValue(color));
    }

    @And("User have any siblings, {string}")
    public void noSiblings(String siblings) {
        $(byId("siblings")).selectOptionByValue(siblings);

        $(byId("siblings")).shouldHave(value(siblings));
    }

    @And("User enters {string} in the email field")
    public void enterEmail(String email) {
        $("#email").setValue(email);

        $("#email").shouldHave(value(email));
    }
    @And("User type in message {string}")
    public void  typeInMessage(String message){
        $(byId("message")).sendKeys(message);

        $(byId("message")).shouldHave(value(message));
    }

    @Then("User submits the form successfully")
    public void submitForm() {
        $(byId("submit-btn")).click();

        String alertText = switchTo().alert().getText();

        Assert.assertEquals("Text in alert window is not as expected",
                "Message received!", alertText);
    }
}
