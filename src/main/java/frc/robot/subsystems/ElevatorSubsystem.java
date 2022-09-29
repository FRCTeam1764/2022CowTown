// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotConstants;

public class ElevatorSubsystem extends SubsystemBase {
  /** Creates a new ElevatorSubsystem. */
  private PWMTalonFX elevatorMotor;
  private DigitalInput elevatorBreakBeam;
  
  public ElevatorSubsystem(DigitalInput elevatorBreakBeam){
    this.elevatorBreakBeam = elevatorBreakBeam;
    this.elevatorMotor = new PWMTalonFX(RobotConstants.ELEVATOR_MOTOR);
  }

  public void elevatorOn(double elevatorSpeed){
    if(elevatorBreakBeam.get()){
      elevatorMotor.set(elevatorSpeed);
    }
    else{
      elevatorMotor.set(0);
    }
  }

  public void elevatorOff(){
    elevatorMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
