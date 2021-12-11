package de.linzn.raspberrypiApa102.ledData;

public abstract class LEDRing implements Cloneable {
    protected LED[] ledRingArray;
    protected int ledSize;
    protected int speed;

    public LEDRing(int ledSize, int speed) {
        this.ledSize = ledSize;
        this.ledRingArray = new LED[ledSize];
        this.speed = speed;
    }

    public void setLED(int index, LED led) {
        this.ledRingArray[index] = led;
    }

    public byte[] generateByteLED() {
        byte[] ringByteArray = new byte[ledSize * 3];
        int i = 0;
        for (LED led : ledRingArray) {
            ringByteArray[i + 0] = led.getLED()[0];
            ringByteArray[i + 1] = led.getLED()[1];
            ringByteArray[i + 2] = led.getLED()[2];
            i += 3;
        }
        return ringByteArray;
    }
    public abstract void animate();

    public int getSpeed() {
        return speed;
    }

    @Override
    public LEDRing clone() {
        try {
            return (LEDRing) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
