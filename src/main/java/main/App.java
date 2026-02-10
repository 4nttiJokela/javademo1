package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Anna tehtaalle nimi: ");
        String factoryName = scanner.nextLine();

        Factory factory = new Factory (factoryName);

        boolean exit = false;

        while (!exit) {

            System.out.println("1) Lisää kone");
            System.out.println("2) Listaa kaikki koneet");
            System.out.println("0) Lopeta ohjelma");

            if (scanner.hasNext()) {
                int i = 0;
                String stringInput = scanner.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                        System.out.println("Anna koneen tyyppi:");
                        String machineType = scanner.nextLine();

                        System.out.println("Anna koneen malli:");
                        String machineModel = scanner.nextLine();
                    
                        System.out.println("Anna työntekijän nimi:");
                        String workerName = scanner.nextLine();

                        System.out.println("Anna työntekijän ammattinimike:");
                        String workerRole = scanner.nextLine();

                        Worker newWorker = new Worker(workerName, workerRole);
                        Machine newMachine = new Machine(machineType, machineModel, newWorker);
                        factory.addMachine(newMachine);
                        break;
                    
                    case 2:
                        System.out.println("Tehtaasta " + factory.getName() + " löytyy seuraavat koneet:");
                        ArrayList<Machine> machines = factory.getMachines();

                        for (int index = 0; index < machines.size(); index++) {
                            Machine m = machines.get(index);
                            System.out.println(m.getMachineDetails());
                            System.out.println();
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