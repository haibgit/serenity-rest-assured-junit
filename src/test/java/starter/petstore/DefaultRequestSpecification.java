package starter.petstore;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;

public class DefaultRequestSpecification {

    private static RequestSpecification requestSpec;

    public static RequestSpecification getRequestSpecification() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        String baseUri = environmentVariables.getProperty("restapi.baseurl");
        if (requestSpec == null) {
            requestSpec = new RequestSpecBuilder()
                    .setBaseUri(baseUri)
                    .addHeader("Content-Type", "application/json")
                    .build();
        }
        return requestSpec;
    }


}
