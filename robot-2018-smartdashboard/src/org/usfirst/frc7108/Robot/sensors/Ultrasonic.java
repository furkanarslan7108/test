package org.usfirst.frc7108.Robot.sensors;

import org.usfirst.frc7108.Robot.Robot;

public class Ultrasonic {
	
	
	public Ultrasonic() {
		
		
		 
	}
	public void ultrasonic1() 
    {
    	
    	double averageVolts = Robot.UAna.getAverageVoltage();
		double AV = averageVolts*1000;
		Robot.sonAV = (int) (AV/4.9);
		
		System.out.println(Robot.sonAV);
		
    }
	
	public void ultrasonic2() 
    {
    	
    	double averageVolts = Robot.UAna2.getAverageVoltage();
		double AV = averageVolts*1000;
		Robot.sonAV2 = (int) (AV/4.9);
		
		System.out.println(Robot.sonAV2);
		
    }
}
