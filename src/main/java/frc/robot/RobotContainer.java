
package frc.robot;

import edu.wpi.first.wpilibj.PS5Controller;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Commands.DriveCommand;
import frc.robot.Commands.IntakeCommand;
import frc.robot.Commands.ShootAndIntakeCommand;
import frc.robot.Commands.ShootCommand;
import frc.robot.Subsystems.DriveTrain;
import frc.robot.Subsystems.IntakeArm;
import frc.robot.Subsystems.IntakeRollers;
import frc.robot.Subsystems.Shooter;
import frc.robot.Subsystems.Transfer;

public class RobotContainer {

  private final PS5Controller controller = new PS5Controller(1);

  private final DriveTrain driveTrain = new DriveTrain();
  private final IntakeArm intakeArm = new IntakeArm();
  private final IntakeRollers intakeRollers = new IntakeRollers();
  private final Transfer transfer = new Transfer();
  private final Shooter shooter = new Shooter();

  private final DriveCommand driveCommand = new DriveCommand(driveTrain, controller);

  public RobotContainer() {
    driveTrain.setDefaultCommand(driveCommand);

    configureBindings();
  }

  private void configureBindings() {
    new Trigger(controller::getTriangleButton)
        .onTrue(new IntakeCommand(intakeArm, intakeRollers, shooter, transfer));

    new Trigger(controller::getCircleButton)
        .onTrue(new ShootCommand(shooter, transfer));

    new Trigger(controller::getL1Button)
        .whileTrue(new ShootAndIntakeCommand(transfer, shooter, intakeArm, intakeRollers));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
