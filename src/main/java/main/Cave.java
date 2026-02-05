package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Cave implements Serializable {

    public Player player;
    private ArrayList<Monster> monsters;

    public Cave (Player player) {
        this.player = player;
        this.monsters = new ArrayList<>();
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);

    }

    public void listMonsters() {
        if (monsters.isEmpty()) {
            System.out.println("Luola on tyhjä.");
            return;
        }
        for (int i = 0; i < monsters.size(); i++) {
            monsters.get(i).printInfo(i+1);
        }
    }

    public int monsterCount() {
        return monsters.size();
    }

    public Monster getMonster (int index) {
        return monsters.get(index);
    }

    public void removeMonster(Monster i) {
        monsters.remove(i);
    }
}


