package org.usfirst.frc.team5003.robot.commands;

import org.usfirst.frc.team5003.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GyroQuery extends Command {

    public GyroQuery() {
        requires(Robot.gyro);
    }

    protected void initialize() {
    	Robot.log("Gyro says " + Double.toString(Robot.gyro.getAngle()));
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
