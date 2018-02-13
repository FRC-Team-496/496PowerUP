/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team496.robot;

import org.usfirst.frc.team496.robot.commands.CloseGripper;
import org.usfirst.frc.team496.robot.commands.CloseGripperAuto;
import org.usfirst.frc.team496.robot.commands.LowerHook;
import org.usfirst.frc.team496.robot.commands.OpenGripper;
import org.usfirst.frc.team496.robot.commands.RaiseHook;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	
	private XboxController xbox = new XboxController(0);
	private XboxController op = new XboxController(1);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public OI() {
		JoystickButton leftBumper = new JoystickButton(op,5);
		leftBumper.whileHeld(new OpenGripper());
		JoystickButton rightBumper = new JoystickButton(op,6);
		rightBumper.whileHeld(new CloseGripper());
		
		JoystickButton leftBumperX = new JoystickButton(xbox, 5);
		leftBumperX.whileHeld(new RaiseHook());
		JoystickButton rightBumperX = new JoystickButton(xbox, 6);
		rightBumperX.whileHeld(new LowerHook());
		
		JoystickButton a = new JoystickButton(op, 1);
		a.whenPressed(new CloseGripperAuto());
		
	}
	
	public XboxController getJoystick() {
		return xbox;
	}
	
	public XboxController getOpStick() {
	  return op;
	  
	}
}
