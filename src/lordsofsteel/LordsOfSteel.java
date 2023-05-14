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
        
        boolean sortirPrograma = false;
        do {
            int opcio = menuPrincipal();
            switch (opcio) {
                case 1:
                    afegirPersonatge(personatges);
                break;
                case 2:
                    esborrarPersonatge(personatges);
                break;
                case 3:
                    editarPersonatge(personatges);
                break;
                case 4:
                    iniciarCombat(personatges);
                break;
                case 5:
                    sortirPrograma = sortir();
                break;
            }
        } while (!sortirPrograma);
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
    
    public static void afegirPersonatge(ArrayList<Personatge> personatges) { // Només funcionarà una vegada per cada categoria
        String categoria, nomUsuari, armaUsuari;
        int FOR = 0, CON = 0, VEL = 0, INT = 0, SOR = 0;
        
        System.out.print("Introdueix el nom del teu personatge: ");
        nomUsuari = sc.nextLine().toLowerCase().trim();
        String nom = nomUsuari.substring(0, 1).toUpperCase() + nomUsuari.substring(1);
        
        final int PUNTSTOTALS = 60;
        int puntsRestants = PUNTSTOTALS;
        for (int i = 0; i < 5; i++) {
            if (puntsRestants > 0) {
                switch (i) {
                    case 0:
                        FOR = assignarPunts("força", nom, puntsRestants, PUNTSTOTALS);
                        puntsRestants -= FOR;
                    break;
                    case 1:
                        CON = assignarPunts("constitució", nom, puntsRestants, PUNTSTOTALS);
                        puntsRestants -= CON;
                    break;
                    case 2:
                        VEL = assignarPunts("velocitat", nom, puntsRestants, PUNTSTOTALS);
                        puntsRestants -= VEL;
                    break;
                    case 3:
                        INT = assignarPunts("intel·ligència", nom, puntsRestants, PUNTSTOTALS);
                        puntsRestants -= INT;
                    break;
                    case 4:
                        SOR = assignarPunts("sort", nom, puntsRestants, PUNTSTOTALS);
                        puntsRestants -= SOR;
                    break;
                }
            } else {
                System.out.println("No queden punts per assignar");
            }
        }
        
        sc.nextLine();
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
            System.out.print("Escull la categoria del teu personatge [Nan, Humà, Mitjà, Maia]: ");
            categoria = sc.nextLine().toLowerCase().trim();
            switch (categoria) {
                case "nan":
                    if (triaDevocio().equals("ordre")) {
                        NanOrdre nan = new NanOrdre(nom, FOR, CON, VEL, INT, SOR, new Arma(nomArma));
                        System.out.println("Afegit " + nom + " (Nan: Ordre) amb l'arma " + nomArma + " i estadístiques: " + FOR + "(Força), "
                                            + CON + "(Constitució), " + VEL + "(Velocitat), " + INT + "(Intel·ligència), "
                                            + SOR + "(Sort)");
                        personatges.add(nan);
                    } else {
                        NanCaos nan = new NanCaos(nom, FOR, CON, VEL, INT, SOR, new Arma(nomArma));
                        System.out.println("Afegit " + nom + " (Nan: Caos) amb l'arma " + nomArma + " i estadístiques: " + FOR + "(Força), "
                                            + CON + "(Constitució), " + VEL + "(Velocitat), " + INT + "(Intel·ligència), "
                                            + SOR + "(Sort)");
                        personatges.add(nan);
                    }
                    
                    categoriaCorrecta = true;
                    break;
                case "humà":
                    if (triaDevocio().equals("ordre")) {
                        HumaOrdre huma = new HumaOrdre(nom, FOR, CON, VEL, INT, SOR, new Arma(nomArma));
                        System.out.println("Afegit " + nom + " (Humà: Ordre) amb l'arma " + nomArma + " i estadístiques: " + FOR + "(Força), "
                                            + CON + "(Constitució), " + VEL + "(Velocitat), " + INT + "(Intel·ligència), "
                                            + SOR + "(Sort)");
                        personatges.add(huma);
                    } else {
                        HumaCaos huma = new HumaCaos(nom, FOR, CON, VEL, INT, SOR, new Arma(nomArma));
                        System.out.println("Afegit " + nom + " (Humà: Caos) amb l'arma " + nomArma + " i estadístiques: " + FOR + "(Força), "
                                            + CON + "(Constitució), " + VEL + "(Velocitat), " + INT + "(Intel·ligència), "
                                            + SOR + "(Sort)");
                        personatges.add(huma);
                    }
                    
                    categoriaCorrecta = true;
                    break;
                case "mitjà":
                    if (triaDevocio().equals("ordre")) {
                        MitjaOrdre mitja = new MitjaOrdre(nom, FOR, CON, VEL, INT, SOR, new Arma(nomArma));
                        System.out.println("Afegit " + nom + " (Mitjà: Ordre) amb l'arma " + nomArma + " i estadístiques: " + FOR + "(Força), "
                                            + CON + "(Constitució), " + VEL + "(Velocitat), " + INT + "(Intel·ligència), "
                                            + SOR + "(Sort)");
                        personatges.add(mitja);
                    } else {
                        MitjaCaos mitja = new MitjaCaos(nom, FOR, CON, VEL, INT, SOR, new Arma(nomArma));
                        System.out.println("Afegit " + nom + " (Mitjà: Caos) amb l'arma " + nomArma + " i estadístiques: " + FOR + "(Força), "
                                            + CON + "(Constitució), " + VEL + "(Velocitat), " + INT + "(Intel·ligència), "
                                            + SOR + "(Sort)");
                        personatges.add(mitja);
                    }
                    
                    categoriaCorrecta = true;
                    break;
                case "maia":
                    if (triaDevocio().equals("ordre")) {
                        MaiaOrdre maia = new MaiaOrdre(nom, FOR, CON, VEL, INT, SOR, new Arma(nomArma));
                        System.out.println("Afegit " + nom + " (Maia: Ordre) amb l'arma " + nomArma + " i estadístiques: " + FOR + "(Força), "
                                            + CON + "(Constitució), " + VEL + "(Velocitat), " + INT + "(Intel·ligència), "
                                            + SOR + "(Sort)");
                        personatges.add(maia);
                    } else {
                        MaiaCaos maia = new MaiaCaos(nom, FOR, CON, VEL, INT, SOR, new Arma(nomArma));
                        System.out.println("Afegit " + nom + " (Maia: Caos) amb l'arma " + nomArma + " i estadístiques: " + FOR + "(Força), "
                                            + CON + "(Constitució), " + VEL + "(Velocitat), " + INT + "(Intel·ligència), "
                                            + SOR + "(Sort)");
                        personatges.add(maia);
                    }
                    
                    categoriaCorrecta = true;
                    break;
                default:
                    System.out.println("No s'ha pogut trobar la categoria");
            }
        } while (!categoriaCorrecta);
    }
    
    public static void esborrarPersonatge(ArrayList<Personatge> personatges) {
        Personatge personatge = triaPersonatge(personatges, "esborrar");
        System.out.println("Esborrat " + personatge.getNom());
        personatges.remove(personatge);
        sc.nextLine();
    }
    
    public static void editarPersonatge(ArrayList<Personatge> personatges) {
        Personatge personatge = triaPersonatge(personatges, "editar");
        int puntsTotals;
        if (personatge.getNivell() > 0) {
            puntsTotals = personatge.getFOR() + personatge.getCON() + personatge.getVEL() + personatge.getINT() + personatge.getSOR();
            if (puntsTotals < 60) {
                puntsTotals = 60;
            }
        } else {
            puntsTotals = 60;
        }
        
        int puntsRestants = puntsTotals;
        int FORA = personatge.getFOR(), CONA = personatge.getCON(), VELA = personatge.getVEL(), 
                    INTA = personatge.getINT(), SORA = personatge.getSOR(); // A = Anterior
        for (int i = 0; i < 5; i++) {
            if (puntsRestants > 0) {
                switch (i) {
                    case 0:
                        personatge.setFOR(assignarPunts("força", personatge.getNom(), puntsRestants, puntsTotals));
                        puntsRestants -= personatge.getFOR();
                    break;
                    case 1:
                        personatge.setCON(assignarPunts("constitució", personatge.getNom(), puntsRestants, puntsTotals));
                        puntsRestants -= personatge.getCON();
                    break;
                    case 2:
                        personatge.setVEL(assignarPunts("velocitat", personatge.getNom(), puntsRestants, puntsTotals));
                        puntsRestants -= personatge.getVEL();
                    break;
                    case 3:
                        personatge.setINT(assignarPunts("intel·ligència", personatge.getNom(), puntsRestants, puntsTotals));
                        puntsRestants -= personatge.getINT();
                    break;
                    case 4:
                        personatge.setSOR(assignarPunts("sort", personatge.getNom(), puntsRestants, puntsTotals));
                        puntsRestants -= personatge.getSOR();
                    break;
                }
            } else {
                System.out.println("No queden punts per assignar");
            }
        }
        
        System.out.println("S'han fet les següents modificacions per a " + personatge.getNom() + "\n"
                + "Força: " + FORA + " -> " + personatge.getFOR()
                + ", Constitució: " + CONA + " -> " + personatge.getCON()
                + ", Velocitat: " + VELA + " -> " + personatge.getVEL()
                + ", Inteligència: " + INTA + " -> " + personatge.getINT()
                + ", Sort: " + SORA + " -> " + personatge.getSOR());
        sc.nextLine();
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

            boolean opcioCorrecta = false;
            int opcio = 0;
            do {
                System.out.print("Tria un personatge (" + i + "): ");
                if (sc.hasNextInt()) {
                    int temp = sc.nextInt();
                    if (temp >= 0 && temp <= personatges.size()) {
                        if (personatgesActius[temp - 1] == true) {
                            System.out.println(lluitadors[0].getNom() + " no pot lluitar contra si mateix");
                        } else {
                            opcio = temp;
                            opcioCorrecta = true;
                        }
                    } else {
                        System.out.println("Només hi ha " + (personatges.size() - (i - 1)) + " personatges disponibles");
                    }
                } else {
                    sc.nextLine();
                    System.out.println("Introdueix un valor vàlid");
                }
            } while (!opcioCorrecta);

            personatgesActius[opcio - 1] = true;
            lluitadors[i - 1] = personatges.get(opcio - 1);
            System.out.println("Personatge triat: " + personatges.get(opcio - 1).getNom());
            System.out.println("");
        }
        
        int random = (int)(Math.random());
        Personatge atacant, defensor, atacantInicial, defensorInicial;
        if (random == 0) {
            atacant = lluitadors[0];
            defensor = lluitadors[1];
            atacantInicial = lluitadors[0];
            defensorInicial = lluitadors[1];
        } else {
            atacant = lluitadors[1];
            defensor = lluitadors[0];
            atacantInicial = lluitadors[1];
            defensorInicial = lluitadors[0];
        }
        
        Dau dau1 = new Dau();
        Dau dau2 = new Dau();
        Dau dau3 = new Dau();
        
        int nRonda = 1;
        int defensorPSInicials = defensor.getPS();
        int atacantPSInicials = atacant.getPS();
        do {
            System.out.println("\nRonda " + nRonda);
            int tiradaAtacant = dau1.llencar() + dau2.llencar() + dau3.llencar();
            System.out.println("Tirada atacant: " + tiradaAtacant);

            if (tiradaAtacant <= atacant.getPA()) {
                System.out.println(atacant.getNom() + " ataca...");
                int tiradaDefensor = dau1.llencar() + dau2.llencar() + dau3.llencar();
                System.out.println("Tirada defensor: " + tiradaDefensor);

                if (tiradaDefensor > defensor.getPE()) {
                    if (defensor.getPS() - atacant.getPD() <= 0) {
                        System.out.println("I encerta! A " + defensor.getNom() + " ja no li queden més punts de vida");
                    } else {
                        System.out.println("I encerta! A " + defensor.getNom() + " li queden " + (defensor.getPS() - atacant.getPD())
                                            + " punts de vida");
                    }
                    
                    defensor.setPS(defensor.getPS() - atacant.getPD());
                    if (atacant instanceof NanOrdre || atacant instanceof HumaOrdre || atacant instanceof MitjaOrdre
                        || atacant instanceof MaiaOrdre) atacant.restaurarPS();
                } else {
                    System.out.println("Però " + defensor.getNom() + " l'ha esquivat!");
                    if (defensor instanceof NanCaos || defensor instanceof HumaCaos || defensor instanceof MitjaCaos
                        || defensor instanceof MaiaCaos) {
                        boolean contraatac = defensor.contraatac(dau1, dau2, dau3);
                        if (contraatac && atacant.getPS() - defensor.getPD() > 0) {
                            System.out.println(defensor.getNom() + " encerta el contraatac! A " + atacant.getNom() + " li queden "
                                                + (atacant.getPS() - defensor.getPD() + " punts de vida"));
                            atacant.setPS(atacant.getPS() - defensor.getPD());
                        } else if (contraatac && atacant.getPS() - defensor.getPD() <= 0) {
                            System.out.println(defensor.getNom() + " encerta el contraatac! A " + atacant.getNom() 
                                                + " ja no li punts de vida");
                            atacant.setPS(atacant.getPS() - defensor.getPD());
                        } else {
                            System.out.println(defensor.getNom() + " no ha pogut contraatacar");
                        }
                    }
                }
            } else {
                System.out.println(atacant.getNom() + " ha fallat l'atac!");
            }
            
            nRonda++;
            Personatge aux = atacant;
            atacant = defensor;
            defensor = aux;
        } while (atacant.getPS() > 0 && defensor.getPS() > 0);
        
        defensorInicial.setPS(defensorPSInicials);
        atacantInicial.setPS(atacantPSInicials);
        
        if (atacant.getPS() <= 0) { // Guanya el defensor (atacant de l'ultima ronda)
            System.out.println("\n" + defensor.getNom() + " ha guanyat el combat contra " + atacant.getNom() + "!");
            defensor.setPex(defensor.getPex() + atacantPSInicials);
            System.out.println("Com a recompensa rep " + atacantPSInicials + " punts d'experiència (PEX totals: " + defensor.getPex() + ")");
            pujaNivell(defensor);
        } else { // Guanya l'atacant (defensor de l'ultima ronda)
            System.out.println("\n" + atacant.getNom() + " ha guanyat el combat contra " + defensor.getNom() + "!");
            atacant.setPex(atacant.getPex() + defensorPSInicials);
            System.out.println("Com a recompensa rep " + defensorPSInicials + " punts d'experiència (PEX totals: " + atacant.getPex() + ")");
            pujaNivell(atacant);
        }
        
        sc.nextLine();
    }
    
    public static boolean sortir() {
        boolean resultat = false;
        boolean opcioValida = false;
        do {
            System.out.print("Estàs segur que vols sortir? [S/N]: ");
            char SN = sc.nextLine().toUpperCase().trim().charAt(0);
            switch (SN) {
                case 'S':
                    System.out.println("""
                             _                   _              __    _____ _            _
                            | |                 | |            / _|  / ____| |          | |
                            | |     ___  _ __ __| |___    ___ | |_  | (___ | |_ ___  ___| |
                            | |    / _ \\| '__/ _` / __|  / _ \\|  _|  \\___ \\| __/ _ \\/ _ \\ |
                            | |___| (_) | | | (_| \\__ \\ | (_) | |    ____) | ||  __/  __/ |
                            |______\\___/|_|  \\__,_|___/  \\___/|_|   |_____/ \\__\\___|\\___|_|
                           
                           Gràcies per jugar""");
                    resultat = true;
                    opcioValida = true;
                case 'N':
                    opcioValida = true;
                break;
                default:
                    System.out.println("Introdueix una opció vàlida [S/N]");
                break;
            }
        } while (!opcioValida);
        
        return resultat;
    }
    
    public static String triaDevocio() {
        boolean devocioCorrecta = false;
        String devocio;
        do {   
            System.out.print("Tria una devoció [Ordre, Caos]: ");
            devocio = sc.nextLine().toLowerCase().trim();
            switch (devocio) {
                case "ordre":
                case "caos":
                    devocioCorrecta = true;
                break;
                default:
                    System.out.println("No s'ha pogut trobar la devoció");
                break;
            }
        } while (!devocioCorrecta);
        
        
        return devocio;
    }
    
    public static int assignarPunts(String nomEstadistica, String nom, int puntsRestants, int puntsTotals) {
        int estadistica = 0;
        boolean estadisticaCorrecta = false;
        do {
            System.out.print("Introdueix la " + nomEstadistica + " de " + nom + " (queden " + puntsRestants + "/" + puntsTotals
                              + " per repartir): ");
            if (sc.hasNextInt()) {
                int temp = sc.nextInt();
                if (temp <= puntsRestants) {
                    if (temp < 3) {
                        System.out.println("Com a mínim has d'assignar 3 punts per estadística");
                    } else if (temp > 18) {
                        System.out.println("Com a máxim pots assignar 18 punts per estadística");
                    } else {
                        estadistica = temp;
                        estadisticaCorrecta = true;
                    }
                } else {
                    System.out.println("No es poden assignar els punts, només queden " + puntsRestants + "/" + puntsTotals);
                }
            } else {
                sc.nextLine();
                System.out.println("Introdueix un valor vàlid");
            }
        } while (!estadisticaCorrecta);
        
        return estadistica;
    }
    
    public static Personatge triaPersonatge(ArrayList<Personatge> personatges, String acció) {
        for (int i = 0; i < personatges.size(); i++) {
            String tipus = "";
            if (personatges.get(i) instanceof Nan) {
                tipus = "Nan";
            } else if (personatges.get(i) instanceof Huma) {
                tipus = "Humà";
            } else if (personatges.get(i) instanceof Mitja) {
                tipus = "Mitjà";
            } else if (personatges.get(i) instanceof Maia) {
                tipus = "Maia";
            }
            
            System.out.println((i + 1) + ".- " + personatges.get(i).getNom() + "(" + tipus + ")");
        }
        
        boolean opcioCorrecta = false;
        int opcio = 0;
        do {
            System.out.print("Tria el personatge que vols " + acció + ": ");
            if (sc.hasNextInt()) {
                int temp = sc.nextInt();
                if (temp >= 0 && temp <= personatges.size()) {
                    opcio = temp;
                    opcioCorrecta = true;
                } else {
                    System.out.println("Només hi ha " + (personatges.size()) + " personatges disponibles");
                }
            } else {
                sc.nextLine();
                System.out.println("Introdueix un valor vàlid");
            }
        } while (!opcioCorrecta);
        
        return personatges.get(opcio - 1);
    }
    
    public static void pujaNivell(Personatge personatge) {
        if (personatge.getPex() >= 100 && personatge.getNivell() == 0) {
            nouNivell(personatge, '1');
        } else if (personatge.getPex() >= 200 && personatge.getNivell() == 1) {
            nouNivell(personatge, '2');
        } else if (personatge.getPex() >= 500 && personatge.getNivell() == 2) {
            nouNivell(personatge, '3');
        } else if (personatge.getPex() >= 1000 && personatge.getNivell() == 3) {
            nouNivell(personatge, '4');
        } else if (personatge.getPex() >= 2000 && personatge.getNivell() == 4) {
            nouNivell(personatge, '5');
        }
    }
    
    public static void nouNivell(Personatge personatge, char nivell) {
        System.out.println("Enhorabona, " + personatge.getNom() + " ha pujat a nivell " + nivell + "!");
        personatge.setNivell(personatge.getNivell() + 1);
        personatge.setFOR(personatge.getFOR() + 1);
        personatge.setCON(personatge.getCON() + 1);
        personatge.setVEL(personatge.getVEL() + 1);
        personatge.setINT(personatge.getINT() + 1);
        personatge.setSOR(personatge.getSOR() + 1);
        int PSA = personatge.getPS(), PDA = personatge.getPD(), PAA = personatge.getPA(), PEA = personatge.getPE(); // A = Anterior
        personatge.calculaEstadistiquesDerivades();
        System.out.println("PS: " + PSA + " -> " + personatge.getPS()
                            + ", PD: " + PDA + " -> " + personatge.getPD()
                            + ", PA: " + PAA + " -> " + personatge.getPA()
                            + ", PE: " + PEA + " -> " + personatge.getPE());
    }
}
