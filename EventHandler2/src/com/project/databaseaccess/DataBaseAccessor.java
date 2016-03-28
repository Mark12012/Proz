package com.project.databaseaccess;

import java.sql.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
			System.err.println("£adowanie sterownika JDBC/ODBC zakoñczy³o siê niepowodzeniem.");
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
			System.err.println("Zamkniêcie po³¹czenia zakoñczy³o siê niepowodzeniem.");
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
				
				
				Timestamp timestamp = recordlist.getTimestamp("eventdate");
				if (timestamp != null)
				    System.out.println(timestamp);
				
				
				
				event.setEventdate(recordlist.getDate("eventdate"));
				
				allEvents.add(event);
			}
		}
		catch(SQLException e)
		{
			System.err.println("Pobieranie wydarzeñ zakoñczy³o siê niepowodzeniem.");
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
			System.err.println("Pobieranie id kategorii zakoñczy³o siê niepowodzeniem.");
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
			System.err.println("Pobieranie id u¿ytkownika zakoñczy³o siê niepowodzeniem.");
		}
		finally
		{
			endConnection(c);
		}
		
		return result;
	}
	
	
	public List<EventModel> findEventsInNextWeek(int user_id)
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
			System.err.println("Pobieranie wydarzeñ zakoñczy³o siê niepowodzeniem.");
		}
		finally
		{
			endConnection(c);
		}
		
		return weekEvents;	
	}
	public List<EventModel> findEventsInCertainDay(int user_id,int day, int month, int year)
	{
		List<EventModel> dayEvents = new ArrayList<>();
		
		String query = "SELECT * FROM events WHERE user_id = ? AND DAY(eventdate) = ? " + 
		"AND MONTH(eventdate) = ? AND YEAR(eventdate) = ?";
		Connection c = null;
		
		try
		{
			c = createConnection();
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, user_id);
			statement.setInt(2, day);
			statement.setInt(3, month);
			statement.setInt(4, year);
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
			System.err.println("Pobieranie wydarzeñ zakoñczy³o siê niepowodzeniem.");
		}
		finally
		{
			endConnection(c);
		}
		
		return dayEvents;
	}
	
	public List<EventModel> findEventsInCertainMonth(int user_id,int month, int year)
	{
		List<EventModel> monthEvents = new ArrayList<>();
		
		String query = "SELECT * FROM events WHERE user_id = ? AND MONTH(eventdate) = ? " + 
		"AND YEAR(eventdate) = ?";
		Connection c = null;
		
		try
		{
			c = createConnection();
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, user_id);
			statement.setInt(2, month);
			statement.setInt(3, year);
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
			System.err.println("Pobieranie wydarzeñ zakoñczy³o siê niepowodzeniem.");
		}
		finally
		{
			endConnection(c);
		}
		
		return monthEvents;
	}
	
	public List<EventModel> findEventsInCertainYear(int user_id,int year)
	{
		List<EventModel> yearEvents = new ArrayList<>();
		
		String query = "SELECT * FROM events WHERE user_id = ? AND YEAR(eventdate) = ?";
		Connection c = null;
		
		try
		{
			c = createConnection();
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, user_id);
			statement.setInt(2, year);
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
				
				yearEvents.add(event);
			}
		}
		catch(SQLException e)
		{
			System.err.println("Pobieranie wydarzeñ zakoñczy³o siê niepowodzeniem.");
		}
		finally
		{
			endConnection(c);
		}
		
		return yearEvents;
	}
}