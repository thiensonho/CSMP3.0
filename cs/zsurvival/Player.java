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
public class Player extends Character {

    public static Weapon arms;
    public static BufferedImage playerImg = null;

    public Player (String n, double x, double y, int d, int h, int s, Weapon w) {
        super(n,x,y,d,h,s);
        arms = w;
        init();
    }

    public static void init() {
        try {
            playerImg = ImageIO.read(GamePanel.class.getClassLoader().getResourceAsStream("player.png"));
        } catch (IOException e) {
            // not good
            throw new RuntimeException("NO PLAYER IMAGES");
        }
    }
}
