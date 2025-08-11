
package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class IntakeRollers extends SubsystemBase{
private final DigitalInput beamBreakSensor; 
    private final TalonFX intakeRollersMotor;


    public IntakeRollers() {
        intakeRollersMotor = new TalonFX(6); 
        beamBreakSensor = new DigitalInput(3); 
    }

    public void setVoltage(double Voltage) {
        intakeRollersMotor.setVoltage(Voltage);
    }
    public void stopRollers() {
        intakeRollersMotor.setVoltage(0);
    }
    public boolean isBallDetected() {
        return !beamBreakSensor.get(); 
    }
}
