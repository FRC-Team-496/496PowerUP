package org.usfirst.frc.team496.robot.subsystems;

import org.usfirst.frc.team496.robot.Robot;
import org.usfirst.frc.team496.robot.RobotMap;
import org.usfirst.frc.team496.robot.commands.LiftWithJoystick;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Stage1 extends PIDSubsystem {

	Victor stage1;
	Encoder stage1Encoder;
	private static final double STAGE1_DISTANCE_PER_PULSE = 0.00432; // TODO Determine Distance Per
    // Initialize your subsystem here
    public Stage1() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("Stage1", 0.6, 0, 0.0);
    	stage1 = new Victor(RobotMap.stage1);
    	stage1Encoder = new Encoder(RobotMap.stage1EncoderA,
    	        RobotMap.stage1EncoderB, false, Encoder.EncodingType.k4X);
        stage1Encoder.setDistancePerPulse(STAGE1_DISTANCE_PER_PULSE);
        stage1Encoder.reset();
        setAbsoluteTolerance(1);
        getPIDController().setOutputRange(-1, 1);
        getPIDController().setContinuous(false);
        LiveWindow.add(getPIDController());
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new LiftWithJoystick());
    }
    public void set(double speed) {
        stage1.set(speed);
      }
    
    public void setSetpoint(double setPoint) {
    	getPIDController().setSetpoint(setPoint);
    }
    public void stop() {
    	stage1.set(0);
    }
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return stage1Encoder.getDistance();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	//output = output * 0.5;
    	stage1.pidWrite(output);
    }
    
    public double get() {
    	return stage1Encoder.getDistance();
    }
    
    public void log() {
    	SmartDashboard.putData("Stage1Encoder", stage1Encoder);
    }
}
