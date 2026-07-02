package cat.breadcat.toolbox.util;

/**
 * Provides common mathematical helper methods such as interpolation,
 * range mapping, wrapping, angle conversion, and floating-point comparison.
 *
 * <p>These utilities are useful in graphics, games, simulations,
 * and general-purpose applications.</p>
 */
public final class MathUtil
{
    private MathUtil() {}


    /**
     * Restricts a value to the specified range.
     *
     * @param value the value to clamp
     * @param min the minimum allowed value
     * @param max the maximum allowed value
     * @return {@code value} if it is within the range, otherwise {@code min} or {@code max}
     */
    public static int clamp(int value, int min, int max)
    {
        return (value > max) ? max : ((value < min) ? min : value);
    }

    /**
     * @see #clamp(int, int, int)
     */
    public static long clamp(long value, long min, long max)
    {
        return (value > max) ? max : ((value < min) ? min : value);
    }

    /**
     * @see #clamp(int, int, int)
     */
    public static float clamp(float value, float min, float max)
    {
        return (value > max) ? max : ((value < min) ? min : value);
    }

    /**
     * @see #clamp(int, int, int)
     */
    public static double clamp(double value, double min, double max)
    {
        return (value > max) ? max : ((value < min) ? min : value);
    }


    /**
     * Wraps a value into the half-open interval {@code [min, max)}.
     *
     * <p>Unlike {@link #clamp(int, int, int)}, values outside the range wrap
     * around instead of being limited.</p>
     *
     * <pre>
     * wrap(361, 0, 360) == 1
     * wrap(-1, 0, 360) == 359
     * </pre>
     *
     * @param value the value to wrap
     * @param min the inclusive lower bound
     * @param max the exclusive upper bound
     * @return the wrapped value
     * @throws IllegalArgumentException if {@code min == max}
     */
    public static int wrap(int value, int min, int max)
    {
        if (min == max)
            throw new IllegalArgumentException("The lower bound must not be equal to upper bound");

        int range = max - min;
        return ((value - min) % range + range) % range + min;
    }

    /**
     * @see #wrap(int, int, int)
     */
    public static long wrap(long value, long min, long max)
    {
        if (min == max)
            throw new IllegalArgumentException("The lower bound must not be equal to upper bound");

        long range = max - min;
        return ((value - min) % range + range) % range + min;
    }

    /**
     * @see #wrap(int, int, int)
     */
    public static float wrap(float value, float min, float max)
    {
        if (min == max)
            throw new IllegalArgumentException("The lower bound must not be equal to upper bound");

        float range = max - min;
        return ((value - min) % range + range) % range + min;
    }

    /**
     * @see #wrap(int, int, int)
     */
    public static double wrap(double value, double min, double max)
    {
        if (min == max)
            throw new IllegalArgumentException("The lower bound must not be equal to upper bound");

        double range = max - min;
        return ((value - min) % range + range) % range + min;
    }


    /**
     * Linearly interpolates between two values.
     *
     * @param a the value when interpolation is {@code 0}
     * @param b the value when interpolation is {@code 1}
     * @param t interpolation factor, typically in the range {@code [0, 1]}
     * @return the interpolated value
     */
    public static float lerp(float a, float b, float t)
    {
        return a + (b - a) * t;
    }

    /**
     * @see #lerp(float, float, float)
     */
    public static double lerp(double a, double b, double t)
    {
        return a + (b - a) * t;
    }


    /**
     * Computes the interpolation factor of a value within a range.
     *
     * <pre>
     * inverseLerp(10, 20, 15) == 0.5
     * </pre>
     *
     * @param a the start of the range
     * @param b the end of the range
     * @param v the value to evaluate
     * @return the interpolation factor
     * @throws IllegalArgumentException if {@code a == b}
     */
    public static float inverseLerp(float a, float b, float v)
    {
        if (a == b)
            throw new IllegalArgumentException("Start of the range must not be equal to end");

        return (v - a) / (b - a);
    }

    /**
     * @see #inverseLerp(float, float, float)
     */
    public static double inverseLerp(double a, double b, double v)
    {
        if (a == b)
            throw new IllegalArgumentException("Start of the range must not be equal to end");

        return (v - a) / (b - a);
    }


    /**
     * Smoothly interpolates between two edges using cubic interpolation.
     *
     * <p>The returned value transitions smoothly from {@code 0} to {@code 1}
     * as {@code x} moves from {@code start} to {@code end}.</p>
     *
     * @param edge0 the lower edge
     * @param edge1 the upper edge
     * @param x the input value
     * @return the smoothed interpolation value
     * @throws IllegalArgumentException if {@code edge0 == edge1}
     */
    public static float smoothstep(float edge0, float edge1, float x)
    {
        if (edge0 == edge1)
            throw new IllegalArgumentException("The lower edge must not be equal to the upper edge");

        float t = clamp((x - edge0) / (edge1 - edge0), 0.0f, 1.0f);
        return t * t * (3.0f - 2.0f * t);
    }

