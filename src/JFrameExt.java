////To set to cheat mode commit out owner == 1 in gamepiece setShip method  to reveal enemy ships during game play.

import java.applet.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class JFrameExt extends JFrame implements MouseListener, ActionListener {

	private JPanel contentPane;
	private GameBoard gameBoard;
	private GameBoard gameBoard_1;
	private BasePanel basePanel;
	private AudioClip audioClip[] = new AudioClip[10];
	private int boardSize = 100;
	private int turn = 0;
	private int lastPlay = 0;
	private int computerScore = 0;
	private int playerScore = 0;
	private int gameState = 0;
	private int maxShips = 10;
	private int shipsSelected = 0;
	private ScorePanel scorePanel;
	private MessagePanel messagePanel;
	private LoadPanel titleScreen;
	private int cpuShips;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Toolkit toolkit = Toolkit.getDefaultToolkit();
					Dimension d = toolkit.getScreenSize();
					JFrameExt frame = new JFrameExt();
					frame.setBounds(0, 0, d.width, d.height);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public JFrameExt() {

		LoadMusic();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(
				0, 191, 255), null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		titleScreen = new LoadPanel();
		contentPane.add(titleScreen, BorderLayout.CENTER);
		contentPane.repaint();
		contentPane.revalidate();
		contentPane.validate();

		messagePanel = new MessagePanel();
		titleScreen.getStart().addActionListener(this);
		basePanel = new BasePanel();
		scorePanel = new ScorePanel();
		scorePanel.getRestart().addActionListener(this);

	}

	public void LoadMusic() {
		try {
			URL baseURL = new URL("file:" + System.getProperty("user.dir")
					+ "/");
			URL completeURL = new URL(baseURL, "battleship.wav");
			audioClip[0] = Applet.newAudioClip(completeURL);
			audioClip[0].loop();
		} catch (Exception e) {
			System.out.println("fail");
		}
	}

	public void switchPlayer() {
		if (turn == 1) {
			turn = 0;
		} else {
			turn = 1;
			cpuPlay();
		}
	}

	public synchronized void cpuPlay() {
		Random generator = new Random();
		boolean done = false;

		while (!done) {
			int loc = generator.nextInt(boardSize - 1);
			GamePiece gamePiece = gameBoard_1.getLocation(loc);
			if (gamePiece.getState() == 0) {
				if (gamePiece.getState() == 0) {
					if (gamePiece.checkHit()) {
						gamePiece.changeState(1);
						computerScore++;
						messagePanel
								.updateMessage("You lost a ship please select a location");
						this.repaint();
						scorePanel.updateCPUScores(computerScore);
						lastPlay = 1;
					} else {
						gamePiece.changeState(-1);
						switchPlayer();
						done = true;
						this.repaint();
					}
				}
			}
		}
	}

	public void pickShips(GamePiece picked) {
		if (picked.getOwner() == 0) {
			if (gameBoard_1.pickShips(picked))
				shipsSelected++;
			if (shipsSelected == maxShips)
				gameState++;
		}
		this.repaint();
	}

	public void resetGame() {
		boardSize = 100;
		int dim = 10;
		cpuShips = 10;
		maxShips = messagePanel.setMaxShips();

		if (scorePanel.getLevel() == 0) {
			boardSize = 100;
			dim = 10;
			cpuShips = 10;
		} else if (scorePanel.getLevel() == 1) {
			boardSize = 144;
			dim = 12;
			cpuShips = 12;
		} else if (scorePanel.getLevel() == 2) {
			boardSize = 225;
			dim = 15;
			cpuShips = 14;
		} else {
			boardSize = 100;
			dim = 10;
		}

		contentPane.add(messagePanel, BorderLayout.NORTH);
		messagePanel.updateMessage("Place Your Ships");
		computerScore = 0;
		playerScore = 0;
		gameState = 0;
		shipsSelected = 0;
		contentPane.remove(titleScreen);
		contentPane.add(basePanel);
		contentPane.add(scorePanel, BorderLayout.SOUTH);
		revalidate();
		repaint();
		basePanel.removeAll();
		gameBoard = new GameBoard(0, boardSize);
		gameBoard_1 = new GameBoard(1, boardSize);
		gameBoard.setLayout(new GridLayout(dim, dim, 0, 0));
		gameBoard_1.setLayout(new GridLayout(dim, dim, 0, 0));

		for (int i = 0; i < boardSize; i++)
			gameBoard.getRef(i).addMouseListener(this);

		scorePanel.reset();
		gameBoard.placeShips(boardSize, cpuShips);
		basePanel.add(gameBoard);
		basePanel.add(gameBoard_1);
		this.revalidate();
		updateMessages();
		super.repaint();
		repaint();
	}

	public void updateMessages() {
		if (gameState == 0) {
			messagePanel.updateMessage("Place your ships");
		}

		if (gameState == 1) {
			if (lastPlay == 0) {
				if (turn == 0)
					messagePanel.updateMessage("players turn pick a location");
				if (turn == 1)
					messagePanel
							.updateMessage("Computer is making a Selection please wait");
			}
		}

		if (gameState == 2) {
			if (playerScore == cpuShips) {
				messagePanel.updateMessage("You are victorous---GAME OVER");
				if (scorePanel.getLevel() == 0)
					messagePanel.updateScore(1);
				if (scorePanel.getLevel() == 1)
					messagePanel.updateScore(2);
				if (scorePanel.getLevel() == 3)
					messagePanel.updateScore(3);
			}
			if (computerScore == maxShips)
				messagePanel
						.updateMessage("You have been defeated---GAME OVER");
		}
		lastPlay = 0;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		GamePiece temp;
		System.out.println("Frame has a click");
		if (playerScore != cpuShips && computerScore != maxShips
				&& gameState != 0 && turn == 0)
			try {
				temp = (GamePiece) e.getSource();
				if (temp.getOwner() == turn) {
					if (temp.getState() == 0) {
						if (temp.checkHit()) {
							System.out
									.println("it's a bloddy hiot change the freaking message dude");
							temp.changeState(1);
							messagePanel
									.updateMessage("You sunk an enemy ship get an extra turn-- please select a location");
							lastPlay = 1;

							if (turn == 0) {
								playerScore++;
								scorePanel.updatePlayerScores(playerScore);
							} else
								computerScore++;

							this.repaint();
							super.repaint();
							gameBoard.repaint();
							gameBoard_1.repaint();
							temp.repaint();
						} else {
							temp.changeState(-1);
							switchPlayer();
							this.repaint();
							super.repaint();
							gameBoard.repaint();
							gameBoard_1.repaint();
							temp.repaint();
						}
					}

				}

			} catch (Exception e1) {
			}

		if (gameState == 0)
			pickShips((GamePiece) e.getSource());
		if (computerScore == maxShips || playerScore == cpuShips)
			gameState = 2;

		updateMessages();

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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		resetGame();

	}

}
