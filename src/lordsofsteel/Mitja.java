/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lordsofsteel;

public class Mitja extends Personatge {
    public Mitja(int FOR, int CON, int VEL, int INT, int SOR, Arma arma) {
        super(FOR, CON, VEL, INT, SOR, arma);
    }
    
    @Override
    public void calculaEstadistiquesDerivades() {
        super.calculaEstadistiquesDerivades();
        PE = VEL + SOR + INT + FOR;
    }
}
