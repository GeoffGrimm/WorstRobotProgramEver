package org.usfirst.frc.team5003.robot.commands;

import java.util.Date;
import java.util.Timer;

import org.usfirst.frc.team5003.robot.Robot;

import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickQuery extends Command {

	long start;
    public JoystickQuery() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.joystick);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	start = new Date().getTime();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.log(String.format("%6.1f %6.1f %6.1f %6d %6s %6s",  
    			Robot.joystick.getAxis(AxisType.kX), 
    			Robot.joystick.getAxis(AxisType.kY),
    			Robot.joystick.getAxis(AxisType.kY),
    			Robot.joystick.getPOV(0),
    			Robot.joystick.getRawButton(1),
    			Robot.joystick.getRawButton(2)));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	long now = new Date().getTime();
    	if (now - start > 10*1000)
    		return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
