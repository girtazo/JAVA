/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teatro;

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
    
    private String host;
    private int port;
    private Socket socket;
    
    public Client(String host){
        this.host = host;
        port = 5000;
        startServer();
        emit();
        killServer();
    }
    
    /**
     * Inicializa el Socket
     */
    public void startServer(){
        try {
            socket = new Socket(host, port);
            System.out.printf("Conectado con %s:%d\n", host, port);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Envia mensajes (Gestiona la salida de datos por el socket)
     * Llama a receiveResponse() para recoger las respuestas del servidor
     */
    public void emit(){
        DataOutputStream dos;
        Scanner scanner = new Scanner(System.in);
        String message = "Hola";
            try {
                dos = new DataOutputStream( socket.getOutputStream() );
                dos.writeUTF(message); // Mensaje automatico (saludo formal)
                receiveResponse(); // Escucha la respuesta al saludo
                do{
                    System.out.printf("Introduce mensaje a enviar\n");
                    message = scanner.nextLine();                    
                    dos.writeUTF(message);
                    receiveResponse();
                }while( !message.toLowerCase().equals("fin") );
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    /**
     * Recibe las respuestas del servidor (Gestiona la entrada de datos por el socket)
     */
    public void receiveResponse(){
        DataInputStream dis;
        try {
            dis = new DataInputStream(socket.getInputStream());
            System.out.printf("[Servidor:] %s\n", dis.readUTF());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Detiene el socket
     */
    public void killServer(){
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("Desconectado del servidor. Cerrando cliente...\n");
    }
    
    public static void main(String[]args){
        new Client("localhost");
        // Netbeans no deja pasar argumentos al ejecutar archivos
        // new Client(args[0]);
    }
}
