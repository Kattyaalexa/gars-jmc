package com.example.gameon;

import java.io.File;
import java.util.LinkedList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class GameScreenActivity extends Activity {
	
	private Game game;
	private User user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_screen);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		View layout = findViewById(R.id.game_screen);
		Drawable background = layout.getBackground();
		background.setAlpha(150);
		Intent intent=getIntent();
		int id=intent.getIntExtra("gID", 0);
		TextView focus;
		Searcher.gameSearch("example game", new LinkedList<String>());
		user=new User(new File("User.xml"));
		if(id==0)
		{
			focus=(TextView) this.findViewById(R.id.name);			//set name
			focus.setText(focus.getText()+" Game not found, our bad");
		}
		else
		{
			game=new Game(id);
			focus=(TextView) this.findViewById(R.id.name);			//set name
			focus.setText(focus.getText()+" "+game.getGameTitle());
			
			focus=(TextView) this.findViewById(R.id.release_date);  //set release date
			focus.setText(focus.getText()+" "+game.releaseDate());
			
			focus=(TextView) this.findViewById(R.id.genre);	//set genera
			focus.setText(focus.getText()+" "+game.getGenera()[1]);
			
			focus=(TextView) this.findViewById(R.id.platform);		//set pform
			focus.setText(focus.getText()+" "+game.getPlatform());
		}
		
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
		case R.id.action_logout:
			Intent intent = new Intent(GameScreenActivity.this, MainActivity.class);
			startActivity(intent);
			break;
		case android.R.id.home:
			finish();
		default:
			break;
		}
        return super.onOptionsItemSelected(item);
	}

}
