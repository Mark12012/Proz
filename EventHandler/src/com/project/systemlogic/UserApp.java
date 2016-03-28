package com.project.systemlogic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.project.databaseaccess.DataBaseAccessor;
import com.project.databaseaccess.EventModel;
import com.project.userinterface.CalendarM;

public class UserApp
{
	private static DataBaseAccessor accessor = new DataBaseAccessor();
	//private static EventPrv eventPriv = new EventPrv();
	private static CalendarM calendarM = new CalendarM();
	
	public void eventsOfTheDay(int[] datei) {
		Calendar date = Calendar.getInstance();
		date.set(datei[2], datei[1], datei[0]);
		
		List<EventModel> allEvents = new ArrayList<>();
		//allEvents = accessor.findEventsInCertainDay(1, date);
		allEvents = accessor.findEventsInCertainMonth(1, datei[1]);
		calendarM.clear();
		for(int i = 0; i < allEvents.size(); i++){
			calendarM.addEvent(allEvents.get(i).getTitle(), allEvents.get(i).getDescription());
		}
		System.out.println(allEvents);
		//eventPriv.addEvent("a", "b");
	}
	public void eventsOfTheMonth(Date date) {
		
	}
	
	/*public static void main(String[] args)
	{
		int user_id;
		int category_id;
		String login = "first"; // first,second,third
		String password = "haslo1"; // haslo1,haslo2,haslo3
		String categoryShortcut = "kol"; // kol,lab,sw
		int month = 3;
		user_id = accessor.findCurrentUserId(login,password); 
		category_id = accessor.findCategoryIdByShortCut(categoryShortcut);
		
		System.out.println("Lista wszystkich wydarzeñ u¿ytkownika: " + login);
		System.out.println("Kategoria o skrócie: " + categoryShortcut + " ma id: " + category_id );
		System.out.println("Lista wydarzeñ wszystkich : " + accessor.findAllEvents(user_id));
		System.out.println("Lista wydarzen z najbli¿szego tygodnia: " + 
		accessor.findEventsInThisWeek(user_id));
		System.out.println("Lista wydarzeñ z misi¹ca: " + month + '\n' +
		accessor.findEventsInCertainMonth(user_id, month));
	}*/

}