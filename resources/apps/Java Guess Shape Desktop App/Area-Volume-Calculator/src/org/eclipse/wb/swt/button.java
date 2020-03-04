package org.eclipse.wb.swt;


import java.awt.event.*;

import javax.swing.*;

public class button extends Main
{

	private buttonType b_type;
	
	public JButton thisButton;
	
	public button(buttonType type) 
	{
		this.b_type 	= type;
		button_setup();
	}
	
	private void button_setup() 
	{
		//Create Button
		thisButton = new JButton();
		
		thisButton.setName(b_type.toString());
		thisButton.setText(getButtonType());
		thisButton.setVisible(true);
		thisButton.setFocusable(false);
		addClickEvent();
	}
	
	private String getButtonType() 
	{
		switch (b_type) 
		{
			case c_btn:
			{
				return "Circumference";
			}
			case a_btn:
			{
				return "Area";
			}
			case v_btn:
			{
				return "Volume";
			}
			case calc:
			{
				return "Calculate";
			}
			case back:
			{
				return "Back";
			}
			case exit:
			{
				return "Exit";
			}
			default:
			{
				return "";
			}
		}
	}

	
	void addClickEvent() 
	{
		ActionListener listener = null;
		
		switch (b_type) 
		{
			case c_btn:
			{
				listener = new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// open circumference calculator
						buttonClick(windowType.circumference,false);
						
					}
					
				};
				break;
			}
			case a_btn:
			{
				listener = new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// open area calculator
						buttonClick(windowType.area, false);
					}
					
				};
				break;
			}
			case v_btn:
			{
				listener = new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// open volume calculator
						buttonClick(windowType.volume,false);
					}
					
				};
				break;
			}
			case back:
			{
				listener = new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// back to menu
						buttonClick(windowType.menu,false);
					}
					
				};
				break;
			}
			case exit:
			{
				listener = new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// exit program
						buttonClick(null, true);
					}
					
				};
				
				break;
			}
			default:
			{
				//null
			}
		
		}
		
		thisButton.addActionListener(listener);
		

	}
}
