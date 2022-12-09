package services;

import io.qameta.allure.Step;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseService {

    private final RequestSpecification specification;

    public BaseService(RequestSpecification spec) {
        this.specification = spec;
    }

    @Step("Отправка запроса [GET {basePath}], ожидаемый код ответа: {expectedCode}")
    protected <T> List<T> getList(String basePath, String listPath, Class<T> myClass, int expectedCode) {
        List<T> result = given()
                .spec(specification)
                .basePath(basePath)
                .when().get()
                .then()
                .statusCode(expectedCode)
                .extract().jsonPath().getList(listPath, myClass);
        assertThat(result).isNotNull();
        return result;
    }

    @Step("Отправка запроса [GET {basePath}], ожидаемый код ответа: {expectedCode}")
    protected <T> T getObject(String basePath, Class<T> myClass, int expectedCode) {
        T result = given()
                .spec(specification)
                .basePath(basePath)
                .when()
                .get()
                .then()
                .statusCode(expectedCode)
                .extract().as(myClass);
        assertThat(result).isNotNull();
        return result;
    }

    @Step("Отправка запроса [GET {basePath}], ожидаемый код ответа: {expectedCode}")
    protected Response getResponse(String basePath, int expectedCode) {
        Response result = given()
                .spec(specification)
                .basePath(basePath)
                .when()
                .get()
                .then()
                .statusCode(expectedCode)
                .extract().response();
        assertThat(result).isNotNull();
        return result;
    }

    @Step("Отправка запроса [PUT {basePath}], ожидаемый код ответа: {expectedCode}")
    protected <T> T putObject(String basePath, Class<T> myClass, int expectedCode) {
        T result = given()
                .spec(specification)
                .basePath(basePath)
                .when()
                .put()
                .then()
                .statusCode(expectedCode)
                .extract().as(myClass);
        assertThat(result).isNotNull();
        return result;
    }

    @Step("Отправка запроса [PUT {basePath}], ожидаемый код ответа: {expectedCode}")
    protected Response putResponse(String basePath, int expectedCode) {
        Response result = given()
                .spec(specification)
                .basePath(basePath)
                .when()
                .put()
                .then()
                .statusCode(expectedCode)
                .extract().response();
        assertThat(result).isNotNull();
        return result;
    }

    @Step("Отправка запроса [POST {basePath}], ожидаемый код ответа: {expectedCode}")
    protected <T> T postObject(String basePath, Class<T> myClass, int expectedCode) {
        T result = given()
                .spec(specification)
                .basePath(basePath)
                .when()
                .post()
                .then()
                .statusCode(expectedCode)
                .extract().as(myClass);
        assertThat(result).isNotNull();
        return result;
    }

    @Step("Отправка запроса [POST {basePath}], ожидаемый код ответа: {expectedCode}")
    protected Response postResponse(String basePath, int expectedCode) {
        Response result = given()
                .spec(specification)
                .basePath(basePath)
                .when()
                .post()
                .then()
                .statusCode(expectedCode)
                .extract().response();
        assertThat(result).isNotNull();
        return result;
    }

    @Step("Отправка запроса [DELETE {basePath}], ожидаемый код ответа: {expectedCode}")
    protected Response deleteResponse(String basePath, int expectedCode) {
        Response result = given()
                .spec(specification)
                .basePath(basePath)
                .when()
                .delete()
                .then()
                .statusCode(expectedCode)
                .extract().response();
        assertThat(result).isNotNull();
        return result;
    }

    @Step("Отправка запроса [HEAD {basePath}], ожидаемый код ответа: {expectedCode}")
    protected Headers head(String basePath, int expectedCode) {
        Headers result = given()
                .spec(specification)
                .basePath(basePath)
                .when()
                .head()
                .then()
                .statusCode(expectedCode)
                .extract().headers();
        assertThat(result).isNotNull();
        return result;
    }

    @Step("Отправка запроса [PATCH {basePath}], ожидаемый код ответа: {expectedCode}")
    protected <T> T patchObject(String basePath, Class<T> myClass, int expectedCode) {
        T result = given()
                .spec(specification)
                .basePath(basePath)
                .when()
                .patch()
                .then()
                .statusCode(expectedCode)
                .extract().as(myClass);
        assertThat(result).isNotNull();
        return result;
    }

    @Step("Отправка запроса [PATCH {basePath}], ожидаемый код ответа: {expectedCode}")
    protected Response patchResponse(String basePath, int expectedCode) {
        Response result = given()
                .spec(specification)
                .basePath(basePath)
                .when()
                .patch()
                .then()
                .statusCode(expectedCode)
                .extract().response();
        assertThat(result).isNotNull();
        return result;
    }

    @Step("Отправка запроса [POST {basePath}], ожидаемый код ответа: {expectedCode}")
    protected <T> List<T> postList(String basePath, Class<T> myClass, int expectedCode) {
        List<T> result = given()
                .spec(specification)
                .basePath(basePath)
                .when().post()
                .then()
                .statusCode(expectedCode)
                .extract().jsonPath().getList("", myClass);
        assertThat(result).isNotNull();
        return result;
    }
}
