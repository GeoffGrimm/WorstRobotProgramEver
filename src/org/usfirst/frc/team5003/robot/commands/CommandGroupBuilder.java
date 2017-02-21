package org.usfirst.frc.team5003.robot.commands;

import java.util.Date;

import org.usfirst.frc.team5003.robot.CommandParser;
import org.usfirst.frc.team5003.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CommandGroupBuilder extends Command {

    public CommandGroupBuilder() {

    }

    protected void initialize() {
    	CommandParser p = new CommandParser();
    	if (!p.init(SmartDashboard.getString("CommandString", "")))
    	{
    		Robot.log(p.debug);
    		return;
    	}
    	
    	CommandGroup g = new CommandGroup();
    	for (int i = 0; i < p.commands.size(); i++)
    		g.addSequential(p.commands.get(i));
    	g.start();
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
