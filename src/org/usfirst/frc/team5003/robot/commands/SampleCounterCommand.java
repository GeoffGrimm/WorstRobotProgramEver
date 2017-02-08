package org.usfirst.frc.team5003.robot.commands;

import org.usfirst.frc.team5003.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SampleCounterCommand extends Command {

	int lastCount;
	
    public SampleCounterCommand() {
        requires(Robot.limitSwitchWithCounter);
        lastCount = 0;
    }

    protected void initialize() {
    	Robot.limitSwitchWithCounter.initialize();
    	lastCount = 0;
    }

    protected void execute() {
    	int currentCount = Robot.limitSwitchWithCounter.getCount();
    	if (currentCount != lastCount)
    	{
    		lastCount = currentCount;
    		System.out.println(currentCount);
    		System.out.println("click");
    	}
    	
    }

    protected boolean isFinished() {
    	int currentCount = Robot.limitSwitchWithCounter.getCount();
        if (currentCount > 100)
        {
        	System.out.println("done");
        	return true;
        }
        	
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
