package com.example.mohammedal.learnarabic;

/**
 * Created by Mohammed Al on 11/17/2017.
 */

public class Word {
    private String arabic;
    private String translation;
    private int mImageResourceId;

    public Word(String Eng, String Arab){
        this.arabic=Arab;
        this.translation=Eng;
    }
    public Word(String Eng, String Arab,int imageResourceId){
        this.arabic=Arab;
        this.translation=Eng;
        this.mImageResourceId = imageResourceId;
    }

    public String getArabic(){
        return arabic;
    }
    public String getTranslation(){
        return translation;
    }
    public int getResourceId(){
        return mImageResourceId;
    }
}
