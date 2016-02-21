package psc.psc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.StringBufferInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

/**
 * Created by guillaume on 08/02/16.
 */
public class Communication extends Activity {
    public static Socket socket = null;
    public static Thread t1;
    public static String srv = "127.0.0.1";
    public static int port = 2009;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.communication);

        final Button initButton = (Button) findViewById(R.id.init);
        initButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                init();
            }
        });

        final Button envoiButton = (Button) findViewById(R.id.envoi);
        envoiButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String req = ((TextView) findViewById(R.id.requete)).getText().toString();
                String arg = ((TextView) findViewById(R.id.argument)).getText().toString();
                send(req, arg);
            }
        });
    }

    public void init() {
        try {
            System.out.println("Demande de connexion");
            socket = new Socket(srv,port);
            System.out.println("Connexion établie avec le serveur, authentification :"); // Si le message s'affiche c'est que je suis connecté
            t1 = new Thread(new Connexion(socket));
            t1.start();
        } catch (UnknownHostException e) {
            System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
        } catch (IOException e) {
            System.err.println("Aucun serveur à l'écoute du port "+port+".");
        }
    }

    public void afficher(String s) {
        ((TextView) findViewById(R.id.reponse)).setText((CharSequence) s);
    }

    public void send(String req, String arg) {
        StringBufferInputStream s = new StringBufferInputStream(req+" "+arg);
        System.setIn(s);
    }

    public void parse(String reponse) {

    }
}

