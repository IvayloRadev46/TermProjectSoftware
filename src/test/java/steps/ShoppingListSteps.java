package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.example.models.ShoppingListItem;
import org.example.services.ShoppingListService;
import org.example.util.Database;

import static org.junit.Assert.assertEquals;

public class ShoppingListSteps {

    private final ShoppingListService shoppingListService = new ShoppingListService();

    private String productName;
    private int quantity;
    private String actualResult;

    @Before
    public void setup() {
        Database.reset();
    }

    @Given("потребителят иска да управлява списък за пазаруване")
    public void userWantsToManageShoppingList() {
    }

    @Given("в списъка за пазаруване има продукт {string} с количество {int}")
    public void shoppingListContainsProduct(String productName, int quantity) {
        Database.shoppingListItems.add(new ShoppingListItem(productName, quantity));
    }

    @When("въведе продукт {string} с количество {int} за списъка")
    public void enterProductForShoppingList(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    @When("натисне бутона за добавяне в списъка")
    public void clickAddToShoppingListButton() {
        actualResult = shoppingListService.addToShoppingList(productName, quantity);
    }

    @When("маркира продукта {string} като закупен")
    public void markProductAsPurchased(String productName) {
        actualResult = shoppingListService.markAsPurchased(productName);
    }

    @Then("системата връща резултат за списъка {string}")
    public void systemReturnsShoppingListResult(String expectedResult) {
        assertEquals(expectedResult, actualResult);
    }
}