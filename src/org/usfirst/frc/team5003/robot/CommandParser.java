package org.usfirst.frc.team5003.robot;
import java.util.ArrayList;
import java.util.Objects;

import org.usfirst.frc.team5003.robot.commands.DriveWithGyro;
import org.usfirst.frc.team5003.robot.commands.SimpleDriveCommand;
import org.usfirst.frc.team5003.robot.commands.TurnWithGyro;

import edu.wpi.first.wpilibj.command.Command;

public class CommandParser {
	
	public ArrayList<Command> commands = new ArrayList<Command>();
	public String debug = "";

	public Boolean init(String s){
		s = s.toLowerCase();
		String[] fields = s.split(",");
		double power = 0.5;
		for (int i = 0; i < fields.length; i++)
		{
			String field = fields[i].trim();
			String commandText = field.substring(0,1);
			String valueText = field.substring(1, field.length());
					
			double value = 0;
			try{
				value = Double.parseDouble(valueText);
			}
			catch (Exception ex){
				debug += String.format("%s from %s is not a double\r\n",  valueText, field);
			}
			
			if (commandText.equals("p")){
				if (Math.abs(value) > 1)
					debug += String.format("%s from %s is not between -1.0 and 1.0\r\n",  valueText, field);
				else
					power = value;
			}
			else if (commandText.equals("d")){
				if (value < 0 || value > 10)
					debug += String.format("%s from %s is less than 0 or greater than 10\r\n",  valueText, field);
				else{
					SimpleDriveCommand c = new SimpleDriveCommand(value, power, false);
					if (!c.isGood)
						debug += String.format("SimpleDriveCommand is not good\r\n");
					else
						commands.add(c);
				}
			}
			else if (commandText.equals("b")){
				if (value < 0 || value > 10)
					debug += String.format("%s from %s is less than 0 or greater than 10\r\n",  valueText, field);
				else{
					DriveWithGyro c = new DriveWithGyro(value, power);
					if (!c.isGood)
						debug += String.format("DriveStraightWithGyro is not good\r\n");
					else
						commands.add(c);
				}
			}
			
			else if (commandText.equals("t")){
				if (value < 0 || value > 10)
					debug += String.format("%s from %s is less than 0 or greater than 10\r\n",  valueText, field);
				else{
					SimpleDriveCommand c = new SimpleDriveCommand(value, power, true);
					if (!c.isGood)
						debug += String.format("SimpleDriveCommand is not good\r\n");
					else
						commands.add(c);
				}
			}
			else if (commandText.equals("g")){
				if (Math.abs(value) > 180)
					debug += String.format("%s from %s is not between -180 and 180\r\n",  valueText, field);
				else{
					TurnWithGyro c = new TurnWithGyro(value, power);
					if (!c.isGood)
						debug += String.format("SimpleTurnWithGyro is not good\r\n");
					else
						commands.add(c);
				}
			}

			else{
				debug += String.format("%s from %s is not s,d,b,t,g\r\n",  commandText, field);
			}
			
		}
		if (debug.length() > 0){
			commands.clear();
			return false;
		}
		return true;

	}
}
