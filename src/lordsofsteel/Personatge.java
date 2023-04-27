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
    
    public Personatge(int FOR, int CON, int VEL, int INT, int SOR, Arma arma) {
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
}
