package vitals;

public class SpO2Vital implements Vital {
    private final float min;
    private final String message;
    private final String warningMsg;

    public SpO2Vital(float min) {
        this.min = min;
        this.message = "Oxygen Saturation out of range!";
        this.warningMsg = "Warning: Approaching hypoxemia";
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
        float tol = tolerance(min);

        if (reading.spo2 >= min) {
            if (reading.spo2 <= min + tol) {
                return warningMsg;
            }
        }
        return null;
    }
}
