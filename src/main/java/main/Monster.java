package main;

public class Monster {
    private String type;
    private int health;

    public Monster (String type, int health) {
        this.type = type;
        this.health = health;
    }

    public void printInfo (int number) {
        System.out.println(number + ":" + type + " / " + health + "HP");
    }

    public boolean takeDamage (int dmg) {
        health -= dmg;
        if (health > 0) {
            System.out.println("Hirviöllä on " + health + " elämää jäljellä.");
            return true;
        } else {
            System.out.println(type + " on kuollut!");
            return false;
        } 
    }

    public String getType () {
        return type;
    }
    
}
