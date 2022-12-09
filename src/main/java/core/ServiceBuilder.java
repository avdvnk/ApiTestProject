package core;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import services.BaseService;

public class ServiceBuilder {

    private RequestSpecBuilder specBuilder = new RequestSpecBuilder();

    public ServiceBuilder(String uri) {
        specBuilder = specBuilder
                .setBaseUri(uri)
                .setContentType(ContentType.JSON)
                .setRelaxedHTTPSValidation()
                .addFilter(new AllureRestAssured());
    }

    public ServiceBuilder addHeader(String key, String value) {
        if (value != null) specBuilder = specBuilder.addHeader(key, value);
        return this;
    }

    public ServiceBuilder addParam(String key, Object... values) {
        if (values != null) specBuilder = specBuilder.addParam(key, values);
        return this;
    }

    public ServiceBuilder addQueryParam(String key, Object value) {
        if (value != null) specBuilder = specBuilder.addQueryParam(key, value);
        return this;
    }

    public ServiceBuilder addPathParam(String key, Object value) {
        if (value != null) specBuilder = specBuilder.addPathParam(key, value);
        return this;
    }

    public ServiceBuilder addBody(Object body) {
        if (body != null) specBuilder = specBuilder.setBody(body);
        return this;
    }

    public ServiceBuilder setAccept(String mediaTypes) {
        if (mediaTypes != null) specBuilder.setAccept(mediaTypes);
        return this;
    }

    public RequestSpecification buildSpecification() {
        return specBuilder.build();
    }

    public BaseService buildService() {
        return new BaseService(buildSpecification());
    }
}
