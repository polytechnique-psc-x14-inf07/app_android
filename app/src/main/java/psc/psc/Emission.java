package psc.psc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Emission extends Thread {

    private PrintWriter out;
    private String login = null, message = null;
    private Scanner sc = null;
    private volatile boolean interrupted = false;

    public Emission(PrintWriter out) {
        this.out = out;
    }

    public void run() {
        interrupted = false;
        try {
            sc = new Scanner(System.in);

            while(!this.interrupted){
                message = sc.nextLine();
                System.out.println(message
                );
                out.println(message);
                out.flush();
            }
        } finally {
            System.out.println("Le serveur s'est déconnecté.");
        }
    }

    public void interrupt() {
        System.out.println("Thread émission interrompu.");
        this.interrupted=true;
    }
}

