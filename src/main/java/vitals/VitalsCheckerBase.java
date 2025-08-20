package vitals;

import java.util.List;

public abstract class VitalsCheckerBase {
    protected final List<Vital> vitals;
    protected final CriticalMessageHandler messageHandler;

    protected VitalsCheckerBase(CriticalMessageHandler messageHandler, List<Vital> vitals) {
        this.messageHandler = messageHandler;
        this.vitals = vitals;
    }

    protected boolean checkVital(Vital vital, VitalReading reading) {
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
