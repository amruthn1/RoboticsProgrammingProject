// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase {
  private final Timer m_timer = new Timer();
  // Declare 2 VictorSP motors
  private VictorSP victorSP1;
  private VictorSP victorSP2;
  private boolean up = false;
  /** Creates a new ExampleSubsystem. */
  public ElevatorSubsystem() {
    // On initialization, create 2 new VictorSP motors and assign ports
    victorSP1 = new VictorSP(Constants.motorPort1);
    victorSP2 = new VictorSP(Constants.motorPort2);
  }

  @Override
  public void periodic() {
    if (up) {
      elevatorUp(Constants.uplength);
    } else {
      elevatorDown(Constants.downlength);
    }
    // This method will be called once per scheduler run

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  private void elevatorUp(int uplength) {
    // Check timer to start and then check when to stop motors
    do {
      // Set speed of VictorSP1 to 1.0 to move one direction
      victorSP1.set(1.0);
      // Set speed of VictorSP2 to 1.0 to move opposite direction
      victorSP2.set(1.0);
    } while (m_timer.get() < uplength);
    // When duration is over, stop both motors
    victorSP1.stopMotor();
    victorSP2.stopMotor();
}

private void elevatorDown(int downlength) {
    // Check timer to start and then check when to stop motors
    // Not putting this in autonomousPeriodic() so it only runs when initialized
    do {
      // Set speed of VictorSP1 to 1.0 to move opposite direction
      victorSP1.set(1.0);
      victorSP1.setInverted(true);
      // Set speed of VictorSP2 to 1.0 to move one direction
      victorSP2.set(1.0);
      victorSP2.setInverted(true);
    } while (m_timer.get() < downlength);
    // When duration is over, stop both motors
    victorSP1.stopMotor();
    victorSP2.stopMotor();
    // Get rid of inversion
    victorSP1.setInverted(false);
    victorSP2.setInverted(false);
}
  public void setUp(boolean value){
    this.up = value;
  }
}
