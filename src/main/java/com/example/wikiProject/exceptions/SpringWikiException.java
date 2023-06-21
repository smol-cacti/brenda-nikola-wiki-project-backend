package com.example.wikiProject.exceptions;

public class SpringWikiException extends RuntimeException {
    public SpringWikiException(String exMessage) {
        super(exMessage);
    }

    public SpringWikiException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }
}
