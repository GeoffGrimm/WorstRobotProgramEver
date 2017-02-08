package org.usfirst.frc.team5003.robot.commands;

import org.usfirst.frc.team5003.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class RunTalonWithJoystick extends Command {

    public RunTalonWithJoystick() {
        requires(Robot.talon);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.talon.set(-Robot.joystick.getX());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
