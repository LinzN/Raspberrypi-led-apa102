package de.linzn.raspberrypiApa102.rings;

import de.linzn.raspberrypiApa102.ledData.LED;
import de.linzn.raspberrypiApa102.ledData.LEDRing;

public class PulseRing extends LEDRing {

    private int brightness = 10;
    private boolean high;

    public PulseRing(int ledSize) {
        super(ledSize, 20);
        high = true;
    }

    public PulseRing(int ledSize, int speed) {
        super(ledSize, speed);
    }

    public void animate() {
        for (LED led : this.ledRingArray) {
            led.setBrightness(brightness);
        }
        if (high) {
            brightness += 1;
            if (brightness >= 100) {
                brightness = 100;
                high = false;
            }
        } else {
            brightness -= 1;
            if (brightness <= 10) {
                brightness = 10;
                high = true;
            }
        }
    }
}
