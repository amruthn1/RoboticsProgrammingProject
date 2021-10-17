// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants;

public class PIDControllerSubsystem extends PIDSubsystem {
  Encoder encoder;
  PWMVictorSPX vSPX;
  SimpleMotorFeedforward smff;
  PIDController pidContoller;

  /** Creates a new PIDControllerSubsystem. */
  public PIDControllerSubsystem() {
    super(new PIDController(Constants.kP, Constants.kI, Constants.kD));
    // Initialize new Encoder with both motor channels
    encoder = new Encoder(Constants.encoderPort1, Constants.encoderPort2);
    // Create new VictorSPX motor
    vSPX = new PWMVictorSPX(Constants.motorChannel);
    // Create new SimpleMotorFeedforward
    smff = new SimpleMotorFeedforward(Constants.ks, Constants.kv);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    getController().setTolerance(Constants.tolerance);
    // Set setpoint
    getController().setSetpoint(Constants.setPoint);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  @Override
  protected void useOutput(double output, double setpoint) {
    // Set voltage based on computation done by PIDSubsystem
    vSPX.setVoltage(output + smff.calculate(setpoint));
  }

  @Override
  protected double getMeasurement() {
    // Return encoder rate
    return encoder.getRate();
  }
}
