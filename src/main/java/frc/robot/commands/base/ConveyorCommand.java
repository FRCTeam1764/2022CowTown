// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.base;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ConveyorSubsystem;

public class ConveyorCommand extends CommandBase {
  /** Creates a new ConveyorCommand. */
  private ConveyorSubsystem conveyor;
  private double conveyorSpeed;
  private boolean override;

  public ConveyorCommand(ConveyorSubsystem conveyor, double conveyorSpeed, boolean override) {
    this.conveyor = conveyor;
    this.conveyorSpeed = conveyorSpeed;
    this.override = override;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    conveyor.conveyorOn(conveyorSpeed, override);
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    conveyor.conveyorOff();
  }
  
  @Override
  public boolean isFinished() {
    return false;
  }
}
