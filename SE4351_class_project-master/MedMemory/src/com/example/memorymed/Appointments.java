package com.example.memorymed;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class Appointments extends Activity
{
	//private String calendar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appointments);
		
		
		
		/*boolean firstTime = this.getIntent().getExtras().getBoolean("isFirstTime");
		
		if(firstTime)
		{
			promptCalendarChoice();
		}
		
		/*
		 * Will read in settings asynchronous to first time dialog. Thus, reads in
		 * settings if it's not the first time, or sets defaults if it is.
		 */
		/*
		SharedPreferences settings = getSharedPreferences(MainActivity.PREF_NAME, 0);
		calendar = settings.getString("selectedCalendar", "None");
		
		//Populate list
		if(!calendar.equals("None"))
		{
			
		}*/
	}
	
	/*
	 * Prompts the user for their choice of calendar, or use app's local calendar
	 */
	
	/*
	private void promptCalendarChoice() {
		CalendarSelectionDialog dialog = new CalendarSelectionDialog();
		dialog.setCancelable(false);
		Bundle args = new Bundle();
		args.putStringArray("availableCalendars", new String[]{"Google Calendar", "Calendar", "Outlook", "Whatever"});
		dialog.setArguments(args);
		dialog.show(getFragmentManager(), "Calendar");
	}
	
	public void setCalendar(String calendar)
	{
		this.calendar = calendar;
		Log.i("Calendar", this.calendar);
	}
	
	/*
	 * This refresh the list of events. Called during onCreate and whenever the user edits, adds, or deletes events. 
	 */
	
	/*
	private void populateEvents()
	{
		
	}
	*/
}
