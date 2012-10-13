import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePiece extends JPanel implements MouseListener {

	private int owner;
	private int index;
	private int state;
	private boolean valid = false;

	/**
	 * Create the panel.
	 */

	public GamePiece(int player, int indexed, boolean hasShip) {

		this.owner = player;
		this.index = indexed;
		this.state = 0;
		this.valid = hasShip;

		setForeground(Color.YELLOW);
		setBorder(new LineBorder(new Color(64, 64, 64)));
		setBackground(Color.CYAN);
		if (player == 1)
			setBackground(Color.GREEN);
		if (valid)
			setBackground(Color.WHITE);

		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
	}

	public void reset() {

		this.state = 0;
		this.valid = false;

		setBackground(Color.CYAN);
		if (owner == 1)
			setBackground(Color.GREEN);
	}

	public int getOwner() {
		return owner;
	}

	public boolean checkVaild() {
		return valid;
	}

	public int getState() {
		return state;
	}

	public void changeState(int newState) {
		if (state == 0)
			state = newState;
		changeColor();
	}

	public int getIndex() {
		return index;
	}

	public boolean checkHit() {
		return valid;
	}

	public void showShip() {
		if (valid == true && state == 0)
			setBackground(Color.YELLOW);
		repaint();

	}

	private void changeColor() {
		if (state == 0) {
			setBackground(Color.CYAN);
			System.out.println("no color change");
		} else if (state == 1) {
			setBackground(Color.RED);
			System.out.println("RED");
		} else {
			setBackground(Color.BLACK);
			System.out.println("Black");
		}
	}

	public void setShip() {
		valid = true;
		 if(owner == 1)
		setBackground(Color.magenta);
		this.repaint();
	}

	@Override
	public synchronized void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}