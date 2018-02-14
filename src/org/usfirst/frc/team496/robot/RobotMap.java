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
	public static int leftFrontMotor = 0;
	public static int rightFrontMotor = 1;
	public static int leftRearMotor = 2;
	public static int rightRearMotor = 3;
	
	
	public static int stage1 = 4;
	public static int stage2 = 5;
	
	
	public static int gripper = 6;
	public static int hook = 7;
	public static final int winch = 8;
	public static final int arm = 9;
	
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
	
	//Solenoids
	
	public static int hookSolUp = 0;
	public static int hookSoDown = 1;
  
	
	
	
	
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
