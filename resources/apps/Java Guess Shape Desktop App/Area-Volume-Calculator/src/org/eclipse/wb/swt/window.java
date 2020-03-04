package org.eclipse.wb.swt;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class window {
	
	//Frame
	private JFrame frame;
	private Integer f_width;
	private Integer f_height;
	
	//Buttons
	private LinkedList<button> buttons;
	
	//Other
	private String f_Title;
	private windowType w_type;
	
	public boolean isActiveWindow;
	

	//New Window Constructor
	public window(String fTitle, Integer fWidth, Integer fHeight, boolean active, windowType type) 
	{
		//Setup Frame
		this.frame 			= new JFrame();
		this.f_Title 		= fTitle; //frame title
		this.f_width 		= fWidth; //frame width
		this.f_height 		= fHeight; //frame height
		this.isActiveWindow = active;
		this.w_type 		= type;
		
		this.buttons 		= new LinkedList<button>();
		
		//Add Buttons To List
		build_window();
	}
	
	private void build_window() 
	{
		frame.setSize(f_width, f_height);
		frame.setVisible(isActiveWindow);
		frame.setTitle(f_Title);
		frame.setResizable(false);
		frame.setLocation(getCenter(0));
		
		build_buttons();
		
	}
	
	private Point getCenter(int padding) 
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int x = (dim.width - w) / 2;
		int y = ((dim.height - h) / 2) + padding;
		
		return new Point(x,y);
	}
	private void build_buttons() 
	{
		switch(w_type) 
		{
			case menu:
			{
				buttons.add(new button(buttonType.c_btn));
				buttons.add(new button(buttonType.a_btn));
				buttons.add(new button(buttonType.v_btn));
				buttons.add(new button(buttonType.exit));
				positionButtons();
				
				System.out.println("Working: " + w_type);
				break;
			}
			
			default:
			{
				buttons.add(new button(buttonType.calc));
				buttons.add(new button(buttonType.back));
				buttons.add(new button(buttonType.exit));
				System.out.println("Working: " + w_type);
				positionButtons();
				break;
			}
		}
	}
	
	private void positionButtons() 
	{
		int padding = 10;
		
		for (int i = 0; i < buttons.size(); i++) 
		{
			buttons.get(i).thisButton.setLocation(getCenter(padding));
			padding += 60; // Button Height + 10
		}
	}
	

}
