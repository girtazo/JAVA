/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moverpelota;

/**
 *
 * @author mati
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Campo campo = new Campo();
        campo.init();
        campo.start();
    }
    
}
