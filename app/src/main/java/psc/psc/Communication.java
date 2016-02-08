package psc.psc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.charset.Charset;

/**
 * Created by guillaume on 08/02/16.
 */
public class Communication extends Activity {

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
                String req = (String) ((TextView) findViewById(R.id.requete)).getText();
                String arg = (String) ((TextView) findViewById(R.id.argument)).getText();
                send(req, arg);
            }
        });

    }

    public void init() {

    }

    public void afficher(String s) {
        ((TextView) findViewById(R.id.reponse)).setText((CharSequence) s);
    }

    public void send(String req, String arg) {

    }

    public void parse(String reponse) {

    }
}

