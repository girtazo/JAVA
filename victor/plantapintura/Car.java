/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantapintura;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trebol
 */
public class Car extends Thread{
    private final static int PAINTED = 0, NOT_PAINTED = 1, ON_PROCESS = 2;
    private int plate;
    private Station station;
    private int status = NOT_PAINTED;
    
    public Car(int plate){
        this.plate = plate;
    }
    
    public void enter(Station station){
        this.station = station;
        this.start();
    }
    
    @Override
    public void run(){
        while( status != PAINTED ){
            station.enter(this);
            
            if( status == PAINTED )
                break;
            /*else{
                try {
                    // ON_PROCESS
                    sleep(6000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
        }
    }
    
    public int getStatus(){
        return status;
    }
    
    public void setStatus(int status){
        this.status = status;
    }
    
    public int getPlate(){
        return plate;
    }
}