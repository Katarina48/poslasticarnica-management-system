/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import communication.Communication;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import view.LoginForm;
import style.Stil;

public class Main {

    public static void main(String[] args) {
        
        Stil.stilizujOptionPane(); 
        
        Main client = new Main();
        try {
            client.connect();
        } catch (IOException ex) {
            
            JOptionPane.showMessageDialog(
                null, 
                "Sistem ne može da se poveže sa serverom. Proverite da li je server pokrenut!", 
                "Greška pri povezivanju", 
                JOptionPane.ERROR_MESSAGE
            );
            System.exit(0); // Ugasi klijentski proces bezbedno
        }
    }

    private void connect() throws IOException {
        Socket socket = new Socket("localhost", 9000);
        Communication.getInstance().setSocket(socket);
        (new LoginForm()).setVisible(true);
    }
}