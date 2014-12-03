/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moverpelota;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class Pelota{
    
    public int altura = 50;
    public int anchura = 50;
    public int x;
    public int y;
    public String movimiento;
    private Campo campo;
    private boolean libre;
    
    public Pelota(int x,int y,int anchura, int altura,Campo campo){
        this.x = x;
        this.y = y;
        this.anchura = anchura;
        this.altura = altura;
        this.campo = campo;
        this.libre = true;
    }

    public void moverDerecha(){
        
        x = x+1;
        movimiento = "derecha";
        
    }
    
    public void moverIzquierda(){
        
        x = x-1;
        movimiento = "izquierda";
        
    }
}
