package com.project.databaseaccess;

import java.util.List;

public interface Handable
{
	//Event Get
	public List<EventModel> findAllEvents(int user_id);
	public List<EventModel> findEventsInNextWeek(int user_id);
	public List<EventModel> findEventsInCertainDay(int user_id,int day, int month, int year);
	public List<EventModel> findEventsInCertainMonth(int user_id,int month, int year);
	public List<EventModel> findEventsInCertainYear(int user_id,int year);
//	public List<Event> findAllEventsOfCategory(User user,EventCategory category);
//	public Event findNearestEvent(User user);
//	
	//Event Set
//	public void insertEvent(int user_id,EventModel event);
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
