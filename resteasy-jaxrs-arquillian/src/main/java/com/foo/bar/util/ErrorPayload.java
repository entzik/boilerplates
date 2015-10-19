package com.foo.bar.util;

/**
 * Created by emilkirschner on 12/10/15.
 */
public class ErrorPayload {
    private final String uuid;
    private final String devMessage;
    private final String userMessage;

    public ErrorPayload(String uuid, String devMessage, String userMessage) {
        this.uuid = uuid;
        this.devMessage = devMessage;
        this.userMessage = userMessage;
    }

    public String getUuid() {
        return uuid;
    }

    public String getDevMessage() {
        return devMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }
}
