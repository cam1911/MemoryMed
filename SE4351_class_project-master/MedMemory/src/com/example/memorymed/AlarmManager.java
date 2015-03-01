package com.example.memorymed;

import java.util.Iterator;
import java.util.TreeMap;

import android.os.Bundle;


//Simplified storage for events
public abstract class AlarmManager
{
	private static TreeMap<String, Event> events = new TreeMap<String, Event>();
	
	public static void addEvent(String name, Event e)
	{
		events.put(name, e);
	}
	
	public static Event getEvent(String name)
	{
		return events.get(name);
	}
	
	public static Event removeEvent(String name)
	{
		return events.remove(name);
	}
	
	public static boolean removeEvent(Event e)
	{
		Iterator<Event> it = events.values().iterator();
		while(it.hasNext())
		{
			Event e2 = it.next();
			if(e.equals(e2))
			{
				it.remove();
				return true;
			}
		}
		return false;
	}
	
	public static boolean containsEvent(Event e)
	{
		return events.containsValue(e);
	}
	
	public static boolean containsName(String name)
	{
		return events.containsKey(name);
	}
	
	public static int getSize()
	{
		return events.size();
	}
	
	
	
	//A basic wrapper for the event information
	private final class Event
	{
		private Bundle information;
		public static final String
				REPEAT = "repeat",
				BEGIN_TIME = "begintime",
				END_TIME = "endtime",
				TITLE = "title",
				CONTENT = "content";
		
		public static final int
				WEEKLY = 0xF001,
				BIWEEKLY = 0xF002,
				MONTHLY = 0xF003,
				YEARLY = 0xF004;
		
		public Event()
		{
			information = new Bundle();
		}
		
		
		/*
		 * Makes sure the Bundle only has specific entries related to information
		 * needed for an event (i.e. date, start time, etc.). Returns true if the
		 * extra was added successfully.
		 */
		public boolean putExtra(String key, Object value)
		{
			if(key.equals(REPEAT) && value instanceof Integer)
			{
				Integer v = (Integer) value;
				switch(v)
				{
				case WEEKLY: case BIWEEKLY: case MONTHLY: case YEARLY: information.putInt(key, v); return true;
				}
			}
			else if(key.equals(BEGIN_TIME) && value instanceof java.util.Calendar)
			{
				java.util.Calendar v = (java.util.Calendar) value;
				information.putSerializable(key, v);
				return true;
			}
			else if(key.equals(END_TIME) && value instanceof java.util.Calendar)
			{
				java.util.Calendar v = (java.util.Calendar) value;
				information.putSerializable(key, v);
				return true;
			}
			else if(key.equals(TITLE) && value instanceof String)
			{
				String v = (String) value;
				information.putString(key, v);
				return true;
			}
			else if(key.equals(CONTENT) && value instanceof String)
			{
				String v = (String) value;
				information.putString(key, v);
				return true;
			}
			
			return false;
		}
				
		public Object getValue(String key)
		{
			return information.get(key);
		}
	}
}
