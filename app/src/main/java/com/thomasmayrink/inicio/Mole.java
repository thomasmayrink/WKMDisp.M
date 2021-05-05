package com.thomasmayrink.inicio;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Mole extends AppCompatActivity implements View.OnTouchListener {

    Game game;

    boolean gameOverTrigger = false;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        game = new Game(this);
        setContentView(game);

        game.setOnTouchListener(this);



    }

    @Override
    protected void onResume() {
        super.onResume();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!game.gameover()) {
                    game.update();

                    game.invalidate();
                }else if(gameOverTrigger == false && game.gameover())
                    {
                        mudarcena();
                        gameOverTrigger = true;
                    }

                new Handler().postDelayed(this, 1000);





            }
        }, 1000);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            int x = (int) event.getX();
            int y = (int) event.getY();

            game.touch(x,y);
            game.score();



        }
        return true;
    }
    public void mudarcena (){
        Intent intent = new Intent( this, Gameover.class);
        startActivity(intent);
        finish();

    }



}
