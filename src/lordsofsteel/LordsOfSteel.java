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
        
        ArrayList<Personatge> personatges = new ArrayList<>();
        personatges.add(n1);
        personatges.add(h1);
        personatges.add(mi1);
        personatges.add(ma1);
        
        int opcio = menuPrincipal();
        switch (opcio) {
            case 1:
                afegirPersonatge();
            break;
            case 2:
                esborrarPersonatge();
            break;
            case 3:
                editarPersonatge();
            break;
            case 4:
                iniciarCombat(personatges);
            break;
            case 5:
                sortir();
            break;
        }
    }
    
    public static int menuPrincipal() {
        int opcio = 0;
        System.out.println("");
        System.out.println("** Menú principal **");
        System.out.println("1.- Afegir personatge");
        System.out.println("2.- Esborrar personatge");
        System.out.println("3.- Editar personatge");
        System.out.println("4.- Iniciar combat");
        System.out.println("5.- Sortir");
        
        boolean entradaCorrecta = false;
        do {
            System.out.print("Tria opció [1-5]: ");
            String entrada = sc.nextLine();
            if (entrada.length() == 0) {
                System.out.println("Introdueix com a mínim un caràcter");
            } else {
                try {
                    opcio = Integer.parseInt(entrada);
                    if (opcio >= 1  &&  opcio <= 5) {
                        entradaCorrecta = true;
                        break;
                    }
                    
                    System.out.println("Introdueix una opció vàlida [1-5]");
                } catch(NumberFormatException e) {
                    System.out.println("Introdueix una opció vàlida [1-5]");
                }
            }
        } while(!entradaCorrecta);
        System.out.println("");
        return opcio;
    }
    
    public static void afegirPersonatge() { // Només funcionarà una vegada per cada categoria
        String categoria, nomUsuari, armaUsuari;
        int FOR, CON, VEL, INT, SOR;
        Arma arma;
        
        System.out.print("Introdueix el nom del teu personatge: ");
        nomUsuari = sc.nextLine().toLowerCase().trim();
        String nom = nomUsuari.substring(0, 1).toUpperCase() + nomUsuari.substring(1);
        
        for (int i = 0; i < 5; i++) {
            final int PUNTSTOTALS = 60;
            int puntsRestants = 60;
            if (puntsRestants > 0) {
                switch (i) {
                    case 0:
                        boolean FORCorrecta = false;
                        do {
                            System.out.print("Introdueix la força de " + nom + " (queden " + puntsRestants + "/" + PUNTSTOTALS
                                              + " per repartir): ");
                            if (sc.hasNextInt()) {
                                int temp = sc.nextInt();
                                if (temp >= puntsRestants) {
                                    FOR = temp;
                                    FORCorrecta = true;
                                } else {
                                    System.out.println("No es poden assignar els punts, només queden " + puntsRestants + "/" + PUNTSTOTALS);
                                }
                            } else {
                                sc.nextLine();
                                System.out.println("Introdueix un valor vàlid");
                            }
                        } while (!FORCorrecta);
                    break;
                    case 1:
                        System.out.print("Introdueix la constitució de " + nom + " (queden " + puntsRestants + "/" + PUNTSTOTALS
                                            + " punts per repartir): ");
                    break;
                    case 2:
                        System.out.print("Introdueix la velocitat de " + nom + " (queden " + puntsRestants + "/" + PUNTSTOTALS
                                            + " punts per repartir): ");
                    break;
                    case 3:
                        System.out.print("Introdueix la intel·ligencia de " + nom + " (queden " + puntsRestants + "/" + PUNTSTOTALS
                                            + " punts per repartir): ");
                    break;
                    case 4:
                        System.out.print("Introdueix la sort de " + nom + " (queden " + puntsRestants + "/" + PUNTSTOTALS
                                            + " punts per repartir): ");
                    break;
                }
            } else {
                
            }
        }
        
        boolean armaCorrecta = false;
        String nomArma = "";
        do {
            System.out.print("Introdueix l'arma del teu personatge [Daga, Espasa, Martell]: ");
            armaUsuari = sc.nextLine().toLowerCase().trim();
            
            if (armaUsuari.equals("daga") || armaUsuari.equals("espasa") || armaUsuari.equals("martell")) {
                nomArma = armaUsuari.substring(0, 1).toUpperCase() + armaUsuari.substring(1);
                armaCorrecta = true;
            } else {
                System.out.println("No s'ha pogut trobar l'arma");
            }
        } while (!armaCorrecta);

        boolean categoriaCorrecta = false;
        do {
            System.out.print("Escull la categoria del teu personatge [Nan, Humà, Mitjà, maia]: ");
            categoria = sc.nextLine().toLowerCase().trim();
            switch (categoria) {
                case "nan":
                    Nan nan = new Nan("Nom", 1, 1, 1, 1, 1, new Arma(nomArma));
                    categoriaCorrecta = true;
                    break;
                case "humà":
                    categoriaCorrecta = true;
                    break;
                case "mitjà":
                    categoriaCorrecta = true;
                    break;
                case "maia":
                    categoriaCorrecta = true;
                    break;
                default:
                    System.out.println("No s'ha pogut trobar la categoria");
            }
        } while (!categoriaCorrecta);
    }
    
    public static void esborrarPersonatge() {
        // Eliminar personatge
    }
    
    public static void editarPersonatge(/* Passar personatge a editar */) {
        // Editar personatge
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
            // Comprovar entrada

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
        
        do {
            int tiradaAtacant = dau1.llencar() + dau2.llencar() + dau3.llencar();
            System.out.println("Tirada atacant: " + tiradaAtacant);

            if (tiradaAtacant <= atacant.getPA()) {
                System.out.println(atacant.getNom() + " ataca...");
                int tiradaDefensor = dau1.llencar() + dau2.llencar() + dau3.llencar();
                System.out.println("Tirada defensor: " + tiradaDefensor);

                if (tiradaDefensor > defensor.getPE()) {
                    System.out.println("I encerta! A " + defensor.getNom() + " li queden " + (defensor.getPS() - atacant.getPD()) 
                                        + "/" + defensor.getPS() + " punts de vida");
                    defensor.setPS(defensor.getPS() - atacant.getPD());
                } else {
                    System.out.println("Però " + defensor.getNom() + " l'ha esquivat!");
                }
            } else {
                System.out.println(atacant.getNom() + " ha fallat l'atac!");
            }

            // Final ronda
            Personatge aux = atacant;
            atacant = defensor;
            defensor = aux;
        } while (atacant.getPS() >= 0 && defensor.getPS() >= 0);
        
        if (atacant.getPS() <= 0) {
            System.out.println(defensor + " ha guanyat el combat contra " + atacant + "!");
            // defensor guanya pex -> pujaNivell(boolean) ? calcular noves estadístiques secundaries
            System.out.println("Com a recompensa rep " + /* pex + */ " punts d'experiència");
        } else {
            // atacant guanya pex -> pujaNivell(boolean) ? calcular noves estadístiques derivades
        }
        
        // Restaurar PS
    }
    
    public static void sortir() {
        System.out.println("""
                             _                   _              __    _____ _            _
                            | |                 | |            / _|  / ____| |          | |
                            | |     ___  _ __ __| |___    ___ | |_  | (___ | |_ ___  ___| |
                            | |    / _ \\| '__/ _` / __|  / _ \\|  _|  \\___ \\| __/ _ \\/ _ \\ |
                            | |___| (_) | | | (_| \\__ \\ | (_) | |    ____) | ||  __/  __/ |
                            |______\\___/|_|  \\__,_|___/  \\___/|_|   |_____/ \\__\\___|\\___|_|
                           
                           Gr\u00e0cies per jugar""");
    }
}
