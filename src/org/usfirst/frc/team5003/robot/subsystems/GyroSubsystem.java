package org.usfirst.frc.team5003.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GyroSubsystem extends Subsystem {

	private ADXRS450_Gyro gyro;
	public Boolean isGood = false;
	
	public GyroSubsystem(){
		isGood = false;
		try{
			gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
			gyro.calibrate();
		}
		catch (Exception ex) {
			gyro = null;
		}
		if (gyro != null)
			isGood = true;
	}


    public void initDefaultCommand() {
    }
    
    public double getAngle(){
    	return gyro.getAngle();
    }
    
    public void reset(){
    	gyro.reset();
    }
}

