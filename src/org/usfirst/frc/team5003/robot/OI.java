package org.usfirst.frc.team5003.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5003.robot.commands.*;

import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.InternalButton;

public class OI {
	
	//Button btn = new JoystickButton(joystick, 2);  //xbox button B (maybe??)
	
	public OI() {
			
		SmartDashboard.putData("ConfigurableTalkativeCommand", new ConfigurableTalkativeCommand("Button"));
		
		SmartDashboard.putData("SimpleDrive", new SimpleDriveCommand(2.0, 0.5, false));
		
		SmartDashboard.putString("CommandString", "P0.1,D1.0");
		SmartDashboard.putData("CommandGroupBuilderButton", new CommandGroupBuilder());
		
		SmartDashboard.putData("Joystick", new JoystickQuery());
		
		/*
		SmartDashboard.putString("CommandString", "P0.1,D2.0");
		InternalButton commandGroupButton = new InternalButton();
		commandGroupButton.whenPressed(new StringBasedCommandGroup());
		SmartDashboard.putData("CommandGroupInternalButton", commandGroupButton);
		*/
		

		/*
		SmartDashboard.putData("Network Table Test", new NetworkTableTest());

		if (Robot.accel.isGood)
			SmartDashboard.putData("AccelQuery", new BuiltInAccelerometerQuery());
		
		if (Robot.gyro.isGood)
			SmartDashboard.putData("GyroQuery", new GyroQuery());
		
		if (Robot.relay.isGood){
			SmartDashboard.putData("Relay Forward", new RelayCommand(Value.kForward));
			SmartDashboard.putData("Relay Reverse", new RelayCommand(Value.kReverse));
			SmartDashboard.putData("Relay On", new RelayCommand(Value.kOn));
			SmartDashboard.putData("Relay Off", new RelayCommand(Value.kOff));
		}
		
		if (Robot.servo.isGood){
			SmartDashboard.putData("Servo +10", new ServoTest(90));
			SmartDashboard.putData("Servo -10", new ServoTest(-90));
			SmartDashboard.putData("Servo +1", new ServoTest(1));
			SmartDashboard.putData("Servo -1", new ServoTest(-1));
			if (Robot.gyro != null)
				SmartDashboard.putData("Track", new TrackWithServo());
		}
		
		if (Robot.limitSwitchWithCounter.isGood)
			SmartDashboard.putData("Clicker", new SampleCounterCommand());
		*/
		

		

		//SmartDashboard.putData("RunString", new StringBasedCommandGroup());
		
		/*
		if (Robot.talon != null && Robot.joystick != null)
			//SmartDashboard.putData("TalonWithJoystick", new RunTalonWithJoystick());

		//if (Robot.drivetrain != null && Robot.joystick != null)
			//SmartDashboard.putData("Drive", new DriveWithJoystickCommand());

			*/
		
	}
	
}
