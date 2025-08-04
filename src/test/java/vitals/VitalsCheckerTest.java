package vitals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class VitalsCheckerTest {

  @Test
  public void testNotOkWhenAnyVitalIsOffRange() throws InterruptedException {
    assertFalse(VitalsChecker.vitalsOk(99f, 102, 70));
    assertTrue(VitalsChecker.vitalsOk(98.1f, 70, 98));
    //added new test to cover all conditions
    assertFalse(VitalsChecker.vitalsOk(93f, 98, 50));
    assertFalse(VitalsChecker.vitalsOk(102f, 70, 98)); // High critical temperature
    assertFalse(VitalsChecker.vitalsOk(94f, 70, 98));  // Low critical temperature
    assertFalse(VitalsChecker.vitalsOk(98f, 61, 98));  // Just above min pulse rate
    assertFalse(VitalsChecker.vitalsOk(98f, 99, 98));  // Just above max pulse rate
    assertFalse(VitalsChecker.vitalsOk(98f, 70, 89));  // Just below min SpO2
    assertTrue(VitalsChecker.vitalsOk(95f, 60, 90));   // All at minimum limits
    assertFalse(VitalsChecker.vitalsOk(102f, 100, 90)); // Temperature and Pulse rate at maximum limits
  }
}




