package com.example.gameon;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SearchActivity extends ListActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.id.search_menu);
		
		Intent intent = getIntent();
		String theTitle = intent.getStringExtra("TITLE");
		LinkedList<Game> gameList = Searcher.gameSearch(theTitle, new LinkedList<String>());
		List<Integer> gameID = new ArrayList<Integer>();
		List<String> gameTitle = new ArrayList<String>();
		for(Game g:gameList)
		{
			gameID.add(g.getGameID());
			gameTitle.add(g.getGameTitle());
		}
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, gameTitle);
//		setListAdapter(adapter);
	}
}
