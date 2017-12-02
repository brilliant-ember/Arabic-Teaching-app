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
        numbers.add(new Word("One","واحد",R.mipmap.one1));
        numbers.add(new Word("Two","اثنين",R.mipmap.two));
        numbers.add(new Word("Three","ثلاثة",R.mipmap.three));
        numbers.add(new Word("Four","اربعة", R.mipmap.four));
        numbers.add(new Word("Five","خمسة",R.mipmap.five));
        numbers.add(new Word("Six","ستة", R.mipmap.six));
        numbers.add(new Word("Seven","سبعة",R.mipmap.seven ));
        numbers.add(new Word("Eight","ثمانية",R.mipmap.eight));
        numbers.add(new Word("Nine","تسعة",R.mipmap.nine));
        numbers.add(new Word("Ten","عشرة", R.mipmap.ten));

        ListView numPage = (ListView) findViewById(R.id.numPage);
        numPage.setAdapter(new WordsAdapter(this,numbers));


    }
}
