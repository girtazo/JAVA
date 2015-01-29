package teatro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victor
 */
public class Server {
    
    private int port;
    private Theater theater;
    private ServerSocket serverSk;
    private Socket clientSk;
    
    public Server(){
        port = 5000;
        theater = new Theater();
        runServer();
        listen();
        killServer();
    }
  
    /**
     * Inicializa el ServerSocket
     */
    private void runServer(){
        try {
            serverSk = new ServerSocket(port);
            System.out.printf("Escuchando en el puerto %d\n", port);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Espera la conexion de un cliente y recibe sus mensajes
     * Llama a reply() para responder al cliente
     */
    private void listen(){
        DataInputStream dis;
        String message;
        try {                
            while(true){
                System.out.printf("Esperado nuevo ciente...\n");
                clientSk = serverSk.accept();
                message = "";
                while( !message.toLowerCase().equals("fin") ){
                    dis = new DataInputStream(clientSk.getInputStream());
                    message = dis.readUTF();
                    System.out.printf("[Cliente:] %s\n", message);
                    reply(message);
                }
                clientSk.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Llama a send() para responder al cliente con la cadena adecuada
     * @param message mensaje del cliente al que responder
     */
    private void reply(String message){
        switch(message.toLowerCase()){
            case "hola":
                send("Hola, soy el Servidor");
                break;
            case "ver butacas":
                send(theater.getInventoryInfo());
                break;
            case "vip1": case "vip2": case "gal": case "lat1": case "lat2": case "cen":
                send(getChairOrFail(message));
                break;
            case "fin":
                send("Fin");
                break;                
            default:
                send(String.format("[ERROR] Opcion no contemplada: %s", message));
                break;
        }
    }
    
    /**
     * Reserva una butaca del tipo chair_type y devuelve un tiquet
     * o devuelve un mensaje indicando que no hay butacas disponibles de ese tipo
     * @param chair_type tipo de la butaca solicitado
     * @return tiquet de la butaca reservada o mensaje de "fallo"
     */
    private String getChairOrFail(String chair_type){
        if(theater.chairTypeIsAvailable(chair_type))
            return theater.getChair(chair_type);              
        return String.format("No quedan butacas de tipo %s\n", chair_type);            
    }
    
    /**
     * Envia message al cliente
     * @param message mensaje a enviar
     */
    private void send(String message){
        System.out.printf("Respondiendo... %s\n", message);
        DataOutputStream dos; 
        try { 
            dos = new DataOutputStream(clientSk.getOutputStream());
            dos.writeUTF(message);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Para el ServerSocket [funcion inalcanzable dada la implementacion de la clase]
     */
    private void killServer(){
        try {
            serverSk.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String []args){
        new Server();
    }
}
