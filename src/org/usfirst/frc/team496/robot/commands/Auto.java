package org.usfirst.frc.team496.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto extends CommandGroup {

    public Auto() {
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
        // e.g. if Command1 requires chases, and Command2 requires arm,
        // a CommandGroup containing them would require both the chases and the
        // arm.
      addSequential(new RotateToAngle(0f));
      addSequential(new DriveTo(10.0,0f));
      //addSequential(new Delay());
      //addSequential(new RotateToAngle(90f));
      //addSequential(new Delay());
      //addSequential(new DriveTo(10, 90f));
      

}
}
