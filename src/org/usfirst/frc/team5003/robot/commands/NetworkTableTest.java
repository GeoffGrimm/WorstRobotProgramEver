package org.usfirst.frc.team5003.robot.commands;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class NetworkTableTest extends Command {

    public NetworkTableTest() {
    }

    protected void initialize() {
    	NetworkTable table = NetworkTable.getTable("GeoffTable");
    	table.putString("RobotSez", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date()) );
    	String s = null;
    	table.getString("StationSaid", s);
    	System.out.println(s);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
