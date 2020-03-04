package org.eclipse.wb.swt;
import java.util.*;

public class Main implements calculate 
{

	public static window mainMenu;
	public static window c_window;
	public static window a_window;
	public static window v_window;
	
	static Integer default_width 	= 600;
	static Integer default_height 	= 400;
	
	static String mainTitle = "Circumference, Area & Volume Calculator";
	static String c_title 	= "Calculate Circumference";
	static String a_title 	= "Calculate Area";
	static String v_title 	= "Claculate Volume";
	
	static LinkedList<window> allWindows;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create Main Menu
		mainMenu = new window(mainTitle, default_width, default_height, true, windowType.menu);
		c_window = new window(c_title,	 default_width, default_height, false, windowType.circumference);
		a_window = new window(a_title,	 default_width, default_height, false, windowType.area);
		v_window = new window(v_title,	 default_width, default_height, false, windowType.volume);
		
		allWindows = new LinkedList<window>();
		allWindows.add(mainMenu);
		allWindows.add(c_window);
		allWindows.add(a_window);
		allWindows.add(v_window);
	}
	
	public void buttonClick(windowType t, boolean isExit) 
	{
		System.out.println("Working " + t);
		if (!isExit) 
		{
			for (window w : allWindows) 
			{
				if(w.w_type == t) 
				{
					w.isActiveWindow = true;
				}
				else 
				{
					w.isActiveWindow = false;
				}
				
				w.setVisibility();
			}
		}
		else 
		{
			System.exit(0);
		}
	}

}
