package vitals;

import java.util.ArrayList;
import java.util.List;

public class VitalsChecker {

    private final List<Vital> vitals = new ArrayList<>();
    private final CriticalMessageHandler messageHandler;

    public VitalsChecker(CriticalMessageHandler messageHandler) {
        this.messageHandler = messageHandler;
        vitals.add(new TemperatureVital(95, 102));
        vitals.add(new PulseRateVital(60, 100));
        vitals.add(new SpO2Vital(90));
    }

    public boolean vitalsOk(float temperature, float pulseRate, float spo2) {
        VitalReading reading = new VitalReading(temperature, pulseRate, spo2);
        boolean allOk = true;

        for (Vital vital : vitals) {
            if (!vital.isNormal(reading)) {
                messageHandler.handle(vital.getCriticalMessage());
                allOk = false;
            }
        }
        return allOk;
    }
}
