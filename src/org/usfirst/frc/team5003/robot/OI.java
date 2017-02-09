package org.usfirst.frc.team5003.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5003.robot.commands.*;

import edu.wpi.first.wpilibj.Relay.Value;

public class OI {
	
	//Button btn = new JoystickButton(joystick, 2);  //xbox button B (maybe??)
	
	public OI() {
			
		SmartDashboard.putData("TalkativeCommand", new TalkativeCommand());
		SmartDashboard.putData("Network Table Test", new NetworkTableTest());

		if (Robot.accel != null)
			SmartDashboard.putData("AccelQuery", new BuiltInAccelerometerQuery());
		
		if (Robot.gyro != null)
			SmartDashboard.putData("GyroQuery", new GyroQuery());
		
		if (Robot.relay != null){
			SmartDashboard.putData("Relay Forward", new RelayCommand(Value.kForward));
			SmartDashboard.putData("Relay Reverse", new RelayCommand(Value.kReverse));
			SmartDashboard.putData("Relay On", new RelayCommand(Value.kOn));
			SmartDashboard.putData("Relay Off", new RelayCommand(Value.kOff));
		}
		
		if (Robot.servo != null){
			SmartDashboard.putData("Servo +10", new ServoTest(10));
			SmartDashboard.putData("Servo -10", new ServoTest(-10));
			SmartDashboard.putData("Servo +1", new ServoTest(1));
			SmartDashboard.putData("Servo -1", new ServoTest(-1));
			if (Robot.gyro != null)
				SmartDashboard.putData("Track", new TrackWithServo());
		}
		
		if (Robot.talon != null && Robot.joystick != null)
			//SmartDashboard.putData("TalonWithJoystick", new RunTalonWithJoystick());

		//if (Robot.drivetrain != null && Robot.joystick != null)
			//SmartDashboard.putData("Drive", new DriveWithJoystickCommand());
		
		if (Robot.limitSwitchWithCounter != null)
			SmartDashboard.putData("Clicker", new SampleCounterCommand());
		
	}
	
}
