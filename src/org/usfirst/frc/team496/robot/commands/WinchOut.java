package org.usfirst.frc.team496.robot.commands;

import org.usfirst.frc.team496.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WinchOut extends Command {

    public WinchOut() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
      requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
      Robot.driveTrain.drive(0, 0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      Robot.winch.set(-1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
      Robot.winch.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
      end();
    }
}
