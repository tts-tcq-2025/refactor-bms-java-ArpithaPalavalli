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






// package vitals;


// public abstract class VitalsChecker {
//   static boolean vitalsOk(float temperature, float pulseRate, float spo2) 
//       throws InterruptedException {
//     if (temperature > 102 || temperature < 95) {
//       System.out.println("Temperature is critical!");
//       for (int i = 0; i < 6; i++) {
//         System.out.print("\r* ");
//         Thread.sleep(1000);
//         System.out.print("\r *");
//         Thread.sleep(1000);
//       }
//       return false;
//     } else if (pulseRate < 60 || pulseRate > 100) {
//       System.out.println("Pulse Rate is out of range!");
//       for (int i = 0; i < 6; i++) {
//         System.out.print("\r* ");
//         Thread.sleep(1000);
//         System.out.print("\r *");
//         Thread.sleep(1000);
//       }
//       return false;
//     } else if (spo2 < 90) {
//       System.out.println("Oxygen Saturation out of range!");
//       for (int i = 0; i < 6; i++) {
//         System.out.print("\r* ");
//         Thread.sleep(1000);
//         System.out.print("\r *");
//         Thread.sleep(1000);
//       }
//       return false;
//     }
//     return true;
//   }
// }
