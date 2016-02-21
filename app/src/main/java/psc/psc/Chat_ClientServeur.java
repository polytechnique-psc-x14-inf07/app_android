package psc.psc;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Chat_ClientServeur extends Thread {

    private Socket socket;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private Thread t3, t4;

    public Chat_ClientServeur(Socket s) {
        socket = s;
    }

    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Emission e = new Emission(out);
            Thread t4 = new Thread(e);
            t4.start();
            Thread t3 = new Thread(new Reception(in, out));
            t3.start();
            // System.out.println("Thread Reception démarré.");
            t3.join();
            // System.out.println("Interruption de réception détectée.");
            e.interrupt();
            // System.out.println("Signal stop envoyé à l'Emetteur.");
        } catch (Exception e) {
            System.err.println("Le serveur distant s'est déconnecté !");
        }
    }
}

