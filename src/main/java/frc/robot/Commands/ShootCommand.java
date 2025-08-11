// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;



import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Shooter;
import frc.robot.Subsystems.Transfer;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ShootCommand extends Command {
private final Shooter shooter;
private final Transfer transfer;
  public ShootCommand(Shooter shooter, Transfer transfer) {
    this.shooter = shooter;
    this.transfer = transfer;
    addRequirements(shooter, transfer);
    
      } 
    
     
    
      // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putString("Robot Mode", "Shooting");
  }

  @Override
  public void execute() {
   
    if (transfer.getBallCount() > 0) {
      shooter.setVoltage(11);
      waituntill (shooter.getAverageRPM() >= 5000);
       while (transfer.getBallCount() > 0) {
        transfer.setVoltage(6);
       }
    }
        }
      
       
      
      
        @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  private void addRequirements(Shooter shooter2, Transfer transfer2) {
   
    throw new UnsupportedOperationException("Unimplemented method 'addRequirements'");
  }
  private void waituntill(boolean b) {
   
    throw new UnsupportedOperationException("Unimplemented method 'waituntill'");
  }

}
  