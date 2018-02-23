package org.usfirst.frc.team496.robot.commands;

import org.usfirst.frc.team496.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class driveWithXbox extends Command {

  double m_lastAngle;
  boolean m_trackAngle;

  public driveWithXbox() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  protected void initialize() {
    m_trackAngle = false;
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {

  
    double y = Robot.m_oi.getJoystick().getY(Hand.kRight);
    double x = Robot.m_oi.getJoystick().getX(Hand.kRight);
    double rot = Robot.m_oi.getJoystick().getX(Hand.kLeft);

    double a1 = 1; // between 0 and 1
    y = (a1 * Math.pow(y, 3) + (1 - a1) * y) / 2;
    // y = Math.pow(y, 3);
    x = (a1 * Math.pow(x, 3) + (1 - a1) * x);
    double gyroAngle = Robot.driveTrain.getGyro().getAngle();
    if (Math.abs(rot) < 0.1) {
      rot = 0;
    }

    if (rot == 0 && Robot.driveTrain.getUnderControl()) {
      // User does not want rotation, If this just happened, note current angle
      if (!m_trackAngle) {
        m_trackAngle = true;
        m_lastAngle = gyroAngle;
      }

      // by here we are sure m_trackAngle is true and m_lastAngle
      // is our target angle, either just set above or on some previous
      // pass.

      // programatically inject rotation if
      // there is error. Use P part of PID only
      double errVal = m_lastAngle - gyroAngle;
      double P = 0.1;

      rot = P * errVal; // proportional rotation injected to counter error
    } else {
      // User is applying rotation, stop tracking angle
      m_trackAngle = false;
    }
    Robot.driveTrain.drive(y, x, -rot * 0.4);
  }



  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return false; // returns false because it will drive until interrupted by another command
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
