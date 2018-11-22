package Framework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GameThread extends JPanel implements Runnable {
	protected int width, height;
	public Thread thread;
	GameScreen gameScreen;
	BufferedImage bufferedImage;
	public long FPS = 60; // so khung hinh tren giay

	public GameThread(GameScreen gameScreen) {
		this.width = gameScreen.width;
		this.height = gameScreen.height;
		this.gameScreen = gameScreen;
		this.thread = new Thread(this);
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		Graphics2D g2 = (Graphics2D) g;
		if (bufferedImage != null) {
			g2.drawImage(bufferedImage, 0, 0, this);
		}
	}

	public void startThread() {
		thread.start();
	}

	@Override
	public void run() {
		long T = 1000 / FPS;
		long TimeBuffer = T / 2; // thoi gian ve + thoi gian cho = thoi gian hien 1 khung hinh
		long BeginTime = System.currentTimeMillis();
		long EndTime;
		long sleepTime;
		while (true) {

			gameScreen.GAME_TIME(System.currentTimeMillis());
			try {

				bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
				if (bufferedImage == null)
					return;
				Graphics2D g2 = (Graphics2D) bufferedImage.getGraphics();

				if (g2 != null) {
					gameScreen.gamePaint(g2);
				}

			} catch (Exception myException) {
				myException.printStackTrace();
			}
			repaint();
			EndTime = System.currentTimeMillis();
			sleepTime = T - (EndTime - BeginTime);

			if (sleepTime < 0) {
				sleepTime = TimeBuffer;
			}

			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException ex) {
			}

			BeginTime = System.currentTimeMillis();
		}
	}
}
