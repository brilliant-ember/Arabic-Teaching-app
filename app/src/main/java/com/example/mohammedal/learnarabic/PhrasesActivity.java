package com.example.mohammedal.learnarabic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<Word> phrases = new ArrayList<>();
        phrases.add(new Word("Hello","مرحباً"));
        phrases.add(new Word("Come on","يلا!"));
        phrases.add(new Word("Formal hello","السلام عليكم ورحمة الله و بركاتةً"));
        phrases.add(new Word("How are you?","كيفك؟"));

        phrases.add(new Word("How much does this cost?","بكم هاذي؟ً"));
        phrases.add(new Word("Thank you very much","شكراَ جزيلاًَ"));
        phrases.add(new Word("What is the time?","كم الساعة؟ً"));
        phrases.add(new Word("I am thirsty masculine form","انا عطشانً"));
        phrases.add(new Word("I am thirsty feminine form","اني عطشانةً"));
        phrases.add(new Word("I want to go to the bathroom","اريد الذهاب إًلى الحمام"));
        phrases.add(new Word("Can you help me?","ايمكنكَ مساعدتي؟ً"));
        phrases.add(new Word("Please","من فضلكً"));
        phrases.add(new Word("Let's go!","هيا بنا!"));
        phrases.add(new Word("What is your name asking a man","ما هو اسمك؟ً"));
        phrases.add(new Word("What is your name asking a woman","ما هو اسمكي؟ً"));
        phrases.add(new Word("How are you feeling, asking a man","كيف تشعر؟ً"));
        phrases.add(new Word("How are you feeling, asking a woman","كيف تشعرين؟ً"));
        phrases.add(new Word("My name is Mohammed","اسمي محمدً"));


        ListView root = findViewById(R.id.phrasesRoot);
        root.setAdapter(new WordsAdapter(this, phrases));

    }
}
