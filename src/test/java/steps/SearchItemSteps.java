package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.example.services.SearchService;
import org.example.util.Database;

import static org.junit.Assert.assertEquals;

public class SearchItemSteps {

    private final SearchService searchService = new SearchService();

    private String searchValue;
    private String searchType;
    private String actualResult;

    @Before
    public void setup() {
        Database.reset();
    }

    @Given("потребителят иска да търси предмет")
    public void userWantsToSearchItem() {
    }

    @When("търси по име {string}")
    public void searchByName(String name) {
        this.searchType = "name";
        this.searchValue = name;
    }

    @When("търси по категория {string}")
    public void searchByCategory(String category) {
        this.searchType = "category";
        this.searchValue = category;
    }

    @When("натисне бутона за търсене")
    public void clickSearchButton() {
        if ("name".equals(searchType)) {
            actualResult = searchService.searchByName(searchValue);
        } else {
            actualResult = searchService.searchByCategory(searchValue);
        }
    }

    @Then("системата връща резултат за търсене {string}")
    public void systemReturnsSearchResult(String expectedResult) {
        assertEquals(expectedResult, actualResult);
    }
}