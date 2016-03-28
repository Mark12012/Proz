package com.project.userinterface;

import java.awt.*;
import javax.swing.*;

public class EventPrv extends JPanel{
	
	protected JLabel textArea;
	private final static String newline = "<br>";

    String initialText = "<html><font color=#ef6900>Events</font>";
	
	public EventPrv() {
		//textArea = new JTextArea();
		textArea = new JLabel();
		this.setBackground(new Color(0x3E454D));
		//textArea.setEditable(false);
		//textArea.setText(initialText);
		//textArea.setHorizontalAlignment(SwingConstants.LEFT);
		this.add(textArea);
		
	}
	public void clear() {
		initialText = "<html><font size=+3 color=#ef6900>Events</font>" + newline;
		textArea.setText(initialText);
	}
	public void addEvent(String title, String des) {
		
		initialText = initialText + newline + "<html><font size=+2 color=white>" + title +
				"</font>" + newline + "<font color=white>" + des + "</font>" + newline;
		textArea.setText(initialText);
		System.out.println(initialText);	
	}

}
