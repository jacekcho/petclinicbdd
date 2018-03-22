package local.petclinic.injections;

import io.restassured.RestAssured;
import local.petclinic.utils.Generators;
import local.petclinic.utils.PropertiesManager;

public class InjectOwners {

    private String firstName = Generators.randomFirstName();
    private String lastName = Generators.randomLastName();
    private String address = Generators.randomAddress();
    private String city = Generators.randomCity();
    private String telephone = Generators.randomTelephoneNumber();

    public InjectOwners addOwner() {
        RestAssured.given()
                .log().all()
                .formParam("firstName", firstName)
                .formParam("lastName", lastName)
                .formParam("address", address)
                .formParam("city", city)
                .formParam("telephone", telephone)
                .post(PropertiesManager.getInstance().getPetClinicAddOwnerUrl());
        return this;
    }

    public String getOwnerLastName() {
        return lastName;
    }

    public String getOwnerFirstName() {
        return firstName;
    }

    public String getOwnerAddress() {
        return address;
    }

    public String getOwnerCity() {
        return city;
    }

    public String getOwnerTelephone() {
        return telephone;
    }
}