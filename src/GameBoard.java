import java.util.Random;
import java.util.Vector;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;

public class GameBoard extends JPanel implements MouseListener {

	private Vector<GamePiece> locations = new Vector();
	/**
	 * Create the panel.
	 */

	private int boardSize = 10;

	public GameBoard(int player, int boardSize) {
		this.boardSize = boardSize;
		setBorder(null);
		setForeground(Color.WHITE);
		setLayout(new GridLayout(10, 10, 0, 0));
		for (int i = 0; i < boardSize; i++) {
			GamePiece gamePieceGenerator0 = new GamePiece(player, i, false);
			addLocation(gamePieceGenerator0);
			add(gamePieceGenerator0);
		}

	}

	public GamePiece getRef(int i) {
		return locations.elementAt(i);
	}

	void addActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
	}

	public void addLocation(GamePiece gp) {
		locations.add(gp);
	}

	public void placeShips(int boardSize, int cpuShips) {
		Random generator = new Random();
		for (int i = 0; i < cpuShips;) {
			int loc = generator.nextInt(boardSize);
			if (locations.elementAt(loc).getState() == 0
					&& !locations.elementAt(loc).checkVaild()) {
				locations.elementAt(loc).setShip();
				i++;
				System.out.println("shiped place at location " + loc);
			}
		}

	}

	public Boolean pickShips(GamePiece picked) {

		if (picked.getOwner() == 0) {
			if (!locations.elementAt(picked.getIndex()).checkVaild()) {
				locations.elementAt(picked.getIndex()).setShip();
				this.repaint();
				return true;
			}
		}
		return false;
	}

	public GamePiece getLocation(int index) {
		return locations.get(index);
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

	public void exposeAllShips() {
		for (int i = 0; i < boardSize; i++) {
			if (locations.elementAt(i).isValid()
					&& locations.elementAt(i).getState() == 0) {
				locations.elementAt(i).showShip();

			}

		}

	}
}
