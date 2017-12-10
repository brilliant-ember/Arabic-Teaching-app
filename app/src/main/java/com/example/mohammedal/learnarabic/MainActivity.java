package com.example.mohammedal.learnarabic;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FamilyListner famL = new FamilyListner();
        TextView family = (TextView) findViewById(R.id.family);
        family.setOnClickListener(famL);

        TextView phrases = findViewById(R.id.phrases);
        phrases.setOnClickListener(new phrasesListner());

        TextView hobbies = findViewById(R.id.hobbies);
        hobbies.setOnClickListener(new HobbiesListner());

        TextView colloquial = findViewById(R.id.colloquial);
        colloquial.setOnClickListener(new colloquialListner());

    }

    public void openNumbersList(View view) {
        Intent i = new Intent(getApplicationContext(),NumbersActivity.class);
        startActivity(i);
    }




    public class HobbiesListner implements View.OnClickListener{
        public void onClick(View view){
            Intent i = new Intent(MainActivity.this, HobbiesActivity.class);
//            final ValueAnimator anime = new ValueAnimator();
//            anime.setDuration(500);
//            anime.setEvaluator(new ArgbEvaluator());
//            anime.setIntValues(Color.rgb(76,207,111),Color.MAGENTA);
//            anime.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
//                @Override
//                public void onAnimationUpdate(ValueAnimator animation){
//                    TextView hobbies = findViewById(R.id.hobbies);
//                    hobbies.setBackgroundColor( (int) anime.getAnimatedValue());
//                }
//            });
//            anime.start();
            startActivity(i);
        }
    }

    public class FamilyListner implements View.OnClickListener{
        public void onClick(View view){
            Intent i =new Intent(MainActivity.this,FamilyActivity.class);
            startActivity(i);

        }
    }

    public class phrasesListner implements View.OnClickListener{
        public void onClick(View view){
            Intent i = new Intent(MainActivity.this, PhrasesActivity.class);
            startActivity(i);
        }
    }

    public class colloquialListner implements View.OnClickListener{
        public void onClick (View v){
            Intent ein = new Intent(MainActivity.this, ColloquialActivity.class);
            startActivity(ein);
        }
    }


}


