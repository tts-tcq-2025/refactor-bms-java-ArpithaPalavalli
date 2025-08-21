package vitals;

import java.util.Arrays;

public class VitalsCheckerWithEarlyWarning extends VitalsCheckerBase {

    public VitalsCheckerWithEarlyWarning(CriticalMessageHandler messageHandler) {
        super(messageHandler, Arrays.asList(
            new TemperatureVital(95, 102),
            new PulseRateVital(60, 100),
            new SpO2Vital(90)
        ));
    }

    public boolean vitalsOk(float temperature, float pulseRate, float spo2) {
        VitalReading reading = new VitalReading(temperature, pulseRate, spo2);
        return monitoredVitals.stream().allMatch(vital -> checkVital(vital, reading));
    }
}
