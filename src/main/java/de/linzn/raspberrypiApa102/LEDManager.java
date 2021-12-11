package de.linzn.raspberrypiApa102;

import de.linzn.raspberrypiApa102.ledData.LED;
import de.linzn.raspberrypiApa102.ledData.LEDRing;
import de.linzn.raspberrypiApa102.rings.RotatingRing;
import de.linzn.raspberrypiApa102.lib.Apa102Output;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Executors;

public class LEDManager implements Runnable {
    private int SPEED = 10;
    private boolean inLoop;
    private String ledMode;
    private LEDRing ledRing;
    private Apa102Output apa102Output;
    private final HashMap<String, LEDRing> modeRings;

    public LEDManager() {
        this.modeRings = new HashMap<>();
    }

    public void init(int LED_SIZE) {
        this.inLoop = true;
        this.setLEDMode("NONE");
        try {
            Apa102Output.initSpi();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.apa102Output = new Apa102Output(LED_SIZE);
        Executors.newSingleThreadExecutor().submit(this);
    }

    public void addLEDRing(String ledMode, LEDRing ledRing) {
        this.modeRings.put(ledMode, ledRing);
    }

    public void setLEDMode(String ledMode) {
        this.ledMode = ledMode.toUpperCase();

        System.out.println("Set MODE to " + this.ledMode);

        if (this.modeRings.containsKey(this.ledMode)) {
            this.ledRing = this.modeRings.get(this.ledMode).clone();
        } else {
            System.out.println("No LED Ring found. Use Fallback");
            this.ledRing = this.fallbackRing();
        }
        this.SPEED = ledRing.getSpeed();
    }


    @Override
    public void run() {
        while (this.inLoop) {
            try {
                this.apa102Output.writeStrip(this.ledRing.generateByteLED());
                if (!ledMode.equalsIgnoreCase("NONE")) {
                    this.ledRing.animate();
                }
                Thread.sleep(SPEED);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private LEDRing fallbackRing() {
        LEDRing ledRing = new RotatingRing(12, 150);
        ledRing.setLED(0, new LED(10, 10, 10));
        ledRing.setLED(1, new LED(0, 0, 0));
        ledRing.setLED(2, new LED(10, 10, 10));
        ledRing.setLED(3, new LED(0, 0, 0));
        ledRing.setLED(4, new LED(10, 10, 10));
        ledRing.setLED(5, new LED(0, 0, 0));
        ledRing.setLED(6, new LED(10, 10, 10));
        ledRing.setLED(7, new LED(0, 0, 0));
        ledRing.setLED(8, new LED(10, 10, 10));
        ledRing.setLED(9, new LED(0, 0, 0));
        ledRing.setLED(10, new LED(10, 10, 10));
        ledRing.setLED(11, new LED(0, 0, 0));
        return ledRing;
    }
}
