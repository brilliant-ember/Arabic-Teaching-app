package com.example.mohammedal.learnarabic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColloquialActivity extends AppCompatActivity {

    //This is the Slang activity, named colloquial for fancy reasons.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colloquial);

        ArrayList<Word> phrases = new ArrayList<>();
        phrases.add(new Word("Yemeni for: I want this","اشتي هذا"));
        phrases.add(new Word("Yemeni for: Hurry up!","فيسع!"));
        phrases.add(new Word("Yemeni for: To strike or to hit","يندف"));
        phrases.add(new Word("Palestinian for: Spider web","شعشبون"));
        phrases.add(new Word("Palestinian for: Scooch over","ليز شوي"));
        phrases.add(new Word("Palestinian for: Clothes","اواعي"));
        phrases.add(new Word("Egyption for: How are you man","ازيك يا باشا"));
        phrases.add(new Word("Egyption for: ٌٌRoom","أوضة "));
        phrases.add(new Word("Egyption for: Barely","بالـزور "));
        phrases.add(new Word("Sham region for: Straightly","دُغرِي "));
        phrases.add(new Word("Sham region for: What?","شو؟ "));
        phrases.add(new Word("Sham region for: Money","مصاري"));
        phrases.add(new Word("Sham region for: I want this","بدي هاد "));
        phrases.add(new Word("Lebanese for: What is this thing","شو هيدا الشي"));
        phrases.add(new Word("Lebanese for: May your house get destroyed how much I loved you","يخرب بيتك شو حبيتك"));
        phrases.add(new Word("Lebanese for: You came at the perfect time","جيت والله جابك"));


        ListView root = findViewById(R.id.colloquialRoot);
        root.setAdapter(new WordsAdapter(this, phrases));






    }
}
