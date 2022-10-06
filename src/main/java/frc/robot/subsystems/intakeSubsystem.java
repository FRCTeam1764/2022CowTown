// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotConstants;

public class intakeSubsystem extends SubsystemBase {
  /** Creates a new intakeSubsystem. */
  private PWMTalonFX intakeMotor;
  private DoubleSolenoid intakeSolenoid;
  private DigitalInput conveyorBreakBeam;
  private DigitalInput elevatorBreakBeam;
  private boolean IsIntakeDeployed = false;
  public intakeSubsystem(DigitalInput conveyorBreakBeam, DigitalInput elevatorBreakBeam) {
   this.intakeMotor = new PWMTalonFX(RobotConstants.INTAKE_MOTOR);
    this.intakeSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, RobotConstants.INTAKE_SOLENOID_FORWARD, RobotConstants.INTAKE_SOLENOID_REVERSE);
    this.conveyorBreakBeam = conveyorBreakBeam;
    this.elevatorBreakBeam = elevatorBreakBeam;


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }


  public void intakeOn(Double speed, boolean override){

 if (override){
  if (IsIntakeDeployed == false){
  intakeSolenoid.set(Value.kForward);
  intakeMotor.set(speed);
  IsIntakeDeployed = true;
   
}else{
  intakeSolenoid.set(Value.kReverse);
  intakeMotor.set(0);
  IsIntakeDeployed = false;
}
 }else{
    if (IsIntakeDeployed == false){
      if (elevatorBreakBeam.get() == false && conveyorBreakBeam.get() == false){
    intakeSolenoid.set(Value.kForward);
    intakeMotor.set(speed);
    IsIntakeDeployed = true;
    }  
  }else{
    intakeSolenoid.set(Value.kReverse);
    intakeMotor.set(0);
    IsIntakeDeployed = false;
  }
 }
  }

  public void intakeOff(){
    intakeMotor.set(0);
    if (IsIntakeDeployed == true ){
    intakeSolenoid.set(Value.kReverse);
  IsIntakeDeployed = false;
    }
  }
}
