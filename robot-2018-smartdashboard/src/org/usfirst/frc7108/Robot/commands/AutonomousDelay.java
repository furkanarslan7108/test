package org.usfirst.frc7108.Robot.commands;

import org.usfirst.frc7108.Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousDelay extends Command{
	long startTime;
	double seconds;
	public AutonomousDelay(double _seconds){
		this.seconds = _seconds;		
		requires(Robot.sase);
	}
	protected void initialize() {
		startTime = System.currentTimeMillis();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.sase.otonomDur();
    	
    	
     // may need to call getJoystick() method
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		return (System.currentTimeMillis() - startTime) > (int) (1000d * this.seconds);
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.sase.otonomDur();

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }



	


}
