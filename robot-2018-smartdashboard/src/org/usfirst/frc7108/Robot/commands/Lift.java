package org.usfirst.frc7108.Robot.commands;

import org.usfirst.frc7108.Robot.Robot;
import org.usfirst.frc7108.Robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;

public class Lift extends Command{

	public Lift() {
		requires(Robot.clifter);
		
	}
	protected void initialize() {
		
	}
	protected void execute() {
		 Robot.clifter.Lifter(Robot.oi.xbox.getRawAxis(5));
	}
	protected boolean isFinished() {
        return false;
    }
	 protected void end() 
	    {
	    	Robot.clifter.Stop();
	    }
	 protected void interrupted() {
	    	end();
	    }
}
