package com.example.memorymed;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	/*
	 * Don't ever change this; used for accessing Shared Preferences via
	 * getSharedPreferences(PREF_NAME, 0);
	 */
	public static final String PREF_NAME = "MedMemoryPreferences";

	private static boolean isFirstTime = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		isFirstTime = isFirstTime();
		Log.i("MainActivity", "first time = " + isFirstTime);

		// For testing
		/*
		 * SharedPreferences settings = getSharedPreferences(PREF_NAME, 0);
		 * SharedPreferences.Editor editor = settings.edit();
		 * editor.putBoolean("isFirstTime", true); editor.commit();
		 */

		// For launch
		if (isFirstTime) {
			SharedPreferences settings = getSharedPreferences(PREF_NAME, 0);
			SharedPreferences.Editor editor = settings.edit();
			editor.putBoolean("isFirstTime", false);
			editor.commit();
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
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void gotocal(View view) {
		Intent myintent = new Intent(this, Calendar.class);
		myintent.putExtra("isFirstTime", isFirstTime);
		startActivity(myintent);
	}

	public void gotomeds(View view) {
		Intent myintent = new Intent(this, Meds.class);
		startActivity(myintent);
	}

	public void gotodoctor(View view) {
		Intent myintent = new Intent(this, Doctor.class);
		startActivity(myintent);
	}

	public void gotopharms(View view) {
		// Intent myintent = new Intent(this, Pharm.class);
		Intent myintent = new Intent(Intent.ACTION_VIEW);
		myintent.setData(Uri.parse("geo:0,0?q=pharmacy"));
		if (myintent.resolveActivity(getPackageManager()) != null)
			startActivity(myintent);
		else
			Toast.makeText(this, "There is no Maps app on this device.",
					Toast.LENGTH_SHORT).show();
	}

	// Not sure what is referencing this method...
	public void gotoaddmedication(View view) {
		Intent myintent = new Intent(this, AddMedication.class);
		startActivity(myintent);
	}

	/*
	 * Reads in if it is the first time the app has been launched. Use field
	 * "isFirstTime" to pass to Intents rather than recalling this method more
	 * that the initial call in onCreate.
	 */
	private boolean isFirstTime() {
		SharedPreferences settings = getSharedPreferences(PREF_NAME, 0);
		return settings.getBoolean("isFirstTime", true);
	}
}
