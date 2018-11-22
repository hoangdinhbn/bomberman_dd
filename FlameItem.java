package Item;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Graphics.ImageList;

public class FlameItem {
	public int loc_x, loc_y;
	public boolean ishide = true;

	public FlameItem(int x, int y) {
		this.loc_x = x;
		this.loc_y = y;

	}

	protected BufferedImage powerup_flames = ImageList.powerup_flames;
	protected BufferedImage brick = ImageList.brick;

	public void draw(Graphics2D g2, FlameItem flameItem) {
		if (this.ishide == false)
			g2.drawImage(powerup_flames, flameItem.loc_x, flameItem.loc_y, 40, 40, null);
		else
			g2.drawImage(brick, flameItem.loc_x, flameItem.loc_y, 40, 40, null);
	}
}
