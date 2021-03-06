// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc7108.Robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.interfaces.Gyro;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc7108.Robot.commands.AutoMode;
import org.usfirst.frc7108.Robot.commands.Autonomous;
import org.usfirst.frc7108.Robot.commands.AutonomusDrive;
import org.usfirst.frc7108.Robot.commands.soldanBasla;
import org.usfirst.frc7108.Robot.sensors.Ultrasonic;
import org.usfirst.frc7108.Robot.sensors.mpuGyro;
//import org.usfirst.frc7108.Robot.commands.*;
//import org.usfirst.frc7108.Robot.commands.AutonomusDrive;
import org.usfirst.frc7108.Robot.subsystems.*;
import org.usfirst.frc7108.Robot.subsystems.KutuAlma;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {
	
	Autonomous autoCG;
	SendableChooser autoChooser;
    //Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();
    DigitalInput limitswitch = new DigitalInput(0);
    
    Counter counter = new Counter(limitswitch);
    
    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Sase sase;
    public static KutuAlma kutualma;
    public static CLifter clifter;
    public static Timer timer;
    public static AnalogInput UAna;
    public static AnalogInput UAna2;
    public static int sonAV;
    public static BuiltInAccelerometer accel;
    public static Pneumatic pnomatik;
	public static double xDeger;
	public static double yDeger;
	public static double zDeger;
	public static mpuGyro gyro;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static int sonAV2;
	public static Ultrasonic ultrasonic;
	public static NetworkTable table;
	public static double x,y;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        sase = new Sase();
        kutualma = new KutuAlma();
        clifter = new CLifter();
        timer = new Timer();
        UAna = new AnalogInput(0);
        UAna2 = new AnalogInput(1);
        accel = new BuiltInAccelerometer();
        gyro = new mpuGyro();
        pnomatik = new Pneumatic();
        ultrasonic = new Ultrasonic();
	    // accel = new BuiltInAccelerometer(Accelerometer.Range.k4G);
        CameraServer.getInstance().startAutomaticCapture();
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        table = NetworkTable.getTable("datatable");
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();
        autoCG = new Autonomous();

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

       

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        SmartDashboard.putData("Auto mode", chooser);
        RobotMap.compresor.setClosedLoopControl(true);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
		Scheduler.getInstance().removeAll();
		autoCG.addSequential(new soldanBasla());
		autoCG.start();
		/*switch ((AutoMode)autoChooser.getSelected()) {
		
		case CENTER_SCALE:
			
			break;
		case RIGHT:
			
			break;
		case LEFT:
			
			break;
		case RIGHT_NO_SCALE:
			
			break;
		case RIGHT_NO_SWITCH:
			
			break;
		case LEFT_NO_SCALE:
			
			break;
		case LEFT_NO_SWITCH:
			
		default: // Center Switch
			
		
		*/}
		

/*    	
        autonomousCommand = chooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
*/
    	
    
    	

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        // ultrasonic.ultrasonic1();
        // ultrasonic.ultrasonic2();
        
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
       // if (auto.zeroGyro();
    	gyro.zeroGyro();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        ultrasonic.ultrasonic1();
        ultrasonic.ultrasonic2();
        xDeger= accel.getX();
        yDeger= accel.getY();
        zDeger= accel.getZ();
		//System.out.println(yDeger);
	    gyro.updateGyro();
        double yawAngle = gyro.getAngle();
	    System.out.println(yawAngle);
        table.putNumber("X",x);
        x += 1;
        y = table.getNumber("Y", 0.0);
        System.out.println(y);
        
           
       //System.out.println("calisiyor");
        
       //RobotMap.saseRobotDrive41.arcadeDrive(oi.xbox);
       //RobotMap.saseRobotDrive41.arcadeDrive(oi.xbox.getY(), -oi.xbox.getX());
    
    /*    
    System.out.println(counter.get());
    counter.reset();
    */
        if(counter.get()!=0) {
        	System.out.println("limit switch basiliyor");
        	counter.reset();
        }
        //System.out.println("Joystickten okunan veri");
        //System.out.println(oi.xbox.getRawAxis(5));
    }
    
    
 
    	
    
    }


