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
public class Player extends Character {

    public static Weapon arms;
    
    public Player (String n, Point p, int d, int h, int s, Weapon w) {
        super(n,p,d,h,s);
        arms = w;
    }
}
