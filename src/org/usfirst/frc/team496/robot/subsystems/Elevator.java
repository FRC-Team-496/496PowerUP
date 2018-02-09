package org.usfirst.frc.team496.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team496.robot.RobotMap;
import org.usfirst.frc.team496.robot.commands.LiftWithJoystick;

/**
 *
 */
public class Elevator extends Subsystem {

    private static final double STAGE2_DISTANCE_PER_PULSE = 0; //TODO Determine Distance Per Pulse
	private static final double STAGE1_DISTANCE_PER_PULSE = 0; //TODO Determine Distance Per Pulse
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	Spark stage1 = new Spark(RobotMap.stage1);
	Spark stage2 = new Spark(RobotMap.stage2);
	
	Encoder stage1Encoder = new Encoder(RobotMap.stage1EncoderA, RobotMap.stage1EncoderB, false, Encoder.EncodingType.k4X);
	Encoder stage2Encoder = new Encoder(RobotMap.stage2EncoderA, RobotMap.stage2EncoderB, false, Encoder.EncodingType.k4X);
	
	
	
	public Elevator() {
		stage1Encoder.setDistancePerPulse(STAGE1_DISTANCE_PER_PULSE);
		stage2Encoder.setDistancePerPulse(STAGE2_DISTANCE_PER_PULSE);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new LiftWithJoystick());
    }
    
    public void stop() {
    	stage1.set(0);
    	stage2.set(0);
    }
    
   
}

