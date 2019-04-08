package cronometro.android.aplicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class Temporizador extends AppCompatActivity {

    Switch switchA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temporizador);

        switchA= (Switch) findViewById(R.id.switch2);
    }

    public void onClick1(View view) {
        Intent crono = new Intent(this, MainActivity.class);
        if (view.getId() == R.id.switch2)
        {
            if (switchA.isChecked())
            {
                startActivity(crono);
            }
        }
    }
}
