package p_en_o_cw_2016;

/** A camera that can be thought of as a pinhole camera with a flat sensor. Each
    pixel is the same size (in meters), so they are not the same angular size when
    perceived from the pinhole. */
public interface Camera {
    /** Angle of view in degrees. */
    float getHorizontalAngleOfView();
    /** Angle of view in degrees. */
    float getVerticalAngleOfView();
    /** The width in pixels. */
    int getWidth();
    /** Returns an array of width x height elements. The element at index r * width + c
        represents the pixel at row r and column c, where row 0 is the topmost row
        (bottommost on the sensor) and column 0 is the leftmost column (rightmost on
        the sensor). A pixel with value (R,G,B) is encoded as R | G << 8 | B << 16. */
    int[] takeImage();
}