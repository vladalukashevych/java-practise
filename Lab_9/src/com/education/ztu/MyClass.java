package com.education.ztu;

public class MyClass {
    public int publicField;
    private String privateField;

    public MyClass() {
        publicField = 0;
        privateField = "Default Value";
    }

    public MyClass(int publicField, String privateField) {
        this.publicField = publicField;
        this.privateField = privateField;
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    private void privateMethod(String message) {
        System.out.println("Private method called with message: " + message);
    }

    public String getPrivateField() {
        return privateField;
    }

    public void setPrivateField(String privateField) {
        this.privateField = privateField;
    }
}
