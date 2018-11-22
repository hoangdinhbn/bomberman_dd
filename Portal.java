package Item;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Graphics.ImageList;

public class Portal {
	public boolean ishide = true;
	public int loc_x, loc_y;

	public Portal(int x, int y) {
		this.loc_x = x;
		this.loc_y = y;

	}

	protected BufferedImage portalImage = ImageList.portal;
	protected BufferedImage brick = ImageList.brick;

	public void draw(Graphics2D g2, Portal portal) {
		if (this.ishide == false)
			g2.drawImage(portalImage, portal.loc_x, portal.loc_y, 40, 40, null);
		else
			g2.drawImage(brick, portal.loc_x, portal.loc_y, 40, 40, null);
	}
}
