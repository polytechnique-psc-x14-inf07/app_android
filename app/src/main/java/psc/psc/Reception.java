package psc.psc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Reception extends Thread {

    private BufferedReader in;
    private String message = null;
    private PrintWriter out;

    public Reception(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    public void run() {
        while(true){
            try {
                message = in.readLine();
                if (message == null) { break; }
                String[] t = message.split(" ");
                if(t.length > 1) {
                    Commande c = new Commande(out, t);
                    c.start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

