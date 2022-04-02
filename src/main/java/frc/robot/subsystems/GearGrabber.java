package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class GearGrabber {
    
    // initiating geargrabber talon
    public TalonFX flywheelTalonM = new TalonFX(Constants.kGearGrabberLeaderID);

    // pneumatics module type is either CTREPCM or REVPH
    // initiating solenoid
    Solenoid gearGrabberSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.kSolenoidID);

    // needs access to sensors?
    boolean actuated;

    public void checkSolenoid(boolean actuated) {
        if (true) {
            // set: grabber up
        } else if (false) {
            // set: grabber down
        }
    }
    
    public void State() {
        int state = 0;
        String stateString;

        switch (state) {
            case 1: stateString = "SCORE";
                // grabber down, motor speed = 1 after 0.1 s
            case 2: stateString = "AQUIRE";
                // grabber down, motor speed = -1
            case 3: stateString = "IDLE";
                // grabber up, motor speed = -1
            case 4: stateString = "NONE";
                break;  
        }

        /*
        SCORE = grabber down, motor speed = 1 after 0.1 s
        AQUIRE = grabber down, motor speed = -1
        IDLE = grabber up, motor speed = -1
        */ 
    }
}
