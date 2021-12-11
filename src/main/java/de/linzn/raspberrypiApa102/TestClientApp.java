/*
 * Copyright (C) 2019. Niklas Linz - All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the LGPLv3 license, which unfortunately won't be
 * written for another century.
 *
 * You should have received a copy of the LGPLv3 license with
 * this file. If not, please write to: niklas.linz@enigmar.de
 *
 */

package de.linzn.raspberrypiApa102;


import de.linzn.raspberrypiApa102.ledData.LED;
import de.linzn.raspberrypiApa102.ledData.LEDRing;
import de.linzn.raspberrypiApa102.rings.PulseRing;
import de.linzn.raspberrypiApa102.rings.RotatingRing;

public class TestClientApp {
    public static TestClientApp testClientApp;
    public LEDManager ledManager;

    public TestClientApp() {
        testClientApp = this;
        this.ledManager = new LEDManager();
        this.setupLED();
        this.ledManager.init(12);
        try {
            while (true) {
                Thread.sleep(5000);
                this.ledManager.setLEDMode("DISCONNECTED");
                Thread.sleep(5000);
                this.ledManager.setLEDMode("RECORDING");
                Thread.sleep(5000);
                this.ledManager.setLEDMode("NONE");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void setupLED() {
        LEDRing rotatingLEDRing = new RotatingRing(12, 150);
        rotatingLEDRing.setLED(0, new LED(255, 0, 0));
        rotatingLEDRing.setLED(1, new LED(255, 0, 0));
        rotatingLEDRing.setLED(2, new LED(255, 0, 0));
        rotatingLEDRing.setLED(3, new LED(10, 10, 10));
        rotatingLEDRing.setLED(4, new LED(10, 10, 10));
        rotatingLEDRing.setLED(5, new LED(10, 10, 10));
        rotatingLEDRing.setLED(6, new LED(10, 10, 10));
        rotatingLEDRing.setLED(7, new LED(10, 10, 10));
        rotatingLEDRing.setLED(8, new LED(10, 10, 10));
        rotatingLEDRing.setLED(9, new LED(10, 10, 10));
        rotatingLEDRing.setLED(10, new LED(10, 10, 10));
        rotatingLEDRing.setLED(11, new LED(10, 10, 10));
        ledManager.addLEDRing("DISCONNECTED", rotatingLEDRing);

        LEDRing pulsingLEDRing = new PulseRing(12, 8);
        pulsingLEDRing.setLED(0, new LED(0, 95, 255));
        pulsingLEDRing.setLED(1, new LED(0, 0, 255));
        pulsingLEDRing.setLED(2, new LED(0, 95, 255));
        pulsingLEDRing.setLED(3, new LED(10, 10, 10));
        pulsingLEDRing.setLED(4, new LED(10, 10, 10));
        pulsingLEDRing.setLED(5, new LED(10, 10, 10));
        pulsingLEDRing.setLED(6, new LED(0, 95, 255));
        pulsingLEDRing.setLED(7, new LED(0, 0, 255));
        pulsingLEDRing.setLED(8, new LED(0, 95, 255));
        pulsingLEDRing.setLED(9, new LED(10, 10, 10));
        pulsingLEDRing.setLED(10, new LED(10, 10, 10));
        pulsingLEDRing.setLED(11, new LED(10, 10, 10));
        ledManager.addLEDRing("RECORDING", pulsingLEDRing);

        LEDRing noneRing = new RotatingRing(12, 20);
        noneRing.setLED(0, new LED(0, 0, 0));
        noneRing.setLED(1, new LED(0, 0, 0));
        noneRing.setLED(2, new LED(0, 0, 0));
        noneRing.setLED(3, new LED(0, 0, 0));
        noneRing.setLED(4, new LED(0, 0, 0));
        noneRing.setLED(5, new LED(0, 10, 0));
        noneRing.setLED(6, new LED(10, 10, 10));
        noneRing.setLED(7, new LED(0, 0, 0));
        noneRing.setLED(8, new LED(0, 0, 0));
        noneRing.setLED(9, new LED(0, 0, 0));
        noneRing.setLED(10, new LED(0, 0, 0));
        noneRing.setLED(11, new LED(0, 0, 0));
        ledManager.addLEDRing("NONE", noneRing);
    }

    public static void main(String[] args) {

        new TestClientApp();
    }

}
