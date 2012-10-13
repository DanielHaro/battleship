import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.FlowLayout;


public class MessagePanel extends JPanel {
	private JTextField topMessage;
	private JTextField Rank;
	private String [] ranks = {"Ensign","Junior Lieutenant","Lieutenant","Commander", "Captain","Rear Admiral","Vice Admiral","Chief Admiral"};
	private int score = 0;
	private int shipCount = 10;
	
	/**
	 * Create the panel.
	 */

	public MessagePanel() {
	
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		setBackground(new Color(30, 144, 255));
		topMessage = new JTextField();
		topMessage.setFont(new Font("Tahoma", Font.BOLD, 18));
		topMessage.setText("Place your ships");
		topMessage.setEditable(false);
		add(topMessage);
		topMessage.setColumns(65);
		JLabel RankLB = new JLabel("Rank");
		RankLB.setHorizontalAlignment(SwingConstants.CENTER);
		RankLB.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(RankLB);
		Rank = new JTextField();
		Rank.setFont(new Font("Tahoma", Font.BOLD, 20));
		Rank.setHorizontalAlignment(SwingConstants.CENTER);
		Rank.setText("Ensign");
		add(Rank);
		Rank.setColumns(10);
	}
	
	public void changeRank()
	{
		if(score == 0)
		{
		  Rank.setText(ranks[0]);
		  shipCount = 10;
		}
		  if (score == 1)
			{
			  Rank.setText(ranks[1]);
			  shipCount = 11;
			}
		if (score > 2)
			{
			  Rank.setText(ranks[2]);
			  shipCount =12; 
			}
		if (score > 4)
		   {
			Rank.setText(ranks[3]);
		    shipCount = 13; 
		   }
			if (score > 7)
			{
			  Rank.setText(ranks[4]);
			  shipCount = 14;
			}		  
		if (score > 11)
		{
			Rank.setText(ranks[5]);
		    shipCount = 15;
		}
	}
	
	public int setMaxShips()
	{return shipCount;}
	
	public void updateMessage(String messageIn)
	{
		System.out.println("message in :" + messageIn);
		topMessage.setText(messageIn);
	}
	
	public void updateScore(int pts)
	{
		score = score + pts;
		changeRank();
	}

} 
