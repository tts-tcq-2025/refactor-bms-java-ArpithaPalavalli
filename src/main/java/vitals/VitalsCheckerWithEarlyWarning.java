package vitals;

import java.util.List;
import java.util.Arrays;

public class VitalsCheckerWithEarlyWarning {
    private final List<Vital> vitals;
    private final CriticalMessageHandler messageHandler;

    public VitalsCheckerWithEarlyWarning(CriticalMessageHandler messageHandler) {
        this.messageHandler = messageHandler;
        this.vitals = Arrays.asList(
            new TemperatureVital(95, 102),
            new PulseRateVital(60, 100),
            new SpO2Vital(90)
        );
    }

    public boolean vitalsOk(float temperature, float pulseRate, float spo2) {
    VitalReading reading = new VitalReading(temperature, pulseRate, spo2);
    return vitals.stream().allMatch(v -> checkVital(v, reading));
}

    private boolean checkVital(Vital vital, VitalReading reading) {
        if (!vital.isNormal(reading)) {
            messageHandler.handle(vital.getCriticalMessage());
            return false;
        }
        String warning = vital.getWarningMessage(reading);
         if (warning != null) {
        messageHandler.handle(warning);
    }
        return true;
    }
}
