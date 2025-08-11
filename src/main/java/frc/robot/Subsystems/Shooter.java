

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;


public class Shooter {

    private final TalonFX shooterMotor1;
    private final TalonFX shooterMotor2;

    public Shooter(){
        shooterMotor1 = new TalonFX(10);
        shooterMotor2 = new TalonFX(12);
    }


    public void setVoltage(double voltage) {
        shooterMotor1.setVoltage(voltage);
        shooterMotor2.setVoltage(voltage);
    }
    public void stopShooter() {
        shooterMotor1.setVoltage(0);
        shooterMotor2.setVoltage(0);
    }
    public double getAverageRPM() {
        double rpm1 = shooterMotor1.getVelocity().getValueAsDouble() * 60; 
        double rpm2 = shooterMotor2.getVelocity().getValueAsDouble() * 60;
        return (rpm1 + rpm2) / 2.0; 
    }
}

