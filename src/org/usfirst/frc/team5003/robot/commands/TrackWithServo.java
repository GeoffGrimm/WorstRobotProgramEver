package org.usfirst.frc.team5003.robot.commands;

import org.usfirst.frc.team5003.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TrackWithServo extends Command {

	double servoRelativeBearing = 0;
	
    public TrackWithServo() {
        requires(Robot.servo);
        requires(Robot.gyro);
        servoRelativeBearing = 0;
    }

    protected void initialize() {
        servoRelativeBearing = Robot.servo.getAngle() - Robot.gyro.getAngle();
    }

    protected void execute() {
    	Robot.servo.setAngle(servoRelativeBearing - Robot.gyro.getAngle());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
