
package org.usfirst.frc.team5003.robot;

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


public class Robot extends IterativeRobot {

	public static BuiltInAccelerometerSubsystem accel;
	public static GyroSubsystem gyro;
	public static RelaySubsystem relay;
	public static ServoSubsystem servo;
	public static TalonSubsystem talon;
	
	//public static DrivetrainSubsystem drivetrain;
	public static LimitSwitchWithCounterSubsystem limitSwitchWithCounter;
	
	public static Joystick joystick;
	
	SendableChooser<Command> chooser;
	
	
	//CameraServer.getInstance().startAutomaticCapture();
	//UsbCamera usbCamera = new UsbCamera("USB Camera 0", 0);
	public static OI oi;

	Command autonomousCommand;

	@Override
	public void robotInit() {	
		accel = null;
		try
		{
			accel = new BuiltInAccelerometerSubsystem();
			SmartDashboard.putString("Accel", "ok");
		}
		catch (Exception ex)
		{
			SmartDashboard.putString("Accel", "*** bad ***");
		}
		
		gyro = null;
		try
		{
			gyro = new GyroSubsystem();
			SmartDashboard.putString("Gyro", "ok");
		}
		catch (Exception ex)
		{
			SmartDashboard.putString("Gyro", "*** bad ***");
		}

		relay = null;
		try
		{
			relay = new RelaySubsystem();
			if (relay.relay == null)
			{
			    log("relay.relay is null, dammit");
				SmartDashboard.putString("Relay", "null as hell");
			}
			else
			{
				log("relay is OK!!");
				SmartDashboard.putString("Relay", "ok");
			}
		}
		catch (Exception ex)
		{
			SmartDashboard.putString("Relay", "*** bad ***");
		}

		servo = null;
		try
		{
			servo = new ServoSubsystem();
			SmartDashboard.putString("Servo", "ok");
		}
		catch (Exception ex)
		{
			SmartDashboard.putString("Servo", "*** bad ***");
		}

		talon = null;
		try
		{
			talon = new TalonSubsystem();
			SmartDashboard.putString("Talon", "ok");
		}
		catch (Exception ex)
		{
			SmartDashboard.putString("talon", "*** bad ***");
		}
		
		//drivetrain = null;
		try
		{
			//drivetrain = new DrivetrainSubsystem();
			SmartDashboard.putString("Drivetrain", "ok");
		}
		catch (Exception ex)
		{
			SmartDashboard.putString("Drivetrain", "*** bad ***");
		}
		
		limitSwitchWithCounter = null;
		try
		{
			limitSwitchWithCounter = new LimitSwitchWithCounterSubsystem();
			SmartDashboard.putString("LimitSwitchWithCounter", "ok");
		}
		catch (Exception ex)
		{
			SmartDashboard.putString("LimitSwitchWithCounter", "*** bad ***");
		}
		
		joystick = null;
		try
		{
			joystick = new Joystick(0);
			SmartDashboard.putString("Joystick", "ok");
		}
		catch (Exception ex)
		{
			SmartDashboard.putString("Joystick", "*** bad ***");
		}
		
		try
		{
			CameraServer.getInstance().startAutomaticCapture();
			SmartDashboard.putString("Camera", "ok");
		}
		catch (Exception ex)
		{
			SmartDashboard.putString("Camera", "*** bad ***");
		}
		
		oi = new OI();
		
		SendableChooser<Command> chooser = new SendableChooser<>();
		chooser.addDefault("Center", new ConfigurableAutonomousCommand("Center"));
		chooser.addDefault("Left", new ConfigurableAutonomousCommand("Left"));
		chooser.addDefault("Right", new ConfigurableAutonomousCommand("Right"));
		
		SmartDashboard.putData("Auto mode", chooser);
		
		//CameraServer.getInstance().startAutomaticCapture();
		//CameraServer server = CameraServer.getInstance();
		//allSeeingEye = server.startAutomaticCapture();
		//allSeeingEye.setFPS(15);
		//allSeeingEye.setResolution(320, 240);
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
		if (autonomousCommand != null)
			autonomousCommand.start();
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
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	public static void log(String s){
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date()) + ":" + s);
    }

}
