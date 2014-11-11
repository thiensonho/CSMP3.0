/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

// TODO: MUSIC http://www3.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html

package cs.zsurvival;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;


import java.awt.geom.Rectangle2D;
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
   boolean left, right, up, down, keyA, keyD;
   AffineTransform xform;

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
       Graphics2D g2d = (Graphics2D)g;
       g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       g2d.setPaint(new TexturePaint(Player.playerImg, new Rectangle2D.Float(0, 0, Player.playerImg.getWidth(), Player.playerImg.getHeight())));
       xform = new AffineTransform();
       updatePlayer();
       g.setColor(Color.WHITE);
       g.fillRect(0, 0, GameFrame.WINDOW_WIDTH, GameFrame.WINDOW_HEIGHT);
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
       g2d.drawImage(Player.playerImg, xform, this);
       
   }

   public static void init() {
        
   }
   
   protected void updatePlayer () {
       xform.translate(player.location.x, player.location.y);
       xform.rotate(Math.PI/180 * player.direction,20,20);
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
        if (e.getKeyCode() == KeyEvent.VK_A) {
            keyA = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            keyD = true;
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
        if (e.getKeyCode() == KeyEvent.VK_A) {
            keyA = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            keyD = false;
        }
        repaint();
    }



    public void actionPerformed(ActionEvent e) {
        if (up) {
            if(player.getLocation().y > 0)
                player.setLocation(player.getLocation().x, player.getLocation().y-player.speed);
        }
        if (down) {
            if(player.getLocation().y < GameFrame.WINDOW_HEIGHT- Player.playerImg.getHeight())
                player.setLocation(player.getLocation().x, player.getLocation().y + player.speed);
        }
        if (left) {
            player.setLocation(player.getLocation().x- player.speed, player.getLocation().y);
        }
        if (right) {
            player.setLocation(player.getLocation().x+ player.speed, player.getLocation().y);
        }
        if (keyA) {
            player.setDirection(player.getDirection()-5);
        }
        if (keyD) {
            player.setDirection(player.getDirection()+5);
        }
        repaint();
    }
}
