package com.project.databaseaccess;

import java.sql.Date;

public class EventModel
{
	public EventModel()
	{
		this.user_id = 0;
		this.place = null;
		this.description = null;
		this.eventdate = null;
		this.title = null;
		this.eventcategory_id = 0;
	}
	
	public EventModel(int user_id, String place,String description,Date eventdate,String title,int  eventcategory_id)
	{
		this.user_id = user_id;
		this.place = place;
		this.description = description;
		this.eventdate = eventdate;
		this.title = title;
		this.eventcategory_id = eventcategory_id;
	}
	
	public EventModel(int user_id, String place,String description,Date eventdate,String title)
	{
		this(user_id,place,description,eventdate,title,1);
	}

	public int getEvent_id()
	{
		return event_id;
	}
	public void setEvent_id(int event_id)
	{
		this.event_id = event_id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getPlace()
	{
		return place;
	}
	public void setPlace(String place)
	{
		this.place = place;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Date getEventdate()
	{
		return eventdate;
	}
	public void setEventdate(Date eventdate)
	{
		this.eventdate = eventdate;
	}
	public int getUser()
	{
		return user_id;
	}
	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}
	public int getEventcategory_id()
	{
		return eventcategory_id;
	}
	public void setEventcategory_id(int eventcategory_id)
	{
		this.eventcategory_id = eventcategory_id;
	}
	
	public String toString()
	{
		return "Wydarzenie: " + title + " dnia: " + eventdate + "opis: " + description + '\n';
	}
	private int event_id;
	private String title;
	private String place;
	private String description;
	private Date eventdate;
	private int user_id;
	private int  eventcategory_id;
}
