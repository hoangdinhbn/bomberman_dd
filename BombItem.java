package Item;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Graphics.ImageList;

public class BombItem {
	public boolean ishide = true;
	public int loc_x, loc_y;

	public BombItem(int x, int y) {
		this.loc_x = x;
		this.loc_y = y;

	}

	protected BufferedImage powerup_bombs = ImageList.powerup_bombs;
	protected BufferedImage brick = ImageList.brick;

	public void draw(Graphics2D g2, BombItem bombItem) {
		if (this.ishide == false)
			g2.drawImage(powerup_bombs, bombItem.loc_x, bombItem.loc_y, 40, 40, null);
		else
			g2.drawImage(brick, bombItem.loc_x, bombItem.loc_y, 40, 40, null);
	}

}
