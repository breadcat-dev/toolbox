package cat.breadcat.toolbox.util;

import cat.breadcat.toolbox.constant.MathConstants;
import cat.breadcat.toolbox.exception.InvalidRangeException;

public final class MathUtils
{
    private MathUtils() {}

    public static int wrap(int value, int min, int max)
    {
        if(min == max)
            throw new InvalidRangeException();

        int range = max - min;
        return ((value - min) % range + range) % range + min;
    }
    public static long wrap(long value, long min, long max)
    {
        if(min == max)
            throw new InvalidRangeException();

        long range = max - min;
        return ((value - min) % range + range) % range + min;
    }
    public static float wrap(float value, float min, float max)
    {
        if(Float.compare(min, max) == 0)
            throw new InvalidRangeException();

        float range = max - min;
        return ((value - min) % range + range) % range + min;
    }
    public static double wrap(double value, double min, double max)
    {
        if(Double.compare(min, max) == 0)
            throw new InvalidRangeException();

        double range = max - min;
        return ((value - min) % range + range) % range + min;
    }


    public static float map(float value, float inMin, float inMax, float outMin, float outMax)
    {
        if(Float.compare(inMin, inMax) == 0)
            throw new InvalidRangeException();

        return (value - inMin) / (inMax - inMin) * (outMax - outMin) + outMin;
    }
    public static double map(double value, double inMin, double inMax, double outMin, double outMax)
    {
        if(Double.compare(inMin, inMax) == 0)
            throw new InvalidRangeException();

        return (value - inMin) / (inMax - inMin) * (outMax - outMin) + outMin;
    }


    public static float lerp(float a, float b, float t)
    {
        return a + (b - a) * t;
    }
    public static double lerp(double a, double b, double t)
    {
        return a + (b - a) * t;
    }

    public static float inverseLerp(float a, float b, float v)
    {
        if(Float.compare(a, b) == 0)
            throw new InvalidRangeException();

        return (v - a) / (b - a);
    }
    public static double inverseLerp(double a, double b, double v)
    {
        if(Double.compare(a, b) == 0)
            throw new InvalidRangeException();

        return (v - a) / (b - a);
    }


    public static float smoothstep(float edge0, float edge1, float x)
    {
        if(Float.compare(edge0, edge1) == 0)
            throw new InvalidRangeException();

        float t = Math.clamp((x - edge0) / (edge1 - edge0), 0.0f, 1.0f);
        return t * t * (3.0f - 2.0f * t);
    }
    public static double smoothstep(double edge0, double edge1, double x)
    {
        if(Double.compare(edge0, edge1) == 0)
            throw new InvalidRangeException();

        double t = Math.clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);
        return t * t * (3.0 - 2.0 * t);
    }

    public static float smootherstep(float edge0, float edge1, float x)
    {
        if(Float.compare(edge0, edge1) == 0)
            throw new InvalidRangeException();

        float t = Math.clamp((x - edge0) / (edge1 - edge0), 0.0f, 1.0f);
        return t * t * t * (t * (t * 6 - 15) + 10);
    }
    public static double smootherstep(double edge0, double edge1, double x)
    {
        if(Double.compare(edge0, edge1) == 0)
            throw new InvalidRangeException();

        double t = Math.clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);
        return t * t * t * (t * (t * 6 - 15) + 10);
    }


    public static boolean approximatelyEqual(float num1, float num2, float epsilon)
    {
        if (epsilon <= 0)
            throw new IllegalArgumentException("Epsilon must be positive.");

        return Math.abs(num1 - num2) <= epsilon;
    }
    public static boolean approximatelyEqual(double num1, double num2, double epsilon)
    {
        if (epsilon <= 0)
            throw new IllegalArgumentException("Epsilon must be positive.");

        return Math.abs(num1 - num2) <= epsilon;
    }

    public static boolean approximatelyZero(float num)
    {
        return approximatelyEqual(num, 0.0, MathConstants.STRICT_EPSILON);
    }
    public static boolean approximatelyZero(double num)
    {
        return approximatelyEqual(num, 0.0, MathConstants.STRICT_EPSILON_F);
    }


    public static int sign(int value)
    {
        return Integer.compare(value, 0);
    }
    public static long sign(long value)
    {
        return Long.compare(value, 0);
    }
    public static float sign(float value)
    {
        return Math.signum(value);
    }
    public static double sign(double value)
    {
        return Math.signum(value);
    }


    public static float degToRad(float degrees)
    {
        return degrees * ((float)Math.PI / 180f);
    }
    public static double degToRad(double degrees)
    {
        return degrees * (Math.PI / 180f);
    }

    public static float radToDeg(float radians)
    {
        return radians * (180f / (float)Math.PI);
    }
    public static double radToDeg(double radians)
    {
        return radians * (180f / Math.PI);
    }
}
