package org.usfirst.frc.team5003.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LimitSwitchWithCounterSubsystem extends Subsystem {

	private DigitalInput limitSwitch;
	private Counter counter;
	
	public LimitSwitchWithCounterSubsystem(){
		limitSwitch = new DigitalInput(1);
		counter = new Counter(limitSwitch);
	}

    public void initDefaultCommand() {
    }
    
    public void initialize()
    {
    	System.out.println("counter init");
    	counter.reset();
    	//counter.clearDownSource();
    	//counter.clearUpSource();
    }
    
    public int getCount()
    {
    	//System.out.println("counter get");
    	return counter.get();
    }
    
    
}

