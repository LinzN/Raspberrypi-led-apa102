package de.linzn.raspberrypiApa102.rings;

import de.linzn.raspberrypiApa102.ledData.LED;
import de.linzn.raspberrypiApa102.ledData.LEDRing;

public class RotatingRing extends LEDRing {

    public RotatingRing(int ledSize) {
        super(ledSize, 80);
    }

    public RotatingRing(int ledSize, int speed) {
        super(ledSize, speed);
    }

    public void animate() {
        int n = ledRingArray.length;
        LED temp = ledRingArray[n - 1];
        System.arraycopy(ledRingArray, 0, ledRingArray, 1, n - 1);
        ledRingArray[0] = temp;
    }
}
