import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Sketch {

	public static void main(String[] args) {
		JFrame j = new JFrame ("Etch a Sketch");
		j.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		j.getContentPane().add(new SketchPanel());
		j.setSize(600, 600);
		j.setVisible(true);
	
	}		
}

class SketchPanel extends JPanel implements MouseListener, MouseMotionListener {
	
	private JButton Shake;
	boolean painting = false;

	Color lineColor = Color.black;
	
	JFrame window;
    Container content;
    int newX, newY, oldX, oldY;
    JLabel coords;
 
  
	
	public SketchPanel() {
		 JFrame window = new JFrame("Etch a Sketch");
	     content = window.getContentPane();
	     content.setLayout( new FlowLayout() );
	     
	     Shake = new JButton("Shake");
	     content.add(Shake, BorderLayout.NORTH);
	     content.addMouseListener(this); 
	     content.addMouseMotionListener(this);
		
		addMouseListener(this);
		setLayout (new BorderLayout());
		
		Shake = new JButton("Shake");
		add(Shake, BorderLayout.NORTH);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.drawLine(oldX,oldY, newX, newY);
        g.setColor(lineColor);
        oldX = newX;
        oldY = newY;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Shake){
		
		}
    }

		public void mouseClicked( MouseEvent e) {
	        newX = e.getX();
	        newY = e.getY();     
		}
		
		public void mousePressed(MouseEvent e) {
			painting = true;
			
			this.addMouseMotionListener(new MouseMotionAdapter() {

		        @Override
		        public void mouseDragged( MouseEvent e) {
			        newX = e.getX();
			        newY = e.getY();
			 
			        if (oldX == 0) {
			            oldX = newX;
			            oldY = newY;
			            return;
			        }
		            repaint();
		        }
			});
		}
	       
	 
	    public void mouseReleased( MouseEvent me) {
	        mouseX = me.getX();
	        mouseY = me.getY();
	       
	    }
	 
	    public void mouseExited( MouseEvent me) {
	        mouseX = me.getX();
	        mouseY = me.getY();
	     
	    }
	    public void mouseEntered( MouseEvent me) {
	        mouseX = me.getX();
	        mouseY = me.getY();
	       
	    }
	 
	    // ...............................................................
	    // IMPLEMENTING MOUSEMOTIONLISTENER REQUIRES YOU WRITE (OVER-RIDE) THESE METHODS 
	 
	   
	    public void mouseMoved( MouseEvent me) {
	        mouseX = me.getX();
	        mouseY = me.getY();
	 
	    }
		}

	 

