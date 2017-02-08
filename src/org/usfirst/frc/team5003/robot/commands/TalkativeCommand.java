package org.usfirst.frc.team5003.robot.commands;

import java.util.Date;

import org.usfirst.frc.team5003.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TalkativeCommand extends Command {
	protected Date start;
	protected Date lastExecute;
	protected Date lastIsFinished;
	protected Boolean done = false;

    public TalkativeCommand() {
    	Robot.log("TalkativeCommand");
    }

    protected void initialize() {
    	done = false;
    	start = new Date();
    	lastExecute = new Date(0);
    	lastIsFinished = new Date(0);
    	Robot.log("initialize");
    }

    protected void execute() {
    	Date now = new Date();
    	long delta = now.getTime() - lastExecute.getTime();
    	if (delta > 500)
    	{
    		lastExecute = now;
    		Robot.log("execute");
    	}
 
    	delta = now.getTime() - start.getTime();

    	if (delta > 5000)
    		done = true;
    }

    protected boolean isFinished() {
    	Date now = new Date();
    	long delta = now.getTime() - lastIsFinished.getTime();
    	if (delta > 500)
    	{
    		lastIsFinished = now;
       		Robot.log("isFinished: " + done.toString());
    	}
        return done;
    }

    protected void end() {
    	Robot.log("end");
    }

    protected void interrupted() {
    	Robot.log("interrupted OMG");
    }

}
