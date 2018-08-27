package org.usfirst.frc7108.Robot.subsystems;

import org.usfirst.frc7108.Robot.RobotMap;
import org.usfirst.frc7108.Robot.commands.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import org.usfirst.frc7108.Robot.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CLifter extends Subsystem  {
	private final WPI_TalonSRX lifterMotor1 = RobotMap.lifterMotor1;
	private final WPI_TalonSRX lifterMotor2 = RobotMap.lifterMotor2;


public void initDefaultCommand() {
	
	 setDefaultCommand(new Lift());
}

public void Lifter(double speed) {
	 lifterMotor1.set(speed);
	 lifterMotor2.set(speed);
	
}
public void Stop() {
	lifterMotor1.set(0);
	lifterMotor2.set(0);
}

}