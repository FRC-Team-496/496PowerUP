package org.usfirst.frc.team496.robot.commands;

import org.usfirst.frc.team496.robot.FieldConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightStationRightSwitch extends CommandGroup {

    public RightStationRightSwitch() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
//    	Lol
    	
    	System.out.println("Right Station Right Switch");
    	addSequential(new DriveTo(FieldConstants.lengthToSwitch, 0f));
        addSequential(new RotateToAngle(-90f));
        addSequential(new DriveTo(FieldConstants.toSwitchAfterTurn, -90f));
    }
}