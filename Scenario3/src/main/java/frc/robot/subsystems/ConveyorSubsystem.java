// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ConveyorSubsystem extends SubsystemBase {
  private final Timer m_timer = new Timer();
  // Declare 2 PWMVictorSPX SpeedController motors
  private SpeedController victorSP1;
  private SpeedController victorSP2;
  //Declare SpeedControllerGroup
  private SpeedControllerGroup scg;
  private boolean forwards = false;
  /** Creates a new ExampleSubsystem. */
  public ConveyorSubsystem() {
    // On initialization, create 2 new PWMVictorSPX motors and assign ports
    victorSP1 = new PWMVictorSPX(Constants.motorport1);
    victorSP2 = new PWMVictorSPX(Constants.motorport2);
    scg = new SpeedControllerGroup(victorSP1, victorSP2);
  }
  public void conveyorForward() {
    //Function to start and stop conveyor based on a given duration
    while (m_timer.get() < Constants.forwardDuration) {
      scg.set(Constants.forwardSpeed);
    }
    scg.stopMotor();
  }

  public void conveyorBackwards() {
    //Function to start and stop conveyor based on a given duration
    while (m_timer.get() < Constants.backwardDuration) {
      scg.setInverted(true);
      scg.set(Constants.backwardSpeed);
    }
      scg.stopMotor();
      scg.setInverted(false);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if (forwards) {
      conveyorForward();
    } else {
      conveyorBackwards();
    }
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  public void setForwards(boolean value){
    this.forwards = value;
  }
}
