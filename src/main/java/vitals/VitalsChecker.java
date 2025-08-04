package vitals;

public abstract class VitalsChecker {
    static final float MAX_TEMPERATURE = 102;
    static final float MIN_TEMPERATURE = 95;
    static final float MAX_PULSE_RATE = 100;
    static final float MIN_PULSE_RATE = 60;
    static final float MIN_SPO2 = 90;

    static boolean vitalsOk(float temperature, float pulseRate, float spo2) throws InterruptedException {
        String errorMessage = null;
        boolean isOk = true;

        if (!checkValue(temperature, MIN_TEMPERATURE, MAX_TEMPERATURE, "Temperature is critical!")) {
            errorMessage = "Temperature is critical!";
            isOk = false;
        }
        if (!checkValue(pulseRate, MIN_PULSE_RATE, MAX_PULSE_RATE, "Pulse Rate is out of range!")) {
            errorMessage = "Pulse Rate is out of range!";
            isOk = false;
        }
        if (!checkValue(spo2, MIN_SPO2, Float.MAX_VALUE, "Oxygen Saturation out of range!")) {
            errorMessage = "Oxygen Saturation out of range!";
            isOk = false;
        }

        if (!isOk && errorMessage != null) {
            displayCriticalMessage(errorMessage);
        }

        return isOk;
    }

    private static boolean checkValue(float value, float min, float max, String errorMessage) {
        return value >= min && value <= max;
    }

    private static void displayCriticalMessage(String message) throws InterruptedException {
        System.out.println(message);
        animateWarning();
    }

    private static void animateWarning() throws InterruptedException {
        for (int i = 0; i < 6; i++) {
            System.out.print("\r* ");
            Thread.sleep(1000);
            System.out.print("\r *");
            Thread.sleep(1000);
        }
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
