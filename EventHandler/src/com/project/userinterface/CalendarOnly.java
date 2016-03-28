package com.project.userinterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

import com.project.databaseaccess.DataBaseAccessor;
import com.project.systemlogic.UserApp;

public class CalendarOnly extends JPanel {
	
	SimpleDateFormat month = new SimpleDateFormat("MMMM");
	SimpleDateFormat year = new SimpleDateFormat("yyyy");
	SimpleDateFormat day = new SimpleDateFormat("d");
	Date date = new Date();
	private static UserApp userApp = new UserApp();

	public void setDate(Date date) {
		this.date = date;
	}
	
	public CalendarOnly() {
		
    GridLayout experimentLayout = new GridLayout(6,8);
     
        this.setLayout(experimentLayout);
        //Dimension buttonSize = new Dimension(getWidth()/21, getHeight()/18);
        
        Calendar today = Calendar.getInstance();
		today.setTime(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.DATE, - cal.get(Calendar.DAY_OF_WEEK) + 1);
		//this.setBackground(new Color(0x3E454D));
		
		int wk = cal.get(Calendar.WEEK_OF_YEAR);
		
		for (int week = 0; week < 6; week++) {
			JButton weekButton = new JButton("Tydzien " + wk++);
			weekButton.setBorderPainted(false);
			weekButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					String cmd = e.getActionCommand();
					System.out.println(cmd);
				}});
			this.add(weekButton);
			for (int d = 0; d < 7; d++) {
				//Color col = Color.black;
		    	if(cal.get(Calendar.MONTH) < today.get(Calendar.MONTH)) {
		    		JButton dataminus = new JButton(day.format(cal.getTime()));
		    		dataminus.setBorderPainted(false);
		    		dataminus.setForeground(new Color(0xA2A0A5));
		    		dataminus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						String cmd = e.getActionCommand();
						System.out.println(cmd);
						System.out.println(cal.get(Calendar.MONTH) - 1);
					}});
		    		this.add(dataminus);
		    	}
		    	else if(cal.get(Calendar.MONTH) > today.get(Calendar.MONTH)) {
		    		JButton dataplus = new JButton(day.format(cal.getTime()));
		    		dataplus.setBorderPainted(false);
		    		dataplus.setForeground(new Color(0xA2A0A5));
		    		dataplus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						String cmd = e.getActionCommand();
						System.out.println(cmd);
						System.out.println(cal.get(Calendar.MONTH) + 1);
					}});
		    		this.add(dataplus);
		    	}
		    	else {
		    		JButton data = new JButton(day.format(cal.getTime()));
		    		//data.setBackground(new Color(0x3E454D));
		    		data.setForeground(new Color(0x3E454D));
		    		data.setBorderPainted(false);
		    		data.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						int[] cmd = new int[3];
						cmd[0] = Integer.parseInt(e.getActionCommand());
						cmd[1] = cal.get(Calendar.MONTH);
						cmd[2] = cal.get(Calendar.YEAR);
						//userApp.eventsOfTheDay(cmd);
						//System.out.println(cmd);
						//System.out.println(cal.get(Calendar.MONTH));
					}});
				this.add(data);  	
		    	}
				
		    	cal.add(Calendar.DATE, +1);
		      }
				
		    }
        

    }
}
