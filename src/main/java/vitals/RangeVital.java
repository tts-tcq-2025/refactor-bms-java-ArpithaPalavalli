package vitals;

public abstract class RangeVital implements Vital {
    protected final float min;
    protected final float max;
    protected final String message;
    private final String lowMsg;
    private final String highMsg;

    protected RangeVital(float min, float max, String message, String lowMsg, String highMsg) {
        this.min = min;
        this.max = max;
        this.message = message;
        this.lowMsg = lowMsg;
        this.highMsg = highMsg;
    }

    protected boolean inRange(float value) {
        return value >= min && value <= max;
    }

    @Override
    public String getCriticalMessage() {
        return message;
    }

    @Override
    public String getWarningMessage(VitalReading reading) {
        float value = extractValue(reading);
        float tol = tolerance(max);

        return (value <= min + tol) ? lowMsg :
               (value >= max - tol) ? highMsg : null;
    }

    // Each subclass tells which value to check
    protected abstract float extractValue(VitalReading reading);
}
