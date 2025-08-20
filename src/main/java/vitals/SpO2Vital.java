package vitals;

public class SpO2Vital implements Vital {

    private final float min;
    private final String message;

    public SpO2Vital(float min) {
        this.min = min;
        this.message = "Oxygen Saturation out of range!";
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
        float tolerance = min * 0.015f; // 1.5% of lower limit
        if (reading.spo2 <= min + tolerance && reading.spo2 >= min) {
            return "Warning: Approaching hypoxemia";
        }
        return null;
    }
}
