package com.thomasmayrink.inicio;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.VectorDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Random;

import javax.security.auth.Destroyable;

public class Game extends View {

    Bitmap character;
    Bitmap hole;
    int frames = 4;

    int currentFrame = 0;

    int x, y, targetX, targetY;

    float vel = 60;
    int vida = 20;

    int score = 1;
    int timer = 5;

    int posicao2;



    public Game(Context context){
        super(context);

        character = BitmapFactory.decodeResource(getResources(), R.drawable.characters);
        hole = BitmapFactory.decodeResource(getResources(), R.drawable.hole);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Rect srcRect = new Rect();
        srcRect.top = 0;
        srcRect.left = currentFrame * (character.getWidth() / 4);
        srcRect.right = srcRect.left + (character.getWidth() / 4);
        srcRect.bottom = character.getHeight();

        Rect dstRect = new Rect();
        dstRect.left = x; dstRect.top = y;
        dstRect.right = dstRect.left + (character.getWidth() / 4);
        dstRect.bottom = dstRect.top + (character.getHeight() / 4);

        canvas.drawBitmap(character, srcRect, dstRect, null);


    }

    public void update() {
        currentFrame = (currentFrame + 1) % frames;

        score = score;
        timer = (timer - 1) % frames;
        vida = vida - 1;



        float deltaX = targetX - x;
        float deltaY = targetY - y;




        float mag = (float) Math.sqrt(deltaX * deltaX * deltaY * deltaY);



        targetX = x;
        targetY = y;








           if (currentFrame > 2.9) {

            x = 200;
            y = 455;

         }
         else if(currentFrame <= 2.5)
        {

            x = 200;
          y = 400;


         }
          else if(currentFrame > 2)
         {

            x = 20;
            y = 40;

        }

        }






   //public void timer (int x, int y){
     //  if(timer == 0)
       //{
         //  Log.i("Info", "Voce perdeubb");
       //}

   //}


   public void touch (int x, int y){


           targetX = x;
           targetY = y;
            if (targetY < 430) {
                score = score + 4;
            }
            else  if(targetY > 450){
                score = score - 4;
                Log.i("Info", "Voce perdeubb");
            }
           //vida = vida - 1;

    }

    public void score (){
       // Log.i("Info", "onClick() chamado");
        if(score > 4)
        {
            Log.i("Info", "Voce ganhou");



        }
        else if (score < 0 )
        {
            Log.i("Info", "Voce perdeu");
        }

    }
    public boolean gameover (){
        if (score < 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }





}





