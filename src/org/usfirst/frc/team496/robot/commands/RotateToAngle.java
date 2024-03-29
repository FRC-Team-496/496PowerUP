package org.usfirst.frc.team496.robot.commands;

import org.usfirst.frc.team496.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class RotateToAngle extends Command{

  private float angle;
  private boolean finished;

  /**
   * @param angle declare a float here e.g. 1.0f
   */
  public RotateToAngle(float angle) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveTrain);
    this.angle = angle;
    
  }

  // Called just before this Command runs the first time
  protected void initialize() {
    //Robot.driveTrain.resetGyro();
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    finished = Robot.driveTrain.rotToAngle(angle);
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    // TODO enter return statment that calculates when robot is close enough to setPoint;
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
