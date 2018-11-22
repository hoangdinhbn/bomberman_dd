package Item;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Graphics.ImageList;

public class SpeedItem {
	public boolean ishide = true;
	public int loc_x, loc_y;

	public SpeedItem(int x, int y) {
		this.loc_x = x;
		this.loc_y = y;

	}

	protected BufferedImage powerup_speed = ImageList.powerup_speed;
	protected BufferedImage brick = ImageList.brick;

	public void draw(Graphics2D g2, SpeedItem speedItem) {
		if (this.ishide == false)
			g2.drawImage(powerup_speed, speedItem.loc_x, speedItem.loc_y, 40, 40, null);
		else
			g2.drawImage(brick, speedItem.loc_x, speedItem.loc_y, 40, 40, null);
	}
}
