package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Syötä pelaajan nimi: ");
        String name = scanner.nextLine();

        Player player = new Player(name);
        Cave cave = new Cave(player);

        boolean exit = false;

        while (!exit) {
            System.out.println("1) Lisää luolaan hirviö");
            System.out.println("2) Listaa hirviöt");
            System.out.println("3) Hyökkää hirviöön");
            System.out.println("4) Tallenna peli");
            System.out.println("5) Lataa peli");
            System.out.println("0) Lopeta peli");

            if (scanner.hasNext()) {
                int i = 0;
                String stringInput = scanner.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                        System.out.println("Anna hirviön tyyppi: ");
                        String type = scanner.nextLine();
                        System.out.println("Anna hirviön elämän määrä numeroina: ");
                        int health = Integer.parseInt(scanner.nextLine());
                        Monster newMonster = new Monster (type, health);
                        cave.addMonster(newMonster);
                        break;
                    
                    case 2:
                        cave.listMonsters();
                        break;
                    
                    case 3:
                        cave.listMonsters();
                        if (!cave.getMonsters().isEmpty()) {
                            System.out.println("Valitse hirviö, johon hyökätä: ");
                            cave.printMonsterListOnly();
                            int index = Integer.parseInt(scanner.nextLine()) -1;
                            if (index >= 0 && index < cave.getMonsters().size()) {
                                Monster target = cave.getMonsters().get(index);
                                boolean alive = cave.player.attack(target);
                                if (!alive) {
                                    cave.removeMonsters(index); 
                                }
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Anna tiedoston nimi, johon peli tallentaa:");
                        String saveFile = scanner.nextLine();
                        
                        try {
                            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile));
                            out.writeObject(cave);
                            out.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Peli tallennettiin tiedostoon " + saveFile + ".");
                        break;

                    case 5:
                        System.out.println("Anna tiedoston nimi, josta peli ladataan:");
                        String loadFile = scanner.nextLine();
 
                        ObjectInputStream in;
                        try {
                            in = new ObjectInputStream(new FileInputStream(loadFile));
                            try {
                                cave = (Cave) in.readObject();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                        } catch (FileNotFoundException e) {

                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        System.out.println("Peli ladattu tiedostosta "+ loadFile + ". Tervetuloa takaisin, "+ name + ".");
                        break;

                    case 0:
                        System.out.println("Peli päättyy. Kiitos pelaamisesta!");
                        exit = true;
                        break;

                    default:
                        System.out.println("Virheellinen valinta");
                        break;
                }
            }
        }scanner.close();
    }
}