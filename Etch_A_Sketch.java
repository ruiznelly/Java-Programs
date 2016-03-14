import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
 
public class Etch_A_Sketch implements ActionListener, MouseListener, MouseMotionListener {
 
    JFrame window;
    Container content;
    int newX, newY, oldX, oldY;
    JLabel coords;
    JButton Shake = new JButton();
    Color lineColor = Color.black; 
 
    public Etch_A_Sketch() {
    	JFrame window = new JFrame("Etch a Sketch");
        content = window.getContentPane();
        content.setLayout( new FlowLayout() );
        Shake = new JButton("Shake");
        Shake.setPreferredSize(new Dimension(630, 30));
		content.add(Shake, BorderLayout.NORTH);
        content.addMouseListener(this);       
        content.addMouseMotionListener(this); 
        Shake.addActionListener(this);
        
        window.setSize(640,480);
        window.setVisible(true);
	            
	       
    }
    public void erase(){
    	
    	content.repaint();
       
    }
    	
    public void mouseClicked(MouseEvent me) {
        newX = me.getX();
        newY = me.getY();     
    }
    public void mousePressed(MouseEvent me) {
        newX = me.getX();
        newY = me.getY();
    }
 
    public void mouseReleased(MouseEvent me) {
    	oldX = 0;
        oldY = 0;
    
    }
 
    public void mouseExited(MouseEvent me) {
    	 oldX = 0;
         oldY = 0;
    }
    public void mouseEntered(MouseEvent me) {
        newX = me.getX();
        newY = me.getY();  
    }
 
    public void mouseDragged(MouseEvent me) {
       newX = me.getX();
       newY = me.getY();
 
       if (oldX == 0 || oldY == 0) {
    	   oldX = newX;
    	   oldY = newY;
           return;
        }
             
        Graphics g = content.getGraphics();
        g.drawLine(oldX,oldY, newX, newY);
        g.setColor(lineColor);
        oldX = newX;
        oldY = newY;
      
    }
    public void mouseMoved(MouseEvent me) {
        newX = me.getX();
        newY = me.getY();
    }
 
    public void actionPerformed(ActionEvent e) {
          
            if (e.getSource() == Shake){
            	erase();
            }
    }
     
    public static void main( String[] args) {
        new Etch_A_Sketch();
    }
}