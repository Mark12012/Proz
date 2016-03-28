package com.project.databaseaccess;

import java.sql.Date;
import java.text.DecimalFormat;

public class DateTimeModel
{
	private int startYear;
	private int startMonth;
	private int startDay;
	private int startHour;
	private int startMinute;
	private int startSeconde;
	
	private int stopYear;
	private int stopMonth;
	private int stopDay;
	private int stopHour;
	private int stopMinute;
	private int stopSeconde;
	
	public DateTimeModel()
	{
		
	}
	
	public DateTimeModel(int year,int month, int day, int hour, int min, int sec, 
			int fyear,int fmonth,int fday, int fhour, int fmin, int fsec )
	{
		this.startYear = year;
		this.startMonth = month;
		this.startDay = day;
		this.startHour = hour;
		this.startMinute = min;
		this.startSeconde = sec;
		this.stopYear = fyear;
		this.stopMonth = fmonth;
		this.stopDay = fday;
		this.stopHour = fhour;
		this.stopMinute = fmin;
		this.stopSeconde = fsec;
	}
	
	public DateTimeModel(int year,int month, int day, int hour, int min, int sec)
	{
		this(year,month,day,hour,min,sec,year,month,day,hour,min,sec);
	}
	
	
	public int getStartYear()
	{
		return startYear;
	}
	public void setStartYear(int startYear)
	{
		this.startYear = startYear;
	}
	public int getStartMonth()
	{
		return startMonth;
	}
	public void setStartMonth(int startMonth)
	{
		this.startMonth = startMonth;
	}
	public int getStartDay()
	{
		return startDay;
	}
	public void setStartDay(int startDay)
	{
		this.startDay = startDay;
	}
	public int getStartHour()
	{
		return startHour;
	}
	public void setStartHour(int startHour)
	{
		this.startHour = startHour;
	}
	public int getStartMinute()
	{
		return startMinute;
	}
	public void setStartMinute(int startMinute)
	{
		this.startMinute = startMinute;
	}
	public int getStartSeconde()
	{
		return startSeconde;
	}
	public void setStartSeconde(int startSeconde)
	{
		this.startSeconde = startSeconde;
	}
	public int getStopYear()
	{
		return stopYear;
	}
	public void setStopYear(int stopYear)
	{
		this.stopYear = stopYear;
	}
	public int getStopMonth()
	{
		return stopMonth;
	}
	public void setStopMonth(int stopMonth)
	{
		this.stopMonth = stopMonth;
	}
	public int getStopDay()
	{
		return stopDay;
	}
	public void setStopDay(int stopDay)
	{
		this.stopDay = stopDay;
	}
	public int getStopHour()
	{
		return stopHour;
	}
	public void setStopHour(int stopHour)
	{
		this.stopHour = stopHour;
	}
	public int getStopMinute()
	{
		return stopMinute;
	}
	public void setStopMinute(int stopMinute)
	{
		this.stopMinute = stopMinute;
	}
	public int getStopSeconde()
	{
		return stopSeconde;
	}
	public void setStopSeconde(int stopSeconde)
	{
		this.stopSeconde = stopSeconde;
	}
	
	public String toString()
	{
		DecimalFormat twodigits = new DecimalFormat("00");
		
		return  Integer.toString(startYear) +'-'+twodigits.format(startMonth)+'-'+twodigits.format(startDay)+' '+
				twodigits.format(startHour)+':'+twodigits.format(startMinute)+':'+
				twodigits.format(startSeconde)+' '+ stopYear+'-'+twodigits.format(stopMonth)+
				'-'+twodigits.format(stopDay)+' '+twodigits.format(stopHour)+':'+
				twodigits.format(stopMinute)+':'+twodigits.format(stopSeconde);
	}

}
