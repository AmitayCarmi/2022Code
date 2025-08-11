

package frc.robot.Subsystems;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeArm extends SubsystemBase {

    
    private final TalonFX intakeArmMotor;
    private final TalonFXConfiguration intakeArmMConfiguration;
    private final PositionDutyCycle posControl = new PositionDutyCycle(0);
    FeedbackConfigs gearRatioConfigs;

    public IntakeArm() {
        intakeArmMConfiguration = new TalonFXConfiguration();
        intakeArmMotor = new TalonFX(5);
        gearRatioConfigs = new FeedbackConfigs();

        intakeArmMConfiguration.Slot0.kP = 1.0;
        intakeArmMConfiguration.Slot0.kI = 0.0;
        intakeArmMConfiguration.Slot0.kD = 0.0;
     
        gearRatioConfigs.SensorToMechanismRatio = 28.0;
        intakeArmMConfiguration.Feedback = gearRatioConfigs;
        intakeArmMotor.getConfigurator().apply(intakeArmMConfiguration);
    }

    public void setArmDegrees(double degrees) {
       double rotations = (degrees / 360.0); 

       intakeArmMotor.setControl(posControl.withPosition(rotations));
    }

    public void lower() {
        setArmDegrees(90); 
    }

    public void raise() {
        setArmDegrees(0); 
    }
}
