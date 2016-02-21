package psc.psc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Random;

public class Commande extends Thread {

    private String[] arguments;
    private int index;
    private PrintWriter out;
    private enum Commandes {
        traceroute, dns, dnsi
    };

    public Commande(PrintWriter out, String[] arguments) {
        this.arguments = arguments;
        this.out = out;
    }

    public void run() {
        PrintWriter p;
        try {
            int value = Integer.parseInt(this.arguments[0]);
            // we are handling a request from the server
            Commandes m = Commandes.valueOf(arguments[1]);
            switch(m) {
                case traceroute:
                    print(value+" traceroute "+arguments[2]);
                    break;
                case dns:
                    print(value+" dns "+arguments[2]);
                    break;
                case dnsi:
                    print(value+" dnsi "+arguments[2]);
                    break;
                default:
                    print("Votre demande est incorrecte. Voici les commandes que je comprends à l'heure actuelle : print, printa, traceroute, dns, ainsi que dnsi");
                    break;
            }
        } catch (NumberFormatException nfe) {
            // we are handling a response from the server
            System.out.println("> " + merge(" ", arguments));
        }
    }
    
    public void print(String message) {
        System.out.println(message);
        out.println(message);
        out.flush();
    }
    
    public String merge(String delimiter, String[] array) {
        String s = array[0];
        for(int k = 1; k < array.length; k++) {
            s+= delimiter;
            s+= array[k];
        }
        return s;
    }
}
