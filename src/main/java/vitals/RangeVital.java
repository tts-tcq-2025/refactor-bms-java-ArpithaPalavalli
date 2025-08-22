package vitals;

public abstract class RangeVital implements WarnableVital {
    protected final float min;
    protected final float max;
    protected final String message;
    protected final String lowWarningMsg;
    protected final String highWarningMsg;
    private final float tolerance;

    protected RangeVital(float min, float max, String message,
                         String lowWarningMsg, String highWarningMsg) {
        this.min = min;
        this.max = max;
        this.message = message;
        this.lowWarningMsg = lowWarningMsg;
        this.highWarningMsg = highWarningMsg;
        this.tolerance = max * 0.015f; // 1.5% of upper limit
    }

    protected boolean inRange(float value) {
        return value >= min && value <= max;
    }

    protected boolean inLowWarning(float value) {
        return value >= min && value <= (min + tolerance);
    }

    protected boolean inHighWarning(float value) {
        return value >= (max - tolerance) && value <= max;
    }

    @Override
    public String getCriticalMessage() {
        return message;
    }

    @Override
    public String getWarningMessage(VitalReading reading) {
        float value = getVitalValue(reading);
        if (inLowWarning(value)) return lowWarningMsg;
        if (inHighWarning(value)) return highWarningMsg;
        return null;
    }

    protected abstract float getVitalValue(VitalReading reading);
}
