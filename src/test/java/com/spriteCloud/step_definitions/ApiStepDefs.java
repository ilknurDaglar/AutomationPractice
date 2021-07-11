package com.spriteCloud.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ApiStepDefs {

    Response response = given().log().all()
            .and().queryParam("id", 1)
            .and().queryParam("title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit")
            .and().queryParam("userId", 1).when().get("https://jsonplaceholder.typicode.com/posts/1");


    @Given("the user sends request to api_url")
    public void theUserSendsRequestToApi_url() {

    }

    @Given("the key is {string} and value is {int}")
    public void the_key_is_and_value_is(String string, Integer int1) {

        int id = response.path("id");
        assertEquals(1, id);
    }

    @Given("response Content type should be {string}")
    public void response_Content_type_should_be(String string) {
        assertEquals(response.contentType(), "application/json; charset=utf-8");

    }

    @Given("Title should be {string}")
    public void title_should_be(String string) {
        assertEquals(response.body().path("title").toString(), "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
    }

    @Then("response status code should be {int}")
    public void response_status_code_should_be(Integer int1) {
        assertEquals(200, response.statusCode());
    }

    @Then("response userId should be {int}")
    public void response_userId_should_be(Integer int1) {
        int userId = response.path("userId");
        assertEquals(1, userId);
    }

//   Im using Pojo method for this kind of tests
//   POJO=Plain Old java Object(De-serialization=Json Response converts to Java Objets)
//    1.Class
//           private int id;
//           private String name;
//
//    public ApiStepDefs(int id, String name, String gender, Long phone) {
//        this.id = id;
//        this.name = name;
//
//    @Override
//    public String toString() {
//        return "ApiStepDefs{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    2.Class
//    Response response = given().accept(ContentType.JSON)
//           .when().get("https://jsonplaceholder");
//
//    PracticeAuto practiceAuto=response.body().as(PracticeAuto.class);
//   assertEquals(PracticeAuto1.getname,expected: "Forrest Gump");
//   assertEquals(PracticeAuto1.getid,expected: "230");


    @Given("the user sends \"id\"key with a value of  {int}")
    public void the_user_sends_id_key_with_a_value_of(Integer int1) {
        Response response = given().log().all()
                .body("{\r\n" + "	\"title\": \"acabasiradanevar\",\r\n" + "    \"body\": \"songayret\",\r\n" + "    \"userId\": 198\r\n" + "}")
                .when().post("posts");

    }

    @And("Content type should be Json")
    public void contentTypeShouldBeJson() {

        assertEquals(response.contentType(), "application/json; charset=utf-8");
    }


}
