package org.usfirst.frc.team5003.robot.commands;

import java.util.Date;

import org.usfirst.frc.team5003.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BuiltInAccelerometerQuery extends Command {

	protected long start;
	protected long lastMessage;
	protected Boolean done;

    public BuiltInAccelerometerQuery() {
        requires(Robot.accel);
    }

    protected void initialize() {
    	start = new Date().getTime();
    	lastMessage = new Date(0).getTime();
    	done = false;
    }

    protected void execute() {
    	long now = new Date().getTime();
    	if (now - lastMessage > 200)
    	{
    		lastMessage = now;
    		double aX = Robot.accel.getX(), 
    			   aY = Robot.accel.getY(), 
    			   aZ = Robot.accel.getZ(),
    			   angleZ = Robot.accel.getAngleZ();
    		String msg = String.format("%10.6f %10.6f %10.6f %10.6f", aX, aY, aZ, angleZ);
    		
    		System.out.println(msg);
    		SmartDashboard.putString("Accel:", msg);
    	}
    	if (now - start > 30000)
    		done = true;
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
