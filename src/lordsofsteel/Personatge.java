/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lordsofsteel;

public abstract class Personatge {
    /* Atributs principals */
    protected String nom;
    protected Arma arma;
    protected int pex;
    protected int nivell;
    
    /* Estadístiques */
    protected int FOR; // Força
    protected int CON; // Constitució
    protected int VEL; // Velocitat
    protected int INT; // Intel·ligència
    protected int SOR; // Sort
    
    /* Estadístiques derivades */
    protected int PS; // Punts de salut
    protected int PD; // Punts de dany
    protected int PA; // Probabilitat d'atacar
    protected int PE; // Probabilitat d'esquivar
    
    public Personatge(String nom, int FOR, int CON, int VEL, int INT, int SOR, Arma arma) {
        this.nom = nom;
        this.FOR = FOR;
        this.CON = CON;
        this.VEL = VEL;
        this.INT = INT;
        this.SOR = SOR;
        this.arma = arma;
        calculaEstadistiquesDerivades();
    }
    
    protected void calculaEstadistiquesDerivades() {
        PS = CON + FOR;
        PD = (FOR + arma.WPOW) / 4;
        PA = INT + SOR + arma.WVEL;
        PE = VEL + SOR + INT;
    }
    
    public void setSOR(int SOR) {
        this.SOR = SOR;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setArma(Arma arma) {
        this.arma = arma;
    }
     
    public void setPex(int pex) {
        this.pex = pex;
    }
     
    public void setNivell(int nivell) {
        this.nivell = nivell;
    }
     
    public void setFOR(int FOR) {
        this.FOR = FOR;
    }
     
    public void setCON(int CON) {
        this.CON = CON;
    }
    
    public void setVEL(int VEL) {
        this.VEL = VEL;
    }
    
    public void setINT(int INT) {
        this.INT = INT;
    }
    
    public void setPS(int PS) {
        this.PS = PS;
    }
    
    public void setPD(int PD) {
        this.PD = PD;
    }
    
    public void setPA(int PA) {
        this.PA = PA;
    }
    
    public void setPE(int PE) {
        this.PE = PE;
    }
    
    public String getNom() {
        return nom;
    }
    
    public Arma getArma() {
        return arma;
    }
    
    public int getPex() {
        return pex;
    }
    
    public int getNivell() {
        return nivell;
    }

    public int getFOR() {
        return FOR;
    }

    public int getCON() {
        return CON;
    }

    public int getVEL() {
        return VEL;
    }

    public int getINT() {
        return INT;
    }
    
     public int getSOR() {
        return SOR;
    }
    
    public int getPS() {
        return PS;
    }

    public int getPD() {
        return PD;
    }

    public int getPA() {
        return PA;
    }

    public int getPE() {
        return PE;
    }
    
    public void restaurarPS() {
        int PSInicials = this.CON + this.FOR;
        if (this.PS < PSInicials) {
            int restaura = (int)(this.PS * 1.10);
            if (restaura > PSInicials) {
                restaura -= restaura - PSInicials;
                System.out.println("PS restaurats al màxim (" + this.PS + "/" + PSInicials + ")");
            } else {
                System.out.println("PS restaurats un 10% (" + this.PS + "/" + PSInicials + " -> " + restaura + "/" + PSInicials + ")");
            }
            
            this.setPS(restaura);
        } else {
            System.out.println("Els PS ja estan al màxim (" + this.PS + "/" + PSInicials + ")");
        }
    }
}
