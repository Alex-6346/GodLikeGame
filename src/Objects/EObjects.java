package Objects;

import java.awt.*;


public class EObjects {
    private Image image;
    private Image changeImage;
    private int x;
    private int y;
    private boolean activated;
    private boolean readyForActivation;

    public EObjects(int x, int y, Image image, Image changeImage, boolean readyForActivation) {
        this.readyForActivation = readyForActivation;
        this.x = x;
        this.y = y;
        this.image = image;
        this.changeImage = changeImage;
        activated = false;
    }

    public void tick() {

    }

    public boolean contains(Point p) {
        if (p.getX() >= x && p.getX() <= image.getWidth(null) + x &&
                p.getY() >= y && p.getY() <= image.getHeight(null) + y) {
            return true;
        }
        return false;
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    public void setChangedImage() {
        image = changeImage;
    }

    public void setActivated(boolean isActivated) {
        activated = isActivated;
    }

    public void setReadyForActivation(boolean isReadyForActivation) {
        readyForActivation = isReadyForActivation;
    }

    public boolean getReadyForActivation() {
        return readyForActivation;
    }

    public boolean isActivated() {
        return activated;
    }
}
