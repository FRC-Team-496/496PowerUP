package org.usfirst.frc.team496.robot.commands;

import org.usfirst.frc.team496.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftWithJoystick extends Command {

	private double m_setpoint1;
	private double m_setpoint2;
    public LiftWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.stage1);
    	//requires(Robot.stage2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	m_setpoint1 = Robot.stage1.get();
    	if(!Robot.stage1.getPIDController().isEnabled()) Robot.stage1.getPIDController().enable();
    	//m_setpoint2 = Robot.stage2.get();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    if(Robot.m_oi.getOpStick().getStickButton(Hand.kLeft)){
    	m_setpoint1 += -Robot.m_oi.getOpStick().getY(Hand.kLeft);
    	
    	if(m_setpoint1 <= 0) {
    		m_setpoint1 = 0;
    	} 
    	if(m_setpoint1 >= 46) {
    		m_setpoint1 = 46;
    	}
    }
    	
    	Robot.stage1.setSetpoint(m_setpoint1);
    
    
   /* if(Robot.m_oi.getOpStick().getStickButton(Hand.kRight)){
    	m_setpoint2 += -Robot.m_oi.getOpStick().getY(Hand.kRight);
    	
    	if(m_setpoint2 <= 0) {
    		m_setpoint2 = 0;
    	} 
    	if(m_setpoint2 >= 46) {
    		m_setpoint2 = 46;
    	}
    }
    	
    	Robot.stage2.setSetpoint(m_setpoint2);*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
