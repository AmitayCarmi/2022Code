// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.IntakeArm;
import frc.robot.Subsystems.IntakeRollers;
import frc.robot.Subsystems.Transfer;
import frc.robot.Subsystems.Shooter;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ShootAndIntakeCommand extends Command {
  private final Transfer transfer;
  private final Shooter shooter;
  private final IntakeArm arm;
  private final IntakeRollers rollers;

  public ShootAndIntakeCommand(Transfer transfer, Shooter shooter, IntakeArm arm, IntakeRollers rollers) {
    this.transfer = transfer;
    this.shooter = shooter;
    this.arm = arm;
    this.rollers = rollers;
    addRequirements(transfer, shooter, arm, rollers);
  }

  @Override
  public void initialize() {
    SmartDashboard.putString("Robot Mode", "Shooting and Intaking");
    arm.lower();
    shooter.setVoltage(11);

  }

  @Override
  public void execute() {

    if (shooter.getAverageRPM() > 5000) {
      transfer.setVoltage(6);
    } else {
      transfer.stopTransfer();
    }

    if ((transfer.getBallCount() < 2)) {
      rollers.setVoltage(6);
    } else {
      rollers.stopRollers();
    }
  }

  @Override
  public void end(boolean interrupted) {
    shooter.stopShooter();
    transfer.stopTransfer();
    rollers.stopRollers();
    arm.raise();
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  private void addRequirements(Transfer transfer2, Shooter shooter2, IntakeArm arm2, IntakeRollers rollers2) {

    throw new UnsupportedOperationException("Unimplemented method 'addRequirements'");
  }
}
