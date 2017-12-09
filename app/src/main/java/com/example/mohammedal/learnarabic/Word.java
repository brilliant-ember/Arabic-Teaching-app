package com.example.mohammedal.learnarabic;

/**
 * Created by Mohammed Al on 11/17/2017.
 * There are 3 constructors:
 *          1. a Word with only an arabic text and a tranlsation text
 *          2. a Word with the texts and an audio file
 *          3. a Word with texts audio and an image id
 *
 */

public class Word {
    private String arabic;
    private String translation;
    private int mImageResourceId;
    private int mAudioResourceId;

    public Word(String Eng, String Arab){
        this.arabic=Arab;
        this.translation=Eng;
    }

    public Word(String Eng, String Arab,int imageResourceId, int audioResourceId){
        this.arabic=Arab;
        this.translation=Eng;
        this.mImageResourceId = imageResourceId;
        this.mAudioResourceId = audioResourceId;
    }

    public Word(String Eng, String Arab, int audioResourceId){
        this.arabic=Arab;
        this.translation=Eng;
        this.mAudioResourceId = audioResourceId;
    }



    public String getArabic(){
        return arabic;
    }
    public String getTranslation(){return translation;}
    public int getImageResourceId(){
        return mImageResourceId;
    }
    public int getAudioResourceId(){return mAudioResourceId;}
}
