package com.example.mohammedal.learnarabic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class HobbiesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);


        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Swimming","السباحة"));
        words.add(new Word("Running","الجري"));
        words.add(new Word("Football","كرةالقدم"));
        words.add(new Word("Golf","الجولف"));
        words.add(new Word("Chess","الشطرنج"));
        words.add(new Word("Playing the Guitar","العزف على الجيتار"));
        ListView root = findViewById(R.id.root);
        root.setAdapter(new WordsAdapter(this, words));
    }
}
