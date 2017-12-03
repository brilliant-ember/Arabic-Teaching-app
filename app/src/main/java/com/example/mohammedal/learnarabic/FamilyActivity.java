package com.example.mohammedal.learnarabic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Dad","اب"));
        words.add(new Word("Mom","ام"));
        words.add(new Word("Brother","اخ"));
        words.add(new Word("Sister","اخت"));
        words.add(new Word("Grandfather","جد"));
        words.add(new Word("Grandmother","جدة"));
        words.add(new Word("Son","ابن"));
        words.add(new Word("Daughter","بنت"));



        ListView root = (ListView) findViewById(R.id.familyRoot);
        root.setAdapter(new WordsAdapter(this, words));

    }
}
