/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.zsurvival;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 *
 * @author s544545
 */
public class Character {
    public String name;
    public Point2D.Double location;
    public double direction;
    public int health;
    public int speed;

    public Character() {}
    public Character(String n, double x, double y, double d, int h, int s) {
        name = n;
        location = new Point2D.Double(x,y);
        direction = d;
        health = h;
        speed = s;


    }

    public String getName(){
        return name;
    }
    public void setName(String n) {
        name = n;
    }

    public Point2D.Double getLocation() {
        return location;
    }
    public void setLocation(double x, double y) {
        location.x = x;
        location.y = y;
    }

    public double getDirection() {
        return direction;
    }
    public  void setDirection(double d){
        direction = d;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int s) {
        speed = s;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int h) {
         health = h;
    }
}
