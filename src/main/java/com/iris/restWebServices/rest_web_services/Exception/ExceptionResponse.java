package com.iris.restWebServices.rest_web_services.Exception;

import java.util.Date;

public class ExceptionResponse {
// basic things to be incllude din the http  response body during an instance of the exception

    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timestamp, String message, String Details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = Details;
    }

    public Date getTimestamp() {
        return timestamp;

    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
