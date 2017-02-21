
package org.usfirst.frc.team5003.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5003.robot.commands.*;
import org.usfirst.frc.team5003.robot.subsystems.*;

import edu.wpi.first.wpilibj.Joystick;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


public class Robot extends IterativeRobot {

	public static BuiltInAccelerometerSubsystem accel;
	public static GyroSubsystem gyro;
	public static RelaySubsystem relay;
	public static ServoSubsystem servo;
	public static TalonSubsystem talon;
	
	public static DrivetrainSubsystem drivetrain;
	public static LimitSwitchWithCounterSubsystem limitSwitchWithCounter;
	
	public static Joystick joystick;
	
	
	SendableChooser<Object> objectChooser;
	SendableChooser<String> stringChooser;
	
	//CameraServer.getInstance().startAutomaticCapture();
	//UsbCamera usbCamera = new UsbCamera("USB Camera 0", 0);
	public static OI oi;

	Command autonomousCommand;

	@Override
	public void robotInit() {	
		
		accel = new BuiltInAccelerometerSubsystem();
		//gyro = new GyroSubsystem();
		servo = new ServoSubsystem();
		relay = new RelaySubsystem();
		talon = new TalonSubsystem();
		limitSwitchWithCounter =  new LimitSwitchWithCounterSubsystem();
		drivetrain = new DrivetrainSubsystem();
	
		joystick = new Joystick(0);
		
		/*try
		{
			UsbCamera usbCamera = CameraServer.getInstance().startAutomaticCapture();
			usbCamera.setFPS(15);
			usbCamera.setResolution(320,240);
			SmartDashboard.putString("CameraStatus", "seems ok");
		}
		catch (Exception ex)
		{
			SmartDashboard.putString("CameraStatus", "*** bad ***");
		}*/
		
		oi = new OI();
		
	
		objectChooser = new SendableChooser<>();
		objectChooser.addDefault("number",  7);
		objectChooser.addDefault("string", "sting as object");
		objectChooser.addDefault("command", new ConfigurableTalkativeCommand("Center"));
		
		stringChooser = new SendableChooser<String>();
		stringChooser.addDefault("none", "none");
		stringChooser.addObject("Left",  "Left");
		stringChooser.addObject("Straight",  "Straight");
		stringChooser.addObject("Right",  "Right");
		SmartDashboard.putData("AutonoumosChoo0ser", stringChooser);
		
		//SmartDashboard.putData("Object Chooser", objectChooser);
		
		//SmartDashboard.putNumber("NumberPicker", 1.00);
		
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//autonomousCommand = chooser.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
		
		Object obj = objectChooser.getSelected();
		if (obj instanceof String)
		{
			System.out.println("You picked a string");
		}
		else if (obj instanceof Integer)
		{
			System.out.println("you picked an int");
		}
		else if (obj instanceof Command)
		{
			System.out.println("That was a command");
		}
		
		double val = SmartDashboard.getNumber("NumberPicker", 0);
		
		String mode = stringChooser.getSelected().toLowerCase();
		if (mode.equals("right")){
		}
		System.out.println(val);
		
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//Robot.drivetrain.tankDrive(0, 0);
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	public static void log(String s){
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date()) + ":" + s);
    }

}
