package com.thomasmayrink.inicio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Gameover extends Activity {

    Button btnMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);

        btnMenu = findViewById(R.id.btnMenu);
    }



    public void onClick(View view){

        if(view == btnMenu){


            btnMenu.bringToFront();
            Intent intent = new Intent( this, MainActivity.class);
            startActivity(intent);
            finish();

        }
    }
}
