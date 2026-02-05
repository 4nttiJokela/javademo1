package main;

import java.io.Serializable;

public class Player implements Serializable {
    public String name;

    public Player (String name) {
        this.name = name;
    }

    public boolean attack (Monster target) {
        System.out.println(name + " hyökkää " + target.type + " hirviöön!");
        return target.takeDamage(10);
    }
}