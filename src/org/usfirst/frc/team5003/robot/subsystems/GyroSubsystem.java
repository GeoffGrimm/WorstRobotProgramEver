package org.usfirst.frc.team5003.robot.subsystems;

import org.usfirst.frc.team5003.robot.Robot;
import org.usfirst.frc.team5003.robot.RobotSettings;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GyroSubsystem extends Subsystem {
	
	private ADXRS450_Gyro gyro;

	public GyroSubsystem()
	{
    	Robot.log("gyro constructor");
    	gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
    	if (gyro == null)
    		Robot.log("*** gyro is null after constructor");
    	else{
    		Robot.log("gyro is not null!");
    		if (!((MotorSafety) gyro).isAlive())
    			Robot.log("*** gyro is not alive");
    		else
    			Robot.log("gyro is alive!");
    	}
		
		
	}

    public void initDefaultCommand() {
    }
    
    public double getAngle(){
    	return gyro.getAngle();
    }
}

