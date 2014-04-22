// *****************************************************************
// *****************************************************************
// *                                                               *
// * Function Name:  MainMenuActivity.java                         *
// * Description: this is the class for all activities in the main *
// * menu of GameON 			                                   *
// * Date Created: February 24, 2014                               *
// * Author: Michael Chiong		                                   *
// *****************************************************************
// *****************************************************************
package com.example.gameon;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.gameon_menu);
		User user=new User(new File("User.xml"));
		
		Button button = (Button)findViewById(R.id.submit_button);
		final EditText editTextTitle = (EditText)findViewById(R.id.game_name);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String title = editTextTitle.getText().toString();
				Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
				intent.putExtra("TITLE", title);
				startActivity(intent);
				
			}
		});
		
		View layout = findViewById(R.id.LinearLayout1);
		Drawable background = layout.getBackground();
		background.setAlpha(150);
		
		configureImageButton();
	}
	
	private void configureImageButton() {
		ImageButton btn = (ImageButton) findViewById(R.id.request_game);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainMenuActivity.this, SearchActivity.class);
				startActivity(intent);
			}
		});
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
    	switch (item.getItemId()) {
		case R.id.action_logout:
			Intent intent = new Intent(MainMenuActivity.this, MainActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
        return super.onOptionsItemSelected(item);
    }
	
}
