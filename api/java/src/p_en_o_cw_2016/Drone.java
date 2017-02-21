package p_en_o_cw_2016;

/** Interface between an autopilot and (real or simulated) drone hardware.
    In the world coordinate system, the direction of gravity is 0 -1 0.
    The coordinate system is right-handed: if 0 -1 0 is down and 0 0 -1 is forward,
    then 1 0 0 is to the right.
    */
public interface Drone {
    /** The distance between the cameras, in meters. Note: the (pinholes of the)
        cameras are on the pitch axis, so pitching rotates the cameras but does not
        translate them. */
    float getCameraSeparation();
    Camera getLeftCamera();
    Camera getRightCamera();
    /** The weight in kg. */
    float getWeight();
    /** The gravity in newtons per kg. */
    float getGravity();
    /** The drag force per unit of speed, in kilograms per second. This drone is highly
        aerodynamic, so the drag force is linear in the speed. */
    float getDrag();
    /** Gets the maximum of the absolute value of the thrust, in newtons. */
    float getMaxThrust();
    float getMaxPitchRate();
    float getMaxRollRate();
    float getMaxYawRate();

    /** The X coordinate, in world coordinates, of the center between the camera pinholes. */
    float getX();
    /** The Y coordinate, in world coordinates, of the center between the camera pinholes. */
    float getY();
    /** The Z coordinate, in world coordinates, of the center between the camera pinholes. */
    float getZ();
    /** The current heading angle (the angle, in degrees, between the cross product of
        the direction of view and positive Y, and positive X).
        A positive heading means the drone is heading towards positive X.
        This value is always between -180 and 180. */
    float getHeading();
    /** The current pitch angle (the angle between the direction of view and the horizontal
        plane), in degrees. A positive pitch angle means the drone is looking down.
        This value is always between -90 and 90. */
    float getPitch();
    /** The current roll angle (the angle between the line that connects the cameras and the
        horizontal line perpendicular to the direction of view), in degrees.
        A positive roll angle means the drone is banking to the right.
        This value is always between -180 and 180. If the absolute value is greater than
        90, this means the drone is upside down. */
    float getRoll();
    /** The amount of simulated time that has passed since the start of the simulation,
        in seconds.
        
        The value 0 indicates that a new simulation has started and that the autopilot should
        reset its state. */
    float getCurrentTime();

    /** Sets the pitch rate (the rate of rotation around the line that connects the cameras),
        in degrees per second. At each point in time between this call and the next call of this method,
        the rate of rotation of the drone around the line that connects the cameras at that point in time
        will be the given value (except for wind influences).
        Note that the pitch rate is NOT always equal to the rate of change of the pitch angle.
        Specifically, the pitch rate is equal to the rate of change of the pitch angle if and only if
        the roll angle is zero. */
    void setPitchRate(float value);
    /** Sets the roll rate, in degrees per second. This equals the rate of change of the roll angle. */
    void setRollRate(float value);
    /** Sets the yaw rate (rate at which the drone rotates around the axis through the center
        between the cameras, perpendicular to the line that connects the cameras and the direction of view),
        in degrees per second. A positive yaw rate means the drone turns to the right (from the point of view
        of someone fixed to the drone and looking in the direction of view, such that the left camera is to
        their left-hand side and the right camera is to their right-hand side).
        At each point in time between this call and the next call of this method, the rate of rotation of the
        drone around the axis through the center of the cameras, perpendicular to the line that connects the cameras
        and the direction of view at that point in time will be the given value (except for wind influences). */
    void setYawRate(float value);
    /** Sets the thrust (the force exerted by the propellors) in newtons. This force is
        perpendicular to the plane defined by the direction of view and the line connecting
        the cameras. Positive means upward (from the point of view of someone fixed to the drone, looking in
        the direction of view, such that the left camera is to their left-hand side and the right camera is to their
        right-hand side). */
    void setThrust(float value);
}
