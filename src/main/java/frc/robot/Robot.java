// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  // Drive motors(falcons) FIXME Change if needed
  public static final WPI_TalonFX frontLeftDriveMotor = new WPI_TalonFX(Constants.FRONT_LEFT_MODULE_DRIVE_MOTOR, "rio");
  public static final WPI_TalonFX frontRightDriveMotor = new WPI_TalonFX(Constants.FRONT_RIGHT_MODULE_DRIVE_MOTOR, "rio");
  public static final WPI_TalonFX backLeftDriveMotor = new WPI_TalonFX(Constants.BACK_LEFT_MODULE_DRIVE_MOTOR, "rio");
  public static final WPI_TalonFX backRightDriveMotor = new WPI_TalonFX(Constants.BACK_RIGHT_MODULE_DRIVE_MOTOR, "rio");

  // Steer motors(neo) FIXME Change if needed
  public static final CANSparkMax frontLeftSteerMotor = new CANSparkMax(Constants.FRONT_LEFT_MODULE_STEER_MOTOR,MotorType.kBrushless);
  public static final CANSparkMax backLeftSteerMotor = new CANSparkMax(Constants.BACK_LEFT_MODULE_STEER_MOTOR, MotorType.kBrushless);
  public static final CANSparkMax frontRightSteerMotor = new CANSparkMax(Constants.FRONT_RIGHT_MODULE_STEER_MOTOR, MotorType.kBrushless);
  public static final CANSparkMax backRightSteerMotor = new CANSparkMax(Constants.FRONT_LEFT_MODULE_STEER_MOTOR, MotorType.kBrushless);

  XboxController myController = new XboxController(0);

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    if(myController.getLeftY()>0.1){
      // Comment out code based on which motor is running.
    frontLeftDriveMotor.set(myController.getLeftY());
    frontRightDriveMotor.set(myController.getLeftY());
    backLeftDriveMotor.set(myController.getLeftY());
    backRightDriveMotor.set(myController.getLeftY());
    frontLeftSteerMotor.set(myController.getLeftY());
    frontRightSteerMotor.set(myController.getLeftY());
    backLeftSteerMotor.set(myController.getLeftY());
    backRightSteerMotor.set(myController.getLeftY());

    SmartDashboard.putNumber("joystick input", myController.getLeftY());
    }
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
