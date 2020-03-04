package org.eclipse.wb.swt;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class window {
	
	//Frame
	private JFrame frame;
	private Integer f_width;
	private Integer f_height;
	
	//GUI Elements
	private LinkedList<button> buttons;
	
	//Other
	private String f_Title;
	public windowType w_type;
	
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
		//TODO: Add Input Elements
		if (w_type != windowType.menu) 
		{
			frame.add(new TextArea());
			frame.add(new TextArea());
		}
		build_buttons();
		setVisibility();
		
		frame.setSize(f_width, f_height);
		frame.setTitle(f_Title);
		frame.setResizable(false);
		frame.setLocation(getCenter(0));
		frame.setLayout(new GridLayout(getElementAmount(), 1));
		
		for(button b : buttons) 
		{
			frame.add(b.thisButton);
			System.out.println(b.thisButton.getName());
		}
	
		
		if (w_type == windowType.menu) 
		{
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
	}
	
	public void setVisibility() 
	{
		frame.setVisible(isActiveWindow);
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
	
	private Integer getElementAmount() 
	{
		switch(w_type) 
		{
			case menu:
			{
				return buttons.size();
			}
			default:
			{
				return 0;
			}
		}
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
				//System.out.println("Working: " + w_type);
				break;
			}
			
			default:
			{
				buttons.add(new button(buttonType.calc));
				buttons.add(new button(buttonType.back));
				//System.out.println("Working: " + w_type);
				break;
			}
		}
	}	

}
