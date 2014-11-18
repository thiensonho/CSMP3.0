/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.zsurvival;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author s544545
 */
public class Bullet {
    public Point2D.Double location;
    public double direction;
    public static BufferedImage bulletImg = null;
    public AffineTransform xform;

    public Bullet (double x, double y, double d) {
        location = new Point2D.Double(x,y);
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
