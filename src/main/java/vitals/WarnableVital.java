package vitals;

public interface WarnableVital extends Vital {
    String getWarningMessage(VitalReading reading);
    default boolean isWarning(VitalReading reading) {
        return getWarningMessage(reading) != null;
    }
}
