/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team496.robot;

import org.usfirst.frc.team496.robot.commands.Auto;
import org.usfirst.frc.team496.robot.commands.DriveTo;
import org.usfirst.frc.team496.robot.commands.LeftStationLeftSwitch;
import org.usfirst.frc.team496.robot.subsystems.DriveTrain;
import org.usfirst.frc.team496.robot.subsystems.ExampleSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
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
	public static final ExampleSubsystem kExampleSubsystem = new ExampleSubsystem();
	public static OI m_oi;

	public static DriveTrain driveTrain;

	
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	SendableChooser<String> driverStationPosition = new SendableChooser<>();
	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();

		driveTrain = new DriveTrain();

		m_chooser.addDefault("Default Auto", new Auto());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		SmartDashboard.putData("drive 20 inches", new DriveTo(10));
		SmartDashboard.putData("Station Position", driverStationPosition);
		driverStationPosition.addObject("Left Station", "Left Station");
		driverStationPosition.addObject("Center Station", "Center Station");
		driverStationPosition.addObject("Right Station", "Right Station");
		
		
		
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
			if(gameData.charAt(0) == 'L')
			{
				Command x = new LeftStationLeftSwitch();
				x.start();
			}
		}
	
		public void	centerStart(String gameData)
		{
			
		}
		
		public void rightStart(String gameData)
		{
			
		}
	
	@Override
		
		public void autonomousInit() {
		String StationPosition = driverStationPosition.getSelected();
		
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
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
		
		
		
		SmartDashboard.putData("AHRS", driveTrain.getGyro());
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	
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
	
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
