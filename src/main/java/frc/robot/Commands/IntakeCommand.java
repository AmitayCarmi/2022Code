// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.IntakeArm;
import frc.robot.Subsystems.IntakeRollers;
import frc.robot.Subsystems.Shooter;
import frc.robot.Subsystems.Transfer;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class IntakeCommand extends Command {
  private final IntakeArm arm;
  private final IntakeRollers rollers;
  private final Transfer transfer;
  private final Shooter shooter;

  public IntakeCommand(IntakeArm arm, IntakeRollers rollers, Shooter shooter, Transfer transfer) {
    this.arm = arm;
    this.rollers = rollers;
    this.shooter = shooter;
    this.transfer = transfer;
    addRequirements(arm, rollers, shooter, transfer);

  }

  @Override
  public void initialize() {
    SmartDashboard.putString("Robot Mode", "Intaking");
  }

  @Override
  public void execute() {

    if (transfer.getBallCount() < 2) {
      arm.lower();
      rollers.setVoltage(6);
      transfer.setVoltage(6);
      ;
    } else {
      arm.raise();
      rollers.stopRollers();
      transfer.stopTransfer();
      shooter.setVoltage(10);
    }

  }

  private void addRequirements(IntakeArm arm2, IntakeRollers rollers2, Shooter shooter2, Transfer transfer2) {

    throw new UnsupportedOperationException("Unimplemented method 'addRequirements'");
  }

}
