// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import frc.robot.constants.RobotConstants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.libraries.internal.LazyTalonFX;

public class Climber extends SubsystemBase {
  private LazyTalonFX climberMasterMotor;
  private LazyTalonFX climberFollowerMotor;
  private DoubleSolenoid climberSolenoid;
  
  public Climber() {
    this.climberMasterMotor = new LazyTalonFX(RobotConstants.CLIMBER_MASTER_MOTOR); 
    this.climberFollowerMotor = new LazyTalonFX(RobotConstants.CLIMBER_MASTER_MOTOR);
    this.climberSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, RobotConstants.CLIMBER_SOLENOID_FORWARD, RobotConstants.CLIMBER_SOLENOID_REVERSE);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void pneumaticsDeploy(){
      climberSolenoid.set(Value.kForward);
  }

  public void pneumaticsWithdraw(){ 
      climberSolenoid.set(Value.kReverse);
  }
  
  public void climberOn(double climberSpeed){
    climberMasterMotor.set(ControlMode.PercentOutput, climberSpeed);
  }

  public void climberOff(){
    climberMasterMotor.set(ControlMode.PercentOutput, 0);
  }

}

