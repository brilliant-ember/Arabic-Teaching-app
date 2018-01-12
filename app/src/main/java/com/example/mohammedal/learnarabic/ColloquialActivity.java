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

public class ColloquialActivity extends AppCompatActivity {

    //This is the Slang activity, named colloquial for fancy reasons.

    private MediaPlayer mp;
    private MediaPlayer.OnCompletionListener isDone = new MediaPlayer.OnCompletionListener() {public void onCompletion(MediaPlayer mp) {}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colloquial);
        // this line to make sure the focus isn't at the editText whrn the activity starts
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        final ArrayList<Word> phrases = new ArrayList<Word>();
        phrases.add(new Word("Yemeni for: I want this","اشتي هذا",R.mipmap.yem, R.raw.yashtihada));
        phrases.add(new Word("Yemeni for: Hurry up!","فيسع!",R.mipmap.yem, R.raw.yfisaa));
        phrases.add(new Word("Yemeni for: To strike or to hit","يندف",R.mipmap.yem, R.raw.yeindouf));
//        phrases.add(new Word("Yemeni for: Leave me aloneً","ماعليك مني",R.mipmap.yem, R.raw.yeindouf));
//        phrases.add(new Word("Yemeni for: Go away","روح لك",R.mipmap.yem, R.raw.yeindouf));


        phrases.add(new Word("Palestinian for: Spider web","شعشبون" , R.raw.palas_shashabon, R.mipmap.palistine));
        phrases.add(new Word("Palestinian for: Scooch over","ليز شوي", R.raw.palas_leez, R.mipmap.palistine));
        phrases.add(new Word("Palestinian for: Clothes","اواعي", R.raw.palas_clothes, R.mipmap.palistine));

        phrases.add(new Word("Egyption for: How are you man","ازيك يا باشا",R.mipmap.msr, R.raw.egyezyak));
        phrases.add(new Word("Egyption for: How old are you?","عندك كم سنة؟ ",R.mipmap.msr ,R.raw.egyhowoldareyou));
        phrases.add(new Word("Egyption for: ٌٌRoom","أوضة ",R.mipmap.msr,R.raw.egyroom));
        phrases.add(new Word("Egyption for: Barely","بالـزور ",R.mipmap.msr, R.raw.egybilzoor));

//        phrases.add(new Word("Sham region for: What do you want?","شو بدك؟ ",));
        phrases.add(new Word("Sham region for: What?","شو؟ ",R.raw.shu, R.mipmap.sham));
        phrases.add(new Word("Sham region for: Money","مصاري", R.raw.palas_money, R.mipmap.sham));
        phrases.add(new Word("Sham region for: I want this","بدي هاد ",R.raw.palas_want, R.mipmap.sham));

        phrases.add(new Word("Lebanese for: What is this thing","شو هيدا الشي", R.mipmap.leb, R.raw.lebshuhyda));
        phrases.add(new Word("Lebanese for: May your house get destroyed how much I loved you","يخرب بيتك شو حبيتك",R.mipmap.leb, R.raw.lebyhrebbytak));
        phrases.add(new Word("Lebanese for: You came at the perfect time","جيت والله جابك", R.mipmap.leb, R.raw.lebjeetwaallahjabak));
        phrases.add(new Word("Lebanese for: What's up babe","شو حياتي", R.mipmap.leb,R.raw.extra));
        phrases.add(new Word("Lebanese for: You are my babe","حبيبي انتا", R.mipmap.leb,R.raw.lebyouaremybabe));

        phrases.add(new Word("Libyan for: What's up?","شنو الجو", R.mipmap.libya,R.raw.shnu_al_jaw));
        phrases.add(new Word("Libyan for: Where have you been?","وينك مغيب", R.mipmap.libya,R.raw.wenak_mgaib));
        phrases.add(new Word("Libyan for: Why?","علاش", R.mipmap.libya,R.raw.allash));
        phrases.add(new Word("Libyan for: I miss you","ستحشتك", R.mipmap.libya,R.raw.estahashtak));



        EditText editText = findViewById(R.id.colSearch);
        ListView root = findViewById(R.id.colloquialRoot);
        final WordsAdapter adapter = new WordsAdapter(this, phrases);
        root.setAdapter(adapter);

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
//        AdView adView = findViewById(R.id.adViewColloquial);
//        AdRequest adRequest = new AdRequest.Builder()
//                .build();
//
//        adView.loadAd(adRequest);

        root.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word current = (Word) adapter.getItem(position);
                releaseMediaPlayer();;
                if (current.getAudioResourceId() != 0){

                    System.out.println(current.getAudioResourceId());
                    System.out.println(current.getArabic());

                mp = MediaPlayer.create(ColloquialActivity.this, current.getAudioResourceId());
                mp.start();
                mp.setOnCompletionListener(isDone);}


            }
        });
 }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        if (mp != null) {

            mp.release();

            mp = null;
        }
    }

}
