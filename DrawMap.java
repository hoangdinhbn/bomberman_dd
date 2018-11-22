package Framework;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import Graphics.ImageList;

public class DrawMap extends JPanel {

	protected BufferedImage wall = ImageList.wall;
	protected BufferedImage brick = ImageList.brick;
	protected BufferedImage portal = ImageList.portal;
	protected BufferedImage grass = ImageList.grass;

	public void drawMap(Graphics2D g2, LoadMap loadMap) {
		BufferedImage image;
		for (int i = 0; i < loadMap.row; i++) {
			for (int j = 0; j < loadMap.column; j++) {
				image = this.setImage((char) loadMap.map[i][j]);
				this.drawImage(image, g2, j * 40, i * 40);
			}
		}
	}

	public BufferedImage setImage(char c) {
		BufferedImage image = null;
		if (c == '#')
			image = wall;
		else if (c == '*')
			image = brick;
		else
			image = grass;
		return image;
	}

	public void drawImage(BufferedImage image, Graphics2D g2, int x, int y) {
		g2.drawImage(image, x, y, 40, 40, null);
	}

}
