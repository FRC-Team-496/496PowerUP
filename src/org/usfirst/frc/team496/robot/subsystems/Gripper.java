package org.usfirst.frc.team496.robot.subsystems;

import org.usfirst.frc.team496.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Spark gripper;
    DigitalInput limitSwitch;
    public Gripper() {
      gripper = new Spark(RobotMap.gripper);
      limitSwitch = new DigitalInput(RobotMap.gripperClosed);
      
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set(double speed) {
      gripper.set(speed);
    }
    
    public boolean isClosed() {
      return limitSwitch.get();
    }
    
    public void stop() {
      gripper.set(0);
    }
    
    
}

