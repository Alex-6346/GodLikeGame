package Objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Images {
    private BufferedImage[] blocks;
    public Images(){
        blocks=new BufferedImage[1];
        try{
            blocks[0] = ImageIO.read(getClass().getResourceAsStream(""));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

