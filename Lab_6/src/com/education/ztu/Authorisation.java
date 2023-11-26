package com.education.ztu;

public class Authorisation {
    public static boolean checkCredentials(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        try {
            if (!login.matches("[a-zA-Z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Invalid login");
            }

            if (!password.matches("[a-zA-Z0-9_]+") || password.length() >= 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Invalid password");
            }

            return true;
        } catch (Exception e) {
            throw e;
        }
    }
}
