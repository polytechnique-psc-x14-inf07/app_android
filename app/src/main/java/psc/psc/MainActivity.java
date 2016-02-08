package psc.psc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button communicationButton = (Button) findViewById(R.id.communication);
        communicationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Communication.class);
                startActivity(intent);
            }
        });

        final Button tracerouteButton = (Button) findViewById(R.id.traceroute);
        tracerouteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Traceroute.class);
                startActivity(intent);
            }
        });

        final Button pagewebButton = (Button) findViewById(R.id.pageweb);
        pagewebButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pageweb.class);
                startActivity(intent);
            }
        });

        final Button bddButton = (Button) findViewById(R.id.bdd);
        bddButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BDD.class);
                startActivity(intent);
            }
        });
    }
}
