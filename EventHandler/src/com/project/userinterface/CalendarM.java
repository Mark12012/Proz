package com.project.userinterface;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;

public class CalendarM extends JFrame implements ActionListener{
	
	EventPrv event = new EventPrv();
	CalendarOnly ch = new CalendarOnly();
	//CalendarBIS ch = new CalendarBIS();
	public CalendarM() {
		
	super("Calendar");
	
		try {
			//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	//setLayout(null);
	
	this.setSize(1260, 540);
	//GridLayout gridLayout = new GridLayout(1,0);
	//JPanel box = new JPanel();
	//box.setSize(new Dimension(getWidth()/21*16, getHeight()));
	//gridLayout.preferredLayoutSize(box);
	this.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	//c.fill = GridBagConstraints.VERTICAL;
	//this.getContentPane().setBackground(new Color(0x3E454D));
	
	
	JMenu menu1 = new JMenu("Plik");
	JMenuItem menu1open = new JMenuItem("Otwórz");
	JMenuItem menu1save = new JMenuItem("Zapisz");
	JMenuItem menu1saveas = new JMenuItem("Zapisz jako...");
	menu1open.addActionListener(this);
	menu1save.addActionListener(this);
	menu1saveas.addActionListener(this);
	menu1.add(menu1open);
	menu1.add(menu1save);
	menu1.add(menu1saveas);
	JMenu menu2 = new JMenu("Menu 4");
	JMenuItem menu2item1 = new JMenuItem("Clear");
	menu2item1.addActionListener(this);	
	menu2.add(menu2item1);
	menu1.add(menu2);
	JMenuBar menuBar = new JMenuBar();
	menuBar.add(menu1);
	setJMenuBar(menuBar);	
		
	
	//ch.setSize(new Dimension(getWidth()*16/21, getHeight()));
    ch.setDate(new Date());
    ch.setVisible(true);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = getHeight()/2;
    c.weightx = 0.5;
    c.gridx = 0;
    c.gridy = 0;
    this.getContentPane().add(ch, c);
	
	
    //event.setSize(new Dimension(getWidth()*5/21, getHeight()));
    event.addEvent("a", "b");
    event.clear();
    event.setVisible(true);
    //event.setHorizontalAlignment(SwingConstants.LEFT);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = getHeight()*2;
    c.weightx = 0.5;
    c.gridx = 1;
    c.gridy = 0;
    this.getContentPane().add(event, c);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		
		switch(cmd){
		case "Clear":
			clear();
			break;
		default:
			System.out.println(cmd);
			break;
		}
	}
	
	public void addEvent(String title, String des) {
		event.addEvent(title, des);
		}
	public void clear() {
		event.clear();
		}
}
