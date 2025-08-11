
package frc.robot.Subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

    private final TalonFX leftDriveMotor;
    private final TalonFX rightDriveMotor;
    private final TalonFXConfiguration rightDriveMotorConfig;
    private final TalonFXConfiguration leftDriveMotorConfig;

    public DriveTrain() {
        rightDriveMotorConfig = new TalonFXConfiguration();
        leftDriveMotorConfig = new TalonFXConfiguration();
        leftDriveMotor = new TalonFX(2);
        rightDriveMotor = new TalonFX(3);

        rightDriveMotorConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        leftDriveMotorConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

        rightDriveMotorConfig.Voltage.PeakForwardVoltage = 12.0;
        rightDriveMotorConfig.Voltage.PeakReverseVoltage = -12.0;
        leftDriveMotorConfig.Voltage.PeakForwardVoltage = 12.0;
        leftDriveMotorConfig.Voltage.PeakReverseVoltage = -12.0;

        rightDriveMotorConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        leftDriveMotorConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;

        leftDriveMotor.getConfigurator().apply(leftDriveMotorConfig);
        rightDriveMotor.getConfigurator().apply(rightDriveMotorConfig);
    }

    public void setTankDriveVoltage(double leftVoltage, double rightVoltage) {
        leftDriveMotor.setVoltage(leftVoltage);
        rightDriveMotor.setVoltage(rightVoltage);
    }
}
