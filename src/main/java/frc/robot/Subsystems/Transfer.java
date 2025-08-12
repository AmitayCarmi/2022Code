// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import static frc.robot.Subsystems.Constants.TRANSFER_BACK_BEAM_BREAK_SENSOR_ID;
import static frc.robot.Subsystems.Constants.TRANSFER_FRONT_BEAM_BREAK_SENSOR_ID;
import static frc.robot.Subsystems.Constants.TRANSFER_MOTOR_ID;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Transfer extends SubsystemBase {

    private final TalonFX transferMotor;
    private static Transfer transfer;
    private final DigitalInput beamBreakSensorFront;
    private final DigitalInput beamBreakSensorBack;

    public Transfer() {
        transferMotor = new TalonFX(TRANSFER_MOTOR_ID);
        beamBreakSensorFront = new DigitalInput(TRANSFER_FRONT_BEAM_BREAK_SENSOR_ID);
        beamBreakSensorBack = new DigitalInput(TRANSFER_BACK_BEAM_BREAK_SENSOR_ID);
    }

    public void setVoltage(double voltage) {
        transferMotor.setVoltage(voltage);
    }

    public void stopTransfer() {
        transferMotor.setVoltage(0);
    }

    public int getBallCount() {
        int count = 0;
        if (!beamBreakSensorFront.get()) {
            count++;
        }
        if (!beamBreakSensorBack.get()) {
            count++;
        }
        return count;
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Ball Count", getBallCount());
    }

    public static Transfer getInstance() {
        if (transfer == null) {
            transfer = new Transfer();
        }
        return transfer;
    }
}