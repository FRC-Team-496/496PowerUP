package org.usfirst.frc.team496.robot.subsystems;

import org.usfirst.frc.team496.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Hook extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Spark hook;
    Compressor c;
    DoubleSolenoid hookSolenoid;
    
    public Hook() {
      hook = new Spark(RobotMap.hook);
      c = new Compressor(0);
      hookSolenoid = new DoubleSolenoid(RobotMap.hookSolUp, RobotMap.hookSoDown);
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
    
    public void deployHook() {
      hookSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void retractHook() {
      hookSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
}

