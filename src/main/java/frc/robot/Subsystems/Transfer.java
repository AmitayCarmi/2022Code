// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Transfer extends SubsystemBase{

private final TalonFX transferMotor;

private final DigitalInput beamBreakSensor1;
private final DigitalInput beamBreakSensor2;
    public Transfer() {
        transferMotor = new TalonFX(5); 
        beamBreakSensor1 = new DigitalInput(1);
        beamBreakSensor2 = new DigitalInput(2);
    }

    public void setVoltage(double voltage) {
        transferMotor.setVoltage(voltage);
    }

public void stopTransfer() {
        transferMotor.setVoltage(0);
    }
public int getBallCount(){
    int count = 0;
    if (!beamBreakSensor1.get()) {count++;}
    if (!beamBreakSensor2.get()) {count++;}
    return count;
}
@Override
    public void periodic() {
      SmartDashboard.putNumber("Ball Count", getBallCount());}

  
}