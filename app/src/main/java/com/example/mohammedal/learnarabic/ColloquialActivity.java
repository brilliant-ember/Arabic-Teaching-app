package com.example.mohammedal.learnarabic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColloquialActivity extends AppCompatActivity {

    //This is the Slang activity, named colloquial for fancy reasons.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colloquial);

        final ArrayList<Word> phrases = new ArrayList<Word>();
        phrases.add(new Word("Yemeni for: I want this","اشتي هذا",R.mipmap.yem, R.raw.yashtihada));
        phrases.add(new Word("Yemeni for: Hurry up!","فيسع!",R.mipmap.yem, R.raw.yfisaa));
        phrases.add(new Word("Yemeni for: To strike or to hit","يندف",R.mipmap.yem, R.raw.yeindouf));
        phrases.add(new Word("Yemeni for: Leave me aloneً","ماعليك مني",R.mipmap.yem, R.raw.yeindouf));
        phrases.add(new Word("Yemeni for: Go away","روح لك",R.mipmap.yem, R.raw.yeindouf));


        phrases.add(new Word("Palestinian for: Spider web","شعشبون"));
        phrases.add(new Word("Palestinian for: Scooch over","ليز شوي"));
        phrases.add(new Word("Palestinian for: Clothes","اواعي"));

        phrases.add(new Word("Egyption for: How are you man","ازيك يا باشا",R.mipmap.msr, R.raw.egyezyak));
        phrases.add(new Word("Egyption for: How old are you?","عندك كم سنة؟ ",R.mipmap.msr ,R.raw.egyhowoldareyou));
        phrases.add(new Word("Egyption for: ٌٌRoom","أوضة ",R.mipmap.msr,R.raw.egyroom));
        phrases.add(new Word("Egyption for: Barely","بالـزور ",R.mipmap.msr, R.raw.egybilzoor));

        phrases.add(new Word("Sham region for: What do you want?","شو بدك؟ "));
        phrases.add(new Word("Sham region for: What?","شو؟ "));
        phrases.add(new Word("Sham region for: Money","مصاري"));
        phrases.add(new Word("Sham region for: I want this","بدي هاد "));

        phrases.add(new Word("Lebanese for: What is this thing","شو هيدا الشي", R.mipmap.leb, R.raw.lebshuhyda));
        phrases.add(new Word("Lebanese for: May your house get destroyed how much I loved you","يخرب بيتك شو حبيتك",R.mipmap.leb, R.raw.lebyhrebbytak));
        phrases.add(new Word("Lebanese for: You came at the perfect time","جيت والله جابك", R.mipmap.leb, R.raw.lebjeetwaallahjabak));
        phrases.add(new Word("Lebanese for: What's up babe","شو حياتي", R.mipmap.leb,R.raw.extra));
        phrases.add(new Word("Lebanese for: You are my babe","حبيبي انتا", R.mipmap.leb,R.raw.lebyouaremybabe));



        ListView root = findViewById(R.id.colloquialRoot);
        root.setAdapter(new WordsAdapter(this, phrases));


        root.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word current = phrases.get(position);
                if (current.getAudioResourceId() != 0){
                MediaPlayer mp = MediaPlayer.create(ColloquialActivity.this, current.getAudioResourceId());
                mp.start();}


            }
        });





            }
}
