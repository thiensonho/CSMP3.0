/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

// TODO: MUSIC http://www3.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html

package cs.zsurvival;

import java.awt.*;
import java.awt.event.*;


import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.Timer;

/**
 *
 * @author s506571
 */
public class GamePanel extends StatePanel implements ActionListener {
  
   Player player;
   Timer timer;
   Timer controlTimer;
   final static int CONTROL_DELAY_MS = 100;
   boolean left, right, up, down;

   public GamePanel() {
       Weapon pistol = new Weapon (1, 1, 1000);
       player = new Player("ThienSon", new Point(GameFrame.WINDOW_WIDTH/2, GameFrame.WINDOW_HEIGHT/2), 0, 100, 5 ,pistol);
       timer = new Timer(30, this);
       timer.setCoalesce(false); // oh god if not
       timer.start();
        controlTimer = new Timer(CONTROL_DELAY_MS, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                repaint();
            }
        });
   }

   @Override
   public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, GameFrame.WINDOW_WIDTH, GameFrame.WINDOW_HEIGHT);
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g.drawImage(Player.playerImg, player.location.x, player.location.y, this);
   }

   public static void init() {
        
   }
   

   @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
        }
        repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }
        repaint();
    }



    public void actionPerformed(ActionEvent e) {
        if (up) {
            player.setLocation(player.getLocation().x, player.getLocation().y-player.speed);
        }
        if (down) {
            player.setLocation(player.getLocation().x, player.getLocation().y + player.speed);
        }
        if (left) {
            player.setLocation(player.getLocation().x- player.speed, player.getLocation().y);
        }
        if (right) {
            player.setLocation(player.getLocation().x+ player.speed, player.getLocation().y);
        }
        repaint();
    }
}
