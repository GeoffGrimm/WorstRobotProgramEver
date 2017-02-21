package org.usfirst.frc.team5003.robot.commands;

import java.util.Date;

import org.usfirst.frc.team5003.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ConfigurableTalkativeCommand extends Command {

	String configuration;
	long start;
	long lastMessage;
	
    public ConfigurableTalkativeCommand() {
    	this("default string");

    }
    public ConfigurableTalkativeCommand(String configuration){
    	this.configuration = configuration;
    	Robot.log(String.format("%s ctor", configuration));
    }

    protected void initialize() {
    	Robot.log(String.format("%s init", configuration));
    	start = new Date().getTime();
    	lastMessage = start;
    }

    protected void execute() {
    	long now = new Date().getTime();
    	if (now - lastMessage > 1000)
    	{
    		Robot.log(String.format("%s execute", configuration));
    		lastMessage = now;
    	}
    }

    protected boolean isFinished() {
    	long now = new Date().getTime();
    	if (now - start > 5000){
    		Robot.log(String.format("%s isFinished", configuration));
    		return true;
    	}
        return false;
    }

    protected void end() {
    	Robot.log(String.format("%s end", configuration));
    }

    protected void interrupted() {
    	Robot.log(String.format("%s interrupted", configuration));
    }
}
