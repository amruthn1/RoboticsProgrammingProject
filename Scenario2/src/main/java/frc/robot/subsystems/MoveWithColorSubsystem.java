// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MoveWithColorSubsystem extends SubsystemBase {
  //Create new timer
  private final Timer timer = new Timer();
  //Create 4 SpeedControllers for 4 of the PWMVictorSPX motors
  SpeedController m_topLeft = new PWMVictorSPX(Constants.victorSPXChannel1);
  SpeedController m_topRight = new PWMVictorSPX(Constants.victorSPXChannel2);
  SpeedController m_bottomLeft = new PWMVictorSPX(Constants.victorSPXChannel3);
  SpeedController m_bottomRight = new PWMVictorSPX(Constants.victorSPXChannel4);
  //Create 2 SpeedControllerGroups for top and bottom set of motors
  SpeedControllerGroup scg_top =  new SpeedControllerGroup(m_topLeft, m_topRight);
  SpeedControllerGroup scg_bottom = new SpeedControllerGroup(m_bottomLeft, m_bottomRight);
  String[] colors;
  /** Creates a new MoveWithColorSubsystem. */
  public MoveWithColorSubsystem() {
  }
   //Function to move robot based on array of colors passed in
   public void moveRobot(){
    //Iterate through array 
    for (int i = 0; i < colors.length; i++){
        //If color is green, set speed of both SpeedControllerGroups
        if (colors[i] == "green") {
            scg_top.set(Constants.scg_top_speed);
            scg_bottom.set(Constants.scg_bottom_speed);
        } else if (colors[i] == "red") {
            //If color is red, stop all motors
            scg_top.stopMotor();
            scg_bottom.stopMotor();
        } else if (colors[i] == "yellow") {
            //If color is yellow, stop all motors for 5 seconds
            if (timer.get() < 5) {
                scg_top.stopMotor();
                scg_bottom.stopMotor();
            } else {
                //After 5 seconds, restart motors
                scg_top.set(Constants.scg_top_speed);
                scg_bottom.set(Constants.scg_bottom_speed);
            }
        }
    }
}
  @Override
  public void periodic() {
    moveRobot();
  }

  @Override
  public void simulationPeriodic() {
    moveRobot();
  }
  public void setColors(String[] values) {
    this.colors = values;
  }
}
