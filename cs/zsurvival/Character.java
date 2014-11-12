/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.zsurvival;

import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author s544545
 */
public class Character {
    public String name;
    public Point location;
    public double direction;
    public int health;
    public int speed;

    public Character() {}
    public Character(String n, Point p, double d, int h, int s) {
        name = n;
        location = p;
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

    public Point getLocation() {
        return location;
    }
    public void setLocation(int x, int y) {
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
