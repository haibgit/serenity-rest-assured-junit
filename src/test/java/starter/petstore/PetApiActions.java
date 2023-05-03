package starter.petstore;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PetApiActions extends UIInteractions {
    @Given("Kitty is available in the pet store")
    public Long givenKittyIsAvailableInPetStore() {
        Pet pet = new Pet("Kitty", "available");
        return given().spec(DefaultRequestSpecification.getRequestSpecification()).basePath("/pet").body(pet).post().getBody().as(Pet.class, ObjectMapperType.GSON).getId();
    }

    @When("I ask for a pet using Kitty's ID: {0}")
    public void whenIAskForAPetWithId(Long id) {
//        given().spec(DefaultRequestSpecification.getRequestSpecification()).basePath("/pet").when().get("/" + id);
        when().get("/" + id);
    }

    @Then("I get Kitty as result")
    public void thenISeeKittyAsResult() {
        then().body("name", Matchers.equalTo("Kitty"));
        then().body("status", Matchers.equalTo("available"));
    }


    @When("Provider new name to Kitty")
    public void whenUpdateNewNameToKitty(Long id) {
        Pet dog = new Pet("Dog", "available", id);
        given().spec(DefaultRequestSpecification.getRequestSpecification()).basePath("/pet").body(dog).put();

    }

    @Then("I get Dog as result")
    @Step("Verify that the result contains a dog")
    public void thenISeeDogAsResult() {
        then().body("name", Matchers.equalTo("Dog"));
        then().body("status", Matchers.equalTo("available"));
    }

    @Step("Finds Pets by status Sold")
    public void thenFind() {
        given().spec(DefaultRequestSpecification.getRequestSpecification()).basePath("/pet").queryParam("status", "sold").get("/findByStatus");
        List<PetRefactor> pets = SerenityRest.lastResponse().jsonPath().getList("", PetRefactor.class);
        for (PetRefactor pet : pets) {
            assertThat(pet.getId(), Matchers.notNullValue());
            assertThat(pet.getStatus(), Matchers.equalTo("sold"));
        }
    }
}


