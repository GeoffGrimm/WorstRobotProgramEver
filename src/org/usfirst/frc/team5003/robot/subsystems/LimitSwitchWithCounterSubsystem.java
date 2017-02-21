package org.usfirst.frc.team5003.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LimitSwitchWithCounterSubsystem extends Subsystem {

	private DigitalInput limitSwitch;
	private Counter counter;
	public Boolean isGood = false;
	
	public LimitSwitchWithCounterSubsystem(){
		isGood = false;
		try{
			limitSwitch = new DigitalInput(5);
			counter = new Counter(limitSwitch);
			limitSwitch.get();
			counter.get();
		}
		catch (Exception ex){
			limitSwitch = null;
			counter = null;
		}
		if (limitSwitch != null && counter != null)
			isGood = true;
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

