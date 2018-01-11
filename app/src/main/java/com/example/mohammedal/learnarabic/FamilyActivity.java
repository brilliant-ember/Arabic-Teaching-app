package com.example.mohammedal.learnarabic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        // this line to make sure the focus isn't at the editText whrn the activity starts
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Dad","اب", R.raw.dad));
        words.add(new Word("Mom","ام",R.raw.mom));
        words.add(new Word("Brother","اخ",R.raw.bro));
        words.add(new Word("Sister","اخت",R.raw.sister));
        words.add(new Word("Grandfather","جد",R.raw.grandpa));
        words.add(new Word("Grandmother","جدة",R.raw.grandma));
        words.add(new Word("Son","ابن", R.raw.son));
        words.add(new Word("Daughter","بنت", R.raw.girl));
        words.add(new Word("Wife","زوجة", R.raw.wife));
        words.add(new Word("Husband","زوج", R.raw.husband));


        ListView root = (ListView) findViewById(R.id.familyRoot);
        final WordsAdapter adapter = new WordsAdapter(this, words);
        root.setAdapter(adapter);

        AdView adView = findViewById(R.id.adViewFamily);
        AdRequest adRequest = new AdRequest.Builder()
                .build();

        adView.loadAd(adRequest);

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

        root.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word current = (Word)adapter.getItem(position);
                //Toast.makeText(NumbersActivity.this,"HEY",Toast.LENGTH_SHORT).show();
                if (current.getAudioResourceId() != 0){
                    MediaPlayer mp = MediaPlayer.create(FamilyActivity.this, current.getAudioResourceId());
                    mp.start();}


            }
        });

    }
}
