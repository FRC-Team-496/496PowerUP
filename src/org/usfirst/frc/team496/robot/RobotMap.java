/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team496.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// Speed Controller PWM Ports
	public final static int leftFrontMotor = 0;
	public final static int rightFrontMotor = 1;
	public final static int leftRearMotor = 2;
	public final static int rightRearMotor = 3;

	public final static int stage1 = 4;
	public final static int stage2 = 5;

	public final static int gripper = 6;
	public final static int hook = 7;
	public final static int winch = 8;
	public final static int arm = 9;

	// DIO PINS
	public final static int leftSideEncoderA = 0;
	public final static int leftSideEncoderB = 1;
	public final static int rightSideEncoderA = 2;
	public final static int rightSideEncoderB = 3;
	public final static int stage1EncoderA = 4;
	public final static int stage1EncoderB = 5;
	public final static int stage2EncoderA = 6;
	public final static int stage2EncoderB = 7;
	public final static int gripperClosed = 8;
	public final static int gripperOpen = 9;

	// Solenoids

	public final static int hookSolUp = 0;
	public final static int hookSoDown = 1;

	// Elevator Lift Constants
	public final static int STAGE1_MAX_HEIGHT = 48; //TODO determine max travel 
	public final static int STAGE2_MAX_HEIGHT = 48; //TODO determine max travel 
	
	public final static int SCALE_HEIGHT = 0; //TODO
	public final static int SWITCH_HEIGHT = 0; //TODO

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
