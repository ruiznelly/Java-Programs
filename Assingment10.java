import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import javax.swing.event.*;

public class Assingment10 {
	public static void main (String [] arg) {
		
		JFrame j = new JFrame ("Super Ball");
		j.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		j.getContentPane().add(new MainPanel());
		j.setSize(400, 600);
		j.setVisible(true);
	
	}		
}

class MainPanel extends JPanel implements ActionListener, MouseListener {
	private JPanel controls;
	private JSlider ballSlider;
	private JButton buttonRed;
	private JButton buttonBlue;
	private int barValue = 0;
	boolean dragging = false;
	Color color = Color.RED;
	static final int FPS_MIN = 0;
	static final int FPS_MAX = 100;
	static final int FPS_INIT = 20;  
	int X= 20, Y= 20;
	
	
	public MainPanel () {
		addMouseListener(this);
		setLayout (new BorderLayout());
	
		JSlider ballSlider = new JSlider(JSlider.VERTICAL, FPS_MIN, FPS_MAX, FPS_INIT);
		
		ballSlider.setMajorTickSpacing(10);
		ballSlider.setMinorTickSpacing(5);
		ballSlider.setPaintTicks(true);
		ballSlider.setPaintLabels(true);
		ballSlider.setAlignmentX(Component.RIGHT_ALIGNMENT);
		SliderListener listener = new SliderListener();
		ballSlider.addChangeListener(listener);
		
		controls = new JPanel();
		BoxLayout layout = new BoxLayout(controls, BoxLayout.X_AXIS);
		controls.setLayout(layout);
		controls.add(ballSlider);
		controls.add(Box.createRigidArea(new Dimension (0,20)));
		
		buttonRed = new JButton("red");
		buttonBlue = new JButton("blue");
		
		buttonRed.setPreferredSize(new Dimension(185, 30));
		buttonBlue.setPreferredSize(new Dimension(185, 30));
		JPanel southPanel = new JPanel();
		
		southPanel.add(buttonRed);
		southPanel.add(buttonBlue);
		add(BorderLayout.SOUTH, southPanel);
		buttonRed.addActionListener(this);
		buttonBlue.addActionListener(this);
		
		add(BorderLayout.EAST, controls);
		
	}

	
private class SliderListener implements ChangeListener{
	
	
	public void stateChanged (ChangeEvent event) {
		JSlider slider = (JSlider) event.getSource();
		barValue = slider.getValue();
		repaint();
	}
}

public void paintComponent(Graphics g){
	
		super.paintComponent(g);
		
	 	g.setColor(color);
	    g.fillOval(X, Y, barValue, barValue);
		   
}
public void mouseClicked(MouseEvent e) {
		barValue = 20;
		X = e.getX();
	    Y = e.getY();
	    repaint(); 
}


public void mousePressed(MouseEvent e) {
		 dragging = true;
		
	this.addMouseMotionListener(new MouseMotionAdapter() {

        @Override
        public void mouseDragged(MouseEvent e) {
           X = e.getX();
           Y = e.getY();
   
           repaint();
        }
	});
}
	

	public void mouseReleased(MouseEvent e) {
		 dragging = false;
		
	}
	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonRed){
			color = Color.red;
		}
		else if(e.getSource() == buttonBlue)
		{
			color = Color.blue;
		}
		
		repaint();
	}	
}


