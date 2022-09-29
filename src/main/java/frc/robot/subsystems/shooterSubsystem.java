// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotConstants;
import frc.robot.libraries.external.control.PidConstants;
import frc.robot.libraries.internal.LazyTalonFX;

public class shooterSubsystem extends SubsystemBase {
  /** Creates a new shooterSubsystem. */
private LazyTalonFX shooterMasterMotor; 
private LazyTalonFX shooterFollowMotor;

public double shooterVelocity = 0;

  public shooterSubsystem() {
    shooterMasterMotor = new LazyTalonFX(RobotConstants.SHOOTER_MASTER_MOTOR)
    shooterFollowMotor = new LazyTalonFX(RobotConstants.SHOOTER_FOLLOWER_MOTOR)


  }

public LazyTalonFX ConfigureMotors(int portNum, boolean isMaster, boolean isInverted){
  LazyTalonFX talon = configTalons(portNum, isMaster, isInverted);
  talon.setNeutralMode(NeutralMode.Coast);

  if(isMaster){
  talon.config_kP(PidConstants.kSlot_Shooter_Velocity, 0.060, PidConstants.kTimeoutMs);
  talon.config_kI(PidConstants.kSlot_Shooter_Velocity, 0.0, PidConstants.kTimeoutMs);
  talon.config_kD(PidConstants.kSlot_Shooter_Velocity, 0.0009, PidConstants.kTimeoutMs);
  talon.config_kF(PidConstants.kSlot_Shooter_Velocity, 0.049, PidConstants.kTimeoutMs);
  talon.config_IntegralZone(PidConstants.kSlot_Shooter_Velocity, (int)PidConstants.kGains_Velocity_Shooter.kIzone, PidConstants.kTimeoutMs);
  talon.configClosedLoopPeakOutput(PidConstants.kSlot_Shooter_Velocity, PidConstants.kGains_Velocity_Shooter.kPeakOutput, PidConstants.kTimeoutMs);
  talon.configAllowableClosedloopError(PidConstants.kSlot_Shooter_Velocity, 0, PidConstants.kTimeoutMs);
  talon.selectProfileSlot(PidConstants.kSlot_Shooter_Velocity, PidConstants.PID_PRIMARY);
  }
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Shoot(){

  }
}
