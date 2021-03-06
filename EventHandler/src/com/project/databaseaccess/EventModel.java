package com.project.databaseaccess;

import java.sql.Date;

public class EventModel
{

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
