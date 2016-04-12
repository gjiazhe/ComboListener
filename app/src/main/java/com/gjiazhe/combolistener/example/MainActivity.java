package com.gjiazhe.combolistener.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gjiazhe.combolistener.ComboListenerBuilder;

public class MainActivity extends AppCompatActivity {
    private Button btnCombo;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCombo = (Button) findViewById(R.id.btn_combo);
        toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);

        new ComboListenerBuilder().setMaxInterval(500)
                .observeOn(btnCombo)
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
