package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.example.services.LoginService;
import org.example.util.Database;

import static org.junit.Assert.assertEquals;

public class LoginSteps {

    private final LoginService loginService = new LoginService();

    private String email;
    private String password;
    private String actualResult;

    @Before
    public void setup() {
        Database.reset();
    }

    @Given("потребителят е на екрана за вход")
    public void userIsOnLoginScreen() {
    }

    @When("потребителят въведе имейл {string} и парола {string}")
    public void userEntersEmailAndPassword(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @When("натисне бутона за вход")
    public void userClicksLoginButton() {
        actualResult = loginService.login(email, password);
    }

    @Then("системата връща резултат за вход {string}")
    public void systemReturnsLoginResult(String expectedResult) {
        assertEquals(expectedResult, actualResult);
    }
}