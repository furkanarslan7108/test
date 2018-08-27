package org.usfirst.frc7108.Robot.commands;

import org.usfirst.frc7108.Robot.Robot;
import org.usfirst.frc7108.Robot.commands.*;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousTurn extends Command{
	
	long startTime;
	double seconds = 1;
	double speed;
	public AutonomousTurn(double _speed){
		requires(Robot.sase);
		this.speed = _speed;
	}
	protected void initialize() {
		startTime = System.currentTimeMillis();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.sase.otonomDon(this.speed);//+ verirsen saga - verirsen sola doner
    	
    	
     // may need to call getJoystick() method
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		return (System.currentTimeMillis() - startTime) > (int) (1000d * seconds);
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
