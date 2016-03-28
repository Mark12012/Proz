package com.project.systemlogic;

import com.project.databaseaccess.DataBaseAccessor;
import com.project.databaseaccess.DateTimeModel;
public class UserApp
{
	private static DataBaseAccessor accessor = new DataBaseAccessor();

	public static void main(String[] args)
	{
		int user_id;
		int category_id;
		String login = "first"; // first,second,third
		String password = "haslo1"; // haslo1,haslo2,haslo3
		String categoryShortcut = "kol"; // kol,lab,sw
		int month = 3;
		int day = 26;
		int year = 2016;
		user_id = accessor.findCurrentUserId(login,password); 
		category_id = accessor.findCategoryIdByShortCut(categoryShortcut);
		
		System.out.println("Lista wszystkich wydarze� u�ytkownika: " + login);
		System.out.println("Kategoria o skr�cie: " + categoryShortcut + " ma id: " + category_id );
		System.out.println("Lista wydarze� wszystkich : " + accessor.findAllEvents(user_id));
		System.out.println("Lista wydarzen z najbli�szego tygodnia: " + 
		accessor.findEventsInNextWeek(user_id));
		System.out.println("Lista wydarze� z misi�ca: " + month + '\n' +
		accessor.findEventsInCertainMonth(user_id, month, year));
		System.out.println("Lista wydarze� z dnia: " + day + '0' +  month + year +'\n' +
		accessor.findEventsInCertainDay(user_id, day,month,year));
		System.out.println("Lista wydarze� z roku: " + year + '\n' +
		accessor.findEventsInCertainYear(user_id, year));
		DateTimeModel dat = new DateTimeModel();
		System.out.println("\n"  + dat);
		
	}

}
