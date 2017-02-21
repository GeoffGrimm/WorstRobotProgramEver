package org.usfirst.frc.team5003.robot.commands;

import java.util.Date;

import org.usfirst.frc.team5003.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SimpleDriveCommand extends Command {
	Double power;
	Double time;
	Boolean turn;
	long start;
	
	public Boolean isGood = false;

    public SimpleDriveCommand(double time, double power, Boolean turn) {
    	isGood = false;
       	if (!(Robot.drivetrain.isGood)){
       		return;
    	}

    	try {
    		requires(Robot.drivetrain);
    	}
    	catch (Exception ex) {
    		return;
    	}
    	
    	this.time = time;
    	this.power = power;
    	this.turn = turn;
    	isGood = true;
    }

    protected void initialize() {
    	if (!isGood)
     		return;   	

    	Robot.drivetrain.tankDrive(0, 0);
    	Date now = new Date();
    	start = now.getTime();
    }

    protected void execute() {
    	if (!isGood)
    		return;
    	if (turn)
    		Robot.drivetrain.tankDrive(power, -power);
    	else
    		Robot.drivetrain.tankDrive(power, power);
  		
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
