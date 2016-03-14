package drawCircle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.*;
import java.awt.geom.*;

public class Circle extends JFrame implements ActionListener, MouseListener {
    Shape circle = new Ellipse2D.Float(5, 5, 5, 5);
    int x, y;
    public Circle () {
    	
        setSize(400,600);
        addMouseListener(this);
        
    }

    public static void main(String[] args) {
        //TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
              public void run() {
                   Circle frame = new Circle();
                   frame.setVisible(true);
              }
        });
    }
    
    @Override
    public void paint(Graphics g) {
        drawCircle(x, y);
    }

    public void actionPerformed(ActionEvent ae) {

    }

    public void drawCircle(int x, int y) {
        Graphics g = this.getGraphics();
        g.drawOval(x, y, x, y);
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 20, 20);
       
     
    }

    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        repaint();
    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }
}