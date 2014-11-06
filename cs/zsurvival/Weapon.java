/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs.zsurvival;

/**
 *
 * @author s544545
 */
public class Weapon {
    public int rateOfFire;
    public int damage;
    public int ammo;

    public Weapon(int r, int d, int a) {
        rateOfFire = r;
        damage = d;
        ammo = a;
    }

    public int getAmmo() {
        return ammo;
    }

    public int getDamage() {
        return damage;
    }

    public int getRateOfFire() {
        return rateOfFire;
    }

    public void setAmmo(int a) {
        ammo = a;
    }

    public void setDamage(int d) {
        damage = d;
    }

    public void setRateOfFire(int r) {
       rateOfFire = r;
    }


}
