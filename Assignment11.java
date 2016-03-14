
import java.io.*;
import java.net.MalformedURLException;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class Assignment11 {

	public static void main(String[] args) {
		JFrame f = new JFrame("Crawler");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    String s =  "This is an important message from the government!";
	    MarqueePanel mp = new MarqueePanel(s, 100);
	    f.add(mp);
	    mp.setBackground (Color.yellow);
	    f.pack();
	    f.setLocationRelativeTo(null);
	    f.setSize(600, 200);
	    f.setVisible(true);
	    mp.start();
	}
}

class MarqueePanel extends JPanel implements ActionListener {
    private static final int RATE = 15;
    private final Timer timer = new Timer(1000 / RATE, this);
    private final JLabel label = new JLabel();
    private final String s;
    private final int n;
    private int index;
    private JButton controler;
    public MarqueePanel(String s, int n) {
    	
    	JPanel southPanel = new JPanel();
    	setLayout (new BorderLayout());
    	controler = new JButton("control");
		southPanel.add(controler);
		add(BorderLayout.SOUTH, southPanel);
		controler.addActionListener(this);
		
        if (s == null || n < 1) {
            throw new IllegalArgumentException("Null string or n < 1");
        }
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
        	sb.append(' ');	       	
        }
        this.s = sb + s + sb;
        this.n = n;
        label.setFont(new Font("Serif", Font.ITALIC, 36));
        label.setText(sb.toString());
        this.add(label);
    }   
    public void start() {
	    	timer.start();	
	}
     @Override
     public void actionPerformed(ActionEvent e) {
        index++;
        
        if (index > s.length() - n) {
        	index = 0;
        }
            if (e.getSource() == controler){
            	 try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}	
            }       
        	label.setText(s.substring(index, index + n));     
     }       
 }
    
      
