import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

public class LoadPanel extends JPanel {
	private JButton start;
	private int state;

	/**
	 * Create the panel.
	 */
	public LoadPanel(int state) {
		this.state = state;
		setBackground(new Color(0, 0, 0));
		setLayout(new BorderLayout(0, 0));
		if (state == 1 || state == 2)
			start = new JButton("continue");
		else
			start = new JButton("start");
		start.setFont(new Font("Tahoma", Font.BOLD, 20));
		start.setVerticalAlignment(SwingConstants.BOTTOM);
		add(start, BorderLayout.SOUTH);

	}

	public void paintComponent(Graphics g) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension d = toolkit.getScreenSize();
		ImageIcon x;
		super.paintComponent(g);
		if (state == 1)
			x = new ImageIcon("winMedal2.jpg");
		else

		if (state == 2)
			x = new ImageIcon("loser3.jpg");

		else
			x = new ImageIcon("battleshipfiring.jpg");
		x.paintIcon(this, g, (d.width - x.getIconWidth()) / 2,
				(d.height - x.getIconHeight()) / 2);
	}

	public JButton getStart() {
		return start;
	}

}
