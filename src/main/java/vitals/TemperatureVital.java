package vitals;

public class TemperatureVital extends RangeVital {

    public TemperatureVital(float min, float max) {
        super(min, max, "Temperature is critical!");
    }

    @Override
    public boolean isNormal(VitalReading reading) {
        return inRange(reading.temperature);
    }
}
