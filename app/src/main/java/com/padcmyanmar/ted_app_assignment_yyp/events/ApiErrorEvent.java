package com.padcmyanmar.ted_app_assignment_yyp.events;

public class ApiErrorEvent {
    private String errorMessage;

    public ApiErrorEvent(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
