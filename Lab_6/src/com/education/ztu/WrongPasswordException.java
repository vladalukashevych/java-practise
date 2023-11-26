package com.education.ztu;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Wrong password");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
