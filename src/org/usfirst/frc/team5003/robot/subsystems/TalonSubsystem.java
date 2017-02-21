package org.usfirst.frc.team5003.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TalonSubsystem extends Subsystem {

	private Talon talon;
	public Boolean isGood = false;

    public TalonSubsystem(){
    	isGood = false;
    	try{
    		talon = new Talon(4);
    		talon.stopMotor();
    	}
    	catch (Exception ex){
    		talon = null;
    	}
    	if (talon != null)
    		isGood = true;
    }
    
    public void initDefaultCommand() {
    }
    
    public void set(double speed){
    	talon.set(speed);
    }
    
    public void stop(){
    	talon.stopMotor();
    }

}

