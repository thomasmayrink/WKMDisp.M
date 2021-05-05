package com.thomasmayrink.inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

   // Button btnTeste;
    Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //btnTeste = new Button(this);
        //btnTeste.setText("Button Test");
        //setContentView(btnTeste);

        btnPlay = findViewById(R.id.btnPlay);
    }

    @Override
    protected void onStart() {
        super.onStart();


        // Tratamento do evento
        Log.i("Info:", "onStart() chamado");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("Info", "onResume() chamado");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("Info", "onStop() chamado");
    }

    public void onClick(View view){
        //if (view == btnPlay){
            // Carregar nova janela do jogo
          //  Intent intent = new Intent(this, ActivityGame.class);
            //startActivity(intent);
     //   }
        if(view == btnPlay){

            Intent intent = new Intent( this, Mole.class);
            startActivity(intent);
            finish();

        }
    }

}