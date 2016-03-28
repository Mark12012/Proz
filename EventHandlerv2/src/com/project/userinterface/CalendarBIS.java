package com.project.userinterface;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CalendarBIS extends JPanel {
	
	SimpleDateFormat month = new SimpleDateFormat("MMMM");
	SimpleDateFormat year = new SimpleDateFormat("yyyy");
	SimpleDateFormat day = new SimpleDateFormat("d");
	Date date = new Date();

	public void setDate(Date date) {
		this.date = date;
	}
	  
	public void drawCenteredString(String s, int w, int h, Graphics g) {
	    FontMetrics fm = g.getFontMetrics();
	    int x = (w - fm.stringWidth(s)) / 2;
	    //int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
	    g.drawString(s, x, h);
	}
  
	public void paintComponent(Graphics g) {
		  
		System.out.println(getWidth()+ " " + getHeight());
		g.setColor(new Color(0x3E454D));
		super.paintComponent(g);
		g.fillRect(0, 0, getWidth()*16/21, getHeight()/9*5);
		g.setColor(new Color(0xBE776E));
		drawCenteredString(month.format(date), getWidth()*16/21, 50, g);
		g.setColor(Color.white);
		drawCenteredString(year.format(date), getWidth()*16/21, 36, g);
		g.setColor(Color.white);
		//g.drawString(year.format(date), getWidth()*16/21, 36);
		g.setColor(Color.white);
		//g.drawString(year.format(date), getWidth()*16/21, 36);
		
		Calendar today = Calendar.getInstance();
		today.setTime(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.DATE, - cal.get(Calendar.DAY_OF_WEEK) + 1);
		
		int wk = cal.get(Calendar.WEEK_OF_YEAR);
		
		for (int week = 0; week < 6; week++) {
			for (int d = 0; d < 7; d++) {
				//Color col = Color.black;
		    	if(cal.get(Calendar.MONTH) == today.get(Calendar.MONTH))
		    		g.setColor(Color.white);
		    	else
		    		g.setColor(new Color(0x73ACB7));
		          
		    	  	g.drawString(day.format(cal.getTime()), d * getWidth()/21 + getWidth()/21*5 + 4, week * 29 + 81 + 20);
		    	  	
		    	cal.add(Calendar.DATE, +1);
		      }
		    }
	    
	    
	    
		
	}
		  
	/*public int getFirstWeekOfMonth() {
		
		int monthOfYear;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.DATE, - cal.get(Calendar.DAY_OF_WEEK) + 1);
		monthOfYear = cal.get(Calendar.WEEK_OF_YEAR);
		return monthOfYear;
	}*/
	 
}