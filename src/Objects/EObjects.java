package Objects;

import java.awt.*;


public class EObjects {
    private Image image;
    private Image changeImage;
    private int x;
    private int y;
    private String marker;

    public EObjects(int x, int y, Image image, Image changeImage, String marker) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.changeImage = changeImage;
        this.marker = marker;
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

    public String getMarker(){
        return marker;
    }
}
