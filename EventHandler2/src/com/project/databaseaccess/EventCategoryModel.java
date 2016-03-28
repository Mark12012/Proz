package com.project.databaseaccess;

public class EventCategoryModel
{
	private Long eventcategory_id;
	private String title;
	private String shortcut;
	private boolean isPrivate;
	private String colour;
	
	public String getColour()
	{
		return colour;
	}
	public void setColour(String colour)
	{
		this.colour = colour;
	}
	public Long getEventcategory_id()
	{
		return eventcategory_id;
	}
	public void setEventcategory_id(Long eventcategory_id)
	{
		this.eventcategory_id = eventcategory_id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getShortcut()
	{
		return shortcut;
	}
	public void setShortcut(String shortcut)
	{
		this.shortcut = shortcut;
	}
	public boolean isPrivate()
	{
		return isPrivate;
	}
	public void setPrivate(boolean isPrivate)
	{
		this.isPrivate = isPrivate;
	}
	
	
	
	public String toString()
	{
		return "Categoria wydarzenia: " + title + " o skrócie : " + shortcut;
	}
}
