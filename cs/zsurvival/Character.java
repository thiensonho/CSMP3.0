/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.zsurvival;

import java.awt.Point;

/**
 *
 * @author s544545
 */
public class Character {
    public static String name;
    public static Point location;
    public static int direction;
    public static int health;
    public static int speed;

    public Character() {}
    public Character(String n, Point p, int d, int h, int s) {
        name = n;
        location = p;
        direction = d;
        health = h;
        speed = s;

    }
}
