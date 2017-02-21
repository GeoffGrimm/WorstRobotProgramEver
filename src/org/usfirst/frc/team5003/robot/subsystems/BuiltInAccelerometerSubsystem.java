package org.usfirst.frc.team5003.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BuiltInAccelerometerSubsystem extends Subsystem {

    private BuiltInAccelerometer accel;
    public Boolean isGood = false;
    
    public BuiltInAccelerometerSubsystem(){
    	isGood = false;
    	try{
    		accel = new BuiltInAccelerometer(Accelerometer.Range.k4G);   
    		accel.getX();
    	}
    	catch (Exception ex){
    		accel = null;
    	}
    	if (accel != null)
    		isGood = true;
    }
    
    public void initDefaultCommand() {
    }
    
    public double getX(){
    	return accel.getX();
    }
    
    public double getY(){
    	return accel.getY();
    }
    
    public double getZ(){
    	return accel.getZ();
    }
    
    // http://www.digikey.com/en/articles/techzone/2011/may/using-an-accelerometer-for-inclination-sensing
    public double getAngleZ(){
    	double aX = accel.getX(), 
    		   aY = accel.getY(), 
    		   aZ = accel.getZ();
    	double aTot = Math.sqrt(aX*aX + aY*aY + aZ*aZ);
    	double angleZ = (180 * Math.acos(aZ / aTot))/ 3.14159;
    	return angleZ;
    }
}

