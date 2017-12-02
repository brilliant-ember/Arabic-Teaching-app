package com.example.mohammedal.learnarabic;

/**
 * Created by Mohammed Al on 11/17/2017.
 */

public class Word {
    String arabic;
    String translation;
    public Word(String Eng, String Arab){
        this.arabic=Arab;
        this.translation=Eng;
    }
    public String getArabic(){
        return arabic;
    }
    public String getTranslation(){
        return translation;
    }
}
