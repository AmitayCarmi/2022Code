
package frc.robot.Commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Shooter;
import frc.robot.Subsystems.Transfer;

public class ShootCommand extends Command{
  private final Shooter shooter;
  private final Transfer transfer;

  public ShootCommand(Shooter shooter, Transfer transfer) {
    this.shooter = shooter;
    this.transfer = transfer;
    addRequirements(shooter, transfer);

  }

  @Override
  public void initialize() {
    SmartDashboard.putString("Robot Mode", "Shooting");
  }

  @Override
  public void execute() {

    if (transfer.getBallCount() > 0) {
      shooter.setVoltage(11);

      if (shooter.getAverageRPM() >= 5000) {
        transfer.setVoltage(6);
      } else {
        transfer.stopTransfer();
      }
    }
  }

  @Override
  public void end(boolean interrupted) {
    shooter.stopShooter();
    transfer.stopTransfer();

  }

  @Override
  public boolean isFinished() {
    return transfer.getBallCount() == 0;
  }

  private void addRequirements(Shooter shooter2, Transfer transfer2) {

    throw new UnsupportedOperationException("Unimplemented method 'addRequirements'");
  }

}
