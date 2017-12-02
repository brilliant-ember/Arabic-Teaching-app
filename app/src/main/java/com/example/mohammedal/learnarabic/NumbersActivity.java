package com.example.mohammedal.learnarabic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> Words= new ArrayList<String>();

        ArrayList<Word> numbers= new ArrayList<Word>();
        numbers.add(new Word("One","واحد"));
        numbers.add(new Word("Two","اثنين"));
        numbers.add(new Word("Three","ثلاثة"));
        numbers.add(new Word("Four","اربعة"));
        numbers.add(new Word("Five","خمسة"));
        numbers.add(new Word("Six","ستة"));
        numbers.add(new Word("Seven","سبعة"));
        numbers.add(new Word("Eight","ثمانية"));
        numbers.add(new Word("Nine","تسعة"));
        numbers.add(new Word("Ten","عشرة"));

        ListView numPage = (ListView) findViewById(R.id.numPage);
        numPage.setAdapter(new WordsAdapter(this,numbers));


    }
}
