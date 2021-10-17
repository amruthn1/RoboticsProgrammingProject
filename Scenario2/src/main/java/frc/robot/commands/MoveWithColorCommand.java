// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.MoveWithColorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** A MoveWithColorCommand that uses a MoveWithColorSubsystem. */
public class MoveWithColorCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final MoveWithColorSubsystem m_MoveWithColorSubsystem;

  /**
   * Creates a new MoveWithColorCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public MoveWithColorCommand(MoveWithColorSubsystem subsystem) {
    m_MoveWithColorSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_MoveWithColorSubsystem.setColors(Constants.colors);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_MoveWithColorSubsystem.periodic();
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
