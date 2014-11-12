/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.zsurvival;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author s544545
 */
public class Bullet {
    public Point location;
    public double direction;
    public static BufferedImage bulletImg = null;

    public Bullet (int x, int y, double d) {
        location = new Point(x,y);
        direction = d;
        init();
    }

    public static void init() {
        try {
            bulletImg = ImageIO.read(GamePanel.class.getClassLoader().getResourceAsStream("bullet.png"));
        } catch (IOException e) {
            // not good
            throw new RuntimeException("NO BULLET IMAGES");
        }
    }


}
