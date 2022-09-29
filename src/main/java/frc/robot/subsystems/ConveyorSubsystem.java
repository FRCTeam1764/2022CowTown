// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotConstants;

public class ConveyorSubsystem extends SubsystemBase {
  /** Creates a new Conveyor. */
  private PWMTalonFX conveyorMotor;
  private DigitalInput conveyorBreakBeam;
  private int count;

  public ConveyorSubsystem(DigitalInput conveyorBreakBeam){
    this.conveyorBreakBeam = conveyorBreakBeam; 
    this.conveyorMotor = new PWMTalonFX(RobotConstants.CONVEYOR_MOTOR);
    count=0;
  }
  
  public void conveyorOn(double conveyorSpeed, boolean override) {
    if(conveyorBreakBeam.get() || override){
      count =0;
      conveyorMotor.set(conveyorSpeed);
    }
    else if(!conveyorBreakBeam.get() && count < 25){
      count++;
      conveyorMotor.set(conveyorSpeed);
    }
    else{
      conveyorMotor.set(0);
    }
  }

  public void conveyorOff(){
    conveyorMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
