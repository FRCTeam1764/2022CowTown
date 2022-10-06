// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.base;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooterSubsystem;

public class ShooterCommand extends CommandBase {
  /** Creates a new ShooterCommand. */

  public shooterSubsystem Shooter;
  public   double shooterRatio = 4.8;
  public ShooterCommand(shooterSubsystem shooter) {
    // Use addRequirements() here to declare subsystem dependencies.

this.Shooter = shooter;


    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Shooter.setShooterVelocity(245.7);
    Shooter.Shoot();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {


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
