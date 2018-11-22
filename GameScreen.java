package Framework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import Graphics.ImageList;
import Object.Bomber;

public abstract class GameScreen extends JFrame implements KeyListener {
	public int x = 100, y = 100, width, height;

	public GameThread gameThread;
	final int keyPressed = 0;
	final int keyReleased = 1;

	public GameScreen(Bomber bomber) {
		this.width = bomber.loadMap.column * 40;
		this.height = bomber.loadMap.row * 40;
		InitScreen();
		gameThread = new GameThread(this);
		gameThread.setPreferredSize(new Dimension(width, height));
		add(gameThread);
		pack();
	}

	public void InitScreen() {
		setSize(width, height);
//		setLocation(x, y);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		addKeyListener(this);
	}

	public void GameStart() {
		gameThread.startThread();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keyAction(e, keyPressed);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyAction(e, keyReleased);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	protected BufferedImage game_over = ImageList.game_over;
	protected BufferedImage you_win = ImageList.you_win;

	public void drawGameover(Graphics2D g2) {
		g2.drawImage(game_over, 0, 0, width, height, null);
	}

	public void drawYouWin(Graphics2D g2) {
		g2.drawImage(you_win, 0, 0, width, height, null);
	}

	public abstract void GAME_TIME(long deltaTime);

	public abstract void gamePaint(Graphics2D g2);

	public abstract void keyAction(KeyEvent e, int event);
}
