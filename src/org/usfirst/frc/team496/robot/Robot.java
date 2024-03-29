/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team496.robot;

import org.usfirst.frc.team496.robot.commands.CenterStationLeftSwitch;
import org.usfirst.frc.team496.robot.commands.LeftOrRightAutoLineOnly;
import org.usfirst.frc.team496.robot.commands.LeftStationLeftScale;
import org.usfirst.frc.team496.robot.commands.LeftStationLeftSwitch;
import org.usfirst.frc.team496.robot.commands.LeftStationRightSwitch;
import org.usfirst.frc.team496.robot.subsystems.Arm;
import org.usfirst.frc.team496.robot.subsystems.DriveTrain;
import org.usfirst.frc.team496.robot.subsystems.Elevator;
import org.usfirst.frc.team496.robot.subsystems.Gripper;
import org.usfirst.frc.team496.robot.subsystems.Hook;
import org.usfirst.frc.team496.robot.subsystems.PDP;
import org.usfirst.frc.team496.robot.subsystems.Winch;
import org.usfirst.frc.team496.robot.subsystems.Stage1;
import org.usfirst.frc.team496.robot.subsystems.Stage2;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	

	public static DriveTrain driveTrain;
	public static Gripper gripper;
	//public static Elevator elevator;
	public static Hook hook;
	public static Winch winch;
	public static Arm arm;
	public static OI m_oi;
	//public static PDP pdp;
	public static Stage1 stage1;
	public static Stage2 stage2;


	
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	SendableChooser<String> driverStationPosition = new SendableChooser<>();
	SendableChooser<Boolean> crossTheAutoLine = new SendableChooser<>();
	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		
	    
		driveTrain = new DriveTrain();
		//elevator = new Elevator();
		stage1 = new Stage1();
		stage2 = new Stage2();
		gripper = new Gripper();
		winch = new Winch();
		hook = new Hook();
		arm = new Arm();
		//pdp = new PDP();

		CameraServer.getInstance().startAutomaticCapture();

		//OI MUST BE INSTANTIATED AFTER ALL SUBSYSTEMS OR IT WILL THROW A NULL SUBSYSTEM ERROR
		m_oi = new OI();
	

		driverStationPosition.addObject("Left Station", "Left Station");
		driverStationPosition.addObject("Center Station", "Center Station");
		driverStationPosition.addObject("Right Station", "Right Station");
		crossTheAutoLine.addObject("False", false);
		crossTheAutoLine.addObject("True", true);
        SmartDashboard.putData("Station Position", driverStationPosition);
        SmartDashboard.putData("Cross The Auto Line Only", crossTheAutoLine);
        
        
        
        //SmartDashboard.putData("POT", Robot.arm.getPot());
		

	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */

	
		
	
		public void leftStart(String gameData)
		{
			
			if(crossTheAutoLine.getSelected() == true)
			{
				Command x = new LeftOrRightAutoLineOnly();
				x.start();
			}
			
			else if(gameData.charAt(0) == 'L'&& gameData.charAt(1) == 'R')
			{
				Command x = new LeftStationLeftSwitch();
				x.start();
			}
			else if(gameData.charAt(0) == 'R' && gameData.charAt(1) == 'R')
			{
			  System.out.println("Left Station RightSwitch");

				 Command x = new LeftStationRightSwitch();
				 x.start();
			}
			else if(gameData.charAt(0) == 'R' && gameData.charAt(1) == 'L')
			{
				Command x = new LeftStationLeftScale();
				x.start();
			}
		}

	
	
		public void	centerStart(String gameData)
		{
			
			if(gameData.charAt(0) == 'L')
			{
				Command x = new CenterStationLeftSwitch();
				x.start();
			}
		}
		
		public void rightStart(String gameData)
		{
			if(crossTheAutoLine.getSelected() == true)
			{
				Command x = new LeftOrRightAutoLineOnly();
				x.start();
			}
		}
	
	@Override
		
		public void autonomousInit() {
		 Robot.driveTrain.resetGyro();
	
		String StationPosition = driverStationPosition.getSelected();
		
		Command x = new LeftOrRightAutoLineOnly();
		x.start();
		
/*		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		System.out.println(gameData);
		if(StationPosition.equals("Left Station"))
		{
			leftStart(gameData);
		} 
		else if(StationPosition.equals("Center Station"))
		{
			centerStart(gameData);
		}
		else
		{
			rightStart(gameData);
		}
		
		
		
		
		SmartDashboard.putData("AHRS", driveTrain.getGyro());*/
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		log();
	
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		//if (m_autonomousCommand != null) {
			//m_autonomousCommand.cancel();
		//}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
	

	    
		Scheduler.getInstance().run();
		log();
	      //System.out.println(Robot.elevator.getStage2Enc().get());
        // SmartDashboard.putData(Robot.arm.getPot());
        //System.out.println(Robot.arm.getPot().get);
      SmartDashboard.putBoolean("UnderControl", Robot.driveTrain.getUnderControl());
     
	
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	
	public void log() {
	  //pdp.log();
	  arm.log();
	  stage1.log();
	  stage2.log();
	}
}
