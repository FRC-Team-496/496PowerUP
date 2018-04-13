package org.usfirst.frc.team496.robot.subsystems;


import org.usfirst.frc.team496.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team496.robot.commands.SetArmSetpoint;

/**
 *
 */
public class Arm extends PIDSubsystem {

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Victor arm;
  AnalogPotentiometer pot;
  // AnalogInput pot;


  public Arm() {
    super("Arm", 0.1, 0, 0.0);
    arm = new Victor(RobotMap.arm);
    pot = new AnalogPotentiometer(0,3600,-1950);
    setAbsoluteTolerance(1);
    getPIDController().setOutputRange(-1, 1);
    getPIDController().setContinuous(false);
    SmartDashboard.putData("Arm Pot", pot);
    LiveWindow.add(getPIDController());

  }

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
	//setDefaultCommand(new SetArmSetpoint(-40));
  }

  public void set(double speed) {
    arm.set(speed);
  }

  public void log() {
    SmartDashboard.putData("arm pot", pot); 
    SmartDashboard.putNumber("pot angle",pot.get());
    
  }
  public void stop() {
    arm.set(0);
  }

  public AnalogPotentiometer getPot() {
    return pot;
  }

  @Override
  protected double returnPIDInput() {
    // TODO Auto-generated method stub
    return pot.get();
  }

  @Override
  protected void usePIDOutput(double output) {
    output = output * 0.5;
    arm.pidWrite(output);

  }
}

