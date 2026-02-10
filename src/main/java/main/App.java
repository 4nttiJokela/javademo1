package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Instrument> instruments = new ArrayList<>();

        boolean exit = false;

        while (!exit) { 

            System.out.println("1) Lisää soitin");
            System.out.println("2) Listaa soittimet");
            System.out.println("3) Viritä kielisoittimet");
            System.out.println("4) Soita rumpuja");
            System.out.println("0) Lopeta ohjelma");

            if (scanner.hasNext()) {
                int i = 0;
                String stringInput = scanner.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                        System.out.println("Minkä soittimen haluat lisätä? 1) Kitara, 2) Viulu, 3) Rummut");
                        String stringChoice = scanner.nextLine();
                        int choice =  Integer.parseInt(stringChoice);

                        System.out.println("Anna valmistajan nimi:");
                        String manufacturer = scanner.nextLine();

                        System.out.println("Anna hinta euroina:");
                        int price = Integer.parseInt(scanner.nextLine());
                        
                        if (choice == 1) {
                            Guitar newGuitar = new Guitar(manufacturer, price);
                            instruments.add(newGuitar);
                        } else if (choice == 2) {
                            Violin newViolin = new Violin(manufacturer, price);
                            instruments.add(newViolin);
                        } else if (choice == 3) {
                            Drum newDrums = new Drum(manufacturer, price);
                            instruments.add(newDrums);
                        } else {
                            System.out.println("Virheellinen soitinvalinta.");
                        }
                        break;
                    
                    case 2:
                        if (instruments.isEmpty()) {
                            System.out.println("Ei lisättyjä soittimia");
                        } else {
                            for (Instrument inst : instruments) {
                                System.out.println(inst.getDetails());
                            }
                        }
                        break;

                    case 3:
                        for(Instrument inst : instruments) {
                            if(inst instanceof StringInstrument) {
                                StringInstrument stringInst = (StringInstrument) inst;
                                stringInst.tune();
                            }
                        }
                        break;

                    case 4:
                        for (Instrument inst : instruments) {
                            if (inst instanceof Drum) {
                                Drum drum = (Drum) inst;
                                drum.playBeat();
                            }
                        }
                        break;
                        
                    case 0:
                        exit = true;
                        System.out.println("Kiitos ohjelman käytöstä.");
                        break;
                    
                    default:
                        System.out.println("Virheellinen valinta.");
                }
            }
        
        }
        scanner.close();
    }
}