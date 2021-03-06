package com.project.databaseaccess;

import java.util.Calendar;
import java.util.List;

public interface Handable
{
	//Event Get
	public List<EventModel> findAllEvents(int user_id);
	public List<EventModel> findEventsInThisWeek(int user_id);
	public List<EventModel> findEventsInCertainDay(int user_id, Calendar date);
	public List<EventModel> findEventsInCertainMonth(int user_id,int MONTH);
//	public List<Event> findAllEventsOfCategory(User user,EventCategory category);
//	public Event findNearestEvent(User user);
//	
//	//Event Set
//	public void insertEvent(User user,Event event);
//	public void editEvent(User user,Event upevent);
//	public void deleteEvent(User user,Long event_id);
//	
//	//EventCategory Get
//	public List<EventCategory> findAllCategories();
	public int findCategoryIdByShortCut(String sc);
//	
//	//EventCategory Set
//	public void insertEventCategory(User user,EventCategory category);
	
	
	//User Get
	public int findCurrentUserId(String login, String password);
	
}
