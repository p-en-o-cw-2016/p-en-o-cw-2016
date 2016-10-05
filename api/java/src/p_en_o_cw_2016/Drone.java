package p_en_o_cw_2016;

public interface Drone {
    /** The distance between the cameras, in meters. Note: the (pinholes of the)
        cameras are on the pitch axis, so pitching rotates the cameras but does not
        translate them. */
    float getCameraSeparation();
    Camera getLeftCamera();
    Camera getRightCamera();
    /** The weight in kg. */
    float getWeight();
    /** The gravity in newtons. */
    float getGravity();
    /** The drag force per unit of speed, in kilograms per second. This drone is highly
        aerodynamic, so the drag force is linear in the speed. */
    float getDrag();
    /** Gets the maximum of the absolute value of the thrust, in newtons. */
    float getMaxThrust();
    float getMaxPitchRate();
    float getMaxRollRate();
    float getMaxYawRate();

    /** The current pitch (the angle between the direction of view and the horizontal
        plane), in degrees. Positive pitch means the drone is looking down. */
    float getPitch();
    /** The current roll (the angle between the line that connects the cameras and the
        horizontal plane), in degrees. Positive roll means the drone is banking to the right. */
    float getRoll();
    /** The amount of simulated time that has passed since the start of the simulation,
        in seconds. */
    float getCurrentTime();

    /** Sets the pitch rate, in degrees per second. */
    void setPitchRate(float value);
    /** Sets the roll rate, in degrees per second. */
    void setRollRate(float value);
    /** Sets the yaw rate (rate at which the drone rotates around the vertical axis (parallel to
        gravity) through the center between the cameras), in degrees per second. Positive
        means the drone turns to the right. */
    void setYawRate(float value);
    /** Sets the thrust (the force exerted by the propellors) in newtons. This force is
        perpendicular to the plane defined by the direction of view and the line connecting
        the cameras. Positive means upward. */
    void setThrust(float value);
}