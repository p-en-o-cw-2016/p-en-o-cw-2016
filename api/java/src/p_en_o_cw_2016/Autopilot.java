package p_en_o_cw_2016;

public interface Autopilot {
    /** Called by the testbed in the AWT/Swing GUI thread at a high (but possibly variable)
        frequency, after simulated time has advanced and the simulated world has been
        updated to a new state. Simulated time is frozen for the duration of this call. */
    void timeHasPassed();
}