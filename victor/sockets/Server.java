/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victor
 */
public class Server {

    private ServerSocket serverSk = null;
    private Socket clientSk = null;
    private String message = "";
    
    public Server(){
        try {
            serverSk = new ServerSocket(5000, 4000);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(true){
            try {
                System.out.println("Esperando conexion...");
                clientSk = serverSk.accept();
                while(true){
                    DataInputStream dis = new DataInputStream(clientSk.getInputStream());
                    System.out.printf("[Cliente:] %s\n", message = dis.readUTF());
                    reply();
                        // Cerramos la conexion con el cliente, pero el servidor sigue
                        // escuchando a la espera de mas conexiones
                        // Es lo que entendi en el enunciado. Para cerrar la conexion
                        // del servidor simplemente habria que poner serverSk.close()
                        if(message.toLowerCase().equals("adios")){
                            System.out.println("Cerrando conexion...");
                            clientSk.close();
                            System.out.println("Cerrada conexion con el cliente.");
                            break;
                        }
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void reply(){        
        try {
            DataOutputStream dos = new DataOutputStream(clientSk.getOutputStream());
            dos.writeUTF(getResponse());
            //dos.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private String getResponse(){
        String response = "";
        
        switch(message.toLowerCase()){
            case "hola":
                response = "Hola soy el servidor";
                break;
            case "¿como estas?":
                response = "Muy bien";
                break;
            default:
                response = message;
                break;
        }
        
        return response;
    }
    
    public static void main(String[]args){
        new Server();
    }
    
}
