package frc.robot;

import edu.wpi.first.wpilibj.Timer;

public class PIDF {

    double previous_error = 0;
    double previous_time = 0;
    double mSetpoint;
    double mError;
    double timestamp = Timer.getFPGATimestamp();

    // need to be tuned
    double mP;
    double mI;
    double mD;
    double mF;

    public PIDF(double kP, double kI, double kD, double kF) {
        this.mP = kP;
        this.mI = kI;
        this.mD = kD;
        this.mF = kF;
    }
    

    public void getPosition() {
        // code about measuring sensors
        // where we currently are
    }
    
    // get method for error
    public double getError() {
        return mError;
    }

    // get and set methods
    public double getP() {
        return mP;
    }

    public void setP(double kP){
        mP = kP;
    }

    public double getI() {
        return mI;
    }

    public void setI(double kI){
        mI = kI;
    }

    public double getD() {
        return mD;
    }

    public void setD(double kD){
        mD = kD;
    }

    public double getF() {
        return mF;
    }

    public void setF(double kF){
        mF = kF;
    }

    public double getSetpoint() {
        return mSetpoint;
    }

    public void setSetpoint(double setpoint) {
        mSetpoint = setpoint;
    }

    // setpoint = where we want to be
    // measured_value = where we are

    public double update(double measured_value) throws InterruptedException {
        double integral = 0;
        double derivative = 0;

        double output;
        double error = mSetpoint - measured_value;

        double current_time = timestamp;

        while (error != 0) {
            long dt = (long) current_time - (long) previous_time;
            error = mSetpoint - measured_value;
            integral = integral + error * dt;
            derivative = (error - previous_error) / dt;
            output = mP*error + mI*integral + mD*derivative + mF * mSetpoint;
            previous_error = error;
            wait(dt);
            previous_time = dt;
            return output;
        }
        
        return 0;

    }

}
