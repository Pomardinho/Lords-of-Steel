/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lordsofsteel;

public class Nan extends Personatge {
    public Nan(int FOR, int CON, int VEL, int INT, int SOR, Arma arma) {
        super(FOR, CON, VEL, INT, SOR, arma);
    }
    
    @Override
    public void calculaEstadistiquesDerivades() {
        super.calculaEstadistiquesDerivades();
        PD = (FOR + arma.WPOW + CON) / 4;
    }
}
