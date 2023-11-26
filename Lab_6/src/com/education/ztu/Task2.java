package com.education.ztu;

public class Task2 {
    public static void DoTask() {
        String login = "valid_login";
        String password = "valid_password";
        String confirmPassword = "valid_password";

        try {
            boolean result = Authorisation.checkCredentials(login, password, confirmPassword);
            System.out.println("Credentials are valid: " + result);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
