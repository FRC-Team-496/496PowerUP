package org.usfirst.frc.team496.robot.subsystems;

import org.usfirst.frc.team496.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Arm extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
  Victor arm;
  Potentiometer pot;
 
   public Arm() {
     arm = new Victor(RobotMap.arm);
     pot = new AnalogPotentiometer(0, 360, 30);
   }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

