package vitals;

public class PulseRateVital extends RangeVital {

    public PulseRateVital(float min, float max) {
        super(min, max,
              "Pulse Rate is out of range!",
              "Warning: Approaching bradycardia",
              "Warning: Approaching tachycardia");
    }

    @Override
    public boolean isNormal(VitalReading reading) {
        return inRange(reading.pulseRate);
    }
    @Override
    protected float extractValue(VitalReading reading) {
        return reading.pulseRate;
    }
}
