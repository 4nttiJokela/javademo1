package main;

public class Car {
    private String brand;
    private String model;
    private int speed;

    public Car () {
        this.brand = "";
        this.model = "";
        this.speed = 0;
    }

    public Car (String brand, String model, int speed) {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }

    public void status () {
        System.out.println("Auto: " + brand + " " + model + ", Nopeus: " + speed + " km/h");
    }

    public void accelerate (int amount) {
        if (amount <= 0) {
            System.out.println("Nopeuden täytyy olla positiivinen luku.");
            return;
        }
        speed = speed + amount;
        return;
    }
    public void decelerate (int amount) {
        if (amount < 0) {
            System.out.println("Nopeuden täytyy olla positiivinen luku.");
            return;
        }
        speed = speed - amount;
        if (speed < 0){
            speed = 0;
            return;
        }
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
}



