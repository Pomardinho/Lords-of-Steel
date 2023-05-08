/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package lordsofsteel;
import java.util.Scanner;
import java.util.ArrayList;

public class LordsOfSteel {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Nan n1 = new Nan("Tirion", 8, 6, 13, 16, 16, new Arma("Daga"));
        Huma h1 = new Huma("Luis", 13, 16, 6, 10, 6, new Arma("Espasa"));
        Mitja mi1 = new Mitja("Frodo", 9, 7, 7, 15, 16, new Arma("Martell"));
        Maia ma1 = new Maia("Nil", 7, 9, 12, 15, 17, new Arma("Daga"));
        
        ArrayList<Personatge> personatges = new ArrayList<Personatge>();
        personatges.add(n1);
        personatges.add(h1);
        personatges.add(mi1);
        personatges.add(ma1);
        
        /* Menu principal */
        System.out.println("");
        System.out.println("** Menú principal **");
        System.out.println("1.- Afegir personatge");
        System.out.println("2.- Esborrar personatge");
        System.out.println("3.- Editar personatge");
        System.out.println("4.- Iniciar combat");
        System.out.println("5.- Sortir");
        System.out.print("Tria opció [1-5]: ");
        
        String entrada = sc.nextLine();
        // Comprovar entrada
        int opcio = Integer.parseInt(entrada);
        System.out.println("");
        
        switch (opcio) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                iniciarCombat(personatges);
                break;
            case 5:
                break;
        }
    }
    
    public static void iniciarCombat(ArrayList<Personatge> personatges) {
        boolean[] personatgesActius = new boolean[personatges.size()];
        Personatge[] lluitadors = new Personatge[2];
        
        for (int i = 1; i <= 2; i++) {
            for (int j = 0; j < personatges.size(); j++) {
                if (!personatgesActius[j]) {
                    String tipus = "";
                    if (personatges.get(j) instanceof Nan) {
                        tipus = "Nan";
                    } else if (personatges.get(j) instanceof Huma) {
                        tipus = "Humà";
                    } else if (personatges.get(j) instanceof Mitja) {
                        tipus = "Mitjà";
                    } else if (personatges.get(j) instanceof Maia) {
                        tipus = "Maia";
                    }

                    System.out.println((j + 1) + ".- " + personatges.get(j).getNom() + "(" + tipus + ")");
                }
            }

            System.out.print("Tria un personatge (" + i + "): ");
            int opcio = sc.nextInt();

            // String entrada = sc.nextLine();
            // Comprovar entrada
            // int opcio = Integer.parseInt(entrada);

            personatgesActius[opcio - 1] = true;
            lluitadors[i - 1] = personatges.get(opcio - 1);
            System.out.println("Personatge triat: " + personatges.get(opcio - 1).getNom());
            System.out.println("");
        }
        
        // Inici combat
        int random = (int)(Math.random());
        Personatge atacant, defensor;
        if (random == 0) {
            atacant = lluitadors[0];
            defensor = lluitadors[1];
        } else {
            atacant = lluitadors[1];
            defensor = lluitadors[0];
        }
        
        Dau dau1 = new Dau();
        Dau dau2 = new Dau();
        Dau dau3 = new Dau();
        
        int tiradaAtacant = dau1.llencar() + dau2.llencar() + dau3.llencar();
        System.out.println("Tirada: " + tiradaAtacant);
        
        if (tiradaAtacant <= atacant.getPA()) {
            System.out.println(atacant + " ataca...");
            int tiradaDefensor = dau1.llencar() + dau2.llencar() + dau3.llencar();
            System.out.println("Tirada: " + tiradaDefensor);
            
            if (tiradaDefensor > defensor.getPE()) {
                System.out.println("I encerta! A " + defensor + " li queden " + (defensor.getPS() - atacant.getPD()) 
                                    + "/" + defensor.getPS() + " punts de vida");
                defensor.setPS(defensor.getPS() - atacant.getPD());
            } else {
                System.out.println("Però " + defensor + " l'ha esquivat!");
            }
        }
        
        // Final ronda
        Personatge aux = atacant;
        atacant = defensor;
        defensor = aux;
        
        // Combatre fins que només quedi un personatge amb PS
    }
}
