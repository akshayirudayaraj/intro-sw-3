package frc.robot;

public class Constants {
    public static final int idL1 = 0;
    public static final int idL2 = 1;
    public static final int idR1 = 2;
    public static final int idR2 = 3;

    public static final int joystickLId = 1;
    public static final int joystickRId = 2;

    public static final double kP = 0.3;
    public static final double kI = 0;
    public static final double kD = 0.6;
    public static final double kF = 1;

        // flywheel talons
        public static final int kFlywheelLeaderID = 0;
        public static final int kFlywheelFollowerID = 1;
    
        // flywheel talon pid index
        public static final int kpidIdx = 0;
        public static final int ktimeoutMs = 1000;
    
        // velo pidf constants -- need to be tuned/set
        public static final int kslotIdx = 0;
        public static final int kVP = 0;
        public static final int kVI = 0;
        public static final int kVD = 0;
        public static final int kVF = 0;
    
        // gear grabber talon
        public static final int kGearGrabberLeaderID = 0;
    
        // gear grabber solenoid
        public static final int kSolenoidID = 0;
}