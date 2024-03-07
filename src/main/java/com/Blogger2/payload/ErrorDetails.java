package com.Blogger2.payload;

import java.util.Date;

public class ErrorDetails {

    private Date timestamp;

    private String message;

    private String content;

    public ErrorDetails(Date timestamp, String message, String content) {
        this.timestamp = timestamp;
        this.message = message;
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getContent() {
        return content;
    }
}
