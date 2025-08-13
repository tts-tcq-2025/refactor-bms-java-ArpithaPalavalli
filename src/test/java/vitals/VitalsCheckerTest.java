package vitals;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VitalsCheckerTest {
    VitalsChecker checker = new VitalsChecker(message -> {});

    @Test
    public void temperatureWithinRangeIsNormal() {
        Vital temp = new TemperatureVital(95, 102);
        assertTrue(temp.isNormal(new VitalReading(98.6f, 70, 95)));
    }

    @Test
    public void temperatureBelowMinIsCritical() {
        Vital temp = new TemperatureVital(95, 102);
        assertFalse(temp.isNormal(new VitalReading(94.9f, 70, 95)));
    }

    @Test
    public void temperatureAboveMaxIsCritical() {
        Vital temp = new TemperatureVital(95, 102);
        assertFalse(temp.isNormal(new VitalReading(102.1f, 70, 95)));
    }

    @Test
    public void pulseRateWithinRangeIsNormal() {
        Vital pulse = new PulseRateVital(60, 100);
        assertTrue(pulse.isNormal(new VitalReading(98.6f, 80, 95)));
    }

    @Test
    public void pulseRateBelowMinIsCritical() {
        Vital pulse = new PulseRateVital(60, 100);
        assertFalse(pulse.isNormal(new VitalReading(98.6f, 59.9f, 95)));
    }

    @Test
    public void pulseRateAboveMaxIsCritical() {
        Vital pulse = new PulseRateVital(60, 100);
        assertFalse(pulse.isNormal(new VitalReading(98.6f, 100.1f, 95)));
    }

    @Test
    public void spo2WithinRangeIsNormal() {
        Vital spo2 = new SpO2Vital(90);
        assertTrue(spo2.isNormal(new VitalReading(98.6f, 80, 95)));
    }

    @Test
    public void spo2BelowMinIsCritical() {
        Vital spo2 = new SpO2Vital(90);
        assertFalse(spo2.isNormal(new VitalReading(98.6f, 80, 89.9f)));
    }
}
