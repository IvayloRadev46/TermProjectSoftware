package steps;

import io.cucumber.java.en.*;
import org.example.services.ItemService;

import static org.junit.Assert.assertEquals;

public class AddItemSteps {

    private final ItemService itemService = new ItemService();

    private String name;
    private String category;
    private int quantity;
    private String location;
    private String ownerEmail;
    private String actualResult;

    @Given("потребителят иска да добави предмет")
    public void userWantsToAddItem() {
    }

    @When("въведе предмет с име {string}, категория {string}, количество {int}, местоположение {string} и собственик {string}")
    public void enterItemData(String name, String category, int quantity, String location, String ownerEmail) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.location = location;
        this.ownerEmail = ownerEmail;
    }

    @When("натисне бутона за добавяне")
    public void clickAddButton() {
        actualResult = itemService.addItem(name, category, quantity, location, ownerEmail);
    }

    @Then("системата връща резултат за добавяне {string}")
    public void systemReturnsAddResult(String expectedResult) {
        assertEquals(expectedResult, actualResult);
    }
}