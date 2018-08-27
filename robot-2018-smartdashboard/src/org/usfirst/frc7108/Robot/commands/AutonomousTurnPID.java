// Allahim lutfen duzgun calissin
package org.usfirst.frc7108.Robot.commands;

import org.usfirst.frc7108.Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


	public class AutonomousTurnPID extends Command {
		double angle, power;
		double yawAngle = Robot.gyro.getAngle();
		double kP =  0.009;
		double kD = 0.0138;
		double error = angle-yawAngle;
		double error_old = error;
		int true_flag = 0;
		double accuracy = 1;
		
	public AutonomousTurnPID(double _angle) {
		requires(Robot.sase);	
		this.angle = _angle;			
	}
	
	protected void initialize() {
		
	}
	protected void execute() {
		Robot.gyro.updateGyro();
		yawAngle = Robot.gyro.getAngle();
		error = angle - yawAngle; // ERROR_MAX = 180, 90
		if(error < 0)
		{
		power = -0.2 + ((kP*error + (kD*(error-error_old))));
		}
		else {
			power = 0.2 + ((kP*error + (kD*(error-error_old))));			
		}
		if(power > 1) {
			power = 1;
		}
		else if(power < -1) {
			power = -1;
		}
		Robot.sase.otonomDon(-power);
		System.out.print("Measured: ");
		System.out.print(yawAngle);
		System.out.print("Error: ");
		System.out.print(error);
		System.out.print("Power: ");
		System.out.println(power);
		error_old = error;
		if(yawAngle < angle+1 && yawAngle > angle-1) {
			// System.out.println("Kedicik");
			true_flag++;
		}
		else
		{
			true_flag = 0;
		}
	}
	protected boolean isFinished() {
		// System.out.print("True flag: ");
		// System.out.println(true_flag);
		if(true_flag >= 5) {
			return true;
		}
		else {
			return false;
		}
		
	}
	protected void end() {
		Robot.sase.otonomDur();
	}
}
	

	