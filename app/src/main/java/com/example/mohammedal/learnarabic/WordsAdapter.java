package com.example.mohammedal.learnarabic;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammed Al on 11/17/2017.
 */

public class WordsAdapter extends BaseAdapter implements Filterable {
    Context context;
    public List<Word> wordsList;
    List<Word> filterList;
    CustomFilter filter;

    public WordsAdapter(Context context, List<Word>array){
        this.context = context;
        this.filterList = array;
        this.wordsList=array;

    }


    @Override
    public int getCount() {
        return wordsList.size();
    }

    @Override
    public Object getItem(int position) {
        return wordsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_with_pic, parent,false);
        }

        Word theNewWord = (Word) getItem(position);
        TextView arabic =  convertView.findViewById(R.id.textViewA);
        TextView translation =  convertView.findViewById(R.id.textViewT);
        arabic.setText(theNewWord.getArabic());
        translation.setText(theNewWord.getTranslation());

        if (theNewWord.getImageResourceId() != 0){
            ImageView img = convertView.findViewById(R.id.imageView);
            img.setImageResource(theNewWord.getImageResourceId());
        }


        return convertView;

        };

    @Override
    public Filter getFilter() {
        if(filter == null){
            filter = new CustomFilter(filterList, this);
        }
        return filter;
    }

}
