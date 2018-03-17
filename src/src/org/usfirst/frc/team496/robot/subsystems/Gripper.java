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
    DigitalInput limitSwitchClosed, limitSwitchOpen;
    public Gripper() {
      gripper = new Spark(RobotMap.gripper);
      limitSwitchClosed = new DigitalInput(RobotMap.gripperClosed);
      limitSwitchOpen = new DigitalInput(RobotMap.gripperOpen);
      
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set(double speed) {
      gripper.set(speed);
    }
    
    public boolean isClosed() {
      return limitSwitchClosed.get();
    }
    
    public boolean isOpen() {
      return limitSwitchOpen.get();
    }
    
    public void stop() {
      gripper.set(0);
    }
    
    
}

