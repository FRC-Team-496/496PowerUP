package org.usfirst.frc.team496.robot.subsystems;

import org.usfirst.frc.team496.robot.RobotMap;
import org.usfirst.frc.team496.robot.commands.driveWithXbox;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 *
 */
public class DriveTrain extends Subsystem implements PIDOutput {


  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Talon m_frontLeft = new Talon(RobotMap.leftFrontMotor);
  private Talon m_rearLeft = new Talon(RobotMap.leftRearMotor);
  private Talon m_frontRight = new Talon(RobotMap.rightFrontMotor);
  private Talon m_rearRight = new Talon(RobotMap.rightRearMotor);
  private MecanumDrive driveTrain =
      new MecanumDrive(m_frontLeft, m_rearLeft, m_frontRight, m_rearRight);


  AHRS ahrs = new AHRS(SPI.Port.kMXP); // instantiating imu (gyro)

  double rotateToAngleRate = 0.0f;
  double currentRotationRate;
  boolean changed;
  static final double kP = 0.03;
  static final double kI = 0.00;
  static final double kD = 0.00;
  static final double kF = 0.00;
  /* This tuning parameter indicates how close to "on target" the */
  /* PID Controller will attempt to get. */


  static final double kToleranceDegrees = 1.0f;
  PIDController turnController = new PIDController(kP, kI, kD, kF, ahrs, this);

  public DriveTrain() {
    super();
  }

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new driveWithXbox());
  }

  public void drive(double y, double x, double rot) {
    driveTrain.driveCartesian(y, x, rot);

  }

  public void drive(XboxController xbox) {
    drive(xbox.getY(Hand.kRight), xbox.getX(Hand.kRight),
        xbox.getX(Hand.kLeft));
  }

  public void stop() {
    driveTrain.driveCartesian(0, 0, 0);
  }

  public void rotToAngle(double angle) {
    ahrs.reset();
    turnController.enable();
    currentRotationRate = rotateToAngleRate;

    driveTrain.driveCartesian(0, 0, currentRotationRate, ahrs.getAngle());
  }

  @Override
  public void pidWrite(double output) {

    rotateToAngleRate = output;

  }

} // EOC
