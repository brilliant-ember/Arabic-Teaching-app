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

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        // this line to make sure the focus isn't at the editText whrn the activity starts
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        AdView adView = findViewById(R.id.adViewPhrases);
        AdRequest adRequest = new AdRequest.Builder()
                .build();

        adView.loadAd(adRequest);

        final ArrayList<Word> phrases = new ArrayList<>();
        phrases.add(new Word("Hello","مرحباً",R.raw.marhaba));
        phrases.add(new Word("Come on","اهلاً و سهلاً",R.raw.ahlawasahla));
        phrases.add(new Word("Come on","تفضل",R.raw.welcome));

        phrases.add(new Word("Formal hello","السلام عليكم",R.raw.asalamalikum));
        phrases.add(new Word("How are you? (asking a man)","كيف حالك؟",R.raw.howrumasculine));
        phrases.add(new Word("How are you? (asking a woman)","كيف حالك؟",R.raw.howrufeminine));
        phrases.add(new Word("What is your name? (asking a woman)","ما هو اسمك؟",R.raw.whatisurnamefeminine));
        phrases.add(new Word("What is your name? (asking a man)","ما هو اسمك؟",R.raw.whatisurnamemasculine));
        phrases.add(new Word("My name is Mohammed","اسمي محمد",R.raw.mynameismohammed));
        phrases.add(new Word("What time is it?","كم الساعة؟",R.raw.whattimeisit));
        phrases.add(new Word("It is eight in the morning","الساعة الثامنة صباحاً",R.raw.itiseightmorning));

        phrases.add(new Word("I am sorry masculine","انا اسف",R.raw.iamsorrym));
        phrases.add(new Word("I am sorry feminine","انا اسفة",R.raw.iamsorryfem));

        phrases.add(new Word("---        .       ---","ً"));

        phrases.add(new Word("How do I go to the market?",";كيف اصل الى السوق؟ً",R.raw.market,R.mipmap.shopping));
//        phrases.add(new Word("What are good places to visit?",";كيف اصل الى السوق؟ً"));

        phrases.add(new Word("How much does this cost?","بكم هذا؟ً", R.raw.how_much));
        phrases.add(new Word("How do I go to the restaurant?","كيف اصل الى المطعم؟ً",R.raw.resturant, R.mipmap.resturnat));
        phrases.add(new Word("How can I get to the hotel?","كيف اصل الى الفندق؟ً",R.raw.hotel, R.mipmap.hotel));
        phrases.add(new Word("How can I get to the hospital?","كيف اصل الى المستشفى؟ً",R.raw.how_to_reach_hospital, R.mipmap.hospital_symbol));
        phrases.add(new Word("How can I get to the airport?","كيف اصل الى المطار؟ً",R.raw.airport, R.mipmap.airplane));


        phrases.add(new Word("Where is the exit?","اين المخرج؟ً",R.raw.where_exit, R.mipmap.exit));


        phrases.add(new Word("Thank you very much","شكراَ جزيلاًَ",R.raw.thanks));
        phrases.add(new Word("I am thirsty masculine form","انا عطشانً",R.raw.thirstyman));
        phrases.add(new Word("I am thirsty feminine form","انا عطشانةً",R.raw.thirstywoman));
        phrases.add(new Word("I want to go to the bathroom","اريد الذهاب إًلى الحمام",R.raw.bathroom));
        phrases.add(new Word("Can you help me?","هل يمكنكَ مساعدتي؟ً",R.raw.canuhelpme));
        phrases.add(new Word("Please","من فضلكً",R.raw.please));
        phrases.add(new Word("Let's go!","هيا بنا!",R.raw.letsgo));
        phrases.add(new Word("How are you feeling, asking a man","كيف تشعر؟ً",R.raw.howfeelman));
        phrases.add(new Word("How are you feeling, asking a woman","كيف تشعرين؟ً",R.raw.howfeelwoman));

        phrases.add(new Word("Good luck","حظاً طيباًَ",R.raw.goodluck));
        phrases.add(new Word("------        .       ------","ً"));

        phrases.add(new Word("Oh my god!","يااللهي!", R.raw.oh_my_god));
        phrases.add(new Word("Call an ambulance","اتصل بالاسعاف",R.raw.call_ambulance, R.mipmap.hospital_symbol));

        phrases.add(new Word("Go to hell","اذهب الى الجحيمً", R.raw.go_to_hell));
        phrases.add(new Word("Leave me alone","اتركني و شائني", R.raw.leave_me_alone));
        phrases.add(new Word("I will call the police!","ساتصل بالشرطة!",R.raw.police));


        ListView root = findViewById(R.id.phrasesRoot);
        final WordsAdapter adapter = new WordsAdapter(this, phrases);
        root.setAdapter(adapter);

        EditText editText = findViewById(R.id.phrSearch);
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
                Word current = (Word) adapter.getItem(position);
                if (current.getAudioResourceId() != 0){
                    MediaPlayer mp = MediaPlayer.create(PhrasesActivity.this, current.getAudioResourceId());
                    mp.start();}


            }
        });

    }
}
