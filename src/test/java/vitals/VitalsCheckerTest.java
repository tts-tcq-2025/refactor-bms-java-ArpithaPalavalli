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
  }
}

