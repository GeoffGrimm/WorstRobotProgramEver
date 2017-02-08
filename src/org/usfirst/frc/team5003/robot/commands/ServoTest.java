package org.usfirst.frc.team5003.robot.commands;

import org.usfirst.frc.team5003.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ServoTest extends Command {
	
	double delta;

    public ServoTest() {
    	this(0);
    }
    public ServoTest(double delta)
    {
    	requires(Robot.servo);
    	this.delta = delta;
    }

    protected void initialize() {
    	Robot.servo.tweak(delta);
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
