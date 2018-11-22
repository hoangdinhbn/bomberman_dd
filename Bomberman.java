package Bomberman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import Framework.DrawMap;
import Framework.GameScreen;
import Object.Bomber;

public class Bomberman extends GameScreen {
	final int keyPressed = 0, keyReleased = 1;
	long StartGameTime;
	final long PlayTime = 120;
	long now;
	DrawMap drawMap = new DrawMap();
	Bomber bomber = new Bomber();
	public static int level;
	
	public Bomberman() {
		super(new Bomber());
		StartGameTime = System.currentTimeMillis();
		GameStart();
	}

	public static void main(String[] args) {
		new Bomberman();
	}

	@Override
	public void gamePaint(Graphics2D g2) {
		if (bomber.LOSE == true) {
			this.drawGameover(g2);
		} else if (bomber.WIN == true) {
			this.drawYouWin(g2);
		} else {
			drawMap.drawMap(g2, bomber.loadMap);
			bomber.deleteBoml(bomber);
			for (int i = 0; i < bomber.enemy.ballooms.size(); i++) {
				bomber.enemy.ballooms.get(i).draw(g2, bomber.enemy.ballooms.get(i), bomber.loadMap.map);
			}
			for (int i = 0; i < bomber.enemy.oneals.size(); i++) {
				bomber.enemy.oneals.get(i).draw(g2, bomber.enemy.oneals.get(i), bomber.loadMap.map);
			}
			for (int i = 0; i < bomber.item.bombItems.size(); i++) {
				bomber.item.bombItems.get(i).draw(g2, bomber.item.bombItems.get(i));
			}
			for (int i = 0; i < bomber.item.flameItems.size(); i++) {
				bomber.item.flameItems.get(i).draw(g2, bomber.item.flameItems.get(i));
			}
			for (int i = 0; i < bomber.item.speedItems.size(); i++) {
				bomber.item.speedItems.get(i).draw(g2, bomber.item.speedItems.get(i));
			}
			for (int i = 0; i < bomber.item.portals.size(); i++) {
				bomber.item.portals.get(i).draw(g2, bomber.item.portals.get(i));
			}
			for (int i = 0; i < bomber.bombs.size(); i++) {
				bomber.bombs.get(i).draw(g2, bomber.bombs.get(i));
			}
			bomber.draw(g2, bomber);
			g2.setColor(Color.RED);
			g2.drawString(String.valueOf(PlayTime - (now - StartGameTime) / 1000), 40, 30);
		}
	}

	@Override
	public void keyAction(KeyEvent e, int event) {
		if (event == keyPressed) {
			if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT)
				bomber.LEFT = true;
			else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT)
				bomber.RIGHT = true;
			else if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP)
				bomber.UP = true;
			else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN)
				bomber.DOWN = true;
			bomber.move(bomber, bomber.loadMap.map);
			bomber.Bomber_to_Item(bomber, bomber.loadMap.map);
		}

		else if (event == keyReleased && e.getKeyCode() == KeyEvent.VK_SPACE) {
			bomber.putBoml(bomber, bomber.loadMap.map);
		} else if (event == keyReleased) {
			bomber.notHit();
		}

	}

	@Override
	public void GAME_TIME(long deltaTime) {
		now = deltaTime;
		if ((deltaTime - StartGameTime) / 1000 > PlayTime) {
			bomber.isDie = true;
		}
	}

}
