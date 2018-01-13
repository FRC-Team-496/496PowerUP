package org.usfirst.frc.team496.robot.subsystems;

import org.usfirst.frc.team496.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Talon m_frontLeft = new Talon(RobotMap.leftFrontMotor);
	private Talon m_rearLeft = new Talon(RobotMap.leftRearMotor);
	private Talon m_frontRight = new Talon(RobotMap.rightFrontMotor);
	private Talon m_rearRight = new Talon(RobotMap.rightRearMotor);
	private MecanumDrive driveTrain = new MecanumDrive(m_frontLeft, m_rearLeft, m_frontRight, m_rearRight);
	
	public DriveTrain() {
		super();
	}
	
	public void drive(double x, double y, double rot) {
		driveTrain.driveCartesian(x, y, rot);
	}
	
	public void stop() {
		driveTrain.driveCartesian(0, 0, 0);
	}
		
			

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

