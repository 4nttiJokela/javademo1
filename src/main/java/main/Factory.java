package main;

import java.util.ArrayList;

public class Factory {
    
    private String name;
    private ArrayList<Machine> machines;

    public Factory (String name) {
        this.name = name;
        this.machines = new ArrayList<>();
    }

    public void addMachine (Machine machine) {
        machines.add(machine);
        System.out.println("Kone lisätty!");
    }

    public ArrayList getMachines() {
        return machines;
    }

    public String getName() {
        return name;
    }
}
