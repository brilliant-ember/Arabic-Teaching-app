package com.example.mohammedal.learnarabic;

import android.widget.Filter;

import com.example.mohammedal.learnarabic.Word;
import com.example.mohammedal.learnarabic.WordsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammed Al on 1/7/2018.
 */

public class CustomFilter extends Filter{

    List<Word> filterList;
    WordsAdapter adapter;

    public CustomFilter(List<Word> list, WordsAdapter adapter){
        this.filterList = list;
        this.adapter = adapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if (constraint != null && constraint.length()>0){
            constraint = constraint.toString().toLowerCase();
            ArrayList<Word>filteredWords = new ArrayList<>();

            for(int i=0; i<filterList.size(); i++){
                if (filterList.get(i).getTranslation().toLowerCase().contains(constraint) || filterList.get(i).getArabic().toLowerCase().contains(constraint)){
                    filteredWords.add(filterList.get(i));
                }
            }
            results.count = filteredWords.size();
            results.values = filteredWords;
        }
        else{
            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.wordsList =( ArrayList<Word> ) results.values;
        adapter.notifyDataSetChanged();;
    }
}
