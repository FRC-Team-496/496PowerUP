package org.usfirst.frc.team496.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PDP extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    PowerDistributionPanel pdp = new PowerDistributionPanel();

    public PDP() {
      pdp = new PowerDistributionPanel();

    }
    
    public void log() {
      SmartDashboard.putData(pdp);
    }
}

