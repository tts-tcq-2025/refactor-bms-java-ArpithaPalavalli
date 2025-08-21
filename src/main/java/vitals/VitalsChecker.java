package vitals;

import java.util.ArrayList;
import java.util.List;

public class VitalsChecker extends VitalsCheckerBase {

    public VitalsChecker(CriticalMessageHandler messageHandler) {
        super(messageHandler, createVitals());
    }

    private static List<Vital> createVitals() {
        List<Vital> vitalsList = new ArrayList<>();
        vitalsList.add(new TemperatureVital(95, 102));
        vitalsList.add(new PulseRateVital(60, 100));
        vitalsList.add(new SpO2Vital(90));
        return vitalsList;
    }

    public boolean vitalsOk(float temperature, float pulseRate, float spo2) {
        VitalReading reading = new VitalReading(temperature, pulseRate, spo2);
        boolean allOk = true;
        for (Vital vital : monitoredVitals) {
            allOk &= checkVital(vital, reading);
        }
        return allOk;
    }
}
