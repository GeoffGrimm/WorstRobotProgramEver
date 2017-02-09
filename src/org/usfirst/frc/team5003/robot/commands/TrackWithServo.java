package org.usfirst.frc.team5003.robot.commands;

import org.usfirst.frc.team5003.robot.Robot;

// keep the servo pointing in a fixed direction relative to the gound, no matter how the robot turns
// the angle of the servo relative to the robot and the angle of the gyro should add up to the initial bearing
// if the robot turns right 10 degrees, then the servo must turn left 10 degrees to compensate
// aG = current gyro angle
// aG0 = initial gyro angle
// aS = current servo angle
// as0 = initial servo angle
// aG - aG0 = -(aS - aS0)
// aS = aG0 + aS0 - aG


import edu.wpi.first.wpilibj.command.Command;

public class TrackWithServo extends Command {

	
	double aG0 = 0,
		   aS0 = 0;
	
    public TrackWithServo() {
        requires(Robot.servo);
        requires(Robot.gyro);
        aG0 = 0;
        aS0 = 0;
    }

    protected void initialize() {
        aG0 = Robot.gyro.getAngle();
        aS0 = Robot.servo.getAngle();
    }

    protected void execute() {
    	double aS = aG0 + aS0 - Robot.gyro.getAngle();
    	if (Math.abs(aS - Robot.servo.getAngle()) > 5)
    		Robot.servo.setAngle(aS);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
