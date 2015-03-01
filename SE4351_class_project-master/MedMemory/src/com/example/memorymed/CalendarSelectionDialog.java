package com.example.memorymed;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

public class CalendarSelectionDialog extends DialogFragment
{
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		final String[] calendars = getArguments().getStringArray("availableCalendars");
		builder.setTitle("Choose a Calendar");
		builder.setItems(calendars, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				Calendar calendar;
				SharedPreferences settings = getActivity().getSharedPreferences(MainActivity.PREF_NAME, 0);
				SharedPreferences.Editor editor = settings.edit();
				editor.putString("", calendars[which]);
				editor.commit();
				try
				{
					calendar = (Calendar) getActivity();
					calendar.setCalendar(calendars[which]);
				}
				catch(ClassCastException e)
				{
					
				}
			}
		});
		return builder.create();
	}

}
