package vitals;

public interface Vital {
    boolean isNormal(VitalReading reading);
    String getCriticalMessage();
}
