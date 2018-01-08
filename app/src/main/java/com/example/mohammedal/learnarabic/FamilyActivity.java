package com.example.mohammedal.learnarabic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
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
        words.add(new Word("Wife","زوجة"));
        words.add(new Word("Husband","زوج"));


        ListView root = (ListView) findViewById(R.id.familyRoot);
        final WordsAdapter adapter = new WordsAdapter(this, words);
        root.setAdapter(adapter);

        EditText editText = findViewById(R.id.famSearch);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.getFilter().filter(s);

            }
        });

    }
}
