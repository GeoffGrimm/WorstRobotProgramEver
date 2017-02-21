package org.usfirst.frc.team5003.robot.commands;

import org.usfirst.frc.team5003.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnWithGyro extends Command {
	
	double turnAngle = 0;
	double power = 0;
	double desiredAngle = 0;
	
	public Boolean isGood = false;

    public TurnWithGyro(Double turnAngle, Double power) {
    	isGood = false;
    	if (!(Robot.gyro.isGood && Robot.drivetrain.isGood)){
    		return;
    	}

    	try {
    		requires(Robot.gyro);
    		requires(Robot.drivetrain);
    	}
    	catch (Exception ex){
    		return;
    	}
    	
    	this.turnAngle = turnAngle;
    	this.power = power;
    	isGood = true;
    }

    protected void initialize() {
    	if (!isGood)
    		return;
    	
    	desiredAngle = Robot.gyro.getAngle() + turnAngle;
    }

    protected void execute() {
    	if (!isGood)
    		return;
    	
    	double delta = desiredAngle - Robot.gyro.getAngle();
    	
		// tweak speed based on difference from target
		double scaledPower = power;
		
		// if overshot, rotate in other direction
		// sign might be wrong here
		if (delta < 0)
			scaledPower *= -1;
		
		// start turning
		Robot.drivetrain.tankDrive(scaledPower, -scaledPower);
    }

    protected boolean isFinished() {
    	if (!isGood)
    		return true;
    	
    	if (Math.abs(desiredAngle - Robot.gyro.getAngle()) < 2)
    		return true;
    	
    	return false;
    }

    protected void end() {
    	if (!isGood)
    		return;
    	Robot.drivetrain.tankDrive(0,0);
   }

    protected void interrupted() {
    	if (!isGood)
    		return;
    }
}
