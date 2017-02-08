package org.usfirst.frc.team5003.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TalonSubsystem extends Subsystem {

	private Talon talon;

    public TalonSubsystem(){
    	talon = new Talon(4);
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

