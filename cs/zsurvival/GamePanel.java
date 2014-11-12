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
   Point mouseLoc;
   final static int CONTROL_DELAY_MS = 100;
   boolean left, right, up, down, mouseClick;
   AffineTransform xform;
   Bullet b;
   private AffineTransform bulletForm;

   public GamePanel() {
       Weapon pistol = new Weapon (1, 1, 1000);
       
       player = new Player("ThienSon", new Point(GameFrame.WINDOW_WIDTH/2, GameFrame.WINDOW_HEIGHT/2), 0, 100, 5 ,pistol);
       b = new Bullet(player.location.x, player.location.y, player.direction);
       timer = new Timer(30, this);
       timer.setCoalesce(false); // oh god if not
       timer.start();


   }

   @Override
   public void paint(Graphics g) {
       Graphics2D g2d = (Graphics2D)g;
       g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       g2d.setPaint(new TexturePaint(Player.playerImg, new Rectangle2D.Float(0, 0, Player.playerImg.getWidth(), Player.playerImg.getHeight())));
       xform = new AffineTransform();
       bulletForm = new AffineTransform();
       updatePlayer();
       g.setColor(Color.WHITE);
       g.fillRect(0, 0, GameFrame.WINDOW_WIDTH, GameFrame.WINDOW_HEIGHT);
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
       g2d.drawImage(Player.playerImg, xform, this);
       bulletForm.translate(b.location.x, b.location.y);
       bulletForm.rotate(b.direction,20,20);
       g2d.drawImage(Bullet.bulletImg, bulletForm,this);
       
   }

   public static void init() {
        
   }
   
   protected void updatePlayer () {
       mouseLoc = MouseInfo.getPointerInfo().getLocation();
       float xDistance = mouseLoc.x - player.location.x;
       float yDistance = mouseLoc.y - player.location.y;
       player.direction = Math.toDegrees(Math.atan2(yDistance, xDistance));
       xform.translate(player.location.x, player.location.y);
       xform.rotate(Math.PI/180 * player.direction,20,20);
       


   }
   @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            down = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            right = true;
        }
        
        repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            right = false;
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseClick = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseClick = false;
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
            if(player.getLocation().x > 0)
            player.setLocation(player.getLocation().x- player.speed, player.getLocation().y);
        }
        if (right) {
            if(player.getLocation().x < GameFrame.WINDOW_WIDTH);
            player.setLocation(player.getLocation().x+ player.speed, player.getLocation().y);
        }
        if (mouseClick) {
            b.location.setLocation(player.getLocation());
            b.direction = Math.atan2(mouseLoc.y - player.getLocation().y, mouseLoc.x - player.getLocation().x);
        }
       b.location.x += Math.cos(b.direction);
       b.location.y += Math.sin(b.direction);
        repaint();
    }
}
