package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class Flywheel {

    // initiating flywheel talons
    public TalonFX flywheelTalonM = new TalonFX(Constants.kFlywheelLeaderID);
    public TalonFX flywheelTalonS = new TalonFX(Constants.kFlywheelFollowerID);

    public Flywheel() {
        // one follows another
        flywheelTalonS.set(ControlMode.Follower, Constants.kFlywheelLeaderID);

        // SRX mag encoder
        flywheelTalonM.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, Constants.kpidIdx, Constants.ktimeoutMs);
        
        // velocity PIDF?
        flywheelTalonM.config_kP(Constants.kslotIdx, Constants.kVP);
        flywheelTalonM.config_kI(Constants.kslotIdx, Constants.kVI);
        flywheelTalonM.config_kD(Constants.kslotIdx, Constants.kVD);
        flywheelTalonM.config_kF(Constants.kslotIdx, Constants.kVF);
    }

    // need to be assigned
    public double gearRatio;
    public double wheelRadius;

    public class InputOutput {
        // velocity you want to output -- in m/s
        double requestVelo = 0;

        // converts velocity into encoder units (ticks per 100ms)
        double requestEncUnits = requestVelo * 60 * (gearRatio * 2 * Math.PI * wheelRadius);
    }

    // instance of InputOutput class
    InputOutput mInputOutput = new InputOutput();
    
    public void setRPM() {
        flywheelTalonM.set(ControlMode.Velocity, mInputOutput.requestEncUnits);
    }

}