package com.example.mohammedal.learnarabic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        final ArrayList<Word> numbers= new ArrayList<Word>();
        numbers.add(new Word("One","واحد",R.mipmap.one1, R.raw.one));
        numbers.add(new Word("Two","اثنين",R.mipmap.two, R.raw.two));
        numbers.add(new Word("Three","ثلاثة",R.mipmap.three, R.raw.three));
        numbers.add(new Word("Four","اربعة", R.mipmap.four, R.raw.four));
        numbers.add(new Word("Five","خمسة",R.mipmap.five, R.raw.five));
        numbers.add(new Word("Six","ستة", R.mipmap.six, R.raw.six));
        numbers.add(new Word("Seven","سبعة",R.mipmap.seven, R.raw.seven));
        numbers.add(new Word("Eight","ثمانية",R.mipmap.eight, R.raw.eight));
        numbers.add(new Word("Nine","تسعة",R.mipmap.nine,R.raw.nine));
        numbers.add(new Word("Ten","عشرة", R.mipmap.ten, R.raw.ten));

        ListView numPage = findViewById(R.id.numPage);
        numPage.setAdapter(new WordsAdapter(this,numbers));

        numPage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word current = numbers.get(position);
                //Toast.makeText(NumbersActivity.this,"HEY",Toast.LENGTH_SHORT).show();
                MediaPlayer mp = MediaPlayer.create(NumbersActivity.this, current.getAudioResourceId());
                mp.start();


            }
        });


    }
}
