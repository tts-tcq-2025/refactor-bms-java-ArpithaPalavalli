package vitals;

public interface Vital {
    boolean isNormal(VitalReading reading);
    String getCriticalMessage();
}
default String getWarningMessage(VitalReading reading) {
        return null;
    }
