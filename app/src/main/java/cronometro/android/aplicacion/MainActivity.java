package cronometro.android.aplicacion;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_stop, btn_reset;
    Chronometer chronometro;
    Boolean correr=false;
    long detenerse;
    Switch switchE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start=findViewById(R.id.btn_start);
        btn_stop=findViewById(R.id.btn_stop);
        btn_reset=findViewById(R.id.btn_reset);
        chronometro=findViewById(R.id.chronometro);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startChronometro();
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopChronometro();
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetChronometro();
            }
        });

        switchE= (Switch) findViewById(R.id.switch1);
    }

    private void stopChronometro() {
        if(correr){
            chronometro.stop();
            detenerse = SystemClock.elapsedRealtime() - chronometro.getBase();
            correr=false;
        }
    }

    private void startChronometro() {
        if(!correr){
            chronometro.setBase(SystemClock.elapsedRealtime() - detenerse);
            chronometro.start();
            correr=true;
        }
    }

    private void resetChronometro() {
        chronometro.setBase(SystemClock.elapsedRealtime());
        detenerse = 0;

    }

    public void onClick(View view) {
        Intent tempo = new Intent(this, Temporizador.class);

        if (view.getId() == R.id.switch1)
        {
            if (switchE.isChecked())
            {
                startActivity(tempo);
            }
        }
    }

}
