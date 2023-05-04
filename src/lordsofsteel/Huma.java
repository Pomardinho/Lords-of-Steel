/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lordsofsteel;

public class Huma extends Personatge {
    public Huma(String nom, int FOR, int CON, int VEL, int INT, int SOR, Arma arma) {
        super(nom, FOR, CON, VEL, INT, SOR, arma);
    }
    
    @Override
    public void calculaEstadistiquesDerivades() {
        super.calculaEstadistiquesDerivades();
        PS = CON + FOR + INT;
    }
}
