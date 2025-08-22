package vitals;

public class VitalReading {
    public final float temperature;
    public final float pulseRate;
    public final float spo2;

    public VitalReading(float temperature, float pulseRate, float spo2) {
        this.temperature = temperature;
        this.pulseRate = pulseRate;
        this.spo2 = spo2;
    }
}
