package org.usfirst.frc.team496.robot.subsystems;

import org.usfirst.frc.team496.robot.RobotMap;
import org.usfirst.frc.team496.robot.commands.driveWithXbox;
import org.usfirst.frc.team496.util.DummyPIDOutput;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {

  private int ahrsOnTargetCounter = 0;
  private static final int MINIMUM_AHRS_ON_TARGET_ITERATIONS = 4;
  private boolean underControl = false;

  private static final double ABS_TOLERANCE_ROTATETO = 1;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Talon m_frontLeft = new Talon(RobotMap.leftFrontMotor);
  private Talon m_rearLeft = new Talon(RobotMap.leftRearMotor);
  private Talon m_frontRight = new Talon(RobotMap.rightFrontMotor);
  private Talon m_rearRight = new Talon(RobotMap.rightRearMotor);
  private MecanumDrive driveTrain =
      new MecanumDrive(m_frontLeft, m_rearLeft, m_frontRight, m_rearRight);



  AHRS ahrs;


  Encoder enc1 = new Encoder(RobotMap.leftSideEncoderA, RobotMap.leftSideEncoderB, true, Encoder.EncodingType.k4X);

  double wheel = 6.5;
  double wheel1Ticks = 1082; // our measure was 328
  double circumfrence = Math.PI * wheel;
  double ticks = circumfrence / wheel1Ticks;



  boolean changed;
  static final double kP = 0.1;
  static final double kI = 0.0;
  static final double kD = 0.1;
  static final double kF = 0.00;
  /* This tuning parameter indicates how close to "on target" the */
  /* PID Controller will attempt to get. */


  static final double kToleranceDegrees = 1.0f;

  PIDController turnController;
  DummyPIDOutput dummyOutput = new DummyPIDOutput(); // for rotate to

  private static double ABS_TOLERANCE_DRIVETO_DISTANCE = 1;

  DummyPIDOutput dummy2 = new DummyPIDOutput();
  PIDController driveTo;

  public DriveTrain() {
    super();
    try {
      ahrs = new AHRS(SPI.Port.kMXP); // instantiating imu (gyro)
    } catch (Exception e) {
      System.out.println(e);
    }

    turnController = new PIDController(kP, kI, kD, kF, ahrs, dummyOutput);

    turnController.setAbsoluteTolerance(ABS_TOLERANCE_ROTATETO);
    turnController.setOutputRange(-.5, .5);
    turnController.setInputRange(-180f, 180f);
    turnController.setContinuous(true);
    //SmartDashboard.putData("Turn Controller", turnController);

    enc1.setDistancePerPulse(ticks);
    enc1.reset();
    driveTo = new PIDController(1, 0, 0, enc1, dummy2);
    
    SmartDashboard.putBoolean("UnderControl", underControl);
  }

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new driveWithXbox());
  }

  public void drive(double y, double x, double rot) {
    driveTrain.driveCartesian(y, x, rot);

  }

  
  public void stop() {
    driveTrain.driveCartesian(0, 0, 0);
  }



  public boolean rotToAngle(float angle) {
    turnController.setSetpoint(angle);

    if (ahrs == null) {
      throw new IllegalStateException("can't rotateTo when ahrs is null");
    }
    if (!turnController.isEnabled()) {
      turnController.enable();
    }

    System.out
        .println("Remaining: " + turnController.get() + "  Degrees Turned: "
            + ahrs.getYaw() + " On target: " + turnController.onTarget());

    if (Math.abs(turnController.getError()) < ABS_TOLERANCE_ROTATETO) {
      ahrsOnTargetCounter++;
    } else {
      ahrsOnTargetCounter = 0;
    }

    if (ahrsOnTargetCounter >= MINIMUM_AHRS_ON_TARGET_ITERATIONS) {



      stop();
      driveTrain.driveCartesian(0, 0, 0);
      // turnController.disable();
      return true;
    }

    driveTrain.driveCartesian(0, 0, dummyOutput.get() * -1);
    // Timer.delay(0.005); // wait for a motor update time

    return false;
  }

  public boolean driveTo(double inches, float angle) {

    if (!driveTo.isEnabled()) {

      driveTo.enable();
    }
    if (!turnController.isEnabled()) {
      turnController.enable();
    }
    driveTo.setOutputRange(-1.0, 1.0);
    driveTo.setSetpoint(inches);

    turnController.setSetpoint(angle);

    System.out.println("Remaining: " + driveTo.getError() + " Travelled: "
        + enc1.getDistance()+ " yaw:"  + ahrs.getYaw() );

    if (Math.abs(driveTo.getError()) < ABS_TOLERANCE_DRIVETO_DISTANCE) {
      driveTo.disable();
      stop();
      return true;
    }
    driveTrain.driveCartesian(dummy2.get() * -0.5, 0, dummyOutput.get() * -0.5);
    return false;
  }

  public AHRS getGyro() {
    return ahrs;
  }

  public void resetGyro() {
    ahrs.reset();
    System.out.println("RESET GYRO");
  }

  public void resetEnc1() {
    enc1.reset();
  }
  
  public boolean getUnderControl() {
    return underControl;
  }
  
  public void setUnderControl() {
    underControl = !underControl;
  }


} // EOC
