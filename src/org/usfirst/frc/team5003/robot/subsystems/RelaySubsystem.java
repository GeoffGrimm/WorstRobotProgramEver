package org.usfirst.frc.team5003.robot.subsystems;

import org.usfirst.frc.team5003.robot.Robot;
import org.usfirst.frc.team5003.robot.RobotSettings;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RelaySubsystem extends Subsystem {

	public Relay relay;

    public RelaySubsystem(){
    	Robot.log("Relay constructor");
    	relay = new Relay(RobotSettings.LED_LIGHTS_RELAY, Direction.kBoth);
    	if (relay == null)
    		Robot.log("*** Relay is null after constructor");
    	else{
    		Robot.log("Relay is not null!");
    		if (!relay.isAlive())
    			Robot.log("*** Relay is not alive");
    		else
    			Robot.log("Relay is alive!");
    	}
    }

    public void initDefaultCommand() {
    }
    
    public void set(Value value)
    {
		relay.set(value);
    }
}

