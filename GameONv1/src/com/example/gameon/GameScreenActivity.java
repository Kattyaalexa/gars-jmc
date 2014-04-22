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
	
	//private Game game;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_screen);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		View layout = findViewById(R.id.game_screen);
		Drawable background = layout.getBackground();
		background.setAlpha(150);
		
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
