package org.usfirst.frc.team5003.robot.subsystems;

import org.usfirst.frc.team5003.robot.RobotSettings;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivetrainSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Spark driveLeft0 = new Spark(RobotSettings.DRIVE_LEFT_PWM_0);
	Victor driveLeft1 = new Victor(RobotSettings.DRIVE_LEFT_PWM_1);
	Spark driveRight0 = new Spark(RobotSettings.DRIVE_RIGHT_PWM_0);
	Victor driveRight1 = new Victor(RobotSettings.DRIVE_RIGHT_PWM_1);
			
	RobotDrive robotDrive = new RobotDrive(driveLeft0, driveLeft1, driveRight0, driveRight1);

	public void arcadeDrive(Joystick stick)
	{
		//robotDrive.arcadeDrive(stick);
		//double moveValue = -stick.getRawAxis(RobotSettings.MOVE_VAL_AXIS);// * moveFactor * driveDirection.getFactor();
		//double rotateValue = -stick.getRawAxis(RobotSettings.ROTATE_VAL_AXIS);// * rotateFactor * driveDirection.getFactor();
		//robotDrive.arcadeDrive(moveValue, rotateValue);

	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

