package org.usfirst.frc.team496.robot.subsystems;

import org.usfirst.frc.team496.robot.Robot;
import org.usfirst.frc.team496.robot.RobotMap;
import org.usfirst.frc.team496.robot.commands.LiftWithJoystick;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

  private static final double STAGE2_DISTANCE_PER_PULSE = 0; // TODO Determine Distance Per Pulse
  private static final double STAGE1_DISTANCE_PER_PULSE = 0.004; // TODO Determine Distance Per
                                                                 // Pulse

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Spark stage1;
  Spark stage2;
  Encoder stage1Encoder, stage2Encoder;



  public Elevator() {
    stage1 = new Spark(RobotMap.stage1);
    stage2 = new Spark(RobotMap.stage2);
    stage1Encoder = new Encoder(RobotMap.stage1EncoderA,
        RobotMap.stage1EncoderB, true, Encoder.EncodingType.k4X);
    stage2Encoder = new Encoder(RobotMap.stage2EncoderA,
        RobotMap.stage2EncoderB, true, Encoder.EncodingType.k4X);
    stage1Encoder.setDistancePerPulse(STAGE1_DISTANCE_PER_PULSE);
    // stage2Encoder.setDistancePerPulse(STAGE2_DISTANCE_PER_PULSE);
  }

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new LiftWithJoystick());
  }

  public void drive(XboxController stick) {
    if (Robot.arm.getPot().get() > 25) {
      stage1.set(0);
      stage2.set(0);
    } else {
      stage1.set(stick.getY(Hand.kRight));
      stage2.set(stick.getY(Hand.kLeft));
    }
  }

  public void stop() {
    stage1.set(0);
    stage2.set(0);
  }

  public Encoder getStage1Enc() {
    return stage1Encoder;
  }

  public Encoder getStage2Enc() {
    return stage2Encoder;
  }

}

