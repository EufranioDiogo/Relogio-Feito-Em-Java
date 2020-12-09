/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulacg;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 *
 * @author ed
 */
public class ComponentePrincipal extends JComponent {

    int x;

    public ComponentePrincipal() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000 / 24);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ComponentePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    repaint();
                }

            }
        }
        ).start();
    }

    int s, m, h;

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g.setColor(new Color(130, 40, 200, 120));
        g2.setStroke(new BasicStroke(5f));
        AffineTransform aff0 = g2.getTransform();
        
        g2.translate(100, 100);
        
        AffineTransform aff = g2.getTransform();


        g2.rotate(Math.toRadians(s), 100, 100);
        g.drawLine(100, 100, 100, 0);
        g2.setTransform(aff);
        s += 9;

        g2.rotate(Math.toRadians(m), 100, 100);
        g.drawLine(100, 100, 100, 0);
        g2.setTransform(aff);
        m += 3;
        
        g2.rotate(Math.toRadians(h++), 100, 100);
        g.drawLine(100, 100, 100, 0);
        g2.setTransform(aff);

  

        g.drawRoundRect(-20, -20, 220, 220, 25, 25);
        
        g2.drawString("12", 90, 10);
        g2.drawString("3", 175, 85);
        g2.drawString("6", 94, 185);        
        g2.drawString("9", 0, 85);
        
        g2.setTransform(aff0);

    }

}
