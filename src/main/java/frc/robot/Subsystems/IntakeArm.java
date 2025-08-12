
package frc.robot.Subsystems;


import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;

import static frc.robot.Subsystems.Constants.INTAKE_ARM_GEAR_RATIO;
import static frc.robot.Subsystems.Constants.INTAKE_ARM_MOTOR_ID;
import static frc.robot.Subsystems.Constants.INTAKE_ARM_PID_KD;
import static frc.robot.Subsystems.Constants.INTAKE_ARM_PID_KI;
import static frc.robot.Subsystems.Constants.INTAKE_ARM_PID_KP;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeArm extends SubsystemBase {

    private static IntakeArm intakeArm;
    private final TalonFX intakeArmMotor;
    private final TalonFXConfiguration intakeArmMConfiguration;
    private final PositionDutyCycle posControl = new PositionDutyCycle(0);

    public IntakeArm() {
        intakeArmMConfiguration = new TalonFXConfiguration();
        intakeArmMotor = new TalonFX(INTAKE_ARM_MOTOR_ID);

        intakeArmMConfiguration.Slot0.kP = INTAKE_ARM_PID_KP;
        intakeArmMConfiguration.Slot0.kI = INTAKE_ARM_PID_KI;
        intakeArmMConfiguration.Slot0.kD = INTAKE_ARM_PID_KD;

        intakeArmMotor.getConfigurator().apply(intakeArmMConfiguration);
    }

    public void setArmDegrees(double degrees) {
        double rotations = (degrees / 360.0) * INTAKE_ARM_GEAR_RATIO;

        intakeArmMotor.setControl(posControl.withPosition(rotations));
    }

    public void lower() {
        setArmDegrees(90);
    }

    public void raise() {
        setArmDegrees(0);
    }

    public static IntakeArm getInstance() {
        if (intakeArm == null) {
            intakeArm = new IntakeArm();
        }
        return intakeArm;
    }
}
