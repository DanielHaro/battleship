import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;


public class LoadPanel extends JPanel {
private JButton start;

	/**
	 * Create the panel.
	 */
	public LoadPanel() {
		setBackground(new Color(0, 0, 0));
		setLayout(new BorderLayout(0, 0));
	    start = new JButton("start");
	    start.setFont(new Font("Tahoma", Font.BOLD, 20));
		start.setVerticalAlignment(SwingConstants.BOTTOM);
		add(start, BorderLayout.SOUTH);
	
	}
	
	public void paintComponent(Graphics g) 
     	{   
	       ImageIcon x;
		   super.paintComponent(g);
		   x = new ImageIcon("battleshipfiring.jpg");
		   x.paintIcon(this, g, 410,110);
		}
		
	public JButton getStart(){return start;}
	
}
