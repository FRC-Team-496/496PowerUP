package org.usfirst.frc.team496.robot.subsystems;

import org.usfirst.frc.team496.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Hook extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Spark hook;
    
    public Hook() {
      hook = new Spark(RobotMap.hook);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set(double speed) {
      hook.set(speed);
    }

    public void stop() {
      
      hook.set(0);
      
    }
}

