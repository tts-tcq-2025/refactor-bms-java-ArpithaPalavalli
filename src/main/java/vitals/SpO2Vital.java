package vitals;

public class SpO2Vital implements WarnableVital {
    private final float min;
    private final String message;
    private final String warningMessage;
    private final float tolerance;

    public SpO2Vital(float min) {
        this.min = min;
        this.message = "Oxygen Saturation out of range!";
        this.warningMessage = "Warning: Approaching hypoxemia";
        this.tolerance = min * 0.015f; // 1.5% of threshold
    }

    @Override
    public boolean isNormal(VitalReading reading) {
        return reading.spo2 >= min;
    }

    @Override
    public String getCriticalMessage() {
        return message;
    }

    @Override
    public String getWarningMessage(VitalReading reading) {
        return (reading.spo2 < (min + tolerance) && reading.spo2 >= min)
                ? warningMessage : null;
    }
}
