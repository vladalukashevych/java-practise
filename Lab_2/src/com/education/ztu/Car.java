package com.education.ztu;

public class Car {
    private String brand;
    private String model;
    private Engine engine;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.engine = new Engine();
    }

    public String GetInfo() {
        return "* Car - Brand: " + brand + "Model: " + model + " *";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    class Engine {
        private Boolean engineWorks;

        public Engine() {
            this.engineWorks = false;
        }

        public void startEngine() {
            if(engineWorks) {
                System.out.println("Engine's already running");
                return;
            }

            engineWorks = true;
            System.out.println("Engine started.");
        }

        public void stopEngine() {
            engineWorks = false;
            System.out.println("Engine stopped.");
        }
    }
}
