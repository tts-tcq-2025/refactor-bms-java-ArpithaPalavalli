package vitals;

import java.util.ArrayList;
import java.util.List;

public class VitalsCheckerWithEarlyWarning {

    private final List<Vital> vitals = new ArrayList<>();
    private final CriticalMessageHandler messageHandler;

    public VitalsCheckerWithEarlyWarning(CriticalMessageHandler messageHandler) {
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
            } else {
                checkWarning(vital, reading);
            }
        }
        return allOk;
    }

    private void checkWarning(Vital vital, VitalReading reading) {
        if (vital instanceof TemperatureVital) {
            float min = 95f;
            float max = 102f;
            float tolerance = max * 0.015f;

            if (reading.temperature <= min + tolerance) {
                messageHandler.handle("Warning: Approaching hypothermia");
            } else if (reading.temperature >= max - tolerance) {
                messageHandler.handle("Warning: Approaching hyperthermia");
            }

        } else if (vital instanceof PulseRateVital) {
            float min = 60f;
            float max = 100f;
            float tolerance = max * 0.015f;

            if (reading.pulseRate <= min + tolerance) {
                messageHandler.handle("Warning: Approaching bradycardia");
            } else if (reading.pulseRate >= max - tolerance) {
                messageHandler.handle("Warning: Approaching tachycardia");
            }

        } else if (vital instanceof SpO2Vital) {
            float min = 90f;
            float tolerance = min * 0.015f;

            if (reading.spo2 <= min + tolerance && reading.spo2 >= min) {
                messageHandler.handle("Warning: Approaching hypoxemia");
            }
        }
    }
}
