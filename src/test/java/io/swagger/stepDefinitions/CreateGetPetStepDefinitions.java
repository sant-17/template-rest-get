package io.swagger.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.swagger.tasks.GetPetTask;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static io.swagger.constants.Constants.URL_Base;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateGetPetStepDefinitions {
    private static final String  restAPIUrl = URL_Base;

    @When("I send a request to the endpoint {string} with pet id {string}")
    public void iSendARequestToTheEndpointWithPetId(String endpoint, String id) {

        Actor user  = Actor.named("user").whoCan(CallAnApi.at(restAPIUrl));

        user.attemptsTo(
                GetPetTask.fromEndpoint(endpoint,id)

        );

    }

    @Then("I Validate that the response code is {string}")
    public void iValidateThatTheResponseCodeIs(String code) {

        Actor user = Actor.named("user");

        String codeRest = String.valueOf(SerenityRest.lastResponse().getStatusCode());
        user.should(
                seeThat("The responde code is",res->codeRest,equalTo(code))
        );
    }

}
