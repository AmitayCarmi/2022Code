
package frc.robot.Subsystems;

import static frc.robot.Subsystems.Constants.LEFT_DRIVE_MOTOR_ID;
import static frc.robot.Subsystems.Constants.MAXIMUM_DRIVE_VOLTAGE;
import static frc.robot.Subsystems.Constants.MINIMUM_DRIVE_VOLTAGE;
import static frc.robot.Subsystems.Constants.RIGHT_DRIVE_MOTOR_ID;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    private static DriveTrain driveTrain;

    private final TalonFX leftDriveMotor;
    private final TalonFX rightDriveMotor;

    private final TalonFXConfiguration leftDriveMotorConfig;
    private final TalonFXConfiguration rightDriveMotorConfig;

    public DriveTrain() {
        rightDriveMotorConfig = new TalonFXConfiguration();
        leftDriveMotorConfig = new TalonFXConfiguration();
        leftDriveMotor = new TalonFX(LEFT_DRIVE_MOTOR_ID);
        rightDriveMotor = new TalonFX(RIGHT_DRIVE_MOTOR_ID);

        rightDriveMotorConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        leftDriveMotorConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

        rightDriveMotorConfig.Voltage.PeakForwardVoltage = MAXIMUM_DRIVE_VOLTAGE;
        rightDriveMotorConfig.Voltage.PeakReverseVoltage = -MINIMUM_DRIVE_VOLTAGE;
        leftDriveMotorConfig.Voltage.PeakForwardVoltage = MAXIMUM_DRIVE_VOLTAGE;
        leftDriveMotorConfig.Voltage.PeakReverseVoltage = -MINIMUM_DRIVE_VOLTAGE;

        rightDriveMotorConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        leftDriveMotorConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;

        leftDriveMotor.getConfigurator().apply(leftDriveMotorConfig);
        rightDriveMotor.getConfigurator().apply(rightDriveMotorConfig);
    }

    public void setTankDriveVoltage(double leftVoltage, double rightVoltage) {
        leftDriveMotor.setVoltage(leftVoltage);
        rightDriveMotor.setVoltage(rightVoltage);
    }

    public static DriveTrain getInstance() {
        if (driveTrain == null) {
            driveTrain = new DriveTrain();
        }
        return driveTrain;
    }
}