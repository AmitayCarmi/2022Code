// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DriveTrain;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveCommand extends Command {
  private final DriveTrain drive;
  private final PS5Controller Controller;

  public DriveCommand(DriveTrain drive, PS5Controller Controller) {
    this.drive = drive;
    this.Controller = Controller;
    addRequirements(drive);
  }

  @Override
  public void execute() {
    double left = -Controller.getLeftY();
    double right = -Controller.getRightY();

    drive.setTankDriveVoltage(left, right);
  }

  
  
}
