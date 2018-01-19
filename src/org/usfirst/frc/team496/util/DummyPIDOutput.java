package org.usfirst.frc.team496.util;

import edu.wpi.first.wpilibj.SpeedController;

public class DummyPIDOutput implements SpeedController{
 
  /**
   * Creating a fake speed controller based on code by Marty Kauas team 2485
   */

  private double output;
  
  @Override
  public double get() {
    return output;
  }
  
  public void set(double speed, byte syncGroup) {
    set(speed);
    
  }

  @Override
  public void pidWrite(double output) {
this.output = output;    
  }

  @Override
  public void set(double speed) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setInverted(boolean isInverted) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean getInverted() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void disable() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void stopMotor() {
    // TODO Auto-generated method stub
    
  }
}
