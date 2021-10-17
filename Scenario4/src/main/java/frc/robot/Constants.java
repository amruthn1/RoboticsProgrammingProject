// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
     //Random values for these variables
     public final static double kP = 1.0;
     public final static double kI = 1.1;
     public final static double kD = 1.2;
     public final static double tolerance = 1.5;
     public final static int encoderPort1 = 5;
     public final static int encoderPort2 = 6;
     public final static int ks = 7;
     public final static int kv = 8;
     public final static int motorChannel = 1;
     public final static double setPoint = 5.5;
}
