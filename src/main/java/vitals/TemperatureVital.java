package vitals;

public class TemperatureVital extends RangeVital {
    public TemperatureVital(float min, float max) {
        super(min, max,
              "Temperature is critical!",
              "Warning: Approaching hypothermia",
              "Warning: Approaching hyperthermia");
    }

    @Override
    public boolean isNormal(VitalReading reading) {
        return inRange(reading.temperature);
    }

    @Override
    protected float getVitalValue(VitalReading reading) {
        return reading.temperature;
    }
}
