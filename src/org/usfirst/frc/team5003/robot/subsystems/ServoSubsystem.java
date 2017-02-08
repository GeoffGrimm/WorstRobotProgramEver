package org.usfirst.frc.team5003.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ServoSubsystem extends Subsystem {
	
	private Servo servo;

	public ServoSubsystem(){
		servo = new Servo(9);
	}

    public void initDefaultCommand() {
    }
    
    public void set(double value){
    	servo.set(value);
    }
    
    public double get(){
    	return servo.get();
    }
    
    public void setAngle(double degrees){
    	servo.setAngle(degrees);
    }
    
    public double getAngle(){
    	return servo.getAngle();
    }
    
    public void tweak(double delta){
    	servo.setAngle(servo.getAngle() + delta);
    }
}

