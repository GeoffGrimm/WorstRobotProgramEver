package org.usfirst.frc.team5003.robot.commands;

import org.usfirst.frc.team5003.robot.Robot;

import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Command;

public class RelayCommand extends Command {
	
	public Value value = Value.kOff;

    public RelayCommand() {
    	this(Value.kOff);
    }
    
    public RelayCommand(Value value)
    {
    	this.value = value;
    	requires(Robot.relay);
    }
    
    protected void initialize() {
    	Robot.relay.set(value);
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
