package org.usfirst.frc.team5003.robot.commands;

import org.usfirst.frc.team5003.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ConfigurableAutonomousCommand extends Command {

	String configuration;
	
    public ConfigurableAutonomousCommand() {
    	this("default string");

    }
    public ConfigurableAutonomousCommand(String configuration){
    	this.configuration = configuration;
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.log("Running autonomous mode with " + configuration);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
