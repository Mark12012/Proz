package com.project.databaseaccess;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DataBaseAccessor implements Handable
{
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			System.err.println("�adowanie sterownika JDBC/ODBC zako�czy�o si� niepowodzeniem.");
		}
	}
	
	private Connection createConnection()
	throws SQLException
	{
		return DriverManager.getConnection("jdbc:mysql://localhost/eventhandler","root","");
	}
	
	private void endConnection(Connection connection)
	{
		if(connection == null)
		{
			return;
		}
		try
		{
			connection.close();
		}
		catch(SQLException e)
		{
			System.err.println("Zamkni�cie po��czenia zako�czy�o si� niepowodzeniem.");
		}
	}
	
	public List<EventModel> findAllEvents(int user_id)
	{
		List<EventModel> allEvents = new ArrayList<>();
		
		String query = "SELECT * FROM events WHERE user_id = ?";
		Connection c = null;
		
		try
		{
			c = createConnection();
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, user_id);
			ResultSet recordlist = statement.executeQuery();
			
			while(recordlist.next())
			{
				EventModel event = new EventModel();
				event.setEvent_id(recordlist.getInt("event_id"));
				event.setUser_id(recordlist.getInt("user_id"));
				event.setEventcategory_id(recordlist.getInt("eventcategory_id"));
				event.setTitle(recordlist.getString("title"));
				event.setPlace(recordlist.getString("place"));
				event.setDescription(recordlist.getString("description"));
				event.setEventdate(recordlist.getDate("eventdate"));
				
				allEvents.add(event);
			}
		}
		catch(SQLException e)
		{
			System.err.println("Pobieranie wydarze� zako�czy�o si� niepowodzeniem.");
		}
		finally
		{
			endConnection(c);
		}
		
		return allEvents;
	}
	
	public int findCategoryIdByShortCut(String sc)
	{
		int result = 0;
		
		String query = "SELECT * FROM eventcategories WHERE shortcut = ?";
		Connection c = null;
		
		try
		{
			c = createConnection();
			PreparedStatement statement = c.prepareStatement(query);
			statement.setString(1, sc);
			ResultSet recordlist = statement.executeQuery();
			
			while(recordlist.next())
			{
				result = recordlist.getInt("eventcategory_id");
			}
		}
		catch(SQLException e)
		{
			System.err.println("Pobieranie id kategorii zako�czy�o si� niepowodzeniem.");
		}
		finally
		{
			endConnection(c);
		}
		
		return result;
		
	}
	
	public int findCurrentUserId(String login, String password)
	{
		int result = 0;
		
		String query = "SELECT user_id from users where login = ? AND password = ?";
		
		Connection c = null;
		
		try
		{
			c = createConnection();
			PreparedStatement statement = c.prepareStatement(query);
			statement.setString(1, login);
			statement.setString(2, password);
			ResultSet recordlist = statement.executeQuery();
			while(recordlist.next())
			{
				result= recordlist.getInt("user_id");
			}
		}
		catch(SQLException e)
		{
			System.err.println("Pobieranie id u�ytkownika zako�czy�o si� niepowodzeniem.");
		}
		finally
		{
			endConnection(c);
		}
		
		return result;
	}
	
	
	public List<EventModel> findEventsInThisWeek(int user_id)
	{
		List<EventModel> weekEvents = new ArrayList<>();
		
		Calendar cal = Calendar.getInstance();
		Calendar cal7 = Calendar.getInstance();
		cal7.add(Calendar.DAY_OF_MONTH, 7);
		SimpleDateFormat dateOnly = new SimpleDateFormat("yyyy-MM-dd");
		
		String query = "SELECT * FROM events where eventdate BETWEEN ? AND ?";;
		Connection c = null;
		
		try
		{
			c = createConnection();
			PreparedStatement statement = c.prepareStatement(query);
			statement.setString(1, dateOnly.format(cal.getTime()));
			statement.setString(2, dateOnly.format(cal7.getTime()));
			ResultSet recordlist = statement.executeQuery();
			
			while(recordlist.next())
			{
				EventModel event = new EventModel();
				event.setEvent_id(recordlist.getInt("event_id"));
				event.setUser_id(recordlist.getInt("user_id"));
				event.setEventcategory_id(recordlist.getInt("eventcategory_id"));
				event.setTitle(recordlist.getString("title"));
				event.setPlace(recordlist.getString("place"));
				event.setDescription(recordlist.getString("description"));
				event.setEventdate(recordlist.getDate("eventdate"));
				
				weekEvents.add(event);
			}
		}
		catch(SQLException e)
		{
			System.err.println("Pobieranie wydarze� zako�czy�o si� niepowodzeniem.");
		}
		finally
		{
			endConnection(c);
		}
		
		return weekEvents;	
	}
	
	public List<EventModel> findEventsInCertainDay(int user_id, Calendar date)
	{
		List<EventModel> dayEvents = new ArrayList<>();
		SimpleDateFormat dateOnly = new SimpleDateFormat("yyyy-MM-dd");
		String query = "SELECT * FROM events WHERE user_id = ? AND WHERE eventdate = ?";
		Connection c = null;
		
		try
		{
			c = createConnection();
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, user_id);
			statement.setString(2, dateOnly.format(date.getTime()));
			ResultSet recordlist = statement.executeQuery();
			
			while(recordlist.next())
			{
				EventModel event = new EventModel();
				event.setEvent_id(recordlist.getInt("event_id"));
				event.setUser_id(recordlist.getInt("user_id"));
				event.setEventcategory_id(recordlist.getInt("eventcategory_id"));
				event.setTitle(recordlist.getString("title"));
				event.setPlace(recordlist.getString("place"));
				event.setDescription(recordlist.getString("description"));
				event.setEventdate(recordlist.getDate("eventdate"));
				
				dayEvents.add(event);
			}
		}
		catch(SQLException e)
		{
			System.err.println("Pobieranie wydarze� zako�czy�o si� niepowodzeniem.");
		}
		finally
		{
			endConnection(c);
		}
		
		return dayEvents;
	}
	
	public List<EventModel> findEventsInCertainMonth(int user_id,int MONTH)
	{
		List<EventModel> monthEvents = new ArrayList<>();
		
		String query = "SELECT * FROM events WHERE user_id = ?" +
		" AND MONTH(eventdate) = ?";
		Connection c = null;
		
		try
		{
			c = createConnection();
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, user_id);
			statement.setInt(2, MONTH);
			ResultSet recordlist = statement.executeQuery();
			
			while(recordlist.next())
			{
				EventModel event = new EventModel();
				event.setEvent_id(recordlist.getInt("event_id"));
				event.setUser_id(recordlist.getInt("user_id"));
				event.setEventcategory_id(recordlist.getInt("eventcategory_id"));
				event.setTitle(recordlist.getString("title"));
				event.setPlace(recordlist.getString("place"));
				event.setDescription(recordlist.getString("description"));
				event.setEventdate(recordlist.getDate("eventdate"));
				
				monthEvents.add(event);
			}
		}
		catch(SQLException e)
		{
			System.err.println("Pobieranie wydarze� zako�czy�o si� niepowodzeniem.");
		}
		finally
		{
			endConnection(c);
		}
		
		return monthEvents;
	}
}