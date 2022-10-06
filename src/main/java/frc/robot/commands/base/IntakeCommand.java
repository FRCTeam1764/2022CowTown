// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.base;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intakeSubsystem;

public class IntakeCommand extends CommandBase {
  /** Creates a new IntakeCommand. */
public intakeSubsystem Intake;
public double intakeSpeed;
public boolean override;


  public IntakeCommand(intakeSubsystem intake, double intakeSpeed, boolean override) {
    // Use addRequirements() here to declare subsystem dependencies.
this.override = override;
this.intakeSpeed = intakeSpeed;
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Intake.intakeOn(intakeSpeed, override);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Intake.intakeOff();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Intake.intakeOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
