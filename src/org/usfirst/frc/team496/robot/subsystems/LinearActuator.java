package org.usfirst.frc.team496.robot.subsystems;

import org.usfirst.frc.team496.robot.RobotMap;
import org.usfirst.frc.team496.robot.commands.linearActuator;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LinearActuator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Spark linActuator = new Spark(RobotMap.linearActuator);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
      setDefaultCommand(new linearActuator());
    }
    
    public void drive(double speed) {
      linActuator.set(speed);
    }
    
    public void drive(XboxController xbox) {
      drive(xbox.getY(Hand.kRight));
    }
    
    public void stop() {
      drive(0);
    }
}

