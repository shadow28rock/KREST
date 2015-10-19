package sample.view;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by 803581 on 06.10.2015.
 */
public class Background {
   BufferedImage img = new BufferedImage(320,240,BufferedImage.TYPE_3BYTE_BGR);
    Graphics2D g2d = img.createGraphics();
    public void Draw() {
        try {
            g2d.setColor(Color.white);
            g2d.fillRect(0, 0, 320, 240);

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

            g2d.setColor(Color.BLUE);
            g2d.setStroke(new BasicStroke(30.f));

            g2d.drawLine(0, 0, 320, 240);
            g2d.drawLine(0, 240, 320, 0);

            g2d.setColor(Color.GREEN);
            g2d.setFont(new Font("Arial", Font.PLAIN, 25));

            g2d.drawString("1712", 130, 60);
        }
        finally {
            g2d.dispose();
        }
    }
}
