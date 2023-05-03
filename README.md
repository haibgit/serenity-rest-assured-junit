# Running the tests under Maven

The template project comes with both Maven and Gradle build scripts. To run the tests with Maven, open a command window and run:

    mvn clean verify


# Viewing the reports

Both of the commands provided above will produce a Serenity test report in the `target/site/serenity` directory. Go take a look!

### If you don't using  extends UIInteractions 
in your report, you can't see the some title for example
@Given("Kitty is available in the pet store")
@When("I ask for a pet using Kitty's ID: {0}")
@Then("I get Kitty as result")