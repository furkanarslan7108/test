package org.usfirst.frc7108.Robot.commands;

import org.usfirst.frc7108.Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Reverse extends Command{
	public Reverse() {
		requires(Robot.pnomatik);
	}
	protected void initialize() {
	
	}
	protected void execute() {
		 Robot.pnomatik.Reverse();
	}
	protected boolean isFinished() {
        return false;
    }
	 protected void end() 
	    {
	    	Robot.pnomatik.Off();
	    }
	 protected void interrupted() {
	    	end();
	    }


	}


