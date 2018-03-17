package org.usfirst.frc.team496.robot.commands;

import org.usfirst.frc.team496.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetArmSetpoint extends Command {
    private double m_setPoint;
    public SetArmSetpoint(double setpoint) {
      m_setPoint = setpoint;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
      requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
      Robot.arm.enable();
      Robot.arm.setSetpoint(m_setPoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
      
      return Robot.arm.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
      Robot.arm.disable();
      Robot.arm.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
      end();
    }
}
