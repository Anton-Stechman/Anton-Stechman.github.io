package org.eclipse.wb.swt;

public interface calculate 
{
	public final double pi = Math.PI;
	
	public static double calc_pi(double r) 
	{
		return (pi * r) * r;
	}
	public static double calc_area(double l, double w) 
	{
		return l * w;
	}
	public static double calc_vol(double l, double w, double h) 
	{
		return l * w * h;
	}

}
