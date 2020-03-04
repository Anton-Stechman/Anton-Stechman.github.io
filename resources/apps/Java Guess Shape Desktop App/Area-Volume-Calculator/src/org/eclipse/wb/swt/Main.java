package org.eclipse.wb.swt;

import java.util.*;

public class Main {

	static window mainMenu;
	static window c_window;
	static window a_window;
	static window v_window;
	
	static Integer default_width 	= 600;
	static Integer default_height 	= 400;
	
	static String mainTitle = "Circumference, Area & Volume Calculator";
	static String c_title 	= "Calculate Circumference";
	static String a_title 	= "Calculate Area";
	static String v_title 	= "Claculate Volume";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create Main Menu
		mainMenu = new window(mainTitle, default_width, default_height, true, windowType.menu);
		c_window = new window(c_title,	 default_width, default_height, false, windowType.circumference);
		a_window = new window(a_title,	 default_width, default_height, false, windowType.area);
		v_window = new window(v_title,	 default_width, default_height, false, windowType.volume);
	}

}
