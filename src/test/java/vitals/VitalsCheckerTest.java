package vitals;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
    // ---------- NEW TESTS FOR WARNING EXTENSION ----------

    @Test
    public void temperatureLowWarningTriggered() {
        messages.clear();
        checker.vitalsOk(95.5f, 72f, 98f);
        assertTrue(messages.contains("Warning: Approaching hypothermia"));
    }

    @Test
    public void temperatureHighWarningTriggered() {
        messages.clear();
        checker.vitalsOk(101.5f, 72f, 98f);
        assertTrue(messages.contains("Warning: Approaching hyperthermia"));
    }

    @Test
    public void pulseRateLowWarningTriggered() {
        messages.clear();
        checker.vitalsOk(98.6f, 61f, 95f);
        assertTrue(messages.contains("Warning: Approaching bradycardia"));
    }

    @Test
    public void pulseRateHighWarningTriggered() {
        messages.clear();
        checker.vitalsOk(98.6f, 99f, 95f);
        assertTrue(messages.contains("Warning: Approaching tachycardia"));
    }

    @Test
    public void spo2WarningTriggered() {
        messages.clear();
        checker.vitalsOk(98.6f, 72f, 90.5f);
        assertTrue(messages.contains("Warning: Approaching hypoxemia"));
    }
}


