package org.usfirst.frc.team5003.robot.subsystems;

import org.usfirst.frc.team5003.robot.commands.IdleDrivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivetrainSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Talon driveLeft;
	Talon driveRight;
	RobotDrive drive;
	public Boolean isGood;
	
	public DrivetrainSubsystem(){
		isGood = false;
		try{
			driveLeft = new Talon(0);
			driveLeft.stopMotor();
			driveRight = new Talon(1);
			driveRight.stopMotor();
			drive = new RobotDrive(driveLeft, driveRight);
			drive.tankDrive(0.0,  0.0);
			drive.setSafetyEnabled(false);
		}
		catch (Exception ex){
			driveLeft = null;
			driveRight = null;
			drive = null;
		}
		if (driveLeft != null && driveRight != null && drive != null)
			isGood = true;
	}

	public void arcadeDrive(Joystick stick)
	{
		//robotDrive.arcadeDrive(stick);
		//double moveValue = -stick.getRawAxis(RobotSettings.MOVE_VAL_AXIS);// * moveFactor * driveDirection.getFactor();
		//double rotateValue = -stick.getRawAxis(RobotSettings.ROTATE_VAL_AXIS);// * rotateFactor * driveDirection.getFactor();
		//robotDrive.arcadeDrive(moveValue, rotateValue);

	}
	
	public void tankDrive(double left, double right){
		drive.tankDrive(left, right);
	}
	
	public void arcadeDrive(double move, double rotate){
		drive.arcadeDrive(move, rotate);
	}
    public void initDefaultCommand() {
    	//https://www.chiefdelphi.com/forums/showthread.php?t=153673
    	// 
    	setDefaultCommand(new IdleDrivetrain());
    }
}

