
package org.usfirst.frc7108.Robot.subsystems;

import org.usfirst.frc7108.Robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatic extends Subsystem{
	public Pneumatic() {
		
	}
	public void Off() {
		RobotMap.db.set(Value.kOff);
	}
	public void Forward() {
		RobotMap.db.set(Value.kForward);
	}
	public void Reverse() {
		RobotMap.db.set(Value.kReverse);
	}
	public void initDefaultCommand() {
		
	}
}
	