    /**
     * @see #smoothstep(float, float, float)
     */
    public static double smoothstep(double edge0, double edge1, double x)
    {
        if (edge0 == edge1)
            throw new IllegalArgumentException("The lower edge must not be equal to the upper edge");

        double t = clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);
        return t * t * (3.0 - 2.0 * t);
    }

    /**
     * Smoothly interpolates between two edges using quintic interpolation.
     *
     * <p>Produces smoother transitions than {@link #smoothstep(float, float, float)}
     * because both the first and second derivatives are zero at the endpoints.</p>
     */
    public static float smootherstep(float edge0, float edge1, float x)
    {
        if (edge0 == edge1)
            throw new IllegalArgumentException("The lower edge must not be equal to the upper edge");

        float t = clamp((x - edge0) / (edge1 - edge0), 0.0f, 1.0f);
        return t * t * t * (t * (t * 6 - 15) + 10);
    }

    /**
     * @see #smoothstep(float, float, float)
     */
    public static double smootherstep(double edge0, double edge1, double x)
    {
        if (edge0 == edge1)
            throw new IllegalArgumentException("The lower edge must not be equal to the upper edge");

        double t = clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);
        return t * t * t * (t * (t * 6 - 15) + 10);
    }


    /**
     * Maps a value from one range to another.
     *
     * <pre>
     * map(5, 0, 10, 0, 100) == 50
     * </pre>
     *
     * @param value the value to map
     * @param inMin the lower bound of the input range
     * @param inMax the upper bound of the input range
     * @param outMin the lower bound of the output range
     * @param outMax the upper bound of the output range
     * @return the mapped value
     * @throws IllegalArgumentException if {@code inMin == inMax}
     */
    public static float map(float value, float inMin, float inMax, float outMin, float outMax)
    {
        if (inMin == inMax)
            throw new IllegalArgumentException("The lower bound of the input range must not be equal to the upper bound");

        return (value - inMin) / (inMax - inMin) * (outMax - outMin) + outMin;
    }

    /**
     * @see #map(float, float, float, float, float)
     */
    public static double map(double value, double inMin, double inMax, double outMin, double outMax)
    {
        if (inMin == inMax)
            throw new IllegalArgumentException("The lower bound of the input range must not be equal to the upper bound");

        return (value - inMin) / (inMax - inMin) * (outMax - outMin) + outMin;
    }


    /**
     * Determines whether two floating-point values are equal within a tolerance.
     *
     * @param num1 the first value
     * @param num2 the second value
     * @param epsilon the maximum allowed difference
     * @return {@code true} if the values differ by at most {@code epsilon}
     */
    public static boolean approximatelyEqual(float num1, float num2, float epsilon)
    {
        if (epsilon <= 0)
            throw new IllegalArgumentException("Epsilon must be positive.");

        return Math.abs(num1 - num2) <= epsilon;
    }

    /**
     * @see #approximatelyEqual(float, float, float)
     */
    public static boolean approximatelyEqual(double num1, double num2, double epsilon)
    {
        if (epsilon <= 0)
            throw new IllegalArgumentException("Epsilon must be positive.");

        return Math.abs(num1 - num2) <= epsilon;
    }


    /**
     * Computes the sign of the {@code value}
     *
     * <pre>
     * sign(-54) == -1
     * </pre>
     *
     * @param value the value whose sign is to be returned
     * @return the sign
     */
    public static int sign(int value)
    {
        return Integer.compare(value, 0);
    }

    /**
     * @see #sign(int)
     */
    public static long sign(long value)
    {
        return Long.compare(value, 0);
    }

    /**
     * @see #sign(int)
     */
    public static float sign(float value)
    {
        return Math.signum(value);
    }

    /**
     * @see #sign(int)
     */
    public static double sign(double value)
    {
        return Math.signum(value);
    }


    /**
     * Converts an angle from degrees to radians.
     *
     * @param degrees the angle in degrees
     * @return the angle in radians
     */
    public static float degToRad(float degrees)
    {
        return degrees * ((float)Math.PI / 180f);
    }

    /**
     * @see #degToRad(float)
     */
    public static double degToRad(double degrees)
    {
        return degrees * (Math.PI / 180f);
    }


    /**
     * Converts an angle from radians to degrees.
     *
     * @param radians the angle in radians
     * @return the angle in degrees
     */
    public static float radToDeg(float radians)
    {
        return radians * (180f / (float)Math.PI);
    }

    /**
     * @see #radToDeg(float)
     */
    public static double radToDeg(double radians)
    {
        return radians * (180f / Math.PI);
    }
}
