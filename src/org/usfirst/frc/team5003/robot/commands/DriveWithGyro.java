package org.usfirst.frc.team5003.robot.commands;

import java.util.Date;

import org.usfirst.frc.team5003.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveWithGyro extends Command {

	Double power;
	Double time;
	Boolean turn;
	long start;
	
	public Boolean isGood = false;

    public DriveWithGyro(double time, double power) {
    	isGood = false;
       	if (!(Robot.drivetrain.isGood) || !(Robot.gyro.isGood)){
       		return;
    	}

    	try {
    		requires(Robot.drivetrain);
    		requires(Robot.gyro);
    	}
    	catch (Exception ex) {
    		return;
    	}
    	
    	this.time = time;
    	this.power = power;
    	isGood = true;
    }

    protected void initialize() {
    	if (!isGood)
     		return;   	

    	Robot.drivetrain.tankDrive(0, 0);
    	Robot.gyro.reset();
    	Date now = new Date();
    	start = now.getTime();
    }

    protected void execute() {
    	if (!isGood)
    		return;
    	// frc java programming 2017 p 133
    	Robot.drivetrain.arcadeDrive(-power, -Robot.gyro.getAngle() / 360);
  		
    }

    protected boolean isFinished() {
    	if (!isGood)
    		return true;
    	
    	Date now = new Date();
    	if ((now.getTime() - start) > time*1000)
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
