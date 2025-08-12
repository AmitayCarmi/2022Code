
package frc.robot.Subsystems;

import static frc.robot.Subsystems.Constants.INTAKE_BEAM_BREAK_SENSOR_ID;
import static frc.robot.Subsystems.Constants.INTAKE_ROLLERS_MOTOR_ID;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeRollers extends SubsystemBase {
    private static IntakeRollers intakeRollers;
    private final DigitalInput beamBreakSensor;
    private final TalonFX intakeRollersMotor;

    public IntakeRollers() {
        intakeRollersMotor = new TalonFX(INTAKE_ROLLERS_MOTOR_ID);
        beamBreakSensor = new DigitalInput(INTAKE_BEAM_BREAK_SENSOR_ID);
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

    public static IntakeRollers getInstance() {
        if (intakeRollers == null) {
            intakeRollers = new IntakeRollers();
        }
        return intakeRollers;
    }
}