package com.iris.restWebServices.rest_web_services.helloWorld;

public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    @Override
    public String toString() {
        return "HellloworldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
