import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import java.awt.Font;

public class ScorePanel extends JPanel implements MouseListener, ActionListener,ListSelectionListener {
	private JTextField displayPlayer;
	private JTextField DisplayComputer;
	private JButton restart;
	private JComboBox<String> comboBox;
	
	/**
	 * Create the panel.
	 */
	public ScorePanel() {
		setLayout(new GridLayout(2, 1, 0, 0));
		setBackground(new Color(30, 144, 255));
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Player SCORE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel);
		
		displayPlayer = new JTextField();
		displayPlayer.setFont(new Font("Tahoma", Font.BOLD, 20));
		displayPlayer.setText("0");
		panel_1.add(displayPlayer);
		displayPlayer.setColumns(10);
		DefaultListModel<String> listings = new DefaultListModel<String>();
		listings.addElement ("Easy");
		listings.addElement("intermedate");
		listings.addElement("hard");
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		add(panel);
		JLabel lblNewLabel_1 = new JLabel("Computer Score");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel_1);
		DisplayComputer = new JTextField();
		DisplayComputer.setFont(new Font("Tahoma", Font.BOLD, 20));
		DisplayComputer.setText("0");
		panel.add(DisplayComputer);
		DisplayComputer.setColumns(10);
		restart = new JButton("restart game");
		restart.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(restart);
		restart.addActionListener(this);
		String[] options = {"easy","intermedeate","hard"};
		comboBox = new JComboBox<String>(options);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(comboBox);
	}

	public int getLevel()
	{
		return comboBox.getSelectedIndex();
	}
	
	public JButton getRestart()
	{return restart;}
	
    public void updatePlayerScores(int score)
      {
	        displayPlayer.setText("" + score);
	   }
	
	    public void updateCPUScores(int score)
	    {
	        DisplayComputer.setText("" + score);
	    }
	    
	    
	    public void reset()
	    {
	    	displayPlayer.setText("0");
	    	DisplayComputer.setText("0");
	    }
	    
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			// TODO Auto-generated method stub
		}
}
