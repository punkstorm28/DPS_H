package com.example.vyomkeshjha.dps_h.Render;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vyomkeshjha.dps_h.R;

import java.util.ArrayList;

public class Search extends ListActivity {

   PDFsearchHandler searchHandler = new PDFsearchHandler(this);
    ArrayList<String> searchResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            //Do your search here
            searchResults=searchHandler.search(query);
        }

    }
}
