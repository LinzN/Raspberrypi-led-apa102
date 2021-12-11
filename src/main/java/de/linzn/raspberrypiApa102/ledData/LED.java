package de.linzn.raspberrypiApa102.ledData;

public class LED {
    private final int red;
    private final int green;
    private final int blue;
    private int brightness;

    public LED(int red, int green, int blue) {
        this(red, green, blue, 100);
    }

    public LED(int red, int green, int blue, int brightness) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        setBrightness(brightness);
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public byte[] getLED() {
        double calcRed = red;
        if (calcRed > 0) {
            calcRed = ((red / 100d) * this.brightness);
            if (calcRed < 1) {
                calcRed = 1;
            }
        }

        double calcGreen = green;
        if (calcGreen > 0) {
            calcGreen = ((green / 100d) * this.brightness);
            if (calcGreen < 1) {
                calcGreen = 1;
            }
        }
        double calcBlue = blue;
        if (calcBlue > 0) {
            calcBlue = ((blue / 100d) * this.brightness);
            if (calcBlue < 1) {
                calcBlue = 1;
            }
        }

        return new byte[]{(byte) calcRed, (byte) calcGreen, (byte) calcBlue};
    }

    public int getBrightness() {
        return this.brightness;
    }
}
