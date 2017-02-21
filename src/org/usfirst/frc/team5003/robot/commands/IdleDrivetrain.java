package org.usfirst.frc.team5003.robot.commands;

import org.usfirst.frc.team5003.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IdleDrivetrain extends Command {

    public IdleDrivetrain() {
    	requires(Robot.drivetrain);
    	Robot.drivetrain.tankDrive(0,0);
    }

    protected void initialize() {
    	Robot.drivetrain.tankDrive(0,0);
    }

    // default command for drivetrain subsystem, keeps watchdog timer happy
    protected void execute() {
    	Robot.drivetrain.tankDrive(0,0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
