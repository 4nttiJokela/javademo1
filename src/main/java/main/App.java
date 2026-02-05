package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

                        System.out.println("Anna hirviön elämän määrä numerona: ");
                        String stringHealth = scanner.nextLine();
                        int health = Integer.parseInt(stringHealth);
                        
                        Monster newMonster = new Monster(type, health);
                        cave.addMonster(newMonster);
                        break;
                    
                    case 2:
                        cave.listMonsters();
                        break;

                    case 3:
                        if (cave.monsterCount() == 0) {
                            System.out.println("Luola on tyhjä.");
                            break;
                        }
                        System.out.println("Valitse hirviö, johon hyökätä: ");
                        cave.listMonsters();

                        String stringIndex = scanner.nextLine();
                        int index = Integer.parseInt(stringIndex);
                        index = index -1;

                        Monster target = cave.getMonster(index);
                        boolean alive = cave.player.attack(target);

                        if(!alive) {
                            cave.removeMonster(target);
                        }
                        break;
                    
                    case 4:
                        System.out.println("Anna tiedoston nimi, johon peli tallentaa: ");
                        String saveFile = scanner.nextLine();

                        try {
                            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile));
                        out.writeObject(cave);
                        out.close();
                        System.out.println("Peli tallennettiin tiedostoon " + saveFile);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 5:
                        System.out.println("Anna tiedoston nimi, josta peli ladataan: ");
                        String loadFile = scanner.nextLine();
                        try {
                            ObjectInputStream in = new ObjectInputStream(new FileInputStream(loadFile));
                            cave = (Cave) in.readObject();
                            in.close();
                            System.out.println("Peli ladattu tiedostosta" + loadFile + ". Tervetuloa takaisin " + cave.player.name + ".");
                        } catch (Exception e) {
                            System.out.println("Lataus epäonnistui.");
                        }
                        break;
                    
                    case 0:
                        exit = true;
                        System.out.println("Peli päättyi. Kiitos pelaamisesta!");
                        break;
                    
                    default:
                        System.out.println("Virheellinen valinta.");
                }
            }
        
        }
        scanner.close();
    }
}