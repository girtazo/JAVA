/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victor
 */
public class Client {
    
    private String serverName;
    private int port;
    private Socket socket;
    private String message;
    
    public Client(String serverName, int port){
        this.serverName = serverName;
        this.port = port;        
        connectToServer();
        startTransmission();
        //disconnect();
    }
    
    private void startTransmission(){
        Scanner scanner = new Scanner(System.in);
        String response;
        while(true){
            System.out.println("Introduce un mensaje que mandar al servidor: ");
            message = scanner.nextLine();
            send();
            response = receive();
            System.out.printf("[Servidor:] %s\n", response);
            if(response.toLowerCase().equals("adios"))
            {
                System.out.println("Conexion cerrada por el servidor");
                disconnect();
                break;
            }    
        }
    }
    
    private void connectToServer(){
        try {
            System.out.println("Conectando con el servidor...");
            socket = new Socket(serverName, port);
            System.out.println("Conectado.");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    private void send(){
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(message);
            //dos.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String receive(){
        String response = "";
        
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            response = dis.readUTF();
            //dis.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
    private void disconnect(){
        try {
            System.out.println("Cerrando conexion");
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[]args){
        new Client("localhost", 5000);
    }
}
