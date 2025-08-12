
package frc.robot.Subsystems;

import static frc.robot.Subsystems.Constants.SHOOTER_MOTOR_LEFT_ID;
import static frc.robot.Subsystems.Constants.SHOOTER_MOTOR_RIGHT_ID;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.controls.Follower;

import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    private static Shooter shooter;

    private final TalonFX shooterMotorRight;
    private final TalonFX shooterMotorLeft;

    private final StatusSignal<AngularVelocity> leftVelocity;
    private final StatusSignal<AngularVelocity> rightVelocity;

    public Shooter() {
        shooterMotorRight = new TalonFX(SHOOTER_MOTOR_RIGHT_ID);
        shooterMotorLeft = new TalonFX(SHOOTER_MOTOR_LEFT_ID);

        leftVelocity = shooterMotorLeft.getVelocity();
        rightVelocity = shooterMotorRight.getVelocity();

        shooterMotorRight.setControl(new Follower(shooterMotorLeft.getDeviceID(), true));
    }

    public void setVoltage(double voltage) {
        shooterMotorLeft.setVoltage(voltage);
    }

    public void stopShooter() {
        shooterMotorLeft.setVoltage(0);
       
    }

    public double getAverageRPM() {
        double rpm1 = shooterMotorRight.getVelocity().getValueAsDouble() * 60;
        double rpm2 = shooterMotorLeft.getVelocity().getValueAsDouble() * 60;
        return (rpm1 + rpm2) / 2.0;
    }

    @Override
    public void periodic() {
        leftVelocity.refresh();
        rightVelocity.refresh();
    }

    public static Shooter getInstance() {
        if (shooter == null) {
            shooter = new Shooter();
        }
        return shooter;
    }
}
