/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantapintura;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trebol
 */
public class Station {
    private final static int PAINTED = 0, NOT_PAINTED = 1, ON_PROCESS = 2;
    private int max_cars;
    private ArrayList<Car> cars_in_process = new ArrayList<Car>();

    public Station(int max_cars){
        this.max_cars = max_cars;
    }

    public void enter(Car car){
        if( hasSpace() ){            
            paint(car);
            // Cuando ya ha vuelto de pintar
            nextCar(car);
        }else{
            stopCars(car);
        }
    }
    
    // ENTRAN DE UNO EN UNO
    private synchronized void nextCar(Car exit_car){        
        System.out.printf("\n\t>> SALE COCHE %d\n###\nSituación de la planta (ACTUAL)\n", exit_car.getPlate());
        printResume();
        notifyAll();
    }
    
    // SALEN DE UNO EN UNO
    private synchronized void stopCars(Car refused_car){
        System.out.printf("Intento de entrada por coche [%d]. No hay espacio. %d coches en proceso\n", refused_car.getPlate(), cars_in_process.size());

        try {
            wait(); // Espera un segundo
        } catch (InterruptedException ex) {
            Logger.getLogger(Station.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean hasSpace(){
        return cars_in_process.size() < max_cars;
    }
    
    private void paint(Car car){
        //System.out.printf("\n\t>> ENTRA COCHE %d\n###\nSituación de la planta (PREVIA)\n", car.getPlate());
        //printResume();
        cars_in_process.add(car);
        car.setStatus(ON_PROCESS);
        try {
            car.sleep(6000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Station.class.getName()).log(Level.SEVERE, null, ex);
        }
        car.setStatus(PAINTED);
            cars_in_process.remove(car);
    }
    
    private synchronized void printResume(){
        String resume = "";
        if( !cars_in_process.isEmpty() ){
            for( int i = 0; i < cars_in_process.size(); i++ ){
                resume += String.format("Plaza %d -> Coche %d\n", i, cars_in_process.get(i).getPlate());
            }
        System.out.printf("%s###\n", resume);
        }else
            System.out.printf("%s >> Planta VACÍA\n", resume);        
    }
}
