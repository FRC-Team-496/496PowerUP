package org.usfirst.frc.team496.robot.subsystems;

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
public class Stage2 extends PIDSubsystem {

	Victor stage2;
	Encoder stage2Encoder;
	private static final double STAGE2_DISTANCE_PER_PULSE = 0.00432; // TODO Determine Distance Per
    // Initialize your subsystem here
    public Stage2() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("Stage2", 0.6, 0, 0.0);
    	stage2 = new Victor(RobotMap.stage2);
    	stage2Encoder = new Encoder(RobotMap.stage2EncoderA,
    	        RobotMap.stage2EncoderB, false, Encoder.EncodingType.k4X);
        stage2Encoder.setDistancePerPulse(STAGE2_DISTANCE_PER_PULSE);
        stage2Encoder.reset();
        setAbsoluteTolerance(1);
        getPIDController().setOutputRange(-1, 1);
        getPIDController().setContinuous(false);
        LiveWindow.add(getPIDController());
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new LiftWithJoystick());
    }
    public void set(double speed) {
        stage2.set(speed);
      }
    
    public void setSetpoint(double setPoint) {
    	if(!getPIDController().isEnabled()) {
    		getPIDController().enable();
    	}
    	getPIDController().setSetpoint(setPoint);
    }
    public void stop() {
    	stage2.set(0);
    }
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return stage2Encoder.getDistance();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	//output = output * 0.5;
    	stage2.pidWrite(output);
    }
    
    public double get() {
    	return stage2Encoder.getDistance();
    }
    
    public void log() {
    	SmartDashboard.putData("Stage2Encoder", stage2Encoder);
    	SmartDashboard.putNumber("Stage2Encoder Value", stage2Encoder.get());
    }
}
