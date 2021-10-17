// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ConveyorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** A ConveyorBackwards that uses a ConveyorSubsystem. */
public class ConveyorBackwardsCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ConveyorSubsystem m_ConveyorSubsystem;

  /**
   * Creates a new ConveyorBackwardsCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ConveyorBackwardsCommand(ConveyorSubsystem subsystem) {
    m_ConveyorSubsystem = subsystem;
    m_ConveyorSubsystem.setForwards(false);
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_ConveyorSubsystem.periodic();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_ConveyorSubsystem.periodic();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
