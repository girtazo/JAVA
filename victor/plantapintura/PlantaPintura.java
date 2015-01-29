/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantapintura;

/**
 *
 * @author trebol
 */
public class PlantaPintura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Station station = new Station(5);
        Car[] cars = new Car[10];
        for(int i = 0; i < 10; i++){
            Car car = new Car( (int)( ( Math.random()*100000 )+1 ) );
            cars[i] = car;
            car.enter(station);
            //car.start();
        }
        
    }
    
}
