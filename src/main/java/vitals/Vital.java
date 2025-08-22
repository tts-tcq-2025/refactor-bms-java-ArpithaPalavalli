package vitals;

public interface Vital {
    boolean isNormal(VitalReading reading);
    String getCriticalMessage();
    String getWarningMessage(VitalReading reading);

    // Helper: calculate tolerance
    default float tolerance(float base) {
        return base * 0.015f;
    }
}
