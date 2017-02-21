package org.usfirst.frc.team5003.robot.subsystems;

import org.usfirst.frc.team5003.robot.RobotSettings;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RelaySubsystem extends Subsystem {

	private Relay relay;
	public Boolean isGood = false;

    public RelaySubsystem(){
    	isGood = false;
    	try{
    		relay = new Relay(RobotSettings.LED_LIGHTS_RELAY, Direction.kBoth);
    		relay.get();
    	}
    	catch (Exception ex){
    		relay = null;
    	}
    	if (relay != null)
    		isGood = true;
    }

    public void initDefaultCommand() {
    }
    
    public void set(Value value)
    {
		relay.set(value);
    }
}

