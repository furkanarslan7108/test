package org.usfirst.frc7108.Robot.commands;

import org.usfirst.frc7108.Robot.Robot;
//import org.usfirst.frc7108.Robot.subsystems.Sase;
//import org.usfirst.frc7108.Robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class soldanBasla extends CommandGroup{
	public soldanBasla(){
		requires(Robot.sase);
		// this.addSequential(new AutonomusDrive(350));
		// this.addSequential(new AutonomousDelay(0.5));
		this.addSequential(new AutonomousTurnPID(-180));
		// this.addSequential(new AutonomousDelay(0.5));
		// this.addSequential(new AutonomusDrive(200));
		
	
		
	}
}

