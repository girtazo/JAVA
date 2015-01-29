/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teatro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author victor
 */
public class Theater {
    
    // Creamos e iniciaizamos el ArrayList de butacas con su tipo, cantidad y coste
    private ArrayList<Chair> chairs = new ArrayList<Chair>() {{
        int chair_number = 1;
        for(int i = 0; i < 3; i++){
            add(new Chair("VIP1", 250, chair_number++));
        }
        for(int i = 0; i < 3; i++){
            add(new Chair("VIP2", 250, chair_number++));
        }
        for(int i = 0; i < 4; i++){
            add(new Chair("LAT1", 100, chair_number++));
        }
        for(int i = 0; i < 4; i++){
            add(new Chair("LAT2", 100, chair_number++));
        }
        for(int i = 0; i < 8; i++){
            add(new Chair("GAL", 150, chair_number++));
        }
        for(int i = 0; i < 54; i++){
            add(new Chair("CEN", 80, chair_number++));
        }
    }};
    
    /**
     * Devuelve TRUE si hay butacas del tipo type disponibles
     * o FALSE en su defecto
     * @param type tipo de butaca
     * @return TRUE si hay butacas de tipo type disponibles, FALSE si no
     */
    public boolean chairTypeIsAvailable(String type){
        for(Chair chair : chairs){
            if( chair.getType().equals(type.toUpperCase()) ){
                if(chair.isAvailable())
                    return true;
            }
        }
        return false;
    }
    
    /**
     * Busca una butaca del tipo type y cuando encuentra una disponible la
     * marca como [no-disponible] y devuelve un ticket informativo
     * @param type tipo de la butaca
     * @return ticket informativo con el numero de butaca y su tipo
     */
    public String getChair(String type){
        for( int i = 0; i < chairs.size(); i++ ){
            if( chairs.get(i).getType().equals(type.toUpperCase()) ){
                if( chairs.get(i).isAvailable() ){
                    chairs.get(i).markAsNotAvailable();
                    return String.format("Reservada butaca #%d (%s)",
                            chairs.get(i).getNumber(), type);
                }
            }
        }
        return "Butaca no disponible";
    }
    
    /**
     * Hace inventario y devuelve informacion sobre las butacas disponibles,
     * su tipo y su precio
     * @return resumen del inventario de butacas
     */
    public String getInventoryInfo(){
        String type, output = "\nButacas disponibles:\n";        
        // Guarda la cantidad de butacas disponible de cada itp
        HashMap<String, Integer> info = new HashMap<String, Integer>();
        ArrayList <Integer> prices = new ArrayList<Integer>();
        for( Chair chair : chairs ){
            // Si ya guardamos informacion sobre esta categoria de butacas
            if(info.containsKey((type = chair.getType()))) {
                if(chair.isAvailable())// Incrementamos el numero de butacas
                    info.put(type, info.get(type) + 1);
            }else{ // Si no lo inicializamos con el numero de butacas a 0
                if(chair.isAvailable()){
                    info.put(type, 1);
                    prices.add(chair.price); // Y guardamos su precio
                }
            }
        }
        // Formateo del string de salida
        if(info.isEmpty())
            return "No quedan butacas libres\n";
        Iterator iterator = info.entrySet().iterator();
        int i = 0; // Para iterar el arraylist de precios
        while(iterator.hasNext()){
            output += String.format("%s a %d€ cada una\n", 
                    iterator.next(), prices.get(i++));
        }
        return output;
    }
    
    /**
     * Clase de datos privada interna que representa una butaca
     * Metodos setters y getters (sobra comentar)
     */
    private class Chair{
        
        private String type;
        private int price;
        private int number;
        private boolean available;
        
        public Chair(String type, int price, int number){
            this.type = type;
            this.price = price;
            this.number = number;
            this.available = true;
        }
        
        public String getType(){
            return type;
        }
        
        public int getPrice(){
            return price;
        }
        
        public int getNumber(){
            return number;
        }
        
        public boolean isAvailable(){
            return available;
        }
               
        public void markAsNotAvailable(){
            available = false;
        }
    }
}
