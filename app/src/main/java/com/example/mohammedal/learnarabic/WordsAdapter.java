package com.example.mohammedal.learnarabic;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mohammed Al on 11/17/2017.
 */

public class WordsAdapter extends ArrayAdapter {
    public WordsAdapter(Context context, ArrayList<Word>array){
        super(context,0,array);

    }


    public View getView(int position,  View convertView,  ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_with_pic, parent,false);
        }

        Word theNewWord = (Word) getItem(position);
        TextView arabic =  convertView.findViewById(R.id.textViewA);
        TextView translation =  convertView.findViewById(R.id.textViewT);
        arabic.setText(theNewWord.getArabic());
        translation.setText(theNewWord.getTranslation());

        if (theNewWord.getResourceId()!= 0){
            ImageView img = convertView.findViewById(R.id.imageView);
            img.setImageResource(theNewWord.getResourceId());

        }
        return convertView;

        };

}
