package vitals;

public abstract class RangeVital implements Vital {
    protected final float min;
    protected final float max;
    protected final String message;

    protected RangeVital(float min, float max, String message) {
        this.min = min;
        this.max = max;
        this.message = message;
    }

    protected boolean inRange(float value) {
        return value >= min && value <= max;
    }

    @Override
    public String getCriticalMessage() {
        return message;
    }
}
