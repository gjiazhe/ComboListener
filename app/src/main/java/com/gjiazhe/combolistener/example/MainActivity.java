package com.gjiazhe.combolistener.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gjiazhe.combolistener.ComboListenerBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toast toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        Button btnCombo = (Button) findViewById(R.id.btn_combo);

        new ComboListenerBuilder()
                .setMaxInterval(500)//set the Max Interval between two clicks, default is 300ms
                .observeOn(btnCombo)//set the view to be observed
                .setOnComboListener(new ComboListenerBuilder.OnComboListener() {
                    @Override
                    public void onCombo(View view, int comboCount) {
                        toast.setText(comboCount+"");
                        toast.show();
                        Log.i("combo", comboCount+"");
                    }
                })
                .startListen();
    }
}
