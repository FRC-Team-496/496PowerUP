package org.usfirst.frc.team496.robot.commands;

import org.usfirst.frc.team496.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTo extends Command {

  private double inches;
  private boolean finished;

  public DriveTo(double inches) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveTrain);
    this.inches = inches;
  }


  // Called just before this Command runs the first time
  protected void initialize() {
    Robot.driveTrain.resetEnc1();
    Robot.driveTrain.resetGyro();
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    finished = Robot.driveTrain.driveTo(inches);
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return finished;
  }

  // Called once after isFinished returns true
  protected void end() {
    Robot.driveTrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    end();
  }
}
