package org.eclipse.wb.swt;

import javax.swing.*;

public class button 
{
	//Dimensions
	private Integer b_width;
	private Integer b_height;
	
	private buttonType b_type;
	
	public JButton thisButton;
	
	public button(buttonType type) 
	{
		this.b_width 	= 200;
		this.b_height 	= 50;
		this.b_type 	= type;
		
		button_setup();
	}
	
	private void button_setup() 
	{
		thisButton = new JButton();
		
		thisButton.setText(getButtonType());
		thisButton.setVisible(true);
		thisButton.setSize(b_width, b_height);
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

}
