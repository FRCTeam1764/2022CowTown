// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotConstants;
import frc.robot.libraries.internal.LazyTalonFX;
import frc.robot.constants.ShooterConstants;
public class shooterSubsystem extends SubsystemBase {
  /** Creates a new shooterSubsystem. */
private LazyTalonFX shooterMasterMotor; 
private LazyTalonFX shooterFollowMotor;

public double shooterVelocity = 0;

  public shooterSubsystem(double Velocity) {
    shooterMasterMotor =ConfigureMotors(RobotConstants.SHOOTER_MASTER_MOTOR, true, false);
    shooterFollowMotor = ConfigureMotors(RobotConstants.SHOOTER_FOLLOWER_MOTOR, false, false);

    shooterVelocity = Velocity;
  }

private LazyTalonFX ConfigTalons(int portNum, boolean isMaster, boolean isInverted){

  LazyTalonFX talon = new LazyTalonFX(portNum);
  talon.configFactoryDefault();
  talon.setInverted(isInverted);
  talon.enableVoltageCompensation(true);
  talon.configVoltageCompSaturation(12.0, ShooterConstants.kTimeoutMs);

  if(isMaster){
    talon.configOpenloopRamp(ShooterConstants.openDriveVoltageRampRate);
  }

  return talon;
}

public LazyTalonFX ConfigureMotors(int portNum, boolean isMaster, boolean isInverted){
  LazyTalonFX talon = ConfigTalons(portNum, isMaster, isInverted);
  talon.setNeutralMode(NeutralMode.Coast);

  if(isMaster){
  talon.config_kP(ShooterConstants.kSlot_Shooter_Velocity, 0.060, ShooterConstants.kTimeoutMs);
  talon.config_kI(ShooterConstants.kSlot_Shooter_Velocity, 0.0, ShooterConstants.kTimeoutMs);
  talon.config_kD(ShooterConstants.kSlot_Shooter_Velocity, 0.0009, ShooterConstants.kTimeoutMs);
  talon.config_kF(ShooterConstants.kSlot_Shooter_Velocity, 0.049, ShooterConstants.kTimeoutMs);
  talon.config_IntegralZone(ShooterConstants.kSlot_Shooter_Velocity, (int)ShooterConstants.kGains_Velocity_Shooter.kIzone, ShooterConstants.kTimeoutMs);
  talon.configClosedLoopPeakOutput(ShooterConstants.kSlot_Shooter_Velocity, ShooterConstants.kGains_Velocity_Shooter.kPeakOutput, ShooterConstants.kTimeoutMs);
  talon.configAllowableClosedloopError(ShooterConstants.kSlot_Shooter_Velocity, 0, ShooterConstants.kTimeoutMs);
  talon.selectProfileSlot(ShooterConstants.kSlot_Shooter_Velocity, ShooterConstants.PID_PRIMARY);
  }
  return talon;
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Shoot(){
shooterMasterMotor.set(ControlMode.Velocity, shooterVelocity);
  }

  public void stopShooter(){
    shooterMasterMotor.set(ControlMode.PercentOutput,0);
  
  }

  public void setShooterVelocity(double velocity) {
    shooterVelocity = velocity;
  }

}
